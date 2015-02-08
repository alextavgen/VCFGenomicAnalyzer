/**
 * 
 */
package parser;


import analyzer.AbstractAnalyzer;
import model.KeyValuePair;
import model.VCFDataLine;

/**
 * @author Aleks
 *
 */
public class VCFParser {
	private VCFTokenizer tokenizer;
	private static boolean bHeader = true; // Flag shows whether we parse header or not
	private Long lLineNr; // Holds nr of lines in data lines
	private AbstractAnalyzer analyzer;
	
	public VCFParser (AbstractAnalyzer sAnalyzer){
		analyzer = sAnalyzer;
		tokenizer = new VCFTokenizer();
		lLineNr = 0L;
	}
	
	public void parseLine(String line){
		KeyValuePair<String,String> keyValue;
		if (bHeader){ 
			keyValue = tokenizer.getVCFLineMeta(line);
			if (keyValue.getKey().equals("Header colums")) 
				bHeader = false;
		}
		else{ 
			lLineNr++;
			keyValue = tokenizer.getVCFLineGenome(line, lLineNr);
			VCFDataLine dInfo = tokenizer.getDataInfoField (keyValue);
			analyzer.analyzeLine(dInfo);
			}
			
		//System.out.println(keyValue);
	}
	
	public AbstractAnalyzer getAnalyzer (){
		return analyzer;
	}
}
