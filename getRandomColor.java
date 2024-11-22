package com.example.gamedemo;
import java.util.Random;

public class getRandomColor {
    public static <T extends Enum<?>> T getRandomValue(Class<T> enumClass) {
        Random random = new Random();
        T[] values = enumClass.getEnumConstants();
        return values[random.nextInt(values.length)];
    }
}
