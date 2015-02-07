/**
 * Class that encapsulates INFO field from VCF Data Lines. 
 * Used ArrayList for holding records. If additional logic required, it could be changed.
 * In that case we need to make interface more restrictive, set and get for List not use,
 * because it opens internal implementation of data structure.
 */
package model;

import java.util.ArrayList;

/**
 * @author Aleks
 *
 */
public class DataInfoField {
	private ArrayList <KeyValuePair<String, String>> lKeyValue; //Use arraylist, for watching step by step INFO field

	public DataInfoField (){
		lKeyValue = new ArrayList<KeyValuePair<String, String>>(); 
	}
	
	public void addKeyValue(KeyValuePair<String,String> kPair){
		lKeyValue.add(kPair);
	}
	
	
	
	/**
	 * @return the lKeyValue
	 */
	public ArrayList <KeyValuePair<String, String>> getlKeyValue() {
		return lKeyValue;
	}

	/**
	 * @param lKeyValue the lKeyValue to set
	 */
	public void setlKeyValue(ArrayList <KeyValuePair<String, String>> lKeyValue) {
		this.lKeyValue = lKeyValue;
	}

	
}
