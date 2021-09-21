/*
 * Compiler.java
 *
 * A starting place for the unnamed language compiler for CSC 435/535
 * /home/jcorless/csc435/codegen/codegen --file=simple.ir > simple.j
 */

import org.antlr.runtime.*;
import java.io.*;
import AST.*;
import ir.*;
import java.util.ArrayList;

public class Compiler {
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Compiler filename.ul");
			return;
		}
		else {
			input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

		// The name of the grammar here is "ulNoActions",
		// so ANTLR generates ulNoActionsLexer and ulNoActionsParser
		ulLexer lexer = new ulLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulParser parser = new ulParser(tokens);

		try {
			Program p = parser.program();
			PrettyPrintVisitor v = new PrettyPrintVisitor();
			TypeCheckVisitor tv = new TypeCheckVisitor();
			IRVisitor irv = new IRVisitor();
			p.accept(tv);
			p.accept(irv);
			//p.accept(v);
			String name = ((args[0].split("/")[1]).toString());
			name = name.substring(0, name.length() - 3);
			IRGen irgen = new IRGen();
			//irgen.printOut(irv.fList, name);
			ArrayList<IRFunction> fList = irv.fList;
			JGenerator jGen = new JGenerator(fList, name);
			jGen.writeToFile();
			//irv.factory.output(name);
			
		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
		catch (Exception e) {
			System.out.println(e);
			//e.printStackTrace();
		}
	}
}
