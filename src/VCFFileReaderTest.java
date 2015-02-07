import static org.junit.Assert.*;
import io.VCFFileReader;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Aleks
 *
 */
public class VCFFileReaderTest {
	private VCFFileReader reader = null;
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
		reader = new VCFFileReader("c:\\testData.vcf");
		reader.getLineByLine();
	}

}
