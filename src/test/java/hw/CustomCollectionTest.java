package src.test.java.hw;

import org.junit.jupiter.api.Test;
import src.main.java.hw.CustomCollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomCollectionTest {

    /**
     * Тестирует метод binarySearch для списка элементов, реализующих интерфейс Comparable.
     * Проверяется корректность поиска элемента в отсортированном списке целых чисел.
     */
    @Test
    public void testBinarySearchWithComparable() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11);
        // Проверка существующего элемента
        assertEquals(2, CustomCollection.binarySearch(list, 5));
        // Проверка отсутствующего элемента меньше первого
        assertEquals(-1, CustomCollection.binarySearch(list, 0));
        // Проверка отсутствующего элемента больше последнего
        assertEquals(-7, CustomCollection.binarySearch(list, 13));
        // Проверка первого элемента
        assertEquals(0, CustomCollection.binarySearch(list, 1));
        // Проверка последнего элемента
        assertEquals(5, CustomCollection.binarySearch(list, 11));
    }

    /**
     * Тестирует метод binarySearch для списка элементов с использованием компаратора.
     * Проверяется корректность поиска элемента в отсортированном списке строк.
     */
    @Test
    public void testBinarySearchWithComparator() {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        Comparator<String> comparator = String::compareTo;

        // Проверка существующего элемента
        assertEquals(1, CustomCollection.binarySearch(list, "banana", comparator));
        // Проверка отсутствующего элемента меньше первого
        assertEquals(-1, CustomCollection.binarySearch(list, "aardvark", comparator));
        // Проверка отсутствующего элемента больше последнего
        assertEquals(-6, CustomCollection.binarySearch(list, "grape", comparator));
        // Проверка первого элемента
        assertEquals(0, CustomCollection.binarySearch(list, "apple", comparator));
        // Проверка последнего элемента
        assertEquals(4, CustomCollection.binarySearch(list, "fig", comparator));
    }

    /**
     * Тестирует метод binarySearch для списка элементов с использованием пользовательского компаратора.
     * Проверяется корректность поиска элемента в отсортированном в обратном порядке списке строк.
     */
    @Test
    public void testBinarySearchWithCustomComparator() {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        Comparator<String> reverseComparator = (a, b) -> b.compareTo(a);

        // Сортируем список в обратном порядке для проверки поиска с кастомным компаратором
        list.sort(reverseComparator);

        // Проверка существующего элемента
        assertEquals(3, CustomCollection.binarySearch(list, "banana", reverseComparator));
        // Проверка отсутствующего элемента больше первого в обратном порядке
        assertEquals(-1, CustomCollection.binarySearch(list, "grape", reverseComparator));
        // Проверка первого элемента в отсортированном по убыванию списке
        assertEquals(0, CustomCollection.binarySearch(list, "fig", reverseComparator));

    }
}
