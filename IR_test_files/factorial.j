.source factorial.ir
.class public factorial
.super java/lang/Object

.method public static __main()V
	.limit locals 3
	.var 0 is T0 Ljava/lang/String; from L_0 to L_1
	.var 1 is T1 I from L_0 to L_1
	.var 2 is T2 I from L_0 to L_1
	.limit stack 16
L_0:
	ldc "The factorial of 8 is: "
	astore 0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	ldc 8
	istore 1
	iload 1
	invokestatic factorial/factorial(I)I
	istore 2
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2

	invokevirtual java/io/PrintStream/println(I)V

	return

L_1:
.end method

.method public static factorial(I)I
	.limit locals 10
	.var 0 is T0 I from L_2 to L_3
	.var 1 is T1 I from L_2 to L_3
	.var 2 is T2 I from L_2 to L_3
	.var 3 is T3 Z from L_2 to L_3
	.var 4 is T4 Z from L_2 to L_3
	.var 5 is T5 I from L_2 to L_3
	.var 6 is T6 I from L_2 to L_3
	.var 7 is T7 I from L_2 to L_3
	.var 8 is T8 I from L_2 to L_3
	.var 9 is T9 I from L_2 to L_3
	.limit stack 16
L_2:
	ldc 1
	istore 2
	iload 0
	iload 2
	isub
	ifeq L_4
	ldc 0
	goto L_5
L_4:
	ldc 1
L_5:
	istore 3
	iload 3
	ldc 1
	ixor
	istore 4
	iload 4
	ifne L0

	ldc 1
	istore 5
	iload 5
	ireturn

	goto L1

L0:

	ldc 1
	istore 6
	iload 0
	iload 6
	isub
	istore 7
	iload 7
	invokestatic factorial/factorial(I)I
	istore 8
	iload 0
	iload 8
	imul
	istore 9
	iload 9
	ireturn

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
	invokestatic factorial/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
