package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardItem> items;

    public Board() {
        items = new ArrayList<>();
    }

    public void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException("Item already in the list");
        }

        items.add(item);
    }

    public int totalItems() {
        return items.size();
    }

    void displayHistory() {
        for (BoardItem item : items ) {
            item.displayHistory();
        }
    }
}
