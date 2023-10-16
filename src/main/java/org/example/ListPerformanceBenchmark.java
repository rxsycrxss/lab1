package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceBenchmark {
    public static void main(String[] args) {
        int numElements = 100000;
        int numInsertions = 1000;

        // Создаем списки ArrayList и LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Кількість елементів у списку: " + numElements);
        System.out.println("Число введених елементів: " + numInsertions);

        // Заполняем списки случайными числами
        fill(arrayList, numElements, "ArrayList");
        fill(linkedList, numElements, "LinkedList");

        // Измеряем производительность случайного доступа
        randomAccess(arrayList, "ArrayList");
        randomAccess(linkedList, "LinkedList");

        // Измеряем производительность последовательного доступа
        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        // Измеряем производительность вставки в начало списка
        insertAtBeginning(arrayList, numInsertions, "ArrayList");
        insertAtBeginning(linkedList, numInsertions, "LinkedList");

        // Измеряем производительность вставки в конец списка
        insertAtEnd(arrayList, numInsertions, "ArrayList");
        insertAtEnd(linkedList, numInsertions, "LinkedList");

        // Измеряем производительность вставки в середину списка
        insertInMiddle(arrayList, numElements, numInsertions, "ArrayList");
        insertInMiddle(linkedList, numElements, numInsertions, "LinkedList");
    }

    // Заполнение списка случайными числами
    private static void fill(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        System.out.printf("Заповнення %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }

    // Измерение производительности случайного доступа
    private static void randomAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
        }
        System.out.printf("Случайний доступ до %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }

    // Измерение производительности последовательного доступа
    private static void sequentialAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        for (Integer value : list) {
            int element = value;
        }
        System.out.printf("Послідовний доступ до %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }

    // Измерение производительности вставки в начало списка
    private static void insertAtBeginning(List<Integer> list, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numInsertions; i++) {
            list.add(0, i);
        }
        System.out.printf("Вставка в початок %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }

    // Измерение производительности вставки в конец списка
    private static void insertAtEnd(List<Integer> list, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numInsertions; i++) {
            list.add(i);
        }
        System.out.printf("Вставка в кінець %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }

    // Измерение производительности вставки в середину списка
    private static void insertInMiddle(List<Integer> list, int numElements, int numInsertions, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numInsertions; i++) {
            int index = numElements / 2;
            list.add(index, i);
        }
        System.out.printf("Вставка в середину %s: %d ms%n", listType, System.currentTimeMillis() - startTime);
    }
}