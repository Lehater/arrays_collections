## 3.11. Сортировки и поиск. Домашнее задание. (HW)

Реализуйте собственные классы Arrays и Collections, которые будут содержать все реализации методов binarySearch согласно
документации Java.

Ваша задача — самостоятельно реализовать все методы binarySearch, которые реализованы для классов Collections и Arrays в
Java. Документация доступна по ссылкам: [Arrays](https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html)
и [Collections](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html) соответственно.
В [третьем уроке](https://apps.skillfactory.ru/learning/course/course-v1:SkillFactory+MIFIDEV+SEP2024/block-v1:SkillFactory+MIFIDEV+SEP2024+type@sequential+block@ef9e3be99c34486a8148868829605548/block-v1:SkillFactory+MIFIDEV+SEP2024+type@vertical+block@53396be8039f4e628ee10e78a85295e1)
вы уже разбирали реализации некоторых методов из данных классов, поэтому советуем обратить на него пристальное внимание.

> Если посмотреть чуть глубже, то перегрузка в Java реализует концепцию статического полиморфизма, также известную как
> раннее связывание (early binding). Это означает, что компилятор определяет, какой метод вызвать, основываясь на типе и
> количестве аргументов, переданных методу.

Также при реализации методов 15 и 16 для класса Arrays и всех методов класса Collections вы встретитесь с объектом
Comparator и интерфейсом Comparable, а также с понятием дженериков.

> С интерфейсом Comparable вы уже сталкивались в восьмом уроке. Он нужен для того, чтобы определить естественный порядок
> сравнения объектов, без которого невозможно осуществить бинарный поиск.

> Объект Comparator в Java используется для задания нестандартного (или вторичного) порядка сортировки объектов. В
> отличие
> от интерфейса Comparable, который определяет естественный порядок объектов через метод compareTo, Comparator позволяет
> определить различные способы сравнения объектов без изменения их классов.
> Это особенно полезно, когда нужно сортировать объекты по разным критериям в зависимости от ситуации:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchWithComparator {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Charlie", 35));
        people.add(new Person("Bob", 25));

        // Сортировка списка по имени
        Collections.sort(people, new NameComparator());

        // Объект для поиска
        Person searchPerson = new Person("Bob", 0); // Возраст не имеет значения для сравнения по имени

        // Выполнение бинарного поиска
        int index = Collections.binarySearch(people, searchPerson, new NameComparator());
        if (index >= 0) {
            System.out.println("Person found at index: " + index);
            System.out.println("Found person: " + people.get(index).getName());
        } else {
            System.out.println("Person not found");
        }
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
```

> Дженерики — это механизм, который позволяет создавать классы, интерфейсы и методы, способные работать с различными
> типами данных, сохраняя строгую типизацию. Дженерики предоставляют средства для параметризации типов, что позволяет
> избежать ошибок времени выполнения, связанных с неправильным приведением типов, и улучшает читаемость и повторное
> использование кода.

В этом задании вам необходимо их использовать, чтобы реализовать бинарный поиск для массивов и списков всех возможных
объектов в Java.

> В данном примере метод `printList` благодаря применению дженериков может работать с любым списком объектов. Главное,
> чтобы объект реализовывал метод `toString`, а поскольку его реализация есть по умолчанию у всех объектов Java, данный
> метод будет работать для списка любых объектов в принципе:

```java
import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        List<ExampleInteger> intList = new ArrayList<>();
        intList.add(new ExampleInteger(1, 2, 3));
        intList.add(new ExampleInteger(4, 5, 6));
        intList.add(new ExampleInteger(7, 8, 9));

        List<ExampleString> strList = new ArrayList<>();
        strList.add(new ExampleString("a", "b", "c"));
        strList.add(new ExampleString("d", "e", "f"));
        strList.add(new ExampleString("g", "h", "i"));

        printList(intList);
        printList(strList);
    }
}

class ExampleInteger {
    int a;
    int b;
    int c;

    ExampleInteger(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return Integer.toString(a + b + c);
    }
}

class ExampleString {
    String s1;
    String s2;
    String s3;

    ExampleString(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    @Override
    public String toString() {
        return s1 + s2 + s3;
    }
}
```

## Сигнатура метода binarySearch

Пример метода: `binarySearch(List<?> list, T key)`

- `List<?>`: Указывает, что метод принимает список (`List`).
- `T`: Это объявление обобщённого типа `T`. Оно указывает, что метод работает с типом данных, который будет определён в
  момент вызова метода.
- `?`: Этот символ (wildcard) означает «любой тип».
- `extends Comparable`: Указывает, что элементы списка должны быть любого типа, который является потомком (`extends`)
  `Comparable`. То есть элемент списка должен быть сравнимым с объектами типа `T` или с его родительскими классами. То
  есть в данном случае тип элементов списка должен реализовывать интерфейс `Comparable`, причём его параметризованный
  тип (`?`) должен быть либо `T`, либо любой родительский `T` (обозначенный как `? super T`).

---

## Критерии оценивания

Теперь вернёмся к заданию. Ваш класс `Arrays` должен содержать реализации следующих методов:

| Метод                                                                                        | Баллы   |
|----------------------------------------------------------------------------------------------|---------|
| `static int binarySearch(byte[] a, byte key)`                                                | 1 балл  |
| `static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key)`                    | 2 балла |
| `static int binarySearch(char[] a, char key)`                                                | 1 балл  |
| `static int binarySearch(char[] a, int fromIndex, int toIndex, char key)`                    | 2 балла |
| `static int binarySearch(double[] a, double key)`                                            | 1 балл  |
| `static int binarySearch(double[] a, int fromIndex, int toIndex, double key)`                | 2 балла |
| `static int binarySearch(float[] a, float key)`                                              | 1 балл  |
| `static int binarySearch(float[] a, int fromIndex, int toIndex, float key)`                  | 2 балла |
| `static int binarySearch(int[] a, int key)`                                                  | 1 балл  |
| `static int binarySearch(int[] a, int fromIndex, int toIndex, int key)`                      | 2 балла |
| `static int binarySearch(long[] a, long key)`                                                | 1 балл  |
| `static int binarySearch(long[] a, int fromIndex, int toIndex, long key)`                    | 2 балла |
| `static int binarySearch(short[] a, short key)`                                              | 1 балл  |
| `static int binarySearch(short[] a, int fromIndex, int toIndex, short key)`                  | 2 балла |
| `static int binarySearch(T[] a, T key, Comparator<? super T> c)`                             | 2 балла |
| `static int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)` | 2 балла |

Ваш класс `Collections` должен содержать реализации следующих методов:

| Метод                                                                             | Баллы   |
|-----------------------------------------------------------------------------------|---------|
| `static int binarySearch(List<? extends Comparable<? super T>> list, T key)`      | 2 балла |
| `static int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)` | 2 балла |

Максимальный балл по заданию: **29**.

В форме сдачи задания прикрепите ссылку на свой GitHub. Не забудьте сделать ссылку доступной для просмотра.

