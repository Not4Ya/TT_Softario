package org.example.Services;

import org.example.Interfaces.IWriter;

import java.util.List;

public class ConsoleWriter implements IWriter {
    @Override
    public void write(List<String> appearedPages, List<String> disappearedPages, List<String> editedPages){
        System.out.println("Здравствуйте, дорогая и.о. секретаря");
        System.out.println("За последние сутки во вверенных Вам сайтах произошли следующие изменения:");
        System.out.println("Исчезли следующие страницы:");
        print(disappearedPages);
        System.out.println("Появились следующие новые страницы:");
        print(appearedPages);
        System.out.println("Изменились следующие страницы");
        print(editedPages);
    }

    private void print(List<String> list){
        for (String url: list){
            System.out.println(url);
        }
    }
}
