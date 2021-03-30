package com.bridgelabz;

import java.util.ArrayList;

public class AddressBook {
    //UC:1 Ability to create contact
    Contact contact;
    public ArrayList<Contact> addressBook=new ArrayList<Contact>();

    public ArrayList<Contact> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(ArrayList<Contact> addressBook) {
        this.addressBook = addressBook;
    }

    public boolean addContact(Contact contact){
        if(contact!=null) {
            addressBook.add(contact);
            System.out.println(contact);
        }return true;
    }
}
