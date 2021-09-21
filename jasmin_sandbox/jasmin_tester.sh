#!/bin/bash
# bash jasmin_sandbox/jasmin_tester.sh
../codegen --file=jasmin_sandbox/simple.ir > jasmin_sandbox/simple.j
java jasmin.Main jasmin_sandbox/simple.j