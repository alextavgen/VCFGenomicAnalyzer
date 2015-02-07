/**
 * Class that encapsulates strategy for finding 
 * The total number of variants (mutations) represented in the file together with a breakdown
 * of this total by mutation type (SNV/INS/DEL/MNV).
 * A list of genes within which at least one variant has been found, the total number of variants
 * found in that gene, and a breakdown by variant type as for task 1.
 *
 */
package analyzer;

import model.VCFDataLine;

/**
 * @author Aleks
 *
 */
public class MutationAnalyzer extends AbstractAnalyzer{

	@Override
	public void analyzeLine(VCFDataLine vcfLine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

