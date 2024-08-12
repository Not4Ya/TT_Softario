package org.example;


import org.example.Interfaces.IReader;
import org.example.Services.ConsoleWriter;
import org.example.Services.HtmlHandler;
import org.example.Services.HtmlReader;
import org.example.Services.ImprovedHtmlHandler;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        IReader reader = new HtmlReader();
        String previousPagesFilePath = "HtmlPages/PreviousPages";
        String currentPagesFilePath = "HtmlPages/CurrentPages";

        Map<String, String> previousPages = reader.read(previousPagesFilePath);
        Map<String, String> currentPages = reader.read(currentPagesFilePath);

        System.out.println("//--------------------First way--------------------");
        HtmlHandler handler = new HtmlHandler(previousPages, currentPages);
        List<String> disappearedPages = handler.findDisappearedPages();
        List<String> appearedPages = handler.findAppearedPages();
        List<String> editedPages = handler.findEditedPages();

        ConsoleWriter writer = new ConsoleWriter();
        writer.write(disappearedPages, appearedPages, editedPages);

        System.out.println("//--------------------Second way--------------------");
        ImprovedHtmlHandler newOne = new ImprovedHtmlHandler(previousPages, currentPages);
        List<String> disappearedPages2 = newOne.findDisappearedPages();
        List<String> appearedPages2 = newOne.findAppearedPages();
        List<String> editedPages2 = newOne.findEditedPages();

        writer.write(disappearedPages2, appearedPages2, editedPages2);
    }
}