package Project;

import java.text.*;

public class Run {

    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////////
        long startTime1 = System.nanoTime();

        //Creating house objects
        for (int i = 0; i < 300000; i++){
            House House1 = new House(250.6f, "Location 1", 3, "\"The owner's name\"", false);
            House House2 = new House(410.2f, "Location 2", 5, "\"The owner's name\"", false);
            House House3 = new House(350.5f, "Location 3", 3, "\"The owner's name\"", false);
            House House4 = new House(380.0f, "Location 4", 4, "\"The owner's name\"", false);
        }

        for (House i : House.getHouseArrayList()) i.fancyPrint();
        House.printMostSpaciousAL();

        long endTime1 = System.nanoTime();


        ///////////////////////////////////////////////////////////////////////
        long startTime2 = System.nanoTime();

        for (int i = 0; i < 300000; i++){
            House House1 = new House(250.6f, "Location 1", 3, "\"The owner's name\"", true);
            House House2 = new House(410.2f, "Location 2", 5, "\"The owner's name\"", true);
            House House3 = new House(350.5f, "Location 3", 3, "\"The owner's name\"", true);
            House House4 = new House(380.0f, "Location 4", 4, "\"The owner's name\"", true);
        }

        for (House i : House.getHouseLinkedList()) i.fancyPrint();
        House.printMostSpaciousLL();

        long endTime2 = System.nanoTime();


        ///////////////////////////////////////////////////////////////////////
        long duration1 = (endTime1 - startTime1);
        long duration2 = (endTime2 - startTime2);

        System.out.printf("""
                ArrayList  Duration: %s
                LinkedList Duration: %s
                """, customFormat(duration1).replace(',', ' '),
                     customFormat(duration2).replace(',', ' '));
    }

    static public String customFormat(long value) {
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        return myFormatter.format(value);
    }
}