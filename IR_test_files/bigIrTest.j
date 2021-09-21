.source bigIrTest.ir
.class public bigIrTest
.super java/lang/Object

.method public static __main()V
	.limit locals 27
	.var 0 is T0 Z from L_0 to L_1
	.var 1 is T1 [I from L_0 to L_1
	.var 2 is T2 [I from L_0 to L_1
	.var 3 is T3 I from L_0 to L_1
	.var 4 is T4 I from L_0 to L_1
	.var 5 is T5 I from L_0 to L_1
	.var 6 is T6 I from L_0 to L_1
	.var 7 is T7 Ljava/lang/String; from L_0 to L_1
	.var 8 is T8 I from L_0 to L_1
	.var 9 is T9 I from L_0 to L_1
	.var 10 is T10 Ljava/lang/String; from L_0 to L_1
	.var 11 is T11 F from L_0 to L_1
	.var 12 is T12 F from L_0 to L_1
	.var 13 is T13 Ljava/lang/String; from L_0 to L_1
	.var 14 is T14 C from L_0 to L_1
	.var 15 is T15 C from L_0 to L_1
	.var 16 is T16 Ljava/lang/String; from L_0 to L_1
	.var 17 is T17 Z from L_0 to L_1
	.var 18 is T18 Z from L_0 to L_1
	.var 19 is T19 Z from L_0 to L_1
	.var 20 is T20 Ljava/lang/String; from L_0 to L_1
	.var 21 is T21 Z from L_0 to L_1
	.var 22 is T22 Ljava/lang/String; from L_0 to L_1
	.var 23 is T23 Z from L_0 to L_1
	.var 24 is T24 Z from L_0 to L_1
	.var 25 is T25 Ljava/lang/String; from L_0 to L_1
	.var 26 is T26 Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	ldc 1
	newarray int
	astore 1

	ldc 1
	newarray int
	astore 2

	ldc 0
	istore 3
	ldc 1
	istore 4
	aload 1
	iload 3
	iload 4
	iastore

	ldc 0
	istore 5
	ldc 2
	istore 6
	aload 2
	iload 5
	iload 6
	iastore

	ldc "int math test should be 15 result: "
	astore 7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 7
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 10
	istore 8
	iload 8
	invokestatic bigIrTest/foo(I)I
	istore 9
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 9

	invokevirtual java/io/PrintStream/println(I)V

	ldc "float math test should be 15.0 result: "
	astore 10
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 10
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 10.000000
	fstore 11
	fload 11
	invokestatic bigIrTest/bar(F)F
	fstore 12
	getstatic java/lang/System/out Ljava/io/PrintStream;
	fload 12

	invokevirtual java/io/PrintStream/println(F)V

	ldc "char test result: "
	astore 13
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 13
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 99
	istore 14
	iload 14
	invokestatic bigIrTest/baz(C)C
	istore 15
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 15

	invokevirtual java/io/PrintStream/println(C)V

	ldc "bool test result: "
	astore 16
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 16
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 0
	istore 17
	iload 17
	invokestatic bigIrTest/qux(Z)Z
	istore 18
	iload 18
	istore 0
	iload 0
	ldc 1
	ixor
	istore 19
	iload 19
	ifne L0

	ldc "booleans are working"
	astore 20
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 20

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L0:

	iload 0
	ldc 1
	ixor
	istore 21
	iload 21
	ifne L1

	goto L2

L1:

	ldc "booleans are not working"
	astore 22
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 22

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L2:

	ldc 1
	istore 23
	iload 23
	ldc 1
	ixor
	istore 24
	iload 24
	ifne L3

	ldc "if statements are working"
	astore 25
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 25

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L3:

	invokestatic bigIrTest/quux()V

	ldc "array as params should be 3 result: "
	astore 26
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 26
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	aload 1
	aload 2
	invokestatic bigIrTest/quo([I[I)V

	return

L_1:
.end method

.method public static foo(I)I
	.limit locals 14
	.var 0 is T0 I from L_2 to L_3
	.var 1 is T1 I from L_2 to L_3
	.var 2 is T2 I from L_2 to L_3
	.var 3 is T3 I from L_2 to L_3
	.var 4 is T4 [I from L_2 to L_3
	.var 5 is T5 I from L_2 to L_3
	.var 6 is T6 I from L_2 to L_3
	.var 7 is T7 I from L_2 to L_3
	.var 8 is T8 I from L_2 to L_3
	.var 9 is T9 I from L_2 to L_3
	.var 10 is T10 I from L_2 to L_3
	.var 11 is T11 I from L_2 to L_3
	.var 12 is T12 I from L_2 to L_3
	.var 13 is T13 I from L_2 to L_3
	.limit stack 16
L_2:
	ldc 2
	newarray int
	astore 4

	ldc 0
	istore 5
	ldc 1
	istore 6
	aload 4
	iload 5
	iload 6
	iastore

	ldc 2
	istore 7
	iload 7
	istore 1
	ldc 3
	istore 8
	iload 8
	istore 2
	iload 1
	iload 2
	imul
	istore 9
	iload 0
	iload 9
	iadd
	istore 10
	ldc 0
	istore 11
	aload 4
	iload 11
	iaload 
	istore 12
	iload 10
	iload 12
	isub
	istore 13
	iload 13
	istore 3
	iload 3
	ireturn

	return

L_3:
.end method

.method public static bar(F)F
	.limit locals 13
	.var 0 is T0 F from L_4 to L_5
	.var 1 is T1 F from L_4 to L_5
	.var 2 is T2 F from L_4 to L_5
	.var 3 is T3 F from L_4 to L_5
	.var 4 is T4 [F from L_4 to L_5
	.var 5 is T5 I from L_4 to L_5
	.var 6 is T6 F from L_4 to L_5
	.var 7 is T7 F from L_4 to L_5
	.var 8 is T8 F from L_4 to L_5
	.var 9 is T9 F from L_4 to L_5
	.var 10 is T10 F from L_4 to L_5
	.var 11 is T11 F from L_4 to L_5
	.var 12 is T12 F from L_4 to L_5
	.limit stack 16
L_4:
	ldc 2
	newarray float
	astore 4

	ldc 0
	istore 5
	ldc 1.000000
	fstore 6
	aload 4
	iload 5
	fload 6
	fastore

	ldc 2.000000
	fstore 7
	fload 7
	fstore 1
	ldc 3.000000
	fstore 8
	fload 8
	fstore 2
	fload 1
	fload 2
	fmul
	fstore 9
	fload 0
	fload 9
	fadd
	fstore 10
	ldc 1.000000
	fstore 11
	fload 10
	fload 11
	fsub
	fstore 12
	fload 12
	fstore 3
	fload 3
	freturn

	return

L_5:
.end method

.method public static baz(C)C
	.limit locals 8
	.var 0 is T0 C from L_6 to L_7
	.var 1 is T1 [C from L_6 to L_7
	.var 2 is T2 Ljava/lang/String; from L_6 to L_7
	.var 3 is T3 I from L_6 to L_7
	.var 4 is T4 C from L_6 to L_7
	.var 5 is T5 Ljava/lang/String; from L_6 to L_7
	.var 6 is T6 I from L_6 to L_7
	.var 7 is T7 C from L_6 to L_7
	.limit stack 16
L_6:
	ldc 2
	newarray char
	astore 1

	ldc 0
	istore 3
	ldc 103
	istore 4
	aload 1
	iload 3
	iload 4
	castore

	ldc "hars are workin"
	astore 5
	aload 5
	astore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0

	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 2
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 0
	istore 6
	aload 1
	iload 6
	caload 
	istore 7
	iload 7
	ireturn

	return

L_7:
.end method

.method public static qux(Z)Z
	.limit locals 7
	.var 0 is T0 Z from L_8 to L_9
	.var 1 is T1 Z from L_8 to L_9
	.var 2 is T2 Z from L_8 to L_9
	.var 3 is T3 Z from L_8 to L_9
	.var 4 is T4 Z from L_8 to L_9
	.var 5 is T5 Z from L_8 to L_9
	.var 6 is T6 Ljava/lang/String; from L_8 to L_9
	.limit stack 16
L_8:
	ldc 0
	istore 3
	iload 3
	istore 2
	ldc 1
	istore 4
	iload 4
	istore 1
	iload 0
	ldc 1
	ixor
	istore 5
	iload 5
	ifne L0

	ldc "booleans are not working"
	astore 6
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 6

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	iload 2
	ireturn

	goto L1

L0:

	iload 1
	ireturn

L1:

	iload 2
	ireturn

	return

L_9:
.end method

.method public static quux()V
	.limit locals 8
	.var 0 is T0 I from L_10 to L_11
	.var 1 is T1 Ljava/lang/String; from L_10 to L_11
	.var 2 is T2 I from L_10 to L_11
	.var 3 is T3 I from L_10 to L_11
	.var 4 is T4 Z from L_10 to L_11
	.var 5 is T5 Z from L_10 to L_11
	.var 6 is T6 I from L_10 to L_11
	.var 7 is T7 I from L_10 to L_11
	.limit stack 16
L_10:
	ldc "while test result should be 5 result: "
	astore 1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 1
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 0
	istore 2
	iload 2
	istore 0
L0:

	ldc 5
	istore 3
	iload 0
	iload 3
	isub
	iflt L_12
	ldc 0
	goto L_13
	L_12:
	ldc 1
	L_13:
	istore 4
	iload 4
	ldc 1
	ixor
	istore 5
	iload 5
	ifne L1

	ldc 1
	istore 6
	iload 0
	iload 6
	iadd
	istore 7
	iload 7
	istore 0
	goto L0

L1:

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0

	invokevirtual java/io/PrintStream/println(I)V

	return

L_11:
.end method

.method public static quo([I[I)V
	.limit locals 8
	.var 0 is T0 [I from L_14 to L_15
	.var 1 is T1 [I from L_14 to L_15
	.var 2 is T2 I from L_14 to L_15
	.var 3 is T3 I from L_14 to L_15
	.var 4 is T4 I from L_14 to L_15
	.var 5 is T5 I from L_14 to L_15
	.var 6 is T6 I from L_14 to L_15
	.var 7 is T7 I from L_14 to L_15
	.limit stack 16
L_14:
	ldc 0
	istore 3
	aload 0
	iload 3
	iaload 
	istore 4
	ldc 0
	istore 5
	aload 1
	iload 5
	iaload 
	istore 6
	iload 4
	iload 6
	iadd
	istore 7
	iload 7
	istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2

	invokevirtual java/io/PrintStream/println(I)V

	return

L_15:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 16
	invokestatic bigIrTest/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
