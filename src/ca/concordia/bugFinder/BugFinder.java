package ca.concordia.bugFinder;

import java.io.File;
import java.util.List;
import ca.concordia.bugPatterns.BugPattern;

public interface BugFinder {
    List<BugPattern> check(File projectDir);
}
