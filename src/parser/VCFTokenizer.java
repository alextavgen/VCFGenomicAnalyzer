/**
 * 
 */
package parser;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.DataInfoField;
import model.KeyValuePair;
import model.VCFDataLine;



/**
 * @author Aleks
 *
 */
public class VCFTokenizer {
	private static final Set<String> fHEADER_TOKENS = new LinkedHashSet<>();
	//regular expression for extract <key> = <value>
	private static final String fREGEXPKEYVALUE = "(\\w+)=([^\\n\\r]+)";
	// regular expression for extract data lines after header
	private static final String fREGEXPDATALINE = "([^\\r\\n]+)";
	// regular expression for fetching data from INFO field in data lines
	private static final String fREGEXPDATAFIELD ="[\\s\\xA0]+";
	// regular expression for fetching coma separated data from ID field in data lines
	private static final String fCOMASEPARATED = ",";
	// regular expression for fetching semicolon separated data from INFO field in data lines
	private static final String fSEMICOLONSEPARATED = ";";
		
	private KeyValuePair<String, String> keyValueToken;

	
	  /**VCF File Meta DataHeader tokens, for checking correctness of the file format*/
	  static {
		  fHEADER_TOKENS.add("INFO");
		  fHEADER_TOKENS.add("FILTER");
		  fHEADER_TOKENS.add("FORMAT");
		  fHEADER_TOKENS.add("ALT");
		  fHEADER_TOKENS.add("PEDIGREE");
		  fHEADER_TOKENS.add("fileformat");
		  fHEADER_TOKENS.add("fileDate");
		  fHEADER_TOKENS.add("source");
		  fHEADER_TOKENS.add("reference");
		  fHEADER_TOKENS.add("contig");
		  fHEADER_TOKENS.add("phasing");
		  fHEADER_TOKENS.add("CHROM");
		  fHEADER_TOKENS.add("platypusOptions");
		  
	  }
	  	
	private StringTokenizer stImpl;
	private String sDelimiter;
	

	public VCFTokenizer(){
	}

	
	public VCFTokenizer(String sDelimiter){
		this.sDelimiter = sDelimiter;
	}

	private KeyValuePair<String, String> extractKeyValuePair(String sLine, String regExp){
		KeyValuePair<String, String> result = new KeyValuePair<String, String>();
	    Matcher matcher =getMatcherWithRegexp(sLine, regExp);
	    if(matcher.matches()) {
	         result.setKey(matcher.group(1));
	         result.setValue(matcher.group(2));
	      }
	      else {
	    	if ((sLine.substring(0, 5)).equals("CHROM")){
	    		result.setKey("Header colums");
	    		result.setValue(sLine);
	    	}
	    	else
	    		System.err.println("Wrong format file, can't extract Key=Value from VCF - " + sLine );
	      }
	    
		return result;
	}
	
	/*
	 * Some Stubs for File Header Tokenize function 
	 * 
	 */
	public KeyValuePair<String, String> getVCFLineMeta(String sLine){
		String token = null;
		sDelimiter = "#";
		stImpl = new StringTokenizer(sLine, sDelimiter);
		while (stImpl.hasMoreTokens()) {
	     token = stImpl.nextToken(sDelimiter);
		 KeyValuePair<String, String> keyValue = extractKeyValuePair (token, fREGEXPKEYVALUE);
	     if (isCorrectFormat(keyValue.getKey()) || keyValue.getKey().equals("Header colums")){
	        parseMetaHeaderLine(keyValue);
	        return keyValue;
	      }
	      else {
	    	  // Wrong meta header format
	    	  System.out.println("Unrecognised token in META HEADER");
	      }
	    }
		return null;
		
		
	}
	
 
	private void parseMetaHeaderLine(KeyValuePair<String, String> keyValue) {
		//stub for parsing Headers

	}

	private boolean isCorrectFormat(String token) 
	{ return fHEADER_TOKENS.contains(token);} 

	/*
	 * Function for getting VCF lines after #CHROME header
	 * 
	 */
	public KeyValuePair<String, String> getVCFLineGenome(String sLine, Long lLineNr){
		KeyValuePair<String, String> result = new KeyValuePair<String, String>();
		result = extractKeyValuePairFromLine(sLine, fREGEXPDATALINE);	
		result.setKey(lLineNr.toString());
		return result;
	}


	private KeyValuePair<String, String> extractKeyValuePairFromLine(String sLine, String regExp) {
		KeyValuePair<String, String> result = new KeyValuePair<String, String>();
	    Matcher matcher =getMatcherWithRegexp(sLine, regExp);
	    if(matcher.matches()) {
	         result.setValue(matcher.group(1));
	      }
	    return result;
	}

	public VCFDataLine getDataInfoField(KeyValuePair<String, String> keyValue) {
		VCFDataLine result = new VCFDataLine();
		String token =keyValue.getValue();
		String[] elements = token.split(fREGEXPDATAFIELD);
		result.setiChrom(Integer.parseInt(elements[0]));
		result.setlPos(Long.parseLong(elements[1]));
		result.setsID(getListOfIDs(elements[2]));
		result.setRef(elements[3]);
		result.setAlt(elements[4]);
		result.setQual(elements[5]);
		result.setFilter(elements[6]);
		result.setInfo(convertToInfoField(elements[7]));
		result.setFormat(elements[8]);
		result.setNA(elements[9]);
		return result;
	}


	private DataInfoField convertToInfoField(String sLine) {
	    DataInfoField result = new DataInfoField();
		StringTokenizer parser = new StringTokenizer(sLine,fSEMICOLONSEPARATED);
	    String token = null;
	    while (parser.hasMoreTokens()) {
	      token = parser.nextToken(fSEMICOLONSEPARATED);
	      KeyValuePair<String, String> kValue = extractKeyValuePair(token, fREGEXPKEYVALUE);
	      result.addKeyValue(kValue);
	      if (kValue.getKey().equals("Gene")) result.setGeneAssotiated(kValue.getValue());
	    }
		return result;
	}


	private List<String> getListOfIDs(String group) {
	    List<String> result = new ArrayList<String>();
		StringTokenizer parser = new StringTokenizer(group, fCOMASEPARATED);
	    String token = null;
	    while (parser.hasMoreTokens()) {
	      token = parser.nextToken(";");
	      result.add(token);
	    }
		return result;
	}
	
	private Matcher getMatcherWithRegexp (String sLine, String sRegExp){
		Pattern pattern = Pattern.compile(sRegExp, Pattern.COMMENTS);
	    return pattern.matcher(sLine);
	}

}
