import java.util.Objects;

/**
 * The ItemSlot class represents a slot that stores items. Each slot has an index, a stored item, and a limit.
 */
public class ItemSlot {

    /** The index of the slot. */
    private int slotIndex;

    /** The item stored in the slot. */
    private Item itemStored;

    /** The limit of items that can be stored in the slot. */
    private int slotItemLimit;

    /**
     * Constructs an ItemSlot with the specified index, no stored item and a default limit of 10.
     *
     * @param slotIndex the index of the slot
     */
    public ItemSlot(int slotIndex){
        this.slotIndex = slotIndex;
        this.itemStored = null;
        this.slotItemLimit = 10;
    }

    /**
     * Constructs an ItemSlot with the specified index, a stored item, and a default limit of 10.
     *
     * @param slotIndex the index of the slot
     * @param itemStored the item stored in the slot
     */
    public ItemSlot(int slotIndex, Item itemStored){
        this.slotIndex = slotIndex;
        this.itemStored = itemStored;
        this.slotItemLimit = 10;
    }

    /**
     * Returns the index of the slot.
     *
     * @return the index of the slot
     */
    public int getSlotIndex(){
        return this.slotIndex;
    }

    /**
     * Returns the item stored in the slot.
     *
     * @return the item stored in the slot
     */
    public Item getItemStored() {
        return this.itemStored;
    }

    /**
     * Returns the limit of items that can be stored in the slot.
     *
     * @return the limit of items that can be stored in the slot
     */
    public int getSlotLimit() {
        return this.slotItemLimit;
    }

    /**
     * Sets the limit of items that can be stored in the slot.
     *
     * @param slotLimit the new limit of items that can be stored in the slot
     */
    public void setSlotLimit(int slotLimit) {
        this.slotItemLimit = slotLimit;
    }

    /**
     * Sets the index of the slot.
     *
     * @param slotIndex the new index of the slot
     */
    public void setSlotIndex(int slotIndex) {
        this.slotIndex = slotIndex;
    }

    /**
     * Sets the item stored in the slot.
     *
     * @param itemStored the new item stored in the slot
     */
    public void setItemStored(Item itemStored) {
        this.itemStored = itemStored;
    }

    /**
     * Returns a string representation of the slot.
     *
     * @return a string representation of the slot
     */
    @Override
    public String toString() {
        return "ItemSlot{" +
                "slotIndex=" + slotIndex +
                ", itemStored=" + itemStored +
                ", slotItemLimit=" + slotItemLimit +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSlot itemSlot = (ItemSlot) o;
        return slotIndex == itemSlot.slotIndex &&
                slotItemLimit == itemSlot.slotItemLimit &&
                Objects.equals(itemStored, itemSlot.itemStored);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(slotIndex, itemStored, slotItemLimit);
    }
}
