package org.ru.itdt.smenaparser;

import org.ru.itdt.smenaparser.ParserSmena.*;
import org.ru.itdt.smenaparser.ParserSmena.model.*;

public class Main {
    private static final String URL = "https://kinosmena.ru./?date=2022/12/15&facility=druzhba33";
    private final static Worker parser = new Worker(new Parser(), URL);

    static {
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());
    }

    public static void main(String[] args) throws InterruptedException {
        parser.Start();
    }

    static class NewData implements OnNewData {
        @Override
        public void OnNewData(final Object sender, final DatesContainer list) {
            for (final Date date : list.getDates()) {
                System.out.println("------------------" + date.getDate() + "------------------");

                for (final Movie movie : date.getMovies()) {
                    System.out.println("\t\t\t\t" + movie.getName());

                    for (final Cinema cinema : movie.getCinemas()) {
                        System.out.println("Кинотеатр: " + cinema.getName() + "\tпо адресу " + cinema.getAddress());

                        for (int i = 0; i < cinema.getSessions().size(); i++) {
                            if (i % 2 == 0 && i != 0) {
                                System.out.printf("\nНачало: " + cinema.getSessions().get(i).getTime() +
                                        " Цена: " + cinema.getSessions().get(i).getCost() + "\t");
                                continue;
                            }
                            System.out.printf("Начало: " + cinema.getSessions().get(i).getTime() +
                                    " Цена: " + cinema.getSessions().get(i).getCost() + "\t");
                        }
                        System.out.println("\n");
                    }
                    System.out.println();
                }
            }
        }
    }

    static class Completed implements OnCompleted {
        @Override
        public void OnCompleted(final Object sender) {
            System.out.println("Загрузка закончена");
        }
    }
}