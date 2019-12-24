package ui;

import java.util.Scanner;

public interface AppMenu {

    void printMenu();

    void returnPointMenu(int selection);

    default int menu() {
        printMenu();
        return new Scanner(System.in).nextInt();
    }
}
