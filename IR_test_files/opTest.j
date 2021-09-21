.source opTest.ir
.class public opTest
.super java/lang/Object

.method public static __main()V
	.limit locals 0
	.limit stack 16
L_0:
	invokestatic opTest/foo()V

	invokestatic opTest/bar()V

	return

L_1:
.end method

.method public static foo()V
	.limit locals 30
	.var 0 is T0 I from L_2 to L_3
	.var 1 is T1 I from L_2 to L_3
	.var 2 is T2 I from L_2 to L_3
	.var 3 is T3 I from L_2 to L_3
	.var 4 is T4 I from L_2 to L_3
	.var 5 is T5 Z from L_2 to L_3
	.var 6 is T6 Z from L_2 to L_3
	.var 7 is T7 Ljava/lang/String; from L_2 to L_3
	.var 8 is T8 Ljava/lang/String; from L_2 to L_3
	.var 9 is T9 I from L_2 to L_3
	.var 10 is T10 I from L_2 to L_3
	.var 11 is T11 I from L_2 to L_3
	.var 12 is T12 I from L_2 to L_3
	.var 13 is T13 Z from L_2 to L_3
	.var 14 is T14 Z from L_2 to L_3
	.var 15 is T15 Ljava/lang/String; from L_2 to L_3
	.var 16 is T16 Ljava/lang/String; from L_2 to L_3
	.var 17 is T17 I from L_2 to L_3
	.var 18 is T18 I from L_2 to L_3
	.var 19 is T19 I from L_2 to L_3
	.var 20 is T20 I from L_2 to L_3
	.var 21 is T21 Z from L_2 to L_3
	.var 22 is T22 Z from L_2 to L_3
	.var 23 is T23 Ljava/lang/String; from L_2 to L_3
	.var 24 is T24 Ljava/lang/String; from L_2 to L_3
	.var 25 is T25 I from L_2 to L_3
	.var 26 is T26 Z from L_2 to L_3
	.var 27 is T27 Z from L_2 to L_3
	.var 28 is T28 Ljava/lang/String; from L_2 to L_3
	.var 29 is T29 Ljava/lang/String; from L_2 to L_3
	.limit stack 16
L_2:
	ldc 3
	istore 1
	ldc 3
	istore 2
	iload 1
	iload 2
	imul
	istore 3
	iload 3
	istore 0
	ldc 9
	istore 4
	iload 0
	iload 4
	isub
	ifeq L_4
	ldc 0
	goto L_5
L_4:
	ldc 1
L_5:
	istore 5
	iload 5
	ldc 1
	ixor
	istore 6
	iload 6
	ifne L0

	ldc "int mult working"
	astore 7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 7

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L1

L0:

	ldc "int mult NOT working"
	astore 8
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 8

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L1:

	ldc 2
	istore 9
	ldc 3
	istore 10
	iload 9
	iload 10
	iadd
	istore 11
	iload 11
	istore 0
	ldc 5
	istore 12
	iload 0
	iload 12
	isub
	ifeq L_6
	ldc 0
	goto L_7
L_6:
	ldc 1
L_7:
	istore 13
	iload 13
	ldc 1
	ixor
	istore 14
	iload 14
	ifne L2

	ldc "int add working"
	astore 15
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 15

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L3

L2:

	ldc "int add NOT working"
	astore 16
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 16

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L3:

	ldc 5
	istore 17
	ldc 4
	istore 18
	iload 17
	iload 18
	isub
	istore 19
	iload 19
	istore 0
	ldc 1
	istore 20
	iload 0
	iload 20
	isub
	ifeq L_8
	ldc 0
	goto L_9
L_8:
	ldc 1
L_9:
	istore 21
	iload 21
	ldc 1
	ixor
	istore 22
	iload 22
	ifne L4

	ldc "int sub working"
	astore 23
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 23

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L5

L4:

	ldc "int sub NOT working"
	astore 24
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 24

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L5:

	ldc 2
	istore 25
	iload 0
	iload 25
	isub
	iflt L_10
	ldc 0
	goto L_11
	L_10:
	ldc 1
	L_11:
	istore 26
	iload 26
	ldc 1
	ixor
	istore 27
	iload 27
	ifne L6

	ldc "int less than working"
	astore 28
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 28

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L7

L6:

	ldc "int less than NOT working"
	astore 29
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 29

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L7:

	return

L_3:
.end method

.method public static bar()V
	.limit locals 30
	.var 0 is T0 F from L_12 to L_13
	.var 1 is T1 F from L_12 to L_13
	.var 2 is T2 F from L_12 to L_13
	.var 3 is T3 F from L_12 to L_13
	.var 4 is T4 F from L_12 to L_13
	.var 5 is T5 Z from L_12 to L_13
	.var 6 is T6 Z from L_12 to L_13
	.var 7 is T7 Ljava/lang/String; from L_12 to L_13
	.var 8 is T8 Ljava/lang/String; from L_12 to L_13
	.var 9 is T9 F from L_12 to L_13
	.var 10 is T10 F from L_12 to L_13
	.var 11 is T11 F from L_12 to L_13
	.var 12 is T12 F from L_12 to L_13
	.var 13 is T13 Z from L_12 to L_13
	.var 14 is T14 Z from L_12 to L_13
	.var 15 is T15 Ljava/lang/String; from L_12 to L_13
	.var 16 is T16 Ljava/lang/String; from L_12 to L_13
	.var 17 is T17 F from L_12 to L_13
	.var 18 is T18 F from L_12 to L_13
	.var 19 is T19 F from L_12 to L_13
	.var 20 is T20 F from L_12 to L_13
	.var 21 is T21 Z from L_12 to L_13
	.var 22 is T22 Z from L_12 to L_13
	.var 23 is T23 Ljava/lang/String; from L_12 to L_13
	.var 24 is T24 Ljava/lang/String; from L_12 to L_13
	.var 25 is T25 F from L_12 to L_13
	.var 26 is T26 Z from L_12 to L_13
	.var 27 is T27 Z from L_12 to L_13
	.var 28 is T28 Ljava/lang/String; from L_12 to L_13
	.var 29 is T29 Ljava/lang/String; from L_12 to L_13
	.limit stack 16
L_12:
	ldc 3.000000
	fstore 1
	ldc 3.000000
	fstore 2
	fload 1
	fload 2
	fmul
	fstore 3
	fload 3
	fstore 0
	ldc 9.000000
	fstore 4
	fload 0
	fload 4
	fcmpg
	ifeq L_14
	ldc 0
	goto L_15
L_14:
	ldc 1
L_15:
	istore 5
	iload 5
	ldc 1
	ixor
	istore 6
	iload 6
	ifne L0

	ldc "float mult working"
	astore 7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 7

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L1

L0:

	ldc "float mult NOT working"
	astore 8
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 8

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L1:

	ldc 2.500000
	fstore 9
	ldc 3.000000
	fstore 10
	fload 9
	fload 10
	fadd
	fstore 11
	fload 11
	fstore 0
	ldc 5.500000
	fstore 12
	fload 0
	fload 12
	fcmpg
	ifeq L_16
	ldc 0
	goto L_17
L_16:
	ldc 1
L_17:
	istore 13
	iload 13
	ldc 1
	ixor
	istore 14
	iload 14
	ifne L2

	ldc "float add working"
	astore 15
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 15

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L3

L2:

	ldc "float add NOT working"
	astore 16
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 16

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L3:

	ldc 5.000000
	fstore 17
	ldc 4.000000
	fstore 18
	fload 17
	fload 18
	fsub
	fstore 19
	fload 19
	fstore 0
	ldc 1.000000
	fstore 20
	fload 0
	fload 20
	fcmpg
	ifeq L_18
	ldc 0
	goto L_19
L_18:
	ldc 1
L_19:
	istore 21
	iload 21
	ldc 1
	ixor
	istore 22
	iload 22
	ifne L4

	ldc "float sub working"
	astore 23
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 23

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L5

L4:

	ldc "float sub NOT working"
	astore 24
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 24

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L5:

	ldc 2.000000
	fstore 25
	fload 0
	fload 25
	fcmpg
	iflt L_20
	ldc 0
	goto L_21
	L_20:
	ldc 1
	L_21:
	istore 26
	iload 26
	ldc 1
	ixor
	istore 27
	iload 27
	ifne L6

	ldc "float less than working"
	astore 28
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 28

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L7

L6:

	ldc "float less than NOT working"
	astore 29
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 29

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L7:

	return

L_13:
.end method

.method public static baz()V
	.limit locals 7
	.var 0 is T0 C from L_22 to L_23
	.var 1 is T1 C from L_22 to L_23
	.var 2 is T2 C from L_22 to L_23
	.var 3 is T3 Z from L_22 to L_23
	.var 4 is T4 Z from L_22 to L_23
	.var 5 is T5 Ljava/lang/String; from L_22 to L_23
	.var 6 is T6 Ljava/lang/String; from L_22 to L_23
	.limit stack 16
L_22:
	ldc 97
	istore 1
	iload 1
	istore 0
	ldc 98
	istore 2
	iload 0
	iload 2
	isub
	iflt L_24
	ldc 0
	goto L_25
	L_24:
	ldc 1
	L_25:
	istore 3
	iload 3
	ldc 1
	ixor
	istore 4
	iload 4
	ifne L0

	ldc "char less than working"
	astore 5
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 5

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L1

L0:

	ldc "char less than NOT working"
	astore 6
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 6

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L1:

	return

L_23:
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
	invokestatic opTest/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
