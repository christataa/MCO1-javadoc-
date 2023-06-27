import java.util.ArrayList;

/**
 * This class is responsible for viewing various information about different denominations.
 */
public class ViewVMDeno {
    // List of denominations
    private ArrayList<Denomination> denominations;

    /**
     * Constructs a ViewVMDeno with specified list of denominations.
     * @param denominations List of denominations
     */
    public ViewVMDeno(ArrayList<Denomination> denominations){
        this.denominations = denominations;
    }

    /**
     * Prints the denomination and number of pieces for change.
     */
    public void printDenoForChange(){
        int i;
        System.out.println("Denomination for change contains: ");
        for (i=0; i<this.denominations.size(); i++){
            Denomination denomination = this.denominations.get(i);
            System.out.println(denomination.getValue() + " Pesos:\t" + denomination.getPieces()+ " pieces");
        }
    }

    /**
     * Prints the denomination and number of pieces for income.
     */
    public void printDenoIncome(){
        int i;
        for (i=0; i<this.denominations.size(); i++){
            Denomination denomination = this.denominations.get(i);
            System.out.println("income contains: ");
            System.out.println(denomination.getValue() + "Pesos: ");
            System.out.println(denomination.getPieces() + " pieces\n");
        }
    }

    /**
     * Prints the value of denomination at the given index.
     * @param index Index of the denomination
     */
    public void printDenoInfo(int index){
        System.out.println(this.denominations.get(index).getValue());
    }

    /**
     * Prints the number of denominations.
     */
    public void printNumOfDeno(){
        System.out.println(this.denominations.size());
    }
}
