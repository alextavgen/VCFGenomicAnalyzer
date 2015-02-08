import static org.junit.Assert.*;

import io.VCFAbstractReader;
import io.VCFFileReader;

import org.junit.BeforeClass;
import org.junit.Test;

import analyzer.MutationsAnalyzer;

import parser.VCFParser;

/**
 * 
 */

/**
 * @author Aleks
 *
 */
public class VCFFileReaderTest {
	private VCFAbstractReader reader = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link io.VCFFileReader#VCFFileReader(java.lang.String)}.
	 */
	@Test
	public void testVCFFileReader() {
		assertNotNull(reader = new VCFFileReader("c:\testData.vcf")); // TODO
	}

	/**
	 * Test method for {@link io.VCFFileReader#getLineByLine()}.
	 */
	@Test
	public void testGetLineByLine() {
		/*try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("c:\\outputShortUn.txt"))));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}*/

		reader = new VCFFileReader("file:/C:/testData.vcf");
		MutationsAnalyzer analyzer = new MutationsAnalyzer();
		VCFParser parser = new VCFParser(analyzer);
		reader.getLineByLine(parser);
		analyzer.printResults();
		
	}

}
