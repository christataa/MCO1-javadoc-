import java.util.ArrayList;

/**
 * This class is responsible for viewing various information about different transactions.
 */
public class ViewTransaction {
    // List of transactions
    private ArrayList<Transaction> transactions;
    // ViewCart object to display information about bought items
    private ViewCart viewCart;

    /**
     * Constructs a ViewTransaction with specified list of transactions.
     * @param transactions List of transactions
     */
    public ViewTransaction(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    /**
     * Prints all the transactions, displaying the items bought, 
     * their total cost and their total calories.
     */
    public void printAllTransactions(){
        int i;
        for (i=0; i<this.transactions.size(); i++){
            System.out.println("Transaction "+(i+1)+" :");
            this.viewCart = new ViewCart(this.transactions.get(i).getBoughtItems());
            this.viewCart.printItems();
            this.viewCart.printTotalCost();
            this.viewCart.printTotalCalories();
            System.out.println("----------------------------\n");
        }
    }

    /**
     * Prints the total income from all transactions.
     */
    public void printTransactionTotal(){
        double total = 0;
        int i;
        for (i=0; i<this.transactions.size(); i++){
            total = total + this.transactions.get(i).getBoughtItems().genTotalCost();
        }
        System.out.println("Transaction total income: " + total);
    }
}
