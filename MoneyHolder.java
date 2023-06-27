import java.util.ArrayList;

/**
 * Class that holds a list of denominations.
 */
public class MoneyHolder {
    
    /** 
     * A list that holds the denominations.
     */
    private ArrayList<Denomination> denominations;

    /**
     * Constructs a new MoneyHolder object with an empty list of denominations.
     */
    public MoneyHolder() {
        this.denominations = new ArrayList<>();
    }

    /**
     * Retrieves the list of denominations in the money holder.
     *
     * @return the denominations
     */
    public ArrayList<Denomination> getDenominations() {
        return this.denominations;
    }

    /**
     * Replaces the list of denominations in the money holder.
     *
     * @param denominations the new list of denominations
     */
    public void setDenominations(ArrayList<Denomination> denominations) {
        this.denominations = denominations;
    }
}
