package com.crud.library.domain;

public enum BookStatus {

    AVAILABLE("Available"),
    BORROWED("Borrowed"),
    LOST("Lost");

    private final String displayName;

    BookStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
