package org.cdb.antlr.parser;

import com.google.gson.JsonObject;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.*;

public class EvalVisitor extends SimpleExprBaseVisitor<ValObj> {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, ValObj> memory = new HashMap<String, ValObj>();

    public EvalVisitor(JsonObject data) {
        super();

        for (String key : data.keySet()) {
            ValObj item = new ValObj();
            item.type  = ValObj.STRING_TYPE;
            item.value = data.get(key).toString();

            System.out.printf("->init visitor, add: %s - %s\n", key, item);
            memory.put(key.trim(), item);
        }
    }

    public ValObj getVal(String key) {
        return memory.get(key.trim());
    }

    public void removeVal(String key) {
        memory.remove(key);
    }

    public Map<String, ValObj> getMap() {
        return memory;
    }

    /** ID '=' expr NEWLINE */
    @Override
    public ValObj visitAssign(SimpleExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();  // id is left-hand side of '='
        ValObj value = visit(ctx.expr());   // compute value of expression on right
        memory.put(id.trim(), value);           // store it in our memory
        System.out.println("___visitAssign___ value: " + value  + " key:" + ctx.getText());
        return value;
    }

    /** expr NEWLINE */
    @Override
    public ValObj visitPrintExpr(SimpleExprParser.PrintExprContext ctx) {
        ValObj value = visit(ctx.expr()); // evaluate the expr child
        System.out.println("___visitPrintExpr___ value: " + value  + " key:" + ctx.getText());
        //System.out.println(value);         // print the result
        return value;                          // return dummy value
    }

    @Override
    public ValObj visitReturn(SimpleExprParser.ReturnContext ctx)
    {
        ValObj value = visit(ctx.expr());
        System.out.println("___visitReturn___ value: " + value  + " key:" + ctx.getText());
        return value;
    }

    @Override
    public ValObj visitValue(SimpleExprParser.ValueContext ctx) {
        String string = ctx.STRING().getText();
        // trim quotes
        if (string.length() >= 2) {
            string = string.substring(1, string.length() - 1);
        }
        System.out.printf("___visitValue___ value1: %s, key: %s \n", string,  ctx.getText());
        ValObj obj = new ValObj();
        obj.type = ValObj.STRING_TYPE;
        obj.value = string;
        return  obj;
    }

    @Override
    public ValObj visitArrays(SimpleExprParser.ArraysContext ctx) {
        String string = ctx.getText();
        System.out.printf("___visitArrays___ value1: %s, key: %s \n", string,  ctx.getText());
        ValObj obj = new ValObj();
        obj.type = ValObj.STRING_TYPE;
        obj.value = string;

        List<Object> values = new ArrayList<Object>();
        for (SimpleExprParser.ValueContext value : ctx.array().value()) {
            values.add(this.visit(value));
        }
        obj.value = values.toArray();
        System.out.printf("___visitArrays___ value last: %s, key: %s \n\n", obj.value,  ctx.getText());
        return obj;
    }

    @Override
    public ValObj visitArray(SimpleExprParser.ArrayContext ctx) {
        String string = ctx.getText();
        System.out.printf("___visitArray___ value1: %s, key: %s \n", string,  ctx.getText());
        ValObj obj = new ValObj();
        obj.type = ValObj.STRING_TYPE;
        obj.value = string;

        List<Object> values = new ArrayList<Object>();
        for (SimpleExprParser.ValueContext value : ctx.value()) {
            values.add(this.visit(value));
        }
        obj.value = values.toArray();
        System.out.printf("___visitArray___ value last: %s, key: %s \n", obj,  ctx.getText());
        return obj;
    }

    @Override
    public ValObj visitIncaExca(SimpleExprParser.IncaExcaContext ctx) {
        ValObj value = visit(ctx.expr());
        System.out.printf("_______visitINcaExca____childCnt: %d\n", ctx.getChildCount());
        System.out.println(ctx.getChild(0));
        System.out.println(ctx.getChild(1));
        System.out.println(ctx.getChild(2));
        System.out.println(ctx.op.getType() == SimpleExprParser.EXCA);

        System.out.printf("_______visitINcaExca____childCnt: %d\n", ctx.getChildCount());
        //ValObj value2 = visit(ctx.expr(1));
        System.out.println("___visitIncaExca___ value: " + value  + " key:" + ctx.getText());
        return null;
    }

    @Override
    public ValObj visitReg(SimpleExprParser.RegContext ctx) {
        String left = visit(ctx.expr(0)).toString();
        String right = visit(ctx.expr(1)).toString();
        System.out.printf("___visitReg___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        String []keys = right.split("\\|");
        for ( String key : keys) {
            System.out.printf("___ret___key :%s\n", key);
            result.value = Pattern.matches(key, left) ? 1L : 0L;
            if (((Long) result.value).longValue() == 1) {
                break;
            }
        }

        System.out.printf("___visitReg___ value1: %s, value2: %s, key: %s, res =%s \n",
                left, right, ctx.getText(), result.value);
        return result;
    }

    @Override
    public ValObj visitIncExcEqNeq(SimpleExprParser.IncExcEqNeqContext ctx) {
        String left = visit(ctx.expr(0)).toString();
        String right = visit(ctx.expr(1)).toString();
        System.out.printf("___visitIncExcEqNeq___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());

        Long found = 0L;
        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        String []keys = right.split("\\|");
        for ( String key : keys) {
            if (ctx.op.getType() == SimpleExprParser.EXC) {
                found = !left.contains(key) ? 1L : 0L;
            } else if (ctx.op.getType() == SimpleExprParser.INC) {
                found = left.contains(key) ? 1L : 0L;
            } else if (ctx.op.getType() == SimpleExprParser.EQS) {
                System.out.println("-----------left: " + left + " right: " + key);
                found = left.equals(key) ? 1L : 0L;
            } else if (ctx.op.getType() == SimpleExprParser.NEQ) {
                found = !left.equals(key) ? 1L : 0L;
            }
            if (found.longValue() == 1) {
                result.value = found;
                break;
           }
        }

        result.value = found;
        System.out.printf("___visitIncExcEqNeq___ value1: %s, value2: %s, key: %s, res =%s \n",
                left, right, ctx.getText(), result.value);
        return result;
    }

    @Override
    public ValObj visitBlank(SimpleExprParser.BlankContext ctx) {
        return new ValObj();
    }

    @Override
    public ValObj visitComp(SimpleExprParser.CompContext ctx)
    {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression
        int ret = left.compareTo(right);
        System.out.printf("___visitComp___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        if ( ctx.op.getType() == SimpleExprParser.LT ) {
            result.value = ret < 0 ? 1L : 0L;
        } else if ( ctx.op.getType() == SimpleExprParser.LE ) {
            result.value = ret <= 0 ? 1L : 0L;
        } else if ( ctx.op.getType() == SimpleExprParser.GT ) {
            result.value = ret > 0? 1L : 0L;
        } else {
            result.value = ret >= 0 ? 1L : 0L;
        }
        return result;
    }

    @Override
    public ValObj visitEqual(SimpleExprParser.EqualContext ctx)
    {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression
        int ret = left.compareTo(right);
        System.out.printf("___visitEqual___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        if ( ctx.op.getType() == SimpleExprParser.EQ ) {
            result.value = ret == 0 ? 1L : 0L;
        } else {
            result.value = ret != 0 ? 1L : 0L;
        }
        return result;
    }

    /** op='!' expr */
    @Override
    public ValObj visitNot(SimpleExprParser.NotContext ctx) {
        ValObj left = visit(ctx.expr());
        ValObj zero = new ValObj();
        System.out.printf("___visitNot___ value1: %s,  key: %s \n", left, ctx.getText());
        zero.type = ValObj.LONG_TYPE;
        zero.value = 0L;
        int ret = left.compareTo(zero);

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        result.value = ret == 0 ? 1L : 0L;
        return result;
    }

    /** expr op=('&&') expr */
    @Override
    public ValObj visitAnd(SimpleExprParser.AndContext ctx) {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression
        System.out.printf("___visitAnd___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());
        ValObj zero = new ValObj();
        zero.type = ValObj.LONG_TYPE;
        zero.value = 0L;
        int ret1 = left.compareTo(zero);
        int ret2 = right.compareTo(zero);

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        if (ret1 != 0 && ret2 != 0) {
            result.value = 1L;
        } else {
            result.value = 0L;
        }
        return result;
    }

    /** expr op=('||') expr */
    @Override
    public ValObj visitOr(SimpleExprParser.OrContext ctx) {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression

        System.out.printf("___visitOr___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());

        ValObj zero = new ValObj();
        zero.type = ValObj.LONG_TYPE;
        zero.value = 0L;
        int ret1 = left.compareTo(zero);
        int ret2 = right.compareTo(zero);

        ValObj result = new ValObj();
        result.type = ValObj.LONG_TYPE;
        if (ret1 != 0 || ret2 != 0) {
            result.value = 1L;
        } else {
            result.value = 0L;
        }
        return result;
    }

    /** INT */
    @Override
    public ValObj visitInt(SimpleExprParser.IntContext ctx) {
        ValObj obj = new ValObj();
        obj.type = ValObj.LONG_TYPE;
        obj.value = Long.parseLong(ctx.INT().getText());
        System.out.printf("___visitInt___ value1: %s,  key: %s \n", obj, ctx.getText());
        return obj;
    }

    /** ID */
    @Override
    public ValObj visitId(SimpleExprParser.IdContext ctx) {
        String id = ctx.ID().getText().trim();
        System.out.println("_______________visitId________ key:" + ctx.getText());
        if ( memory.containsKey(id) ) return memory.get(id);
        // add test
        ValObj obj = new ValObj();
        obj.type = ValObj.STRING_TYPE;
        obj.value = "NOT EXIST";
        System.out.println("_______________visitId________value: " + obj  + " key:" + ctx.getText());
        // add test end
        return obj;
    }

    /** STRING */
    public ValObj visitString(SimpleExprParser.StringContext ctx) {
        String string = ctx.STRING().getText();
        // trim quotes
        if (string.length() >= 2) {
            string = string.substring(1, string.length() - 1);
        }
        System.out.printf("___visitString___ value1: %s, key: %s \n", string,  ctx.getText());
        ValObj obj = new ValObj();
        obj.type = ValObj.STRING_TYPE;
        obj.value = string;
        return obj;
    }

    /** expr op=('*'|'/') expr */
    @Override
    public ValObj visitMulDiv(SimpleExprParser.MulDivContext ctx) {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression
        System.out.printf("___visitMulDiv___ value1: %s, value2: %s, key: %s\n", left, right, ctx.getText());
        if ( ctx.op.getType() == SimpleExprParser.MUL ) return left.arithmetic(right, '*');

        return left.arithmetic(right, '/'); // must be DIV
    }

    /** expr op=('+'|'-') expr */
    @Override
    public ValObj visitAddSub(SimpleExprParser.AddSubContext ctx) {
        ValObj left = visit(ctx.expr(0));  // get value of left subexpression
        ValObj right = visit(ctx.expr(1)); // get value of right subexpression
        System.out.printf("___visitAddSub___ value1: %s, value2: %s, key: %s \n", left, right, ctx.getText());
        if ( ctx.op.getType() == SimpleExprParser.ADD ) return left.arithmetic(right, '+');;
        return left.arithmetic(right, '-'); // must be SUB
    }

    /** '(' expr ')' */
    @Override
    public ValObj visitParens(SimpleExprParser.ParensContext ctx) {
        System.out.printf("___visitParens___  key: %s \n",  ctx.getText());
        return visit(ctx.expr()); // return child expr's value
    }
}
