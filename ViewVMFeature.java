import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The ViewVMFeature class represents the user interface for interacting with the Vending Machine features.
 */
public class ViewVMFeature {

    private Scanner st = new Scanner(System.in);
    private Scanner num = new Scanner(System.in);
    private Scanner deci = new Scanner(System.in);
    private ViewVMDeno viewValidVMDeno;

    /**
     * Constructs a ViewVMFeature object with the given RegularVM instance.
     *
     * @param regularVM the RegularVM instance
     */
    public ViewVMFeature(RegularVM regularVM) {
        this.viewValidVMDeno = new ViewVMDeno(regularVM.getValidDenominations());
    }

    /**
     * Prints the Vending Machine feature menu and prompts the user for a choice.
     *
     * @return the user's choice
     */
    public int printVMFeatureMenu() {
        int choice1;
        System.out.println("\n\n================================\n" +
                "Vending Machine Feature Menu");
        System.out.println("1. Choose Item\n" +
                "2. Produce Change\n");
        System.out.println("Enter the number of Choice: ");
        choice1 = this.num.nextInt();
        return choice1;
    }

    /**
     * Displays the initial panel for choosing an item.
     */
    public void chooseItemPanel1() {
        System.out.println("\n\n==================== Welcome Customer ===================");
        System.out.println("(@' ^ '@)/ Here are the products of our Vending Machine: \n");
    }

    /**
     * Displays the panel for inserting money and choosing the denomination.
     */
    public void chooseItemPanel2() {
        System.out.println("\n\n========================== Please Insert Money =========================");
        System.out.println("(@' ^ '@)/: Enter value of denomination and number of pieces.\n" +
                "Valid denominations are: 0.01, 0.05, 0.10, 0.25, 1, 5, 10, 20, 50, 100, 200, 500, 1000\n" +
                "[FORMAT] value pieces [example:] 50 1\n");
    }

    /**
     * Displays the panel for choosing an item.
     */
    public void chooseItemPanel3() {
        System.out.println("\n\n========================= Choose Your Item ========================");
        System.out.println("(@' ^ '@)/ Enter the index of the slot and enter number of pieces\n" +
                "[FORMAT] index pieces [Example:] 0 3\n");
    }

    /**
     * Displays the goodbye panel.
     */
    public void goodByePanel() {
        System.out.println("\n\n========================= Thank You and Come Again!!! ========================");
        System.out.println("(@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ bye.. (@' ^ '@)/ \n");
    }

    /**
     * Produces the change.
     */
    public void produceChange() {
        System.out.println("Producing Change...");
    }

    /**
     * Prints a success message for the purchase and displays the customer's change.
     *
     * @param customerChange the customer's change
     */
    public void printSuccessBuy(double customerChange) {
        System.out.println("\\\n\nPurchase Successful!");
        this.produceChange();
        System.out.println("Your Change is: " + customerChange);
    }

    /**
     * Prints a message when the purchase is not successful due to insufficient change.
     *
     * @param payment the payment amount
     */
    public void printNotSuccessBuy(double payment) {
        System.out.println("This Vending Machine does not have enough change to give\n" +
                "Payment of: " + payment + " will be returned.\n" +
                "returning... please get your cash on the change slot below, Thank You!\n");
    }

    /**
     * Prints a message when returning cash to the customer.
     *
     * @param payment the payment amount
     */
    public void printReturnCash(double payment) {
        System.out.println("Payment of: " + payment + " will be returned.\n" +
                "returning... please get your cash on the change slot below, Thank You!\n");
        this.goodByePanel();
    }

    /**
     * Prompts the user to choose an item and returns the input as a list.
     *
     * @return the user's input as a list of strings
     */
    public List<String> chooseItem() {
        System.out.println("Your Input: ");
        String stInput = this.st.nextLine();
        String[] in = stInput.split(" ");
        return new ArrayList<>(Arrays.asList(in));
    }

    /**
     * Prompts the user to insert payment and returns the input as a list.
     *
     * @return the user's input as a list of strings
     */
    public List<String> insertPayment() {
        System.out.println("Your Input: ");
        String stInput = this.st.nextLine();
        String[] in = stInput.split(" ");
        return new ArrayList<>(Arrays.asList(in));
    }

    /**
     * Prints a message when the denomination is not accepted.
     */
    public void printNotAccepted() {
        System.out.println("This denomination is not accepted");
    }

    /**
     * Prints a message when the denomination is accepted.
     */
    public void printAccepted() {
        System.out.println("This denomination is accepted");
    }

    /**
     * Prints a message when an item is added to the cart.
     */
    public void printAdded() {
        System.out.println("Item Added to cart");
    }

    /**
     * Prints a message when an item is not added to the cart due to insufficient quantity.
     */
    public void printNotAdded() {
        System.out.println("Not added to cart. Item quantity not sufficient");
    }

    /**
     * Asks the user if they are done or want to continue input.
     *
     * @return the user's choice (0 for continue, 1 for done)
     */
    public int askIfDone() {
        System.out.println("\n[1] Done\n" +
                "[0] Continue Input");
        return this.num.nextInt();
    }

    /**
     * Asks the user for the number of pieces and returns the input.
     *
     * @return the number of pieces entered by the user
     */
    public int askPieces() {
        System.out.println("Pieces: ");
        return this.num.nextInt();
    }
}
