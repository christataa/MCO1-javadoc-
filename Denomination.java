/**
 * The Denomination class represents a specific denomination of money and the number
 * of pieces at that denomination.
 */
public class Denomination {
    
    /** The value of the denomination. */
    private double value;

    /** The number of pieces at this denomination. */
    private int pieces;

    /**
     * Constructs a Denomination with the specified value and zero pieces.
     *
     * @param value the value of the denomination
     */
    public Denomination(double value){
        this.value = value;
        this.pieces = 0;
    }

    /**
     * Constructs a Denomination with the specified value and number of pieces.
     *
     * @param value the value of the denomination
     * @param pieces the number of pieces at this denomination
     */
    public Denomination(double value, int pieces){
        this.value = value;
        this.pieces = pieces;
    }

    /**
     * Returns the value of the denomination.
     *
     * @return the value of the denomination
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Returns the number of pieces at this denomination.
     *
     * @return the number of pieces at this denomination
     */
    public int getPieces() {
        return this.pieces;
    }

    /**
     * Sets the value of the denomination.
     *
     * @param value the new value of the denomination
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Sets the number of pieces at this denomination.
     *
     * @param pieces the new number of pieces at this denomination
     */
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    /**
     * Returns a string representation of the denomination and the number of pieces.
     *
     * @return a string representation of the denomination and the number of pieces
     */
    @Override
    public String toString() {
        return "Denomination{" +
               "value=" + value +
               ", pieces=" + pieces +
               '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Denomination that = (Denomination) obj;
        return Double.compare(that.value, value) == 0 && pieces == that.pieces;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, pieces);
    }
}
