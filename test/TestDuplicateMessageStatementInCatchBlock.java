package ca.concordia.soen7481.assignment;

import ca.concordia.bugPatterns.BugPattern;
import ca.concordia.bugFinder.DuplicateMessageInCatchBlockBugFinder;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.util.List;

public class TestDuplicateMessageStatementInCatchBlock {	
	@Test
	public void testDuplicateMessageStatementInCatchBlock() {
		List<BugPattern> bugPatterns = new DuplicateMessageInCatchBlockBugFinder().check(new File("fileParser/BugPatterns/DuplicateMessageInCatchBlock.java"));		
		Assert.assertEquals("dublicateCatchBlock", bugPatterns.get(0).getFunctionName());
		Assert.assertEquals(14, bugPatterns.get(0).getLine());		
	}
}
