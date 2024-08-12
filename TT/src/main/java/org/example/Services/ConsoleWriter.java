package org.example.Services;

import org.example.Interfaces.IWriter;

import java.util.List;

public class ConsoleWriter implements IWriter {
    @Override
    public void write(List<String> appearedPages, List<String> disappearedPages, List<String> editedPages){
        System.out.println("Здравствуйте, дорогая и.о. секретаря");
        System.out.println("За последние сутки во вверенных Вам сайтах произошли следующие изменения:");
        System.out.println("Исчезли следующие страницы:");

        disappearedPages.forEach(System.out::println);
        System.out.println("Появились следующие новые страницы:");
        appearedPages.forEach(System.out::println);
        System.out.println("Изменились следующие страницы");
        editedPages.forEach(System.out::println);
        System.out.println();
    }
}
