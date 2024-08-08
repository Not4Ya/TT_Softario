package org.example;


import org.example.Interfaces.IReader;
import org.example.Services.HtmlReader;
import java.util.Map;

public class Main {

    /**
     * PreviousPages: 1 2 3
     * CurrentPages: 4 5
     * Edited pages: 6 7 8
     * */

    public static void main(String[] args) {
        IReader reader = new HtmlReader();
        String previousPagesFilePath = "HtmlPages/PreviousPages";
        String currentPagesFilePath = "HtmlPages/CurrentPages";

        Map<String, String> previousPages = reader.read(previousPagesFilePath);
        Map<String, String> currentPages = reader.read(currentPagesFilePath);




    }
}