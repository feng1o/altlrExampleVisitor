// Generated from SimpleExpr.g4 by ANTLR 4.7.1

    package org.exa.antlr.parser;  //指定package

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleExprParser}.
 */
public interface SimpleExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(SimpleExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(SimpleExprParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrays}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterArrays(SimpleExprParser.ArraysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrays}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitArrays(SimpleExprParser.ArraysContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SimpleExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SimpleExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(SimpleExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(SimpleExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(SimpleExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(SimpleExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(SimpleExprParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(SimpleExprParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(SimpleExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(SimpleExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(SimpleExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(SimpleExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(SimpleExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(SimpleExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(SimpleExprParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(SimpleExprParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComp(SimpleExprParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComp(SimpleExprParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(SimpleExprParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(SimpleExprParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqual(SimpleExprParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqual(SimpleExprParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Reg}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReg(SimpleExprParser.RegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Reg}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReg(SimpleExprParser.RegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SimpleExprParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SimpleExprParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncExcEqNeq}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncExcEqNeq(SimpleExprParser.IncExcEqNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncExcEqNeq}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncExcEqNeq(SimpleExprParser.IncExcEqNeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(SimpleExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(SimpleExprParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReturn(SimpleExprParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReturn(SimpleExprParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncaExca}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncaExca(SimpleExprParser.IncaExcaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncaExca}
	 * labeled alternative in {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncaExca(SimpleExprParser.IncaExcaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleExprParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(SimpleExprParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleExprParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(SimpleExprParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleExprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SimpleExprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleExprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SimpleExprParser.ValueContext ctx);
}