package org.exa.antlr.job;
import com.google.gson.JsonObject;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.exa.antlr.parser.EvalVisitor;
import org.exa.antlr.parser.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class simpleExpr {

    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        String      file;
        if (args.length > 0) {
            file = args[0];
            System.out.println(file);
            is = new FileInputStream(file);
            CharStream      input = CharStreams.fromStream(is);

            String x = "\\.";
            String  rules = input.toString();
            System.out.println("rules steam: " + input.toString());
            SimpleExprLexer   Lexer  = new SimpleExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(Lexer);
            SimpleExprParser parser = new SimpleExprParser(tokens);
            ParseTree        tree   = parser.prog();

            for (Token token : tokens.getTokens()) {
                System.out.println(token);
            }
            System.out.println("tree: "  + tree.toStringTree(parser));

            JsonObject obj  = new JsonObject();
            obj.addProperty("a", 0);
            obj.addProperty("b", 1);
            obj.addProperty("sqlType", "CREATE");
            obj.addProperty("dbName", "test");
            obj.addProperty("host", "127.0.0.1");
            obj.addProperty("sql", "sele'ct * (from \"tb1\"");
            obj.addProperty("sql", "select a\\b");
            obj.addProperty("sql", "Explore   r 1");
            obj.addProperty("sql", "testDb1");
            obj.addProperty("user", "test");
            obj.addProperty("errno", 1);

            ObjectMapper map = new ObjectMapper();
            JsonNode node = map.readTree(obj.toString());


            Visitx eval = new Visitx(node);
            ValObj res = eval.visit(tree);
            System.out.println("最终结果:" + res.value);

            EvalVisitor visitor = new EvalVisitor(obj);
            ValObj resOld = visitor.visit(tree);
            System.out.println("最终结果:" + resOld);

            System.out.println(Long.valueOf(String.valueOf(res.value)).longValue() == 1);


            ((ObjectNode)node).put("x1", "1");
            ((ObjectNode)node).remove("x1");
            System.out.println("last: " + node.get("user").asText());

            /*
            String str = "1";
            System.out.println("最终结果:" + node + " value: " + node.get("host").asText() + " value: " + str);
            System.out.println(node.toString(node));
            System.out.println("last: " + .asText());
             */

            System.out.println("last tostring: " + node.get("sql").toString());
            System.out.println("last: astext" + node.get("sql").asText());
            System.out.println("last rules: " + rules);

            try {
                Pattern.compile(rules);
            } catch (PatternSyntaxException exception) {
                System.err.println(exception.getDescription());
                System.exit(1);
            }
            System.out.println("Syntax is ok.");
            "a.b".replace("\\.", ",");
            String strx2 = "[   {\"host\" : {\"op\" : \"REG\",\"value\" : [            \"a\\w+\"         ]      }   }]";
            System.out.println(strx2);

        }
    }
}