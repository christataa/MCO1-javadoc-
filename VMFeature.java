import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage a vending machine.
 */
public class VMFeature {
    private double customerChange;
    private RegularVM curVM;
    private ArrayList<ItemSlot> itemSlots;
    private ArrayList<Transaction> transactions;
    private ArrayList<Denomination> validDeno;
    private ArrayList<Denomination> vmChange;
    private ArrayList<Denomination> change;
    private ArrayList<Denomination> vmIncome;
    private StockRoom stockRoom;
    private ViewVMSlots viewVMSlots;
    private ViewTransaction viewTransaction;
    private ViewVMDeno viewDenoChange;
    private ViewVMDeno viewDenoIncome;
    private ViewPayment viewPayment;
    private ViewStockRoom viewStockRoom;
    private Payment payment;
    private Cart cart;
    private ViewCart viewCart;
    private ViewVMFeature viewVMFeature;
    private ViewMenu viewMenu;

    /**
     * Creates a VMFeature object to manage a given vending machine.
     * 
     * @param regularVM The vending machine to manage.
     */
    public VMFeature(RegularVM regularVM) {
        this.customerChange = 0;
        this.curVM = regularVM;
        this.payment = new Payment();
        this.cart = new Cart();
        this.itemSlots = this.curVM.getItemSlots();
        this.transactions = this.curVM.getTransactions();
        this.vmChange = this.curVM.getVmChange();
        this.change = new ArrayList<>();
        this.vmIncome = this.curVM.getVmIncome();
        this.validDeno = this.curVM.getValidDenominations();
        this.stockRoom = this.curVM.getStockRoom();
        this.viewVMSlots = new ViewVMSlots(this.itemSlots);
        this.viewTransaction = new ViewTransaction(this.transactions);
        this.viewDenoChange = new ViewVMDeno(this.change);
        this.viewDenoIncome = new ViewVMDeno(this.vmIncome);
        this.viewPayment = new ViewPayment(this.payment);
        this.viewStockRoom = new ViewStockRoom(this.stockRoom);
        this.viewCart = new ViewCart(this.cart);
        this.viewVMFeature = new ViewVMFeature(this.curVM);
    }
    /**
    * This method manages the vending feature menu.
    */
    public void vendingFeatureMenu() {
        int choice1;            
        boolean done = false;   
        boolean done2 = false;  
        boolean found = false;  
        List<String> userInput = new ArrayList<>();    

        this.viewVMFeature.chooseItemPanel1();
        this.viewVMSlots.printAllSlots();
        this.viewVMFeature.chooseItemPanel2();

        while(!done){
            found = false;
            userInput = this.viewVMFeature.insertPayment();
            Denomination input = new Denomination(Double.parseDouble(userInput.get(0)), Integer.parseInt(userInput.get(1)));
            for (int i =0; i<this.validDeno.size()&&!found; i++) {
                if (this.validDeno.get(i).getValue()==(input.getValue())) {
                    found = true;
                    this.payment.getPayment().add(input);
                    this.viewVMFeature.printAccepted();
                }
            }
            if (!found){
                this.viewVMFeature.printNotAccepted();
            }

            int j = this.viewVMFeature.askIfDone();
            if(j==1){
                done = true;
            }
            else done = false;
        }

        if (done){
            this.viewPayment.printBills();
            this.viewPayment.printTotalAmount();

            choice1 = this.viewVMFeature.printVMFeatureMenu();
            switch (choice1){
                case 1: //choose items
                    int j;
                    this.viewPayment.printBills();
                    this.viewPayment.printTotalAmount();
                    this.viewVMFeature.chooseItemPanel3();

                    while (!done2)
                    {
                        userInput = this.viewVMFeature.chooseItem();
                        int index = Integer.parseInt(userInput.get(0));
                        int quantity = Integer.parseInt(userInput.get(1));

                        if ((this.itemSlots.get(index).getItemStored().getAmount()>=quantity)){
                            Item item = new Item(this.itemSlots.get(index).getItemStored().getItemName(),
                                    quantity, this.itemSlots.get(index).getItemStored().getCost(),
                                    this.itemSlots.get(index).getItemStored().getCalories());
                            this.cart.getItemBought().add(item);
                            this.viewVMFeature.printAdded();
                        }
                        else {
                            this.viewVMFeature.printNotAdded();
                        }
                        j = this.viewVMFeature.askIfDone();
                        if(j==1){
                            done2 = true;
                        }
                        else done2=false;
                    }

                    if (done2){
                        this.viewCart.printItems();
                        this.viewCart.printTotalCost();
                        this.viewCart.printTotalCalories();
                        this.produceChange();
                        Transaction t = new Transaction(this.cart, this.payment);
                        this.transactions.add(t);
                        this.payment.getPayment().clear();
                        this.cart.getItemBought().clear();
                    }
                    break;
                case 2: //produce change (give back money)
                    this.viewVMFeature.printReturnCash(this.payment.getBillTotal());
                    this.payment.getPayment().clear();
            }


        }



    }
    /**
     * Produces change by given denomination.
     *
     * @param payment  The payment object.
     * @param vmChange The change in the vending machine.
     * @param value    The value to be deducted.
     */
    public void produceChangeByDeno(Payment payment, ArrayList<Denomination> vmChange, double value){
        double payed = this.payment.getBillTotal();
        double cost = this.cart.genTotalCost();
        int pieces = (int)(this.customerChange/value);
        boolean found = false;


        if (pieces !=0){
            found = false;
            for (int i =0; i<this.vmChange.size()&&!found; i++){
                if(this.vmChange.get(i).getValue()==value){
                    found = true;
                    if(this.vmChange.get(i).getPieces()>=pieces){
                        Denomination bill = new Denomination(value, pieces);
                        this.change.add(bill);
                        this.customerChange = (this.customerChange - (pieces*value));
                    }
                    else{
                        Denomination bill = new Denomination(value, this.vmChange.get(i).getPieces());
                        this.change.add(bill);
                        this.customerChange = (this.customerChange - (this.vmChange.get(i).getPieces()*value));
                    }
                }
            }
        }
    }

    /**
     * This method handles the production of change.
     */
    public void produceChange(){
        double payed = payment.getBillTotal();
        double cost = cart.genTotalCost();
        customerChange = payed - cost;
        double customerChange = this.customerChange;
        boolean removed = false;

        for (int i =0; i<validDeno.size(); i++){
            produceChangeByDeno(payment, vmChange, validDeno.get(i).getValue());
        }

        if (customerChange == 0){
            for (int i =0; i<this.payment.getPayment().size(); i++){
                this.vmIncome.add(this.payment.getPayment().get(i));
            }

            for (int i =0; i<this.change.size(); i++){
                removed = false;
                for (int j = 0; j<this.vmChange.size() && !removed; j++){
                    if (this.vmChange.get(j).getValue() == this.change.get(i).getValue()){
                        this.vmChange.get(j).setPieces(this.vmChange.get(i).getPieces()-this.change.get(i).getPieces());
                        removed = true;
                    }
                }
            }

            for (int i = 0; i<cart.getItemBought().size(); i++){
                removed = false;
                for (int j = 0; j<curVM.getSlotLimit() && !removed; j++){
                    if (itemSlots.get(j).getItemStored() != null){
                        if (cart.getItemBought().get(i).getItemName().equals(itemSlots.get(j).getItemStored().getItemName())){
                            int prevAmount = itemSlots.get(j).getItemStored().getAmount();
                            itemSlots.get(j).getItemStored().setAmount(prevAmount - cart.getItemBought().get(i).getAmount());
                            removed = true;
                        }
                    }

                }
            }
            this.viewVMFeature.printSuccessBuy(customerChange);
            this.viewDenoChange.printDenoForChange();
            this.viewVMFeature.goodByePanel();
        } else {
            this.viewVMFeature.printNotSuccessBuy(this.payment.getBillTotal());
            this.viewVMFeature.printVMFeatureMenu();
        }
    }
    /**
     * The main method that initiates the VMFeature object and calls its methods.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args){
        //notes to coder: 1. error checking for an item if it is stored already in another slot
        //                2. error checking if an item has the same name
        //                3. error checking for entering an item slot that is null
        RegularVM vm = new RegularVM();
        VMFeature vf = new VMFeature(vm);
        MaintenanceFeature mf = new MaintenanceFeature(vm);
        Item a = new Item("Corn Flakes",10,25,120);
        Item b = new Item("Vanilla Popcorn",10,15,140);
        Item c = new Item("Chocolate cookie",10,10,60);
        Item d = new Item("Cereal crackers",10,15,40);
        Item e = new Item("Frozen berries",10,30,60);
        vm.getItemSlots().get(1).setItemStored(a);
        vm.getItemSlots().get(4).setItemStored(b);
        vm.getItemSlots().get(5).setItemStored(c);
        vm.getItemSlots().get(7).setItemStored(d);
        vm.getItemSlots().get(2).setItemStored(e);
        vf.vendingFeatureMenu();
        mf.maintenanceMenu();
    }
}