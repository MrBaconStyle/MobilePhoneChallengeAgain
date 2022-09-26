package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactsList = new ArrayList<Contacts>();

    public void addContact(Contacts contact) {
        int position = findContact(contact);
        if (position < 0) {
            contactsList.add(contact);
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public void queryContact() {
        System.out.println("There are " + contactsList.size() + " in contact list");
        for (int i=0; i < contactsList.size(); i++) {
            System.out.println((i+1) + ". " + contactsList.get(i));
        }
    }

    public void modifyContact(Contacts currentContact, Contacts newContact) {
        int position = findContact(currentContact);
        if (position < 0) {
            System.out.println("Contact can't be modified. There is no such contact in contact list.");
        } else {
            modifyContact(position, newContact);
        }
    }

    private void modifyContact(int position, Contacts contact) {
        contactsList.set(position, contact);
        System.out.println("Contact " + contact + " has been modified.");
    }

    public void removeContact(Contacts contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println("Contact can't be deleted. There is no such contact in contact list");
        } else {
            removeContact(position);
        }
    }

    private void removeContact(int position) {
        //Contacts contact = contactsList.get(position);
        contactsList.remove(position);
    }

    private int findContact (Contacts contact) {
        return contactsList.indexOf(contact);
    }
}
