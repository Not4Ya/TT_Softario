package org.example;


import org.example.Interfaces.IReader;
import org.example.Services.ConsoleWriter;
import org.example.Services.HtmlHandler;
import org.example.Services.HtmlReader;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * PreviousPages: 1 2 3 6 7 8 - появились 4 5
     * CurrentPages:  4 5 6 7 8   - изчезнули 1 2 3
     * Edited pages:  7 8
     * Common page:   6
     * */

    public static void main(String[] args) {


        IReader reader = new HtmlReader();
        String previousPagesFilePath = "HtmlPages/PreviousPages";
        String currentPagesFilePath = "HtmlPages/CurrentPages";

        Map<String, String> previousPages = reader.read(previousPagesFilePath);
        Map<String, String> currentPages = reader.read(currentPagesFilePath);

        HtmlHandler handler = new HtmlHandler();
        List<String> disappearedPages = handler.findDisappearedPages(previousPages, currentPages);
        List<String> appearedPages = handler.findAppearedPages(previousPages, currentPages);
        List<String> editedPages = handler.findEditedPages(previousPages, currentPages);

        ConsoleWriter writer = new ConsoleWriter();
        writer.write(disappearedPages, appearedPages, editedPages);


    }
}