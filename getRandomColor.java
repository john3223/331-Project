/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create class that returns a random value from the SquareType enum.
 * ===============================================================================================
 */
package com.example.gamedemo;
import java.util.Random;

public class getRandomColor {
    public static <T extends Enum<?>> T getRandomValue(Class<T> enumClass) {
        Random random = new Random();

        // create array of random enum constants.
        T[] values = enumClass.getEnumConstants();

        // Return a random constant from the array.
        return values[random.nextInt(values.length)];
    }
}
