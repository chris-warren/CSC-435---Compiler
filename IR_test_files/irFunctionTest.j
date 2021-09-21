.source irFunctionTest.ir
.class public irFunctionTest
.super java/lang/Object

.method public static __main()V
	.limit locals 7
	.var 0 is T0 Ljava/lang/String; from L_0 to L_1
	.var 1 is T1 Ljava/lang/String; from L_0 to L_1
	.var 2 is T2 Ljava/lang/String; from L_0 to L_1
	.var 3 is T3 Ljava/lang/String; from L_0 to L_1
	.var 4 is T4 Ljava/lang/String; from L_0 to L_1
	.var 5 is T5 Ljava/lang/String; from L_0 to L_1
	.var 6 is T6 Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	ldc "multiple "
	astore 4
	aload 4
	astore 1
	ldc "parameters "
	astore 5
	aload 5
	astore 2
	ldc "are working"
	astore 6
	aload 6
	astore 3
	aload 1
	aload 2
	aload 3
	invokestatic irFunctionTest/foo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

	return

L_1:
.end method

.method public static foo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
	.limit locals 3
	.var 0 is T0 Ljava/lang/String; from L_2 to L_3
	.var 1 is T1 Ljava/lang/String; from L_2 to L_3
	.var 2 is T2 Ljava/lang/String; from L_2 to L_3
	.limit stack 16
L_2:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 1
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 2

	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

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
	invokestatic irFunctionTest/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
