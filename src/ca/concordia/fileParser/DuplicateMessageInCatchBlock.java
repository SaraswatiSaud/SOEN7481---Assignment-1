package ca.concordia.fileParser;

public class DuplicateMessageInCatchBlock {
	public static void dublicateCatchBlock(String[] args) {
        try {
        	System.out.println("This is a try block");
        }
        catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("Connection to AMQP service is lost.");
        }
    }
}
