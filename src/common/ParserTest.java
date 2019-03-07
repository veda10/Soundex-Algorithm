package common;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ParserTest {

	static Set<String> nounPhrases = new HashSet<>();
	static int noun_size=0;
	
	public void getNounPhrases(Parse p) {
	    if (p.getType().equals("NNP") || p.getType().equals("NNPS")) {
	         nounPhrases.add(p.getCoveredText());
	         //System.out.println(p.getCoveredText());
	    }
	    
	    for (Parse child : p.getChildren()) {
	         getNounPhrases(child);
	    }
	}
	
	
	public void parserAction(String line) throws Exception {
		InputStream is = new FileInputStream("en-parser-chunking.bin");
	    ParserModel model = new ParserModel(is);
	    Parser parser = ParserFactory.create(model);
	    Parse topParses[] = ParserTool.parseLine(line, parser, 1);
	    for (Parse p : topParses){
	    	getNounPhrases(p);
	    }
	}
	public static void main(String sc) throws Exception {
		/*FileReader file = new FileReader("H:\\Sem5\\IR\\IR_1\\inputfiles\\input1.txt");
		   
	    BufferedReader reader = new BufferedReader(file);

	    String text = "";
	    String line1 = reader.readLine();
	    while(line1!=null){
	        text +=line1;
	        line1 = reader.readLine();
	    }
		String line = text;*/
		noun_size=0;
		new ParserTest().parserAction(sc);
		System.out.println("List of Noun Parse : "+sc+"  "+nounPhrases);
		
		noun_size=nounPhrases.size();
		//System.out.println("print"+noun_size);
		nounPhrases.clear();
	}

}
