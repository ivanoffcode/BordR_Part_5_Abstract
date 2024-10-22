package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
       /* //3 Board Item Class
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        Task task = new Task("Test the application flow", "Pesho", tomorrow);

// this MUST not compile: "'BoardItem' is abstract; cannot be instantiated"
        BoardItem item = new BoardItem("title", tomorrow);*/
        //4. Issue CLass
        /*LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);

        issue.revertStatus();
        issue.advanceStatus();
        issue.advanceStatus();
        issue.revertStatus();

        issue.displayHistory();*/
        //5. Task Class
        /*LocalDate tomorrow = LocalDate.now().plusDays(1);
        Task task = new Task("App flow tests?", "Pesho", tomorrow);

        task.revertStatus();
        task.advanceStatus();
        task.advanceStatus();
        task.revertStatus();
        task.advanceStatus();
        task.advanceStatus();
        task.advanceStatus();

        task.displayHistory();*/
        //6. Logging BoardItems
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Task task = new Task("App flow tests?", "Pesho", tomorrow);
        Issue issue = new Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        Board board = new Board();

        board.addItem(task);
        board.addItem(issue);
        task.advanceStatus();
        issue.advanceStatus();

        board.displayHistory();
    }

}
