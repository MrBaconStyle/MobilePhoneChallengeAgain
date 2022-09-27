package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contactsList;// = new ArrayList<Contacts>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactsList = new ArrayList<Contacts>();
    }

//    public void addContact(Contacts contact) {
//        int position = findContact(contact);
//        if (position < 0) {
//            contactsList.add(contact);
//        } else {
//            System.out.println("Contact already exists.");
//        }
//    }

    public boolean addContact (Contacts contact) {
        if (findContact(contact.getName()) > 0) {
            //System.out.println("Contact already exists");
            return false;
        }
        contactsList.add(contact);
        return true;
    }

    public void printContact() {
        System.out.println("There are " + this.contactsList.size() + " in contact list");
        for (int i=0; i < this.contactsList.size(); i++) {
            System.out.println((i+1) + ". " + this.contactsList.get(i).getName() + " -> " + this.contactsList.get(i).getPhoneNumber());
        }
    }

    public boolean modifyContact(Contacts currentContact, Contacts newContact) {
        int position = findContact(currentContact);
        if (position < 0) {
            System.out.println("Contact can't be modified. There is no such contact in contact list.");
            return false;
        } else {
            modifyContact(position, newContact);
            return true;
        }
    }

    private void modifyContact(int position, Contacts contact) {
        contactsList.set(position, contact);
        System.out.println("Contact " + contact + " has been modified.");
    }

    public boolean removeContact(Contacts contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println("Contact can't be deleted. There is no such contact in contact list");
            return false;
        } else {
            removeContact(position);
            System.out.println(contact.getName() + ", was deleted.");
            return true;
        }
    }

    private void removeContact(int position) {
        //Contacts contact = contactsList.get(position);
        contactsList.remove(position);
    }

    public String queryContact(Contacts contact) {
        if (findContact(contact) >=0) {
            return contact.getName();
        }
         return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >=0) {
            return this.contactsList.get(position);
        }
        return null;
    }

    private int findContact(Contacts contact) {
        return contactsList.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i=0; i<contactsList.size(); i++) {
            Contacts contacts = this.contactsList.get(i);
            if (contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
}
