/**
 * Abstract class for defining interface for Reader Operations
 */
package io;

import parser.VCFParser;

/**
 * @author Aleks
 *
 */
public abstract class VCFAbstractReader {
	protected String sUri;
	public VCFAbstractReader(String sUri){
		this.sUri = sUri;		
	}
	
	public abstract void getLineByLine(VCFParser parser);

}
