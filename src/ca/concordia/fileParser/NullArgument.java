package ca.concordia.fileParser;

public class NullArgument {
	String str1;
	String str2;
	
	public NullArgument(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;		
	}
	
	public boolean equals() {
        return str1.equals(str2);
    }	
}