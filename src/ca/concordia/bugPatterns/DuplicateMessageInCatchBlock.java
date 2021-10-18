package ca.concordia.bugPatterns;

import java.io.File;

public class DuplicateMessageInCatchBlock extends BugPattern {
	public DuplicateMessageInCatchBlock(int line, File file, String functionName) {
		super(line, file, functionName);
	}
	
	public String getBugPatternID() {
		return "BugPattern 3";
	}

	public String getBugPatternDescription() {
		return "Inadequate logging information in catch blocks.";
	}
}
