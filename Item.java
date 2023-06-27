import java.util.Objects;

/**
 * The Item class represents an item with a name, amount, cost, and calorie count.
 */
public class Item {

    /** The name of the item. */
    private String itemName;

    /** The quantity of the item. */
    private int amount;

    /** The cost of the item. */
    private double cost;

    /** The calorie count of the item. */
    private int calories;

    /**
     * Constructs an Item with the specified name, amount, cost, and calorie count.
     *
     * @param itemName the name of the item
     * @param amount the quantity of the item
     * @param cost the cost of the item
     * @param calories the calorie count of the item
     */
    public Item(String itemName, int amount, double cost, int calories){
        this.itemName = itemName;
        this.amount = amount;
        this.cost = cost;
        this.calories = calories;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Returns the cost of the item.
     *
     * @return the cost of the item
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Returns the calorie count of the item.
     *
     * @return the calorie count of the item
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * Sets the name of the item.
     *
     * @param itemName the new name of the item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Sets the quantity of the item.
     *
     * @param amount the new quantity of the item
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Sets the cost of the item.
     *
     * @param cost the new cost of the item
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Sets the calorie count of the item.
     *
     * @param calories the new calorie count of the item
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Returns a string representation of the item.
     *
     * @return a string representation of the item
     */
    @Override
    public String toString() {
        return "Item{" +
               "itemName='" + itemName + '\'' +
               ", amount=" + amount +
               ", cost=" + cost +
               ", calories=" + calories +
               '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return amount == item.amount && Double.compare(item.cost, cost) == 0 && calories == item.calories && Objects.equals(itemName, item.itemName);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, amount, cost, calories);
    }
}
