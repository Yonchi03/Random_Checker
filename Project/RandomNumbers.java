package Project;

import java.util.ArrayList;


public class RandomNumbers {

    static ArrayList<Byte> list = new ArrayList<>();

    public static byte getRandom(byte min, byte max) {
        return (byte) ((Math.random() * ((max - min) + 1)) + min);
    }

    public static void main(String[] args) {
        for (byte i = 1; i < 11; i++) {
            list.add(i);
        }
        for (Byte l : list) {
            System.out.print(l + " ");
        }
        System.out.println();

        remover();
    }

    private static void remover(){
        Byte b = getRandom((byte) 1, (byte) 10);
        if (list.contains(b)){
            list.remove(b);
            System.out.println("Got: " + b);
        }
        if (list.isEmpty()) {
            System.exit(0);
        } else {
            remover();
        }
    }
}
