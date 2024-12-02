package src.main.java.hw;

import java.util.Comparator;

public class CustomArray {

    /**
     * Алгоритм бинарного поиска используется для поиска элемента в отсортированном массиве.
     * Работает путем повторного деления массива пополам, пока искомый элемент не будет найден или пока диапазон
     * поиска не станет пустым.
     * Если элемент найден, возвращается его индекс, если нет — возвращается отрицательное значение, представляющее
     * точку вставки.
     */

    // Метод для бинарного поиска в массиве байтов, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(byte[] a, byte key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива байтов с указанием диапазона
    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            byte midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве символов, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(char[] a, char key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива символов с указанием диапазона
    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            char midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве double, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(double[] a, double key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива double с указанием диапазона
    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            double midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве float, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(float[] a, float key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива float с указанием диапазона
    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            float midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве int, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(int[] a, int key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива int с указанием диапазона
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            int midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве long, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(long[] a, long key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива long с указанием диапазона
    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            long midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве short, возвращающий индекс найденного элемента или точку вставки
    public static int binarySearch(short[] a, short key) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key);
    }

    // Перегрузка метода бинарного поиска для массива short с указанием диапазона
    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            short midVal = a[mid]; // Значение элемента в середине

            if (midVal < key)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (midVal > key)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }

    // Метод для бинарного поиска в массиве объектов с использованием компаратора
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        // Вызов перегруженного метода с указанием всего диапазона массива
        return binarySearch(a, 0, a.length, key, c);
    }

    // Перегрузка метода бинарного поиска для массива объектов с использованием компаратора и указанием диапазона
    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        int low = fromIndex; // Нижняя граница поиска
        int high = toIndex - 1; // Верхняя граница поиска

        while (low <= high) {
            int mid = (low + high) >>> 1; // Находим середину текущего диапазона
            T midVal = a[mid]; // Значение элемента в середине
            int cmp = c.compare(midVal, key); // Сравнение значения в середине с искомым элементом

            if (cmp < 0)
                low = mid + 1; // Искомое значение больше середины, смещаем нижнюю границу
            else if (cmp > 0)
                high = mid - 1; // Искомое значение меньше середины, смещаем верхнюю границу
            else
                return mid; // Элемент найден, возвращаем его индекс
        }
        return -(low + 1);  // Элемент не найден, возвращаем отрицательную точку вставки
    }
}
