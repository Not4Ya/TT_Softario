package org.example.Interfaces;

import java.util.List;

public interface IHtmlHandler {
    List<String> findDisappearedPages();
    List<String> findAppearedPages();
    List<String> findEditedPages();
}
