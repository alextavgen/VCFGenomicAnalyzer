/**
 * Class for implementi
 */
package io;


import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import parser.VCFParser;

/**
 * @author Aleks
 *
 */
public class VCFFileReader extends VCFAbstractReader {	
	public VCFFileReader(String sUri){
		super(sUri);
	}
	

	public void getLineByLine(VCFParser parser){
		try (BufferedReader br = Files.newBufferedReader(Paths.get(new URI(sUri)), StandardCharsets.UTF_8)) {
		    for (String line = null; (line = br.readLine()) != null;) {
		       parser.parseLine(line);
		    }
		} catch (URISyntaxException e1) {
			System.err.println("Wrong URI format" + sUri );
			e1.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error opening file:" + sUri );
			e.printStackTrace();
		}
	}
}
