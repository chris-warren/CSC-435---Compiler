.source printingString.ir
.class public printingString
.super java/lang/Object

.method public static __main()V
	.limit locals 2
	.var 0 is T0 Ljava/lang/String; from L_0 to L_1
	.var 1 is T1 Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	ldc "test string"
	astore 1
	aload 1
	astore 0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0

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
	invokestatic printingString/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
