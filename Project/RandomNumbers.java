package Project;

import java.util.ArrayList;


public class RandomNumbers {

    static ArrayList<Byte> list = new ArrayList<>();

    public static byte getRandom(byte min, byte max) {
        return (byte) ((Math.random() * ((max - min) + 1)) + min);
    }

    public static void main(String[] args) {

        for (byte i = 1; i < 26; i++) {
            list.add(i);
        }
        remover();
    }

    private static void remover(){
        Byte b = getRandom((byte) 1, (byte) 25);
        if (list.contains(b)){
            printList();
            System.out.println("Got: " + b);
            list.remove(b);
        }
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            System.exit(0);
        } else {
            remover();
        }
    }

    private static void printList (){
        System.out.print("List: ");
        for (byte l : list) {
            System.out.print(l + " ");
        }
        System.out.print("\n");
    }
}
