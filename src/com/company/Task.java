package com.company;

import java.time.LocalDate;

public class Task extends BoardItem {

    private static final int ASSIGNEE_MIN_LENGTH = 5;
    private static final int ASSIGNEE_MAX_LENGTH = 30;

    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.TODO);

        ensureValidAssignee(assignee);
        this.assignee = assignee;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        ensureValidAssignee(assignee);

        logEvent(String.format("Assignee changed from %s to %s", this.getAssignee(), assignee));

        this.assignee = assignee;
    }

    private void ensureValidAssignee(String assignee) {
        if (assignee.length() < ASSIGNEE_MIN_LENGTH || assignee.length() > ASSIGNEE_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "The assignee's name must be between %d and %d characters.",
                    ASSIGNEE_MIN_LENGTH, ASSIGNEE_MAX_LENGTH));
        }
    }

    @Override
    public void revertStatus() {
        if (getStatus() != Status.TODO) {
            setStatus(Status.values()[getStatus().ordinal() - 1]);
            this.logEvent(String.format("Status changed from %s to %s", Status.values()[getStatus().ordinal() + 1], getStatus()));
        } else {
            this.logEvent(String.format("Can't revert, already at %s", getStatus()));
        }
    }

    @Override
    public void advanceStatus() {
        if (getStatus() != Status.VERIFIED) {
            setStatus(Status.values()[getStatus().ordinal() + 1]);
            this.logEvent(String.format("Task status changed from %s to %s", Status.values()[getStatus().ordinal() - 1], getStatus()));
        } else {
            this.logEvent(String.format("Can't advance, already at %s", getStatus()));
        }
    }
}
