/**
 * 
 */
package parser;


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
	
	public VCFParser (){
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
			keyValue = tokenizer.getVCFLineGenome(line, lLineNr);
			VCFDataLine dInfo = tokenizer.getDataInfoField (keyValue);
			lLineNr++;
			
			
		}
			
		System.out.println(keyValue);
	}
}
