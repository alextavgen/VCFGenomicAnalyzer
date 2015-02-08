/**
 * Bean Class that encapsulates mutations type and amount.
 */
package model;

/**
 * @author Aleks
 *
 */
public class MutationsHolder {
	private long totalMutations;
	private long SNP;
	private long INS;
	private long DEL;
	private long MNV;
	
	public MutationsHolder(){
		totalMutations = 0;
		SNP = 0;
		INS = 0;
		DEL = 0;
		MNV = 0;
	}

	
	public void incTotalMutations(){
		totalMutations++;
	}
	
	public void incSNP(){
		SNP++;
	}
	
	public void incINS(){
		INS++;
	}
	
	public void incDEL(){
		DEL++;
	}
	
	public void incMNV(){
		MNV++;
	}
	/**
	 * @return the totalMutations
	 */
	public long getTotalMutations() {
		return totalMutations;
	}

	/**
	 * @param totalMutations the totalMutations to set
	 */
	public void setTotalMutations(long totalMutations) {
		this.totalMutations = totalMutations;
	}

	/**
	 * @return the sNP
	 */
	public long getSNP() {
		return SNP;
	}

	/**
	 * @param sNP the sNP to set
	 */
	public void setSNP(long sNP) {
		SNP = sNP;
	}

	/**
	 * @return the iNS
	 */
	public long getINS() {
		return INS;
	}

	/**
	 * @param iNS the iNS to set
	 */
	public void setINS(long iNS) {
		INS = iNS;
	}

	/**
	 * @return the dEL
	 */
	public long getDEL() {
		return DEL;
	}

	/**
	 * @param dEL the dEL to set
	 */
	public void setDEL(long del) {
		DEL = del;
	}

	/**
	 * @return the mNV
	 */
	public long getMNV() {
		return MNV;
	}

	/**
	 * @param mNV the mNV to set
	 */
	public void setMNV(long mNV) {
		MNV = mNV;
	}
	
	
	public String toString(){
		return new String("Total Mutations: " + totalMutations + " SNP:" + SNP 
							+ " INS:" + INS + " DEL:" + DEL + " MNV:" + MNV);
	}
	

}
