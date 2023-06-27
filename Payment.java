import java.util.ArrayList;

/**
 * This class represents a Payment which contains a list of denominations and calculates the total payment amount.
 */
public class Payment {
    
    /** 
     * A list that holds the denominations of the payment.
     */
    private ArrayList<Denomination> denominations;

    /**
     * Constructs a new Payment object with an empty list of denominations.
     */
    public Payment(){
        this.denominations = new ArrayList<>();
    }

    /**
     * Retrieves the list of denominations in the payment.
     *
     * @return the list of denominations
     */
    public ArrayList<Denomination> getDenominations() {
        return this.denominations;
    }

    /**
     * Calculates and returns the total value of the payment.
     *
     * @return the total value of the payment
     */
    public double getBillTotal() {
        double total = 0;
        for (Denomination denomination : this.denominations) {
            total += denomination.getPieces() * denomination.getValue();
        }
        return total;
    }

    /**
     * Sets the list of denominations in the payment.
     *
     * @param denominations the new list of denominations
     * @throws IllegalArgumentException if the provided list is null
     */
    public void setDenominations(ArrayList<Denomination> denominations) {
        if (denominations == null) {
            throw new IllegalArgumentException("Denominations cannot be null.");
        }
        this.denominations = denominations;
    }
}
