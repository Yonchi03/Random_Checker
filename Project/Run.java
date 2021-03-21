package Project;

import java.text.*;

public class Run {

    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////////
        long before0 = Runtime.getRuntime().freeMemory();
        long startTime2 = System.nanoTime();

        House House5 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", true);
        House House6 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", true);
        House House7 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", true);
        House House8 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", true);


        for (House i : House.getHouseLinkedList()) i.fancyPrint();
        House.printMostSpaciousLL();

        long endTime2 = System.nanoTime();
        long used0 = before0 - Runtime.getRuntime().freeMemory();


        ///////////////////////////////////////////////////////////////////////
        long before = Runtime.getRuntime().freeMemory();
        long startTime1 = System.nanoTime();

        House House1 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", false);
        House House2 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", false);
        House House3 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", false);
        House House4 = new House(RandomNumbers.getRandomDouble(200, 700), "Location", RandomNumbers.getRandomInteger(1, 10), "\"The owner's name\"", false);

        for (House i : House.getHouseArrayList()) i.fancyPrint();
        House.printMostSpaciousAL();

        long endTime1 = System.nanoTime();
        long used = before - Runtime.getRuntime().freeMemory();


        ///////////////////////////////////////////////////////////////////////
        long duration1 = (endTime1 - startTime1);
        long duration2 = (endTime2 - startTime2);

        System.out.printf("""
                        ArrayList  Duration: %s
                        LinkedList Duration: %s
                        ArrayList  Memory  : %s
                        LinkedList Memory  : %s
                        """, customFormat(duration1).replace(',', ' '),
                customFormat(duration2).replace(',', ' '),
                customFormat(used).replace(',', ' '),
                customFormat(used0).replace(',', ' '));

        System.gc();
    }

    static public String customFormat(long value) {
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        return myFormatter.format(value);
    }
}