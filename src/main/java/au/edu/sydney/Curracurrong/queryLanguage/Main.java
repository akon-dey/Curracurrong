package au.edu.sydney.Curracurrong.queryLanguage;

import org.antlr.runtime.*;

public class Main {
	public static void main(String[] args) throws Exception {
		CharStream input = new ANTLRFileStream("C:\\query\test4.txt");
                //ANTLRInputStream input = new ANTLRInputStream(System.in);
		TLexer lex = new TLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		//System.out.println("tokens="+tokens);
		TParser parser = new TParser(tokens);
		parser.program();
	}
}
