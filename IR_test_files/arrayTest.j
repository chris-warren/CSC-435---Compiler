.source arrayTest.ir
.class public arrayTest
.super java/lang/Object

.method public static __main()V
	.limit locals 5
	.var 0 is T0 [Ljava/lang/String; from L_0 to L_1
	.var 1 is T1 I from L_0 to L_1
	.var 2 is T2 Ljava/lang/String; from L_0 to L_1
	.var 3 is T3 I from L_0 to L_1
	.var 4 is T4 Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	ldc 1
	anewarray java/lang/String
	astore 0

	ldc 0
	istore 1
	ldc "arrays are working"
	astore 2
	aload 0
	iload 1
	aload 2
	aastore

	ldc 0
	istore 3
	aload 0
	iload 3
	aaload 
	astore 4
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 4

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

	return

L_1:
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
	invokestatic arrayTest/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
