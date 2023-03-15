#!/bin/sh
#java -jar antlr-4.7.1-complete.jar
java -cp antlr-4.7.1-complete.jar org.antlr.v4.Tool -visitor $*
