package org.example.Services;

import org.example.Interfaces.IHtmlHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HtmlHandler implements IHtmlHandler {
    Map<String, String> previousPages = null;
    Map<String, String> currentPages = null;

    public HtmlHandler(Map<String, String> previousPages, Map<String, String> currentPages) {
        this.previousPages = previousPages;
        this.currentPages = currentPages;
    }

    public List<String> findDisappearedPages(){
        return findAppearedPages();
    }

    public List<String> findAppearedPages(){
        List<String> foundPages = new ArrayList<>();

        for (String prevUrl : previousPages.keySet()){
            boolean found = false;
            for (String curUrl : currentPages.keySet()){
                if (prevUrl.equals(curUrl)){
                    found = true;
                    break;
                }
            }
            if (!found){
                foundPages.add(prevUrl);
            }
        }

        return foundPages;
    }

    public List<String> findEditedPages(){
        List<String> foundPages = new ArrayList<>();
        for(String prevUrl : currentPages.keySet()){
            for (String curUrl : previousPages.keySet()){
                if (prevUrl.equals(curUrl) && !currentPages.get(prevUrl).equals(previousPages.get(curUrl))){
                    foundPages.add(prevUrl);
                }
            }
        }
        return foundPages;
    }
}
