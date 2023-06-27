/**
 * This class is responsible for viewing payments.
 * It provides methods to print bills and total amount.
 */
public class ViewPayment {
    private Payment payment;

    /**
     * Constructor initializes the ViewPayment object with payment details.
     *
     * @param payment Payment details to be associated with this object.
     */
    public ViewPayment(Payment payment){
        this.payment = payment;
    }

    /**
     * Prints the details of all bills.
     */
    public void printBills(){
        System.out.println("\n\nDenomination Inserted: ");
        for (Bill bill : this.payment.getPayment()){
            System.out.println(bill.getValue() + " Pieces: " + bill.getPieces());
        }
    }

    /**
     * Prints the total amount of payment inserted.
     */
    public void printTotalAmount(){
        double total = this.payment.getBillTotal();
        System.out.println("You inserted: "+ total + " pesos");
    }
}
