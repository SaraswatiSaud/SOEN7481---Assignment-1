package ca.concordia.bugPatterns;

import java.io.File;

public class HashCodeButNoEqualsBugPattern extends BugPattern {
    public HashCodeButNoEqualsBugPattern(int line, File file, String functionName) {
        super(line, file, functionName);
    }
    
    public String getBugPatternID() {
        return "BugPattern 1";
    }
    
    public String getBugPatternDescription() {
        return "Class defines hashCode() but not equals()";
    }
}