import java.util.ArrayList;

/**
 * Represents a Regular Vending Machine (VM) with different functionalities.
 * It keeps track of items, transactions, payments, and denominations of money.
 */
public class RegularVM {
    private static final int DEFAULT_SLOT_LIMIT = 8;

    private String vmName;
    private Cart vmCart;
    private Payment payment;
    private ArrayList<ItemSlot> itemSlots;
    private ArrayList<Denomination> vmChange;
    private ArrayList<Denomination> validDenominations;
    private ArrayList<Denomination> vmIncome;
    private ArrayList<Transaction> transactions;
    private StockRoom stockRoom;
    private int slotLimit;

    /**
     * Default constructor.
     * Initializes a regular vending machine with a default name.
     */
    public RegularVM(){
        this("Regular VM");
    }

    /**
     * Parameterized constructor.
     * Initializes a regular vending machine with the given name.
     * @param vmName the name of the vending machine.
     */
    public RegularVM(String vmName){
        this.slotLimit = DEFAULT_SLOT_LIMIT;
        this.vmName = vmName;
        this.vmCart = new Cart();
        this.itemSlots = new ArrayList<>();
        initializeItemSlots();
        this.validDenominations = new ArrayList<>();
        initializeValidDenominations();
        this.vmIncome = new ArrayList<>();
        this.vmChange = new ArrayList<>();
        initializeChangeDenominations();
        this.stockRoom = new StockRoom();
        this.payment = new Payment();
        this.transactions = new ArrayList<>();
    }

    /**
     * @return the name of the vending machine.
     */
    public String getVmName() {
        return this.vmName;
    }

    /**
     * @return the list of change denominations in the vending machine.
     */
    public ArrayList<Denomination> getVmChange() {
        return vmChange;
    }

    /**
     * @return the list of income denominations in the vending machine.
     */
    public ArrayList<Denomination> getVmIncome() {
        return vmIncome;
    }

    /**
     * @return the cart of the vending machine.
     */
    public Cart getVmCart() {
        return this.vmCart;
    }

    /**
     * @return the stock room of the vending machine.
     */
    public StockRoom getStockRoom() {
        return this.stockRoom;
    }

    /**
     * @return the list of item slots in the vending machine.
     */
    public ArrayList<ItemSlot> getItemSlots() {
        return this.itemSlots;
    }

    /**
     * @return the list of valid denominations in the vending machine.
     */
    public ArrayList<Denomination> getValidDenominations() {
        return validDenominations;
    }

    /**
     * @return the list of transactions of the vending machine.
     */
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    /**
     * @return the limit of item slots in the vending machine.
     */
    public int getSlotLimit() {
        return this.slotLimit;
    }

    /**
     * Sets the name of the vending machine.
     * @param vmName the new name of the vending machine.
     */
    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    /**
     * Sets the list of item slots in the vending machine.
     * @param itemSlots the new list of item slots.
     */
    public void setItemSlots(ArrayList<ItemSlot> itemSlots) {
        this.itemSlots = itemSlots;
    }

    /**
     * Sets the cart of the vending machine.
     * @param vmCart the new cart of the vending machine.
     */
    public void setVmCart(Cart vmCart) {
        this.vmCart = vmCart;
    }

    /**
     * Sets the stock room of the vending machine.
     * @param stockRoom the new stock room of the vending machine.
     */
    public void setStockRoom(StockRoom stockRoom) {
        this.stockRoom = stockRoom;
    }

    /**
     * Sets the list of change denominations in the vending machine.
     * @param vmChange the new list of change denominations.
     */
    public void setVmChange(ArrayList<Denomination> vmChange) {
        this.vmChange = vmChange;
    }

    /**
     * Sets the list of income denominations in the vending machine.
     * @param vmIncome the new list of income denominations.
     */
    public void setVmIncome(ArrayList<Denomination> vmIncome) {
        this.vmIncome = vmIncome;
    }

    /**
     * Sets the list of transactions in the vending machine.
     * @param transactions the new list of transactions.
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Sets the limit of item slots in the vending machine.
     * @param slotLimit the new limit of item slots.
     */
    public void setSlotLimit(int slotLimit) {
        this.slotLimit = slotLimit;
    }

    /**
     * @return the payment of the vending machine.
     */
    public Payment getPayment() {
        return this.payment;
    }

    /**
     * Sets the payment of the vending machine.
     * @param payment the new payment.
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Initializes the item slots in the vending machine.
     */
    private void initializeItemSlots(){
        for (int i = 0; i < this.slotLimit; i++){
            this.itemSlots.add(new ItemSlot(i));
        }
    }

    /**
     * Initializes the valid denominations in the vending machine.
     */
    private void initializeValidDenominations(){
        this.validDenominations.add(new Denomination(1000));
        this.validDenominations.add(new Denomination(500));
        this.validDenominations.add(new Denomination(200));
        this.validDenominations.add(new Denomination(100));
        this.validDenominations.add(new Denomination(50));
        this.validDenominations.add(new Denomination(20));
        this.validDenominations.add(new Denomination(10));
        this.validDenominations.add(new Denomination(5));
        this.validDenominations.add(new Denomination(1));
        this.validDenominations.add(new Denomination(0.25));
        this.validDenominations.add(new Denomination(0.10));
        this.validDenominations.add(new Denomination(0.05));
        this.validDenominations.add(new Denomination(0.01));
    }

    /**
     * Initializes change denominations available in the vending machine.
     */
    private void initializeChangeDenominations(){
        this.vmChange.add(new Denomination(20, 50));
        this.vmChange.add(new Denomination(50, 50));
        this.vmChange.add(new Denomination(100, 50));
        this.vmChange.add(new Denomination(200, 50));
        this.vmChange.add(new Denomination(500, 50));
        this.vmChange.add(new Denomination(1000, 50));
        this.vmChange.add(new Denomination(10, 50));
        this.vmChange.add(new Denomination(5, 50));
        this.vmChange.add(new Denomination(1, 50));
        this.vmChange.add(new Denomination(0.25, 50));
        this.vmChange.add(new Denomination(0.10, 50));
        this.vmChange.add(new Denomination(0.05, 50));
        this.vmChange.add(new Denomination(0.01, 50));
    }
}
