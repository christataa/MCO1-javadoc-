/**
 * This class is responsible for displaying the items in the Cart object.
 */
public class ViewCart {
    
    /** Cart instance for displaying its items */
    private final Cart cart;

    /**
     * ViewCart constructor
     * @param cart The Cart instance that will be displayed.
     */
    public ViewCart(Cart cart){
        this.cart = cart;
    }

    /**
     * This method prints all items within the cart, including details such as item name, 
     * quantity of items, cost per item and calories per item.
     */
    public void printItems(){
        System.out.println("\n\nItems Selected: ");
        
        for (int i = 0; i < cart.getItemBought().size(); i++) {
            Item item = cart.getItemBought().get(i);
            System.out.printf("[ITEM %d] %s: %d pieces\n", i + 1, item.getItemName(), item.getAmount());
            System.out.printf("Price per piece: %.2f Pesos\n", item.getCost());
            System.out.printf("Calories per piece: %.2f\n-------------------------\n", item.getCalories());
        }
    }

    /**
     * This method prints the total calories of all items within the cart.
     */
    public void printTotalCalories(){
        System.out.println("Total Calories: " + cart.genTotalCalories());
    }

    /**
     * This method prints the total cost of all items within the cart.
     */
    public void printTotalCost(){
        System.out.println("Total Cost: " + cart.genTotalCost());
    }
}
