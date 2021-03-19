package Project;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

class House extends Building {

    //Fields
    private final int numFloors;
    private final String ownerName;
    private static final List<House> houseList = new ArrayList<>();

    //Get method for the list
    protected static List<House> getHouseList() { return houseList; }

    //Constructor
    protected House(float area, String address, int numFloors, String ownerName) {
        super(area, address);
        this.numFloors = numFloors;
        this.ownerName = ownerName;
        houseList.add(this);
    }

    //Method to find the most spacious house
    private static House mostSpacious(){
        House max = houseList.get(0);

        for (House i : houseList) {
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
    protected static void printMostSpacious(){
        System.out.println("НАЙ-ПРОСТОРНА КЪЩА: ");
        mostSpacious().fancyPrint();
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