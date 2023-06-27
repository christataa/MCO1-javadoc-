import java.util.ArrayList;

/**
 * The ViewVMSlots class provides methods for viewing the state of item slots in a vending machine.
 */
public class ViewVMSlots {
    private ArrayList<ItemSlot> slots;

    /**
     * Initializes a new instance of the ViewVMSlots class.
     * @param slots The slots of the vending machine.
     */
    public ViewVMSlots(ArrayList<ItemSlot> slots) {
        this.slots = slots;
    }

    /**
     * Prints the indexes of all empty slots up to the given limit.
     * @param slotLimit The limit up to which slots should be checked.
     */
    public void printEmptySlots(int slotLimit) {
        int i;
        System.out.println("Empty Slots:");
        for (i = 0; i < slotLimit; i++) {
            if (this.slots.get(i).getItemStored() == null) {
                System.out.println("Empty at Index: "+ i);
            }
        }
    }

    /**
     * Prints the details of the item in the given slot index.
     * @param index The index of the slot to be printed.
     */
    public void printSlot(int index) {
        if (this.slots.get(index).getItemStored() != null) {
            System.out.println("Slot " + index + " contains: ");
            System.out.println("Item name: " + this.slots.get(index).getItemStored().getItemName());
            System.out.println("Item pieces: " + this.slots.get(index).getItemStored().getAmount());
            System.out.println("Item cost: " + this.slots.get(index).getItemStored().getCost());
            System.out.println("Item calories: " + this.slots.get(index).getItemStored().getCalories()+"\n------------------");
        } else {
            System.out.println("Slot "+ index +" is empty\n------------------");
        }
    }

    /**
     * Prints the details of all the items in the slots.
     */
    public void printAllSlots() {
        System.out.println("All Slots in the Vending Machine: \n");
        int i;
        for (i = 0; i < this.slots.size(); i++) {
            this.printSlot(i);
        }
    }

    /**
     * Searches for an item by name and displays its details if found.
     * @param itemName The name of the item to search for.
     * @return The index of the slot containing the item if found, otherwise -1.
     */
    public int displayItemByName(String itemName) {
        int i;
        for (i = 0; i < this.slots.size(); i++) {
            if (this.slots.get(i).getItemStored() != null) {
                if (this.slots.get(i).getItemStored().getItemName().contains(itemName)) {
                    System.out.println(this.slots.get(i).getItemStored().getItemName());
                    System.out.println("Quantity: " + this.slots.get(i).getItemStored().getAmount());
                    System.out.println("Cost: " + this.slots.get(i).getItemStored().getCost());
                    System.out.println("Calories: " + this.slots.get(i).getItemStored().getCalories());
                    System.out.println("Item at Slot index: " + i);
                    return i;
                }
            }
        }
        System.out.println("This item does not exist in vending machine slots.");
        return -1;
    }
}
