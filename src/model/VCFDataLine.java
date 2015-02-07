/**
 *  Class(Bean) that encapsulates Data Line from VCF File.
 */
package model;

import java.util.List;

/**
 * @author Aleks
 *
 */
public class VCFDataLine {
	private int iChrom;
	private Long lPos;
	private List<String> sID; // Id could be more than one, they should be unique (check if necessary)
	private String ref;
	private String alt;
	private String qual;
	private String filter; // needs additional logic (PASS or analyze filters)
	private DataInfoField Info;
	private String format;
	private String NA;
	/**
	 * @return the iChrom
	 */
	public int getiChrom() {
		return iChrom;
	}
	/**
	 * @param iChrom the iChrom to set
	 */
	public void setiChrom(int iChrom) {
		this.iChrom = iChrom;
	}
	/**
	 * @return the iPos
	 */
	public Long getlPos() {
		return lPos;
	}
	/**
	 * @param iPos the iPos to set
	 */
	public void setlPos(Long lPos) {
		this.lPos = lPos;
	}
	/**
	 * @return the sID
	 */
	public List<String> getsID() {
		return sID;
	}
	/**
	 * @param sID the sID to set
	 */
	public void setsID(List<String> sID) {
		this.sID = sID;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	/**
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}
	/**
	 * @param alt the alt to set
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}
	/**
	 * @return the prob
	 */
	public String getQual() {
		return qual;
	}
	/**
	 * @param prob the prob to set
	 */
	public void setQual(String qual) {
		this.qual = qual;
	}
	/**
	 * @return the info
	 */
	public DataInfoField getInfo() {
		return Info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(DataInfoField info) {
		Info = info;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/**
	 * @return the nA
	 */
	public String getNA() {
		return NA;
	}
	/**
	 * @param nA the nA to set
	 */
	public void setNA(String nA) {
		NA = nA;
	}
	/**
	 * @return the filter
	 */
	public String getFilter() {
		return filter;
	}
	/**
	 * @param filter the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
}
