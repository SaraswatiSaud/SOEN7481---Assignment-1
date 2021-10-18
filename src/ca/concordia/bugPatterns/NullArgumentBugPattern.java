package ca.concordia.bugPatterns;

import java.io.File;

public class NullArgumentBugPattern extends BugPattern {
	public NullArgumentBugPattern(int line, File file, String functionName) {
        super(line, file, functionName);
    }
    
    public String getBugPatternID() {
        return "BugPattern 2";
    }
    
    public String getBugPatternDescription() {
        return "equals() method does not check for null argument";
    }
	
}
