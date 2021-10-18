package ca.concordia.bugFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ca.concordia.bugPatterns.BugPattern;
import ca.concordia.bugPatterns.NullArgumentBugPattern;
import ca.concordia.fileParser.NullArgument;

/**
 * This class finds BugPattern 2 from the file.
 * @author Saraswati Saud
 *
 */
public class NullArgumentBugFinder implements BugFinder {
	public List<BugPattern> check(File projectDir) {

        List<BugPattern> bugPatterns = new ArrayList<>();
        
        NullArgument obj1 = new NullArgument("test", null);
                
        boolean isNull = obj1.equals();
        
        if (!isNull) {        	
        	int lineNumber = 11;
        	File file = new File("NullArgument.java");
        	String functionName = "equals";        	
            bugPatterns.add(new NullArgumentBugPattern(lineNumber, file, functionName));
        }
        
        return bugPatterns;
    }
}
