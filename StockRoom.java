import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a StockRoom which contains a list of items.
 */
public class StockRoom {
    
    /** The list of items in this stock room */
    private List<Item> items;

    /**
     * Constructs a new, empty StockRoom.
     */
    public StockRoom(){
        this.items = new ArrayList<>();
    }

    /**
     * Returns the list of items in this stock room.
     *
     * @return the items in this stock room
     */
    public List<Item> getItems() {
        return new ArrayList<>(this.items); // Returning a copy for encapsulation
    }

    /**
     * Sets the list of items in this stock room.
     *
     * @param items the new list of items for this stock room
     */
    public void setItems(List<Item> items) {
        if (items != null) {
            this.items = new ArrayList<>(items); // Creating a copy for encapsulation
        }
    }
}
