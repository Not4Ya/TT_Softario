package org.example.Services;

import org.example.Interfaces.IHtmlHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HtmlHandler implements IHtmlHandler {
    public List<String> findDisappearedPages(Map<String, String> map1, Map<String, String> map2){
        return findAppearedPages(map2, map1);
    }

    public List<String> findAppearedPages(Map<String, String> prevPages, Map<String, String> curPages){
        List<String> foundPages = new ArrayList<>();

        for (String prevUrl : prevPages.keySet()){
            boolean found = false;
            for (String curUrl : curPages.keySet()){
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

    public List<String> findEditedPages(Map<String, String> prevPages, Map<String, String> curPages){
        List<String> foundPages = new ArrayList<>();
        for(String prevUrl : prevPages.keySet()){
            for (String curUrl : curPages.keySet()){
                if (prevUrl.equals(curUrl) && !prevPages.get(prevUrl).equals(curPages.get(curUrl))){
                    foundPages.add(prevUrl);
                }
            }
        }
        return foundPages;
    }

}
