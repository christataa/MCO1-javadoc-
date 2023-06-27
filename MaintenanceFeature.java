import java.util.ArrayList;
import java.util.List;


/**
 * controller class for maintenance feature of the vending machine
 */
public class MaintenanceFeature {
    private RegularVM curVM;
    private double currIncome = 0;
    private double prevIncome = 0;
    private ArrayList<ItemSlot> itemSlots;
    private ArrayList<Transaction> transactions;
    private ArrayList<Denomination> vmChange;
    private ArrayList<Denomination> vmIncome;
    private StockRoom stockRoom;
    private ViewVMSlots viewVMSlots;
    private ViewTransaction viewTransaction;
    private ViewVMDeno viewDenoChange;
    private ViewVMDeno viewDenoIncome;
    private ViewStockRoom viewStockRoom;
    private ViewMenu viewMenu;
    private boolean restocked;


    /**
     * this is a constructor for the maintenance feature of vending machines. accepts
     * the vending machine as parameter in order to access the components of the
     * vending machine.
     * @param regularVM the instance of vending machine that user wishes to access the
     *                  maintenance feature of.
     */
    public MaintenanceFeature(RegularVM regularVM){
        this.curVM = regularVM;
        this.itemSlots = this.curVM.getItemSlots();
        this.transactions = this.curVM.getTransactions();
        this.vmChange = this.curVM.getVmChange();
        this.vmIncome = this.curVM.getVmIncome();
        this.stockRoom = this.curVM.getStockRoom();
        this.viewVMSlots = new ViewVMSlots(this.itemSlots);
        this.viewTransaction = new ViewTransaction(this.transactions);
        this.viewDenoChange = new ViewVMDeno(this.vmChange);
        this.viewDenoIncome = new ViewVMDeno(this.vmIncome);
        this.viewStockRoom = new ViewStockRoom(this.stockRoom);
        this.viewMenu = new ViewMenu();
        this.restocked = false;
    }

    /**************************************************************************************/
    /*                                  HELPER METHODS                                    */
    /**************************************************************************************/

    /**
     * this method is used to restock the items (set the quantity)
     * @param index     the index where the item is stored in the stockRoom
     * @param amount    the amount / quantity of item that user wishes to restock
     */
    public void restock(int index, int amount){
        this.stockRoom.getItems().get(index).setAmount(amount);
    }

    /**
     * this method is used to replenish item stock (add quantity to the existing
     * quantity of an item)
     * @param index     the index of vending machine where the item is stored
     * @param amount    the amount / quantity of items that user wishes to replenish
     */
    public void replenish(int index, int amount){
        int temp = this.itemSlots.get(index).getItemStored().getAmount();
        this.itemSlots.get(index).getItemStored().setAmount(amount+temp);
    }

    /**
     * this method is used to delete/remove an item in the vending machine slot
     * @param index     the index of the vending machine slot at where the item
     *                  is stored
     */
    public void deleteItemInSlot(int index){
        this.itemSlots.get(index).setItemStored(null);
    }

    /**
     * this method is used to delete an item in the stockRoom
     * @param index     index at where the item is stored in the stockRoom
     */
    public void deleteItemInStockRoom(int index){
        this.stockRoom.getItems().remove(index);
    }

    /**
     * this method is used to change the price of an item
     * @param index     the index of slot where the item is stored
     * @param cost      the new price that the user wants to replace
     *                  with the old price
     */
    public void changeCost(int index, double cost){
        this.itemSlots.get(index).getItemStored().setCost(cost);
    }

    /**
     * this method is used to search for a specific item in the stockRoom by
     * item name, or substring of the item name.
     * @param name      the name of the item that the user wants to search for
     * @return          the index at where the item is stored in stockRoom if
     *                  found
     */
    public int searchItemInStockRoom(String name){
        int iIndex;
        iIndex = this.viewStockRoom.displayItemByName(name);
        return iIndex;
    }

    /**
     * this method is used to search for a specific item in the vending machine
     * slots by item name, or substring of the item name.
     * @param name      the name of the item that the user wants to search for
     * @return          the index of the vending machine slot where the item is
     *                  stored if found
     */
    public int searchItemInSlots(String name){
        int iIndex;
        iIndex = this.viewVMSlots.displayItemByName(name);
        return iIndex;
    }

    /**
     * this method serves as the function panel for maintenance features, with
     * methods to display the needed menu panels and to perform the options
     * selected by the user. As well to update the components inside the vending
     * machine after performing the maintenance features.
     */
    public void maintenanceMenu(){
        //temporary Arraylist storing the slots and their items inside the vending machine slots
        ArrayList<ItemSlot> tempSlot = new ArrayList<>();
        //storing the items
        for (int i =0; i<this.itemSlots.size(); i++){
            ItemSlot a = this.itemSlots.get(i);
            tempSlot.add(a);
        }
        //temporary Arraylist storing the items inside the vending machine stockRoom
        ArrayList<Item> tempStockRoom = new ArrayList<>();
        //storing the items
        tempStockRoom = this.stockRoom.getItems();


        int choice1, choice2, choice3;
        double incomeTotal=0;

        choice1 = this.viewMenu.maintenanceFeaturePanel();
        switch (choice1){
            case 1: //restock
                while (choice1 !=8)
                {
                    choice1 = this.viewMenu.restockPanel();
                    this.restockMenu(choice1);
                }
                if(choice1 == 8 ){
                    /* if either one of the stockRoom or vending machine slot's items are not the same with the items available before
                       performing the restocking, then the inventory is being restocked, restocked = true. the total income generated
                       from the previous restocking will be stored to the prevIncome. the vending machine's income will be set to 0 (
                       it is collected), then the arraylist for storing the transactions will be cleared to store new transactions made
                       after restocking.*/
                    if ((this.itemSlots.equals(tempSlot)) || (this.stockRoom.equals(tempStockRoom)))
                    {
                        this.restocked = true;
                        for (int i = 0; i < this.transactions.size(); i++) {
                            incomeTotal = incomeTotal + this.transactions.get(i).getPayment().getBillTotal();
                        }
                        this.prevIncome = incomeTotal;
                        this.curVM.setVmIncome(null);
                        //this.curVM.setVmCart(null);
                        this.transactions.clear();
                    }
                    else this.restocked = false;
                    this.maintenanceMenu();
                    System.out.println("check1: " + restocked);//checking only
                }
                break;

            case 2: //change item price
                /* first to ask the choice of user, then perform change price*/
                choice2 = this.viewMenu.changePricePanel();
                this.changeItemPrice(choice2);
                break;

            case 3: //Transaction summary
                /* first get all the total amount of transactions made in all transactions, then set the currentIncome to
                    equal to this amount, then print the past and current total income and print all the transactions to show
                    as summary.
                 */
                incomeTotal = 0;
                for(int i=0; i<this.transactions.size(); i++){
                    incomeTotal = incomeTotal + this.transactions.get(i).getBoughtItems().genTotalCost();
                }
                this.currIncome = incomeTotal;
                this.viewMenu.incomeCollectPanel(this.prevIncome, this.currIncome);
                this.viewTransaction.printAllTransactions();
                break;

            case 5: //view starting inventory and ending inventory
                /* First check if the inventory is being restocked, if it is restocked, will display the list of items in both
                    the stockRoom and the vending machine slots before the restocking and after the restocking. if it is not restocked,
                    will display that the inventory is not restocked and will also display the items in both stockRoom and vending
                    machine slots.
                 */
                System.out.println("check2: " + this.restocked);//checking only
                if (this.restocked){
                    this.viewMenu.printStarting();

                    //temporary stockroom to store the items from previous restocking
                    StockRoom t = new StockRoom();
                    this.stockRoom.setItems(tempStockRoom);

                    ViewStockRoom prevSR = new ViewStockRoom(t);
                    prevSR.displayAllItems();
                    ViewVMSlots prevSL = new ViewVMSlots(tempSlot);
                    prevSL.printAllSlots();
                    this.viewMenu.printEnding();
                }
                else if (!this.restocked){
                    this.viewMenu.printStartAndEndSame();
                }
                this.viewStockRoom.displayAllItems();
                this.viewVMSlots.printAllSlots();
                this.restocked = false;

                break;

            case 6:
        }


    }
    /**
     * Changes the price of an item based on user's choice.
     * 
     * @param choice The option chosen by user to decide where and how to change the price.
     * 1. Change in vending machine (VM) slot, print all then choose index
     * 2. Change in VM slot, search by name then change price
     * 3. Change in stockroom, print all then choose index
     * 4. Change in stockroom, search by name then change price
     * 5. Go back to the maintenance menu
     */
    public void changeItemPrice(int choice){
        int iIndex;
        double input;
        String stInput;

        switch(choice){
            case 1: // change in vm slot, print all then choose index
                this.viewVMSlots.printAllSlots();
                iIndex = this.viewMenu.askInputIndex();
                while (this.itemSlots.get(iIndex).getItemStored() == null){
                    this.viewMenu.printEmpty();
                    iIndex = this.viewMenu.askInputIndex();
                }
                input = this.viewMenu.askInputCost();
                this.changeCost(iIndex, input);
                this.viewMenu.printUpdateMessage();
                this.viewVMSlots.printSlot(iIndex);
                this.viewMenu.clearScreen();
                this.maintenanceMenu();
                break;

            case 2: //change in vm slot, search by name then change price
                stInput = this.viewMenu.askInputString();
                iIndex = this.searchItemInSlots(stInput);
                if (iIndex!=-1) {
                    input = this.viewMenu.askInputCost();
                    this.changeCost(iIndex, input);
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printSlot(iIndex);
                }
                break;

            case 3: //change in stockroom, print all then choose  index
                this.viewStockRoom.displayAllItems();
                iIndex = this.viewMenu.restockPanel1();
                input = this.viewMenu.askInputCost();
                this.changeCost(iIndex, input);
                this.viewMenu.printUpdateMessage();
                this.viewStockRoom.displayItem(iIndex);
                break;

            case 4: //change in stockroom, search by name then change price
                stInput = this.viewMenu.askInputString();
                iIndex = this.searchItemInStockRoom(stInput);
                if (iIndex!=-1) {
                    input = this.viewMenu.askInputCost();
                    this.changeCost(iIndex, input);
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayItem(iIndex);
                }
                break;

            case 5: // back
                this.maintenanceMenu();
        }
    }

    /**
     * Provides various options to restock items based on user's choice.
     *
     * @param choice The option chosen by user to decide how to restock items.
     * 1. Display all items in stockroom and choose index to restock
     * 2. Search item by name in stockroom and restock
     * 3. Add new Item in stockroom
     * 4. Replenish Item Stock in Vending Machine
     * 5. Assign new item to empty Slot in Vending Machine
     * 6. Remove item from a slot in the vending machine
     * 7. Remove item from the stock room
     */
    public void restockMenu(int choice) {
        int iIndex, input;
        String stInput;
        boolean done = false;

        switch (choice) {
            case 1: //display all items in stockroom and choose index to restock
                while (!done){
                    this.viewStockRoom.displayAllItems();
                    iIndex = this.viewMenu.restockPanel1();
                    input = this.viewMenu.askInputNum();
                    this.restock(iIndex, input);
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayItem(iIndex);
                    done = this.viewMenu.askIfDone();
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayAllItems();
                }

                break;

            case 2: //search item by name in stockroom and restock
                while (!done) {
                    stInput = this.viewMenu.askInputString();
                    iIndex = this.searchItemInStockRoom(stInput);
                    if (iIndex != -1) {
                        input = this.viewMenu.askInputNum();
                        this.restock(iIndex, input);
                        this.viewMenu.printUpdateMessage();
                        this.viewStockRoom.displayItem(iIndex);
                        done = this.viewMenu.askIfDone();
                    }
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayAllItems();
                }

                break;

            case 3: //add new Item in stockroom
                while (!done) {
                    List<String> userInput = new ArrayList<>();
                    userInput = this.viewMenu.restockPanel3();
                    Item item = new Item(userInput.get(0), Integer.parseInt(userInput.get(1)), Double.parseDouble(userInput.get(2)), Integer.parseInt(userInput.get(3)));
                    this.stockRoom.getItems().add(item);
                    this.viewMenu.printUpdateMessage();
                    iIndex = this.stockRoom.getItems().size() - 1;
                    this.viewStockRoom.displayItem(iIndex);
                    done = this.viewMenu.askIfDone();
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayAllItems();
                }
                break;

            case 4: //Replenish Item Stock in Vending machine
                while (!done) {
                    this.viewVMSlots.printAllSlots();
                    iIndex = this.viewMenu.restockPanel2();
                    input = this.viewMenu.askInputNum();
                    this.replenish(iIndex, input);
                    done = this.viewMenu.askIfDone();
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printAllSlots();
                }
                break;

            case 5: //Assign new item to empty Slot in Vending Machine
                while (!done) {
                    this.viewVMSlots.printEmptySlots(this.curVM.getSlotLimit());
                    iIndex = this.viewMenu.askInputIndex();
                    List<String> userInput1 = new ArrayList<>();
                    userInput1 = this.viewMenu.restockPanel3();
                    Item item1 = new Item(userInput1.get(0), Integer.parseInt(userInput1.get(1)), Double.parseDouble(userInput1.get(2)), Integer.parseInt(userInput1.get(3)));
                    this.itemSlots.get(iIndex).setItemStored(item1);
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printSlot(iIndex);
                    done = this.viewMenu.askIfDone();
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printAllSlots();
                }

                break;

            case 6:
                while (!done) {
                    this.viewVMSlots.printAllSlots();
                    iIndex = this.viewMenu.askInputIndex();
                    this.deleteItemInSlot(iIndex);
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printSlot(iIndex);
                    done = this.viewMenu.askIfDone();
                }
                if(done){
                    this.viewMenu.printUpdateMessage();
                    this.viewVMSlots.printAllSlots();
                }
                break;

            case 7:
                while (!done) {
                    this.viewStockRoom.displayAllItems();
                    iIndex = this.viewMenu.askInputIndex();
                    this.deleteItemInStockRoom(iIndex);
                    this.viewMenu.printUpdateMessage();
                    this.viewStockRoom.displayAllItems();
                    done = this.viewMenu.askIfDone();
                }
                break;

        }

    }
}