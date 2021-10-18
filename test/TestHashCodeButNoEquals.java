package ca.concordia.soen7481.assignment;

import org.junit.jupiter.api.Test;
import ca.concordia.bugFinder.NullArgumentBugFinder;
import ca.concordia.bugPatterns.BugPattern;
import org.junit.Assert;
import java.io.File;
import java.util.List;

public class TestHashCodeButNoEquals {	
	@Test
	public void testHashCodeButNoEquals() {
		List<BugPattern> bugPatterns = new TestHashCodeButNoEqualsBugFinder().check(new File("fileParser/BugPatterns/HashCodeButNoEquals.java"));		
		Assert.assertEquals("equals()", bugPatterns.get(0).getFunctionName());		
	}
}

