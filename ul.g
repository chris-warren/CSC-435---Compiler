grammar ul;

options { backtrack=true;}

@header {
        import java.util.HashMap;
		import AST.*;
		import java.util.ArrayList;
		import TYPES.*;
}

@members {
        HashMap memory = new HashMap();

}

program returns [Program p]
@init
{
	ArrayList<Function> functions = new ArrayList<Function>();
}
:
	(f = function{functions.add(f);})+ EOF
	{ 
		p = new Program(functions, "pname");
	}
	;
	
function returns [Function f]
:
	d = functionDecl b = functionBody
	{
		f = new Function(d, b, "fname", d.line, d.offset);
	}
	;

functionDecl returns [FunctionDecl d]
:
	cType = compoundType iden = id '(' p = formalParameters ')'
	{
		d = new FunctionDecl(cType, iden, p, "function decl", cType.line, cType.offset);
	}
	;

formalParameters returns [FormalParameterList p]
@init{
	ArrayList<FormalParameter> params = new ArrayList<FormalParameter>();
}
@after{
		p = new FormalParameterList(params);
}
:
	(t = compoundType iden = id{
		params.add(new FormalParameter(new Declaration(t, iden, t.line, t.offset), t.line, t.offset));
		}) 
	(d = moreFormals{
		params.add(new FormalParameter(d, d.line, d.offset));
		})*
	|
	;

moreFormals returns [Declaration d]:
	',' t = compoundType iden = id{d = new Declaration(t, iden, t.line, t.offset);}
	;

functionBody returns [FunctionBody b]
@init{
	ArrayList<VarDecl> declarations = new ArrayList<VarDecl>();
	ArrayList<Statement> statements = new ArrayList<Statement>();
}
@after{
		b = new FunctionBody(new VarDeclList(declarations), new StatementList(statements));
}
:
	'{' (v = varDecl{declarations.add(v);})* (d = statement{statements.add(d);})* '}'
	;

varDecl returns[VarDecl v]:
	t = compoundType i = id SEMI{v = new VarDecl(t, i, i.line, i.offset);}
	;

compoundType returns [TypeNode tnode]:
	t = type
	{
		tnode = t;
		//tnode.type = "test";
		//System.out.println(tnode.type);
	}
	| t = type '[' s = integerConstant ']'
	{
		tnode = new TypeNode(new ArrayType(t.t, s.val), t.line, t.offset);
		//tnode.type = "test";
	}
	;

type returns [TypeNode t]:
	FLOAT {t = new TypeNode(new FloatType(), $FLOAT.line, $FLOAT.getCharPositionInLine());}
	| INT {t = new TypeNode(new IntegerType(), $INT.line, $INT.getCharPositionInLine());}
	| CHAR {t = new TypeNode(new CharType(), $CHAR.line, $CHAR.getCharPositionInLine());} 
	| STRING {t = new TypeNode(new StringType(), $STRING.line, $STRING.getCharPositionInLine());}
	| BOOLEAN {t = new TypeNode(new BooleanType(), $BOOLEAN.line, $BOOLEAN.getCharPositionInLine());}
	| VOID {t = new TypeNode(new VoidType(), $VOID.line, $VOID.getCharPositionInLine());}
;


statement returns [Statement s]:
	SEMI{s = new Statement();}/*not sure what class to make this */
	| e = expr SEMI{s = new ExprStatement(e, e.line, e.offset);}
	| IF OPENPAREN e = expr CLOSEPAREN b1 = block ELSE b2 = block{s = new IfElseStatement(e, b1, b2, $OPENPAREN.line, $OPENPAREN.getCharPositionInLine());}
	| IF OPENPAREN e = expr CLOSEPAREN b = block{s = new IfStatement(e, b, $OPENPAREN.line, $OPENPAREN.getCharPositionInLine());}
	| WHILE OPENPAREN e = expr CLOSEPAREN b = block{s = new WhileStatement(e, b, $OPENPAREN.line, $OPENPAREN.getCharPositionInLine());}
	| PRINT e = expr SEMI{s = new PrintStatement(e, e.line, e.offset);}
	| PRINTLN e = expr SEMI{s = new PrintLnStatement(e, e.line, e.offset);}
	| RETURN (e = expr)? SEMI{s = new ReturnStatement(e, $RETURN.line, $RETURN.getCharPositionInLine());}
	| i = id '=' e = expr SEMI{s = new AssignmentStatement(i, e, i.line, i.offset);}
	/* 
	| i = id '=' e = expr SEMI{s = new AssignmentStatement(i, e);}
	*/
	| ar = arrayRef '=' e2 = expr SEMI{s = new ArrayAssignment(ar, e2, ar.line, ar.offset);}
	/* 
	| i = id '[' e1 = expr ']' '=' e2 = expr SEMI{s = new ArrayAssignment(new ArrayRef(i, e1), e2);}
	*/
	;

block returns [Block b]
@init{
	ArrayList<Statement> statements = new ArrayList<Statement>();
	int li = 9999;
	int ofs = 9999;
}
@after{
		b = new Block(new StatementList(statements), li, ofs);
}
:
	'{' (s = statement{
		statements.add(s);
		li = s.line;
		ofs = s.offset;
		})* '}'
	;

expr returns [Expr e]
@init{
		Expr it = null;
	}
	@after{
		e = it;
	}:
	e1 = compareExpr{it = e1;} ( EQUALITY e2 = compareExpr{it = new EqualityExp(it, e2, $EQUALITY.line, $EQUALITY.getCharPositionInLine());} )*
 
	;

compareExpr returns [Expr e]
@init{
		Expr it = null;
	}
	@after{
		e = it;
	}:
	e1 = addExpr{it = e1;} ( LESSTHAN e2 = addExpr{it = new CompareExpr(it, e2, $LESSTHAN.line, $LESSTHAN.getCharPositionInLine());} )*
	;

addExpr returns [Expr e]
	@init{
		Expr it = null;
		Boolean bool = false;
		int line = -1;
		int offset = -1;
	}
	@after{
		e = it;
	}
	:
		e1 = multExpr {it = e1;}
		((PLUS{line = $PLUS.line; offset = $PLUS.getCharPositionInLine();}|MINUS{line = $MINUS.line; offset = $MINUS.getCharPositionInLine();}{bool = true;}) e2 = multExpr
		{it = new AddExpr(it, e2, bool, line, offset);}
		)*
	/* 
	multExpr ( ('+'|'-') multExpr )*
	*/
	;

multExpr returns [Expr e]
@init{
		Expr it = null;
	}
@after{
		e = it;
	}:
	e1 = atom{it = e1;} 
	( STAR e2 = atom
	{it = new MultExpr(it, e2, $STAR.line, $STAR.getCharPositionInLine());} 
	)*
	;
	

	/*
	do i need literal and float constant? or char etc
	 */
atom returns [Expr e]	:
	  i = id {e = i;}
	| l = literal{e = l;}
	| f = funcCall{e = f;}
	| a = arrayRef{e = a;}
	| brack = brackExp{e = brack;}
	| b = true_{e = b;}
	| b = false_{e = b;}
	;
	

funcCall returns [FuncCall f]:
	i = id '(' e = exprList ')'{f = new FuncCall(i, e, i.line, i.offset);}
	;

arrayRef returns [ArrayRef a]:
	i = id '[' e = expr ']'{a = new ArrayRef(i, e, i.line, i.offset);}
	;

brackExp returns [Expr e]:
	'(' ex = expr ')'{e = new BrackExp(ex, ex.line, ex.offset);}
	;

true_ returns [BooleanLiteral b]:
	TRUE{b = new BooleanLiteral(true, $TRUE.line, $TRUE.getCharPositionInLine());}
	;

false_ returns [BooleanLiteral b]:
	FALSE{b = new BooleanLiteral(false, $FALSE.line, $FALSE.getCharPositionInLine());}
	;

id returns [Id iden] : 
ID
{
	iden = new Id($ID.text, $ID.line, $ID.getCharPositionInLine());
	//iden = new Id($ID.text);
	}
	;


integerConstant returns [IntLiteral i]: 
	INTCONST{i = new IntLiteral(Integer.parseInt($INTCONST.text), $INTCONST.line, $INTCONST.getCharPositionInLine());
			//System.out.println($INTCONST.line);
	}
	;

stringConstant returns [StringLiteral s]:
	STRCONST{s = new StringLiteral($STRCONST.text.substring(1,$STRCONST.text.length()-1), $STRCONST.line, $STRCONST.getCharPositionInLine());}
	;

floatConstant returns [FloatLiteral f]:
	FLOATCONST{f = new FloatLiteral(Float.parseFloat($FLOATCONST.text), $FLOATCONST.line, $FLOATCONST.getCharPositionInLine());}
	;

characterConstant returns [CharacterLiteral c]:
	CHARCONST{c = new CharacterLiteral($CHARCONST.text.charAt(1), $CHARCONST.line, $CHARCONST.getCharPositionInLine());}
	;

literal returns [Expr e]:
	s = stringConstant{e = s;}
	|i = integerConstant{e = i;}
	|f = floatConstant{e = f;}
	|c = characterConstant{e = c;}
	|b = TRUE{e = new BooleanLiteral(true, $TRUE.line, $TRUE.getCharPositionInLine());}
	|b = FALSE{e = new BooleanLiteral(false, $FALSE.line, $FALSE.getCharPositionInLine());}
	;	

exprList returns [ExprList e]
@init{
	ArrayList<Expr> eList = new ArrayList<Expr>();
	int li = 9999;
	int ofs = 9999;
}
@after{
		e = new ExprList(eList, li, ofs);
}
:
	e1 = expr{
		eList.add(e1);
		li = e1.line;
		ofs = e1.offset;
		} (e2 = exprMore{eList.add(e2);})*
	|
	;

exprMore returns [Expr e]:
	',' ex = expr{e = ex;}
	;
 
	
/*LEX*/
WS	: ( '\t' | ' ' | ('\r' | '\n') )+ { $channel = HIDDEN;}
	;

SEMI:
	';'
	;

OPENPAREN:'(';
CLOSEPAREN:')';
OPENCURLY:'{';
CLOSECURLY:'}';

STAR: '*';
PLUS: '+';
MINUS: '-';
EQUALITY: '==';
LESSTHAN: '<';

FLOAT:'float';
INT: 'int';
CHAR: 'char';
STRING: 'string';
BOOLEAN: 'boolean';
VOID: 'void';
	
/* 
TYPE:
	'float'
	| 'int' 
	| 'char'
	| 'string'
	| 'boolean'
	| 'void'
	;
*/
PRINT:
	'print'
	;

PRINTLN:
	'println'
	;

RETURN:
	'return'
	;

IF:
	'if'
	;
ELSE:
	'else'
	;

TRUE:
	'true'
	;

WHILE:
	'while'
	;

FALSE:
	'false'
	;

STRCONST:
	'"'(('A'..'Z')|('a'..'z')|' '|('0'..'9')|':'|'.')+'"'
	;

FLOATCONST:
	('0'..'9')+ '.' ('0'..'9')+
	;

CHARCONST:
	'\''('a'..'z')'\''
	;

ID	: ('a'..'z')+
	;

INTCONST : ('0'..'9')+;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN; } ;