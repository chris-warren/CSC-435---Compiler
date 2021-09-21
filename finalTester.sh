#!/bin/bash
#  export CLASSPATH=/home/jcorless/csc435/codegen/jasmin-2708/classes/:/home/jcorless/csc435/codegen/polyglot-1.3.4/classes/:/home/jcorless/csc435/codegen/soot-2708/classes/:/home/jcorless/csc435/codegen/polyglot-1.3.4/cup-classes/:$CLASSPATH
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
printf "factorial.ul\n"
java Compiler tests/factorial.ul
#../codegen --file=IR_test_files/factorial.ir > IR_test_files/factorial.j
cd IR_test_files
java jasmin.Main factorial.j
java factorial
cd ..

printf "\n"
printf "\n"
printf "test #2\n"
printf "printTest.ul\n"
java Compiler tests/printTest.ul
#../codegen --file=IR_test_files/printTest.ir > IR_test_files/printTest.j
cd IR_test_files
java jasmin.Main printTest.j
java printTest
cd ..



printf "\n"
printf "\n"
printf "test #3\n"
printf "ifelsetest.ul\n"
java Compiler tests/ifelsetest.ul
#../codegen --file=IR_test_files/ifelsetest.ir > IR_test_files/ifelsetest.j
cd IR_test_files
java jasmin.Main ifelsetest.j
java ifelsetest
cd ..

printf "\n"
printf "\n"
printf "test #4\n"
printf "printingString.ul\n"
java Compiler tests/printingString.ul
#../codegen --file=IR_test_files/printingString.ir > IR_test_files/printingString.j
cd IR_test_files
java jasmin.Main printingString.j
java printingString
cd ..

printf "\n"
printf "\n"
printf "test #5\n"
printf "arrayTest.ul\n"
java Compiler tests/arrayTest.ul
#../codegen --file=IR_test_files/arrayTest.ir > IR_test_files/arrayTest.j
cd IR_test_files
java jasmin.Main arrayTest.j
java arrayTest
cd ..

printf "\n"
printf "\n"
printf "test #6\n"
printf "irFunctionTest.ul\n"
java Compiler tests/irFunctionTest.ul
#../codegen --file=IR_test_files/irFunctionTest.ir > IR_test_files/irFunctionTest.j
cd IR_test_files
java jasmin.Main irFunctionTest.j
java irFunctionTest
cd ..

printf "\n"
printf "\n"
printf "test #7\n"
printf "bigIrTest.ul\n"
java Compiler tests/bigIrTest.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main bigIrTest.j
java bigIrTest
cd ..

printf "\n"
printf "\n"
printf "test #8\n"
printf "stringEquality.ul\n"
java Compiler tests/stringEquality.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main stringEquality.j
java stringEquality
cd ..

printf "\n"
printf "\n"
printf "test #9\n"
printf "floatEquality.ul\n"
java Compiler tests/floatEquality.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main floatEquality.j
java floatEquality
cd ..

printf "\n"
printf "\n"
printf "test #10\n"
printf "intEquality.ul\n"
java Compiler tests/intEquality.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main intEquality.j
java intEquality
cd ..

printf "\n"
printf "\n"
printf "test #11\n"
printf "charEquality.ul\n"
java Compiler tests/charEquality.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main charEquality.j
java charEquality
cd ..

printf "\n"
printf "\n"
printf "test #12\n"
printf "boolEquality.ul\n"
java Compiler tests/boolEquality.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main boolEquality.j
java boolEquality
cd ..

printf "\n"
printf "\n"
printf "test #13\n"
printf "opTest.ul\n"
java Compiler tests/opTest.ul
#../codegen --file=IR_test_files/bigIrTest.ir > IR_test_files/bigIrTest.j
cd IR_test_files
java jasmin.Main opTest.j
java opTest
cd ..