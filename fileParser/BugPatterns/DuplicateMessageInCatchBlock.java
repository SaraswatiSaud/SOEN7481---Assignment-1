package ca.concordia.fileParser;

/**
 * This class represents a duplicate logging statements in different catch blocks
 * of the same try block.
 * @author Saraswati Saud
 *
 */
public class DuplicateMessageInCatchBlock {
	public static void dublicateCatchBlock(String[] args) {
        try {
        	System.out.println("This is a try block");
        }
        catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("Connection to AMQP service is lost.");
        }
        catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("Connection to AMQP service is lost.");
        }
    }
}