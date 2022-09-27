package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone newPerson = new MobilePhone("063 123 456");
    private static Contacts vuk = new Contacts("Vuk Arunovic", "063123456");

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
                    newPerson.printContact();
                    break;
                case 2:
                    newMyContact();
                    break;
                case 3:
                    modifyMyContact();
                    break;
//                case 4:
//                    removeMyContact();
//                    break;
//                case 5:
//                    queryMyContact();
//                    break;
                case 6:
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

    private static void newMyContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if (newPerson.addContact(newContact)) {
            System.out.println("New contact added: name= " + name + ", phone = " + phone);
        } else {
            System.out.println(" Cannot add, name already on file");
        }
    }

    private static void modifyMyContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = newPerson.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (newPerson.modifyContact(existingContactRecord, newContact)) {
            System.out.println(" Successfully updated record");
        } else {
            System.out.println(" Error updating record");
        }
    }

    private static void removeMyContact() {
        System.out.println("Enter contact to be deleted: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = newPerson.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        removeMyContact(existingContactRecord);
    }
}
