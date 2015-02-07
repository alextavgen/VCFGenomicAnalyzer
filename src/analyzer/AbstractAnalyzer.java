/**
 * Abstract analyzer class defines interface for different analyze strategy.
 * Encapsulate analyze strategy
 */
package analyzer;

import model.VCFDataLine;

/**
 * @author Aleks
 *
 */
public abstract class AbstractAnalyzer {
	abstract public void analyzeLine (VCFDataLine vcfLine);
	abstract public Object getResult();
}
