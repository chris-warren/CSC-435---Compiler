.source boolEquality.ir
.class public boolEquality
.super java/lang/Object

.method public static __main()V
	.limit locals 0
	.limit stack 16
L_0:
	invokestatic boolEquality/bar()V

	return

L_1:
.end method

.method public static bar()V
	.limit locals 12
	.var 0 is T0 Z from L_2 to L_3
	.var 1 is T1 Z from L_2 to L_3
	.var 2 is T2 Z from L_2 to L_3
	.var 3 is T3 Z from L_2 to L_3
	.var 4 is T4 Ljava/lang/String; from L_2 to L_3
	.var 5 is T5 Ljava/lang/String; from L_2 to L_3
	.var 6 is T6 Z from L_2 to L_3
	.var 7 is T7 Z from L_2 to L_3
	.var 8 is T8 Z from L_2 to L_3
	.var 9 is T9 Z from L_2 to L_3
	.var 10 is T10 Ljava/lang/String; from L_2 to L_3
	.var 11 is T11 Ljava/lang/String; from L_2 to L_3
	.limit stack 16
L_2:
	ldc 0
	istore 0
	ldc 0
	istore 1
	iload 0
	iload 1
	ixor
	ldc 1
	ixor
	istore 2
	iload 2
	ldc 1
	ixor
	istore 3
	iload 3
	ifne L0

	ldc "bool equality is "
	astore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 4
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	goto L1

L0:

	ldc "wrong if"
	astore 5
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 5

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L1:

	ldc 0
	istore 6
	ldc 1
	istore 7
	iload 6
	iload 7
	ixor
	ldc 1
	ixor
	istore 8
	iload 8
	ldc 1
	ixor
	istore 9
	iload 9
	ifne L2

	ldc "not working"
	astore 10
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 10

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L3

L2:

	ldc "working"
	astore 11
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 11

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L3:

	return

L_3:
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
	invokestatic boolEquality/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
