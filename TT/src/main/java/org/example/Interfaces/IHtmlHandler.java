package org.example.Interfaces;

import java.util.List;
import java.util.Map;

public interface IHtmlHandler {
    List<String> findDisappearedPages(Map<String, String> map1, Map<String, String> map2);
    List<String> findAppearedPages(Map<String, String> prevPages, Map<String, String> curPages);
    List<String> findEditedPages(Map<String, String> prevPages, Map<String, String> curPages);
}
