.source ifelsetest.ir
.class public ifelsetest
.super java/lang/Object

.method public static __main()V
	.limit locals 1
	.var 0 is T0 Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	ldc "if else test file"
	astore 0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	invokestatic ifelsetest/foo()V

	return

L_1:
.end method

.method public static foo()V
	.limit locals 8
	.var 0 is T0 Z from L_2 to L_3
	.var 1 is T1 Z from L_2 to L_3
	.var 2 is T2 Ljava/lang/String; from L_2 to L_3
	.var 3 is T3 Z from L_2 to L_3
	.var 4 is T4 Z from L_2 to L_3
	.var 5 is T5 Ljava/lang/String; from L_2 to L_3
	.var 6 is T6 Ljava/lang/String; from L_2 to L_3
	.var 7 is T7 Ljava/lang/String; from L_2 to L_3
	.limit stack 16
L_2:
	ldc 1
	istore 0
	iload 0
	ldc 1
	ixor
	istore 1
	iload 1
	ifne L0

	ldc "first if working"
	astore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 2

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	ldc 0
	istore 3
	iload 3
	ldc 1
	ixor
	istore 4
	iload 4
	ifne L2

	ldc "second if not working"
	astore 5
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 5

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	goto L3

L2:

	ldc "second if working"
	astore 6
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 6

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L3:

	goto L1

L0:

	ldc "first if not working"
	astore 7
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 7

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

L1:

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
	invokestatic ifelsetest/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
