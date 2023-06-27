import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ViewMenu class to present and handle user interaction with menus.
 */
public class ViewMenu {
    
    private final Scanner scanner;

    /**
     * Constructor that initializes scanner
     */
    public ViewMenu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Presents the main menu to the user and returns their choice.
     *
     * @return choice1
     */
    public int mainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Create a Vending Machine\n" +
                "2. Test the Vending Machine Features\n" +
                "3. Exit\n");
        int choice1 = scanner.nextInt();
        return choice1;
    }

    /**
     * Presents the feature testing menu to the user.
     */
    public void printTestMenu() {
        System.out.println("Feature Menu");
        System.out.println("1. Test Vending Machine Features\n" +
                "2. Test Maintenance Feature\n" +
                "3. Exit\n");
        System.out.println("Enter the number of the choice: ");
    }

    /**
     * Presents the maintenance feature panel to the user and returns their choice.
     *
     * @return choice1
     */
    public int maintenanceFeaturePanel(){
        int choice1;
        System.out.println("Maintenance Feature Menu");
        System.out.println("1. Restock\n" +
                "2. Change Price of Items\n" +
                "3. View Transaction summary\n" +
                "4. Replenish Money for change\n" +
                "5. View starting and ending inventory\n" +
                "6. Exit\n");
        System.out.println("Enter the number of Choice: ");
        choice1 = this.num.nextInt();
        return choice1;
    }
   
    
    /**
     * Presents the restock panel to the user and returns their choice.
     *
     * @return choice1
     */
    public int restockPanel() {
        System.out.println("Do you want to:");
        System.out.println("1. See Stock Room Items and choose index to restock\n" +
                "2. Search Item by name in Stock Room to restock\n" +
                "3. add new Item in Stock Room\n" +
                "4. Replenish item stock in Vending Machine\n" +
                "5. Assign new item to empty Slot in Vending Machine\n" +
                "6. Delete an item in the Vending Machine slot\n" +
                "7. Delete an item in the Vending Machine slot\n" +
                "8. back\n");
        int choice1 = scanner.nextInt();
        return choice1;
    }

    /**
     * Presents restock option to the user and returns their choice.
     *
     * @return the index of choice to restock
     */
    public int restockPanel1() {
        System.out.println("Enter the index of Choice to Restock: ");
        int choice1 = scanner.nextInt();
        return choice1;
    }

    /**
     * Presents replenish option to the user and returns their choice.
     *
     * @return the index of choice to replenish
     */
    public int restockPanel2() {
        System.out.println("Enter the index of Choice to Replenish: ");
        int choice1 = scanner.nextInt();
        return choice1;
    }

    /**
     * Collects restock details from the user and returns them.
     *
     * @return a List of restock details provided by the user
     */
    public List<String> restockPanel3() {
        System.out.println("type 0 for item cost or calories that is undecided\n" +
                "Type in [Format] Item name(string),Amount(integer),Cost(can be decimal),Calories:");
        String stInput = scanner.nextLine();
        return Arrays.asList(stInput.split(","));
    }

    /**
     * Presents the price change menu to the user and returns their choice.
     *
     * @return choice, the user's selected option
     */
    public int changePricePanel() {
        System.out.println("Change Price of Items\n" +
                "1. [Change Price in Item slots]\tPrint all Item then select index to change price\n" +
                "2. [Change Price in Item slots]\tSearch Item in vending machine slots by name and change price\n" +
                "3. [Change Price in Stockroom]\tPrint all Item then select index to change price\n" +
                "4. [Change Price in Stockroom]\tSearch Item in vending machine slots by name and change price\n" +
                "5. back");
        int choice = scanner.nextInt();
        return choice;
    }

    /**
     * Prints out the income summary panel.
     *
     * @param previous previous income amount
     * @param currIncome current income amount
     */
    public void incomeCollectPanel(double previous, double currIncome) {
        System.out.println("\n=============================\nPrevious Income: " +previous + " Pesos\n" +
                "Current Income(starting from last restocking): " + currIncome + " Pesos\n");
        System.out.println("Printing Summary: \n");
    }

    /**
     * Collects slot addition details from the user and returns them.
     *
     * @return a List of slot addition details provided by the user
     */
    public List<String> addToSlot() {
        System.out.println("type 0 for item cost or calories that is undecided\n" +
                "Type in [Format] Item name(string),Amount(integer),Cost(can be decimal),Calories:");
        String stInput = scanner.nextLine();
        return Arrays.asList(stInput.split(","));
    }

    /**
     * Asks the user for an item quantity.
     *
     * @return the item quantity input by the user
     */
    public int askInputNum() {
        System.out.println("Enter the item quantity: ");
        int input = scanner.nextInt();
        return input;
    }

    /**
     * Asks the user for an index of choice.
     *
     * @return the index input by the user
     */
    public int askInputIndex() {
        System.out.println("Enter index of choice: ");
        int input = scanner.nextInt();
        return input;
    }

    /**
     * Asks the user for a string input to search for an item.
     *
     * @return the string input by the user
     */
    public String askInputString() {
        System.out.println("Enter the item name to search: ");
        String name = scanner.nextLine();
        return name;
    }

    /**
     * Asks the user for a new cost.
     *
     * @return the cost input by the user
     */
    public double askInputCost() {
        System.out.println("Enter new cost: ");
        double cost = scanner.nextDouble();
        return cost;
    }

    /**
     * Asks the user whether they're done or not.
     *
     * @return a boolean indicating whether the user is done or not
     */
    public boolean askIfDone() {
        System.out.println("Done?\t[NO] - 0\n\t\t[YES] - 1");
        boolean done = scanner.nextInt() == 1;
        return done;
    }

    /**
     * Prints an error message when a slot is empty.
     */
    public void printEmpty() {
        System.out.println("error [This slot is empty]");
    }

    /**
     * Prints the starting inventory.
     */
    public void printStarting() {
        System.out.println("\nStarting Inventory: \n===========================================================\n");
    }

    /**
     * Prints the ending inventory.
     */
    public void printEnding() {
        System.out.println("\nEnding Inventory: \n===========================================================\n");
    }

    /**
     * Prints a message if the starting and ending inventory are the same.
     */
    public void printStartAndEndSame() {
        System.out.println("\nDid not restock yet, Inventory from last restock: \n" +
                "===========================================================\n");
    }

    /**
     * Asks the user to enter the number of choice.
     */
    public void printChooseChoice() {
        System.out.println("Enter the number of Choice: ");
    }

    /**
     * Asks the user to enter an item name.
     */
    public void printAskName() {
        System.out.println("Enter item name: ");
    }

    /**
     * Prints a message indicating that something has been updated.
     */
    public void printUpdateMessage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\nUpdated: ");
    }

    /**
     * Prints a line to separate different sections.
     */
    public void printDisectLine() {
        System.out.println("====================================\n");
    }

    /**
     * Clears the console screen.
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}