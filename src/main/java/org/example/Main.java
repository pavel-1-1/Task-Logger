package org.example;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        Random random = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        NumRandom myNum = (random::nextInt);

        boolean start = true;
        while (start) {
            List<Integer> list = new ArrayList<>();
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.print("Введите размер списка: ");
            int listSize = scanner.nextInt();
            System.out.print("Введите верхнюю границу для значений: ");
            int border = scanner.nextInt();
            logger.log("Создаём и наполняем список");
            for (int i = 0; i < listSize; i++) {
                list.add(myNum.getNumber(border));
            }
            System.out.println("Вот случайный список: " + Arrays.toString(list.toArray()).replace("[", "")
                    .replace("]", ""));
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int filter = scanner.nextInt();
            logger.log("Запускаем фильтрацию");
            List<Integer> listFilter = new Filter(filter).outFilter(list);
            logger.log("Прошло фильтр " + listFilter.size() + " элемента из " + list.size());
            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + Arrays.toString(listFilter.toArray()).replace("[", "")
                    .replace("]", ""));
            start = false;
        }
        logger.log("Завершаем программу");
    }
}