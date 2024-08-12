package org.example.Services;

import jdk.jshell.Snippet;
import org.example.Data.HtmlPage;
import org.example.Data.Statuses;
import org.example.Interfaces.IHtmlHandler;

import java.util.*;

public class ImprovedHtmlHandler implements IHtmlHandler {
    private final Map<String, String> previousPages;
    private final Map<String, String> currentPages;
    private final Set<HtmlPage> set;

    public ImprovedHtmlHandler(Map<String, String> previousPages, Map<String, String> currentPages) {
        this.previousPages = previousPages;
        this.currentPages = currentPages;
        set = new HashSet<>();
        fillSet();
    }

    // Этот метод нужен для создания общего пула страниц
    private void fillSet(){
        for (String url: previousPages.keySet()){
            set.add(new HtmlPage(url, previousPages.get(url), Statuses.PREVIOUS ));
        }

        // Вчерашние уже заполнили. Заполняем сегодняшие.
        for (String url: currentPages.keySet()){
            if (!set.contains(new HtmlPage(url))){
                set.add(new HtmlPage(url, currentPages.get(url), Statuses.CURRENT));
            }
            else{
                set.remove(new HtmlPage(url));
                set.add(new HtmlPage(url, currentPages.get(url), Statuses.CURRENT, Statuses.PREVIOUS));
            }
        }
    }

    @Override
    public List<String> findDisappearedPages() {
        List<String> foundPages = new ArrayList<>();

        for (HtmlPage page: set){
            if (page.getStatuses().size() == 1 && page.getStatuses().contains(Statuses.PREVIOUS)){
                foundPages.add(page.getUrl());
            }
        }
        return foundPages;
    }

    @Override
    public List<String> findAppearedPages() {
        List<String> foundPages = new ArrayList<>();

        for (HtmlPage page: set){
            if (page.getStatuses().size() == 1 && page.getStatuses().contains(Statuses.CURRENT)){
                foundPages.add(page.getUrl());
            }
        }
        return foundPages;
    }

    @Override
    public List<String> findEditedPages() {
        List<String> foundPages = new ArrayList<>();

        for (HtmlPage page: set){
            if (page.getStatuses().contains(Statuses.PREVIOUS) && page.getStatuses().contains(Statuses.CURRENT)){
                foundPages.add(page.getUrl());
            }
        }
        return foundPages;
    }
}
