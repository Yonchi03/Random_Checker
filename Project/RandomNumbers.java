package Project;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;


public class RandomNumbers {

    static ArrayList<Byte> list = new ArrayList<>();
    static byte elementCounter = 20;

    public static float getRandomDouble(float min, float max) {
        return (float) ((Math.random() * ((max - min) + 1)) + min);
    }

    public static int getRandomInteger(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    ////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            list.add((byte) i);
        }
        for (Byte l : list) {
            System.out.print(l + " ");
        }
        System.out.println();
        remover();
    }

    @Contract(pure = true)
    private static Boolean isItInArrayList(byte b){
        byte k = 0;
        for (Byte i : list) {
            if (i == b) {
                k++;
                elementCounter = (byte) (list.indexOf(i));
            }
        }
        return k > 0;
    }

    private static void remover(){
        byte b = (byte) getRandomInteger(1, 10);
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
