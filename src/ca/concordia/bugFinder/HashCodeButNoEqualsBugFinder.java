package ca.concordia.bugFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ca.concordia.bugPatterns.BugPattern;
import ca.concordia.bugPatterns.HashCodeButNoEqualsBugPattern;
import ca.concordia.fileParser.HashCodeButNoEquals;

/**
 * This class finds BugPattern 1 from the file.
 * @author Saraswati Saud
 *
 */
public class HashCodeButNoEqualsBugFinder implements BugFinder {
    public List<BugPattern> check(File projectDir) {

        List<BugPattern> bugPatterns = new ArrayList<>();

        HashCodeButNoEquals obj1 = new HashCodeButNoEquals(1, "Test");
        HashCodeButNoEquals obj2 = new HashCodeButNoEquals(2, "Test");
        
        boolean isHashCodeEquals = obj1.hashCode() == obj2.hashCode();

        if (!isHashCodeEquals) {
        	int lineNumber = 13;
        	File file = new File("HashCodeButNoEquals.java");
        	String functionName = "equals";        	
            bugPatterns.add(new HashCodeButNoEqualsBugPattern(lineNumber, file, functionName));
        }
        
        return bugPatterns;
    }
}