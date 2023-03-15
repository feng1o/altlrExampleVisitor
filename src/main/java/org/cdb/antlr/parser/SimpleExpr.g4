grammar SimpleExpr;

@header {
    package org.cdb.antlr.parser;  //指定package
}

// example v1: 只是parser
//prog : stat* EOF ;  # EOF读取整个文件
//stat : expr ;
//expr : expr ('*' | '/' ) expr
//     | expr ('+' | '-' ) expr
//     | expr op=('+' | '-' ) expr
//     | expr op=('/' | '*' ) expr
//     | '(' expr ')'
//     | ID
//     | INT
//     ;
//
//INT : '0' | [1-9] [0-9]* ;
//LT  :   '<' ;
//LE  :   '<=';
//GT  :   '>' ;
//GE  :   '>=';
//EQ  :   '==';
//NE  :   '!=';
//MUL :   '*' ;
//DIV :   '/' ;
//ADD :   '+' ;
//SUB :   '-' ;
//ID  :   [a-zA-Z_]+ ;
//STRING : '"' .*? '"';
//NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
//WS : [ \t\r\n]+ -> skip ;

@members {
    void startFile() {} // 空实现
    void finishFile() {}
    void defineProperty(Token name, Token value) {}
}

prog : stat+
     ;

stat:   expr NEWLINE                             # printExpr
    |   array NEWLINE                            # arrays
    |   ID '=' expr NEWLINE                      # assign
    |   NEWLINE                                  # blank
    ;

expr:   op='!' expr                              # Not
    |   expr op=('<'|'<='|'>'|'>='|'GT'|'LT') expr         # Comp
    |   expr op=('=='|'!=') expr                 # Equal
    |   expr op='&&' expr                        # And
    |   expr op='||' expr                        # Or
    |   expr op=('*'|'/') expr                   # MulDiv
    |   expr op=('+'|'-') expr                   # AddSub
    |   expr op=('INCA'|'EXCA') array            # IncaExca
    |   expr op=('INC'|'EXC'|'EQS'|'NEQ') expr    # IncExcEqNeq
    |   expr op='REG' expr                       # Reg
    |   INT                                      # int
    |   ID                                       # id
    |   STRING                                   # string
    |   '(' expr ')'                             # parens
    |   op='return' expr ';'                     # return
    ;

array: '[' value (',' value)* ']'
     | '[' ']'
     ;

value: STRING
     ;

INCA :  'INCA';  //包含
EXCA :  'EXCA';
INC :   'INC';  //包含
EXC :   'EXC';
EQS :   'EQS' ;
NEQ :   'NEQ';
REG :   'REG';


LT  :   'LT' ;
GT  :   'GT' ;
//LT  :   '<' ;
LE  :   '<=';
//GT  :   '>' ;
GE  :   '>=';
EQ  :   '==';
NE  :   '!=';
MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ID  :   [a-zA-Z_]+ ;      // match identifiers
INT :   DIGIT+ ;         // match integers
STRING : '"' (ESC|.)*? '"';
//STRING : '"' .*? '"';
ESC: '\\"' | '\\\\' ;   // 双字符序号\"和\\
NEWLINE:'\r'? '\n' | ';';     // return newlines to parser (is end-statement signal)
COMMENT : '/*' .*? '*/' -> skip ;
WS  :   [ \t]+ -> skip ; // toss out whitespace
fragment
    DIGIT : [0-9] ;

fragment
    LETTER : [a-zA-Z0-9] ;


