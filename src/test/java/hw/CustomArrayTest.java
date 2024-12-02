package src.test.java.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.main.java.hw.CustomArray.binarySearch;

public class CustomArrayTest {

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве целых чисел.
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchIntArray() {
        int[] array = {1, 3, 5, 7, 9, 11};
        assertEquals(2, binarySearch(array, 5)); // Ожидаемый индекс числа 5: 2
        assertEquals(-1, binarySearch(array, 0)); // Ожидаемая точка вставки для 0: -1
        assertEquals(-7, binarySearch(array, 13)); // Ожидаемая точка вставки для 13: -7
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве байтов.
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchByteArray() {
        byte[] array = {1, 3, 5, 7, 9, 11};
        assertEquals(2, binarySearch(array, (byte) 5)); // Ожидаемый индекс числа 5: 2
        assertEquals(-1, binarySearch(array, (byte) 0)); // Ожидаемая точка вставки для 0: -1
        assertEquals(-7, binarySearch(array, (byte) 13)); // Ожидаемая точка вставки для 13: -7
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве символов.
     * Проверяется, что для существующих символов возвращается правильный индекс,
     * а для отсутствующих символов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchCharArray() {
        char[] array = {'a', 'c', 'e', 'g', 'i', 'k'};
        assertEquals(2, binarySearch(array, 'e')); // Ожидаемый индекс символа 'e': 2
        assertEquals(-2, binarySearch(array, 'b')); // Ожидаемая точка вставки для 'b': -2
        assertEquals(-7, binarySearch(array, 'm')); // Ожидаемая точка вставки для 'm': -7
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве чисел с плавающей точкой (double).
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchDoubleArray() {
        double[] array = {1.1, 3.3, 5.5, 7.7, 9.9};
        assertEquals(2, binarySearch(array, 5.5)); // Ожидаемый индекс числа 5.5: 2
        assertEquals(-1, binarySearch(array, 0.5)); // Ожидаемая точка вставки для 0.5: -1
        assertEquals(-6, binarySearch(array, 10.1)); // Ожидаемая точка вставки для 10.1: -6
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве чисел с плавающей точкой (float).
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchFloatArray() {
        float[] array = {1.1f, 3.3f, 5.5f, 7.7f, 9.9f};
        assertEquals(2, binarySearch(array, 5.5f)); // Ожидаемый индекс числа 5.5: 2
        assertEquals(-1, binarySearch(array, 0.5f)); // Ожидаемая точка вставки для 0.5: -1
        assertEquals(-6, binarySearch(array, 10.1f)); // Ожидаемая точка вставки для 10.1: -6
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве длинных чисел (long).
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchLongArray() {
        long[] array = {1L, 3L, 5L, 7L, 9L};
        assertEquals(2, binarySearch(array, 5L)); // Ожидаемый индекс числа 5: 2
        assertEquals(-1, binarySearch(array, 0L)); // Ожидаемая точка вставки для 0: -1
        assertEquals(-6, binarySearch(array, 11L)); // Ожидаемая точка вставки для 11: -6
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве коротких чисел (short).
     * Проверяется, что для существующих элементов возвращается правильный индекс,
     * а для отсутствующих элементов возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchShortArray() {
        short[] array = {1, 3, 5, 7, 9};
        assertEquals(2, binarySearch(array, (short) 5)); // Ожидаемый индекс числа 5: 2
        assertEquals(-1, binarySearch(array, (short) 0)); // Ожидаемая точка вставки для 0: -1
        assertEquals(-6, binarySearch(array, (short) 11)); // Ожидаемая точка вставки для 11: -6
    }

    /**
     * Проверяет корректность выполнения бинарного поиска в массиве строк с использованием компаратора.
     * Проверяется, что для существующих строк возвращается правильный индекс,
     * а для отсутствующих строк возвращается корректная точка вставки.
     */
    @Test
    public void testBinarySearchObjectArray() {
        String[] array = {"apple", "banana", "cherry", "date", "fig"};
        // Ожидаемый индекс строки "banana": 1
        assertEquals(1, binarySearch(array, "banana", String::compareTo));
        // Ожидаемая точка вставки для "aardvark": -1
        assertEquals(-1, binarySearch(array, "aardvark", String::compareTo));
        // Ожидаемая точка вставки для "grape": -6
        assertEquals(-6, binarySearch(array, "grape", String::compareTo));
    }
}
