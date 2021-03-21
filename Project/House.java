package Project;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;

class House extends Building {

    //Fields
    private final int numFloors;
    private final String ownerName;
    private static final ArrayList<House> houseArrayList = new ArrayList<>();
    private static final LinkedList<House> houseLinkedList = new LinkedList<>();

    //Get method for the list
    protected static ArrayList<House> getHouseArrayList() { return houseArrayList; }
    protected static LinkedList<House> getHouseLinkedList() { return houseLinkedList; }

    //Constructor
    protected House(float area, String address, int numFloors, String ownerName, boolean link) {
        super(area, address);
        this.numFloors = numFloors;
        this.ownerName = ownerName;
        if (link) {
            houseLinkedList.add(this); } else {
            houseArrayList.add(this); }
    }

    //Methods to find the most spacious house
    protected static House mostSpaciousAL(){
        House max = houseArrayList.get(0);

        for (House i : houseArrayList) {
            if (i.getArea() / i.numFloors > max.getArea() / max.numFloors) max = i;
        }
        return max;
    }

    protected static House mostSpaciousLL(){
        House max = houseLinkedList.getFirst();

        for (House i : houseLinkedList) {
            if (i.getArea() / i.numFloors > max.getArea() / max.numFloors) max = i;
        }
        return max;
    }

    //Method for printing houses
    protected void fancyPrint(){
        System.out.printf("---------------------------------------------------%n");
        System.out.print(this);
        System.out.printf("---------------------------------------------------%n%n");
    }

    //Method to print the most spacious house
    protected static void printMostSpaciousAL(){
        System.out.println("НАЙ-ПРОСТОРНАТА КЪЩА Е: (AL)");
        mostSpaciousAL().fancyPrint();
    }

    protected static void printMostSpaciousLL(){
        System.out.println("НАЙ-ПРОСТОРНАТА КЪЩА Е: (LL)");
        mostSpaciousLL().fancyPrint();
    }

    //Override "toString" so the return value is as we want it
    @Override
    public String toString() {
        return  String.format("""
                Address : %s
                Owner   : %s
                Floors  : %d
                Area    : %s
                """,
                this.getAddress(), this.ownerName, this.numFloors,
                NumberFormat.getInstance().format(this.getArea()));
    }

}