/**
 *  Class for holding Key = Value entities, used in VCFTokenizer class
 */
package model;

/**
 * @author Aleks
 *
 */
public class KeyValuePair<T1, T2> {
	private T1 key;
	private T2 value;
	
	public KeyValuePair(){
		
	}
	
	public KeyValuePair (T1 Key, T2 Value){
		this.key = Key;
		this.value = Value;
	}
	
	/**
	 * @return the value
	 */
	public T2 getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T2 value) {
		this.value = value;
	}
	/**
	 * @return the key
	 */
	public T1 getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(T1 key) {
		this.key = key;
	}
	
	public String toString(){
		return "Key = " + key.toString() + " Value = " + value.toString();
	}
	
	
}
