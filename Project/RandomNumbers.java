package Project;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;


public class RandomNumbers {

    static ArrayList<Byte> list = new ArrayList<>();
    static byte elementCounter;

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

    @Contract(pure = true)
    private static Boolean isItInArrayList(byte b){
        boolean k = false;
        for (Byte i : list) {
            if (i == b) {
                k = true;
                elementCounter = (byte) (list.indexOf(i));
            }
        }
        return k;
    }

    private static void remover(){
        byte b = getRandom((byte) 1, (byte) 10);
        if (isItInArrayList(b)){
            list.remove(elementCounter);
            System.out.println("Got: " + b);
        }
        if (list.isEmpty()) {
            System.exit(0);
        } else {
            remover();
        }
    }
}
