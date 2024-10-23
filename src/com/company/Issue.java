package com.company;

import java.time.LocalDate;

public class Issue extends BoardItem {

    private final String description;
    private static final Status INITIAL_STATUS = Status.VERIFIED;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.OPEN);

        if (description.isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void revertStatus() {
        if(getStatus() != Status.OPEN){
            setStatus(Status.OPEN);
            this.logEvent(String.format("Issue status set to %s", getStatus()));
        }
        else {
            this.logEvent(String.format("Issue status already %s", getStatus()));
        }
    }

    @Override
    public void advanceStatus() {
        if (getStatus() != Status.VERIFIED){
            setStatus(Status.VERIFIED);
            this.logEvent(String.format("Issue status set to %s", getStatus()));
        }
        else {
            this.logEvent(String.format("Issue status already %s", getStatus()));
        }
    }
}
