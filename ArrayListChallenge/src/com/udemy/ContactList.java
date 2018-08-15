package com.udemy;

import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        if(findContact(contact.getName()) < 0) {
            contactList.add(contact);
        } else {
            System.out.println("Contact named " + contact.getName() + " already exists.  Cannot add duplicates.");
        }
    }

    public void modifyContact(String name, String newNumber) {
        int position = findContact(name);
        if (position >= 0) {
            contactList.set(position,new Contact(name,newNumber));
            System.out.println("Contact info for " + name + " updated.");
        } else {
            System.out.println("Could not find " + name + " in contact list.");
        }
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            contactList.remove(position);
            System.out.println(name + " removed from contacts.");
        } else {
            System.out.println("Could not find " + name + " in contact list.");
        }
    }

    public void printContactList() {
        for(int i=0; i<contactList.size(); i++) {
            System.out.println(contactList.get(i).getName() + ": " + contactList.get(i).getNumber());
        }
    }

    private int findContact(String name) {
        for(int i=0; i<contactList.size(); i++) {
            if(contactList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact getContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return contactList.get(position);
        }
        return null;
    }


}
