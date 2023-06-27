/**
 * This class represents a Transaction which includes the items bought and the payment method used.
 */
public class Transaction {
    
    /** The Cart object containing the items bought in this transaction */
    private Cart boughtItems;
    
    /** The Payment object used for this transaction */
    private Payment payment;

    /**
     * Constructs a new Transaction with the specified cart and payment.
     *
     * @param boughtItems the cart containing the items bought in this transaction
     * @param payment the payment method used for this transaction
     */
    public Transaction (Cart boughtItems, Payment payment){
        this.boughtItems = boughtItems;
        this.payment = payment;
    }

    /**
     * Returns the cart containing the items bought in this transaction.
     *
     * @return the cart of this transaction
     */
    public Cart getBoughtItems() {
        return this.boughtItems;
    }

    /**
     * Returns the payment method used for this transaction.
     *
     * @return the payment of this transaction
     */
    public Payment getPayment() {
        return this.payment;
    }

    /**
     * Sets the cart containing the items bought in this transaction.
     *
     * @param boughtItems the new cart for this transaction
     */
    public void setBoughtItems(Cart boughtItems) {
        this.boughtItems = boughtItems;
    }

    /**
     * Sets the payment method used for this transaction.
     *
     * @param payment the new payment for this transaction
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
