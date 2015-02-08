/**
 * Class that encapsulates strategy for finding 
 * The total number of variants (mutations) represented in the file together with a breakdown
 * of this total by mutation type (SNV/INS/DEL/MNV).
 * A list of genes within which at least one variant has been found, the total number of variants
 * found in that gene, and a breakdown by variant type as for task 1.
 *
 */
package analyzer;

import java.util.HashMap;
import java.util.Map;

import model.MutationsHolder;
import model.VCFDataLine;

/**
 * @author Aleks
 *
 */
public class MutationAnalyzer extends AbstractAnalyzer{

	private MutationsHolder mHolder;
	private HashMap<String, MutationsHolder> mGenes;
	
	public MutationAnalyzer (){
		mHolder = new MutationsHolder();
		mGenes = new HashMap<String, MutationsHolder> ();
	}
	@Override
	public void analyzeLine(VCFDataLine vcfLine) {
		String sGeneAssotiated = new String();
		boolean comaAlt = vcfLine.getAlt().contains(",");
		if (vcfLine.getRef() != null) mHolder.incTotalMutations();
		if (vcfLine.getAlt().equals("<DEL>")) return;
		sGeneAssotiated = vcfLine.getInfo().getGeneAssotiated();
		if (checkSNP(vcfLine)){
			MutationsHolder mTHolder =  mGenes.get(sGeneAssotiated);
			if (mTHolder == null){
				mTHolder = new MutationsHolder();
				mTHolder.setSNP(1);
				mTHolder.incTotalMutations();
				mGenes.put(sGeneAssotiated, mTHolder);
			} else 
			{ 
				mTHolder.incSNP();
				mTHolder.incTotalMutations();
				mGenes.put(sGeneAssotiated,mTHolder);
				mHolder.incSNP();
			}
		}
		else 
			if (checkINS(vcfLine) && !comaAlt){
				MutationsHolder mTHolder =  mGenes.get(sGeneAssotiated);
				if (mTHolder == null){
					mTHolder = new MutationsHolder();
					mTHolder.setINS(1);
					mTHolder.incTotalMutations();
					mGenes.put(sGeneAssotiated, mTHolder);
				} else 
				{ 
					mTHolder.incINS();
					mTHolder.incTotalMutations();
					mGenes.put(sGeneAssotiated,mTHolder);
					mHolder.incINS();
				}
				
			}
			else
				if (checkDEL(vcfLine)){
					MutationsHolder mTHolder =  mGenes.get(sGeneAssotiated);
					if (mTHolder == null){
						mTHolder = new MutationsHolder();
						mTHolder.setDEL(1);
						mTHolder.incTotalMutations();
						mGenes.put(sGeneAssotiated, mTHolder);
					} else 
					{ 
						mTHolder.incDEL();
						mTHolder.incTotalMutations();
						mGenes.put(sGeneAssotiated,mTHolder);
						mHolder.incDEL();
					}
					
				}
				else
					if (checkMNV(vcfLine)){
						MutationsHolder mTHolder =  mGenes.get(sGeneAssotiated);
						if (mTHolder == null){
							mTHolder = new MutationsHolder();
							mTHolder.incTotalMutations();
							mTHolder.setMNV(1);
							mGenes.put(sGeneAssotiated, mTHolder);
						} else 
						{ 
							mTHolder.incMNV();
							mTHolder.incTotalMutations();
							mGenes.put(sGeneAssotiated,mTHolder);
							mHolder.incMNV();
						}				
					}
					

	}
	private boolean checkSNP(VCFDataLine vcfLine){
		String sRef =  vcfLine.getRef();
		String sAlt =  vcfLine.getAlt();
		if (!isValidDNA(sRef) || !isValidDNA(sRef)) return false;
		if (sRef.length()==1 
				&& sAlt.length()==1 
				&& (!sRef.equals(sAlt))) return true;
		return false;
		
	}
	
	
	private boolean checkINS(VCFDataLine vcfLine){
		String sRef =  vcfLine.getRef();
		String sAlt =  vcfLine.getAlt();
		if (!isValidDNA(sRef) || !isValidDNA(sRef)) return false;
		
		int rLength = sRef.length();
		if (rLength<sAlt.length() && rLength == 1 && sAlt.contains(sRef)) return true;
		return false;

	}
	
	private boolean checkMNV(VCFDataLine vcfLine){
		String sRef =  vcfLine.getRef();
		String sAlt =  vcfLine.getAlt();
		if (!isValidDNA(sRef) || !isValidDNA(sRef)) return false;
		if (sRef.length() > 1 && sAlt.length() > 1) return true;
		return false;
		
	}
		
	private boolean checkDEL(VCFDataLine vcfLine){
		String sRef =  vcfLine.getRef();
		String sAlt =  vcfLine.getAlt();
		if (!isValidDNA(sRef) || !isValidDNA(sRef)) return false;
		int aLength = sAlt.length();
		if (sRef.length()>aLength && aLength == 1 && sRef.contains(sAlt)) return true;
		return false;
		
	}
	public boolean isValidDNA(String dna){	
		return dna.matches("^[ATCG]+$");
	}
	@Override
	public Object getResult() {
		// TODO Return analyze result in some form
		return null;
	}
	
	public void printResults(){
		System.out.println(mHolder.toString());
		for (Map.Entry<String, MutationsHolder> entry : mGenes.entrySet())
		{
		    System.out.println("Gene: " + entry.getKey() + " --- " + entry.getValue().toString());
		}
	}
}

