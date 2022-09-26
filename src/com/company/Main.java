package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone contactList = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contactList.queryContact();
                    break;
                case 2:
                    newContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print contact list.");
        System.out.println("\t 2 - To add an contact.");
        System.out.println("\t 3 - To modify contact.");
        System.out.println("\t 4 - To remove contact.");
        System.out.println("\t 5 - To quit the application.");
    }

    public static void newContact() {
        System.out.println("Enter new contact: ");
        contactList.addContact(scanner.nextLine());
    }
}
