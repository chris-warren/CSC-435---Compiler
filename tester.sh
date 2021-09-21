#!/bin/bash
printf "\n"
printf "\n"
printf "starting tests\n"
printf "\n"
printf "\n"
printf "making\n"
clear
make clean
make
printf "\n"
printf "****************\n"
printf "accept cases\n"
printf "****************\n"

printf "\n"
printf "\n"
printf "test #1\n"
printf "test_functions_accept1.ul\n"
java Compiler tests/test_functions_accept1.ul

printf "\n"
printf "\n"
printf "test #2\n"
printf "test_varDecl_accept1.ul\n"
java Compiler tests/test_varDecl_accept1.ul

printf "\n"
printf "\n"
printf "test #3\n"
printf "test_statements_accept1.ul\n"
java Compiler tests/test_statements_accept1.ul

printf "\n"
printf "\n"
printf "test #4\n"
printf "test_expr_accept1.ul\n"
java Compiler tests/test_expr_accept1.ul



printf "\n"
printf "****************\n"
printf "reject cases\n"
printf "****************\n"

printf "\n"
printf "\n"
printf "test #1\n"
printf "test_functions_reject1.ul\n"
java Compiler tests/test_functions_reject1.ul

printf "\n"
printf "\n"
printf "test #2\n"
printf "lab1_should_reject.ul\n"
java Compiler tests/lab1_should_reject.ul

printf "\n"
printf "\n"
printf "test #3\n"
printf "test_empty.ul\n"
java Compiler tests/test_empty.ul

printf "\n"
printf "\n"
printf "test #4\n"
printf "test_varDecl_reject1.ul\n"
java Compiler tests/test_varDecl_reject1.ul

printf "\n"
printf "\n"
printf "test #5\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_statements_reject1.ul

printf "\n"
printf "\n"
printf "test #6\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject1.ul

printf "\n"
printf "\n"
printf "test #7\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject2.ul

printf "\n"
printf "\n"
printf "test #8\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject3.ul

printf "\n"
printf "\n"
printf "test #9\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject4.ul

printf "\n"
printf "\n"
printf "test #10\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject5.ul

printf "\n"
printf "\n"
printf "test #11\n"
printf "test_statements_reject1.ul\n"
java Compiler tests/test_expr_reject6.ul
