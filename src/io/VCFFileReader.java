/**
 * Class for implementi
 */
package io;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import parser.VCFParser;

/**
 * @author Aleks
 *
 */
public class VCFFileReader {
	private String sFileName;
	private VCFParser parser; 
	public VCFFileReader(String sPath){
		sFileName = sPath;
	}
	

	public void getLineByLine(){
		parser = new VCFParser();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(sFileName), StandardCharsets.UTF_8)) {
		    for (String line = null; (line = br.readLine()) != null;) {
		       parser.parseLine(line);
		    }
		} catch (IOException e) {
			System.out.println("Error opening file:" + sFileName);
			e.printStackTrace();
		}
	}
}
