/**
 * This class is responsible for viewing various information about items in a stockroom.
 */
public class ViewStockRoom {
    // Stockroom instance
    private StockRoom stockRoom;

    /**
     * Constructs a ViewStockRoom with the specified stockroom.
     * @param stockRoom The stockroom to view
     */
    public ViewStockRoom(StockRoom stockRoom){
        this.stockRoom = stockRoom;
    }

    /**
     * Displays information about the item with the specified name.
     * @param itemName Name of the item
     * @return The index of the item if found, else -1
     */
    public int displayItemByName(String itemName){
        int i;
        for (i=0; i<this.stockRoom.getItems().size(); i++){
            Item item = this.stockRoom.getItems().get(i);
            if (item!=null && item.getItemName().contains(itemName)) {
                System.out.println(item.getItemName());
                System.out.println("quantity: " + item.getAmount());
                System.out.println("Cost: " + item.getCost());
                System.out.println("Calories: " + item.getCalories());
                System.out.println("item at Slot index: " + i);
                return i;
            }
        }
        System.out.println("This Item does not exist in vending machine slots.");
        return -1;
    }

    /**
     * Displays information about the item at the specified index.
     * @param index Index of the item
     */
    public void displayItem(int index){
        Item item = this.stockRoom.getItems().get(index);
        System.out.println("[index:" + index + "]\tItem name: " + item.getItemName());
        System.out.println("stock amount: " + item.getAmount()
        + "\nitem Cost: " + item.getCost()
        + "\nitem Calories: " + item.getCalories()+ "\n");
    }

    /**
     * Displays information about all items in the stockroom.
     */
    public void displayAllItems(){
        System.out.println("All Items in Stockroom: \n");
        int i;
        if (this.stockRoom.getItems() == null){
            System.out.println("There is nothing in the Stock Room");
        } else {
            for (i=0; i<this.stockRoom.getItems().size(); i++){
                this.displayItem(i);
            }
        }
    }
}
