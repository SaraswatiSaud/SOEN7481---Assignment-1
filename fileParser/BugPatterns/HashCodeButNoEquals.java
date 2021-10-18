package ca.concordia.fileParser;

/**
 * This class defines a hashCode() method but not an equals() method and hence may violate
 * the invariant that equals objects must have equal hashcodes.
 * @author Saraswati Saud
 *
 */
public class HashCodeButNoEquals {	
	int id;
	String name;
	
	public HashCodeButNoEquals(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeButNoEquals simpson = (HashCodeButNoEquals) o;
        return id == simpson.id &&
                name.equals(simpson.name);
    }

    @Override
    public int hashCode() {
        return id;
    }

}