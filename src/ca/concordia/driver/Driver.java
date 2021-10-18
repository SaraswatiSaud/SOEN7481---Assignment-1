package ca.concordia.driver;

import ca.concordia.bugFinder.*;
import ca.concordia.bugPatterns.BugPattern;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the Driver class of the project
 * @author Saraswati Saud
 */
public class Driver {
    public static void main(String[] args) {
    	File filesToBeParsed = new File("fileParser");        
        Set<BugPattern> bugPattern = new HashSet<>();
        BugFinder finder;
        
        // BugPattern 1: Class defines hashCode() but not equals().
        finder = new HashCodeButNoEqualsBugFinder();
        bugPattern.addAll(finder.check(filesToBeParsed));
        
        // BugPattern 2: equals() method does not check for null argument.
        finder = new NullArgumentBugFinder();
        bugPattern.addAll(finder.check(filesToBeParsed));

        // BugPattern 3: Inadequate logging information in catch blocks.
        finder = new DuplicateMessageInCatchBlockBugFinder();
        bugPattern.addAll(finder.check(filesToBeParsed));
        
        System.out.println(bugPattern);
    }    
}
