package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    //UC:1 Ability to create contact
    Contact contact;
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Contact> addressBook = new ArrayList<Contact>();

    public ArrayList<Contact> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(ArrayList<Contact> addressBook) {
        this.addressBook = addressBook;
    }

    public boolean addContact(Contact contact) {
        if (contact != null) {
            addressBook.add(contact);
            System.out.println(contact);
        }
        return true;
    }

    public boolean editContactByEmail(String email) {
        String checkEmail;
        String choice;
        Boolean status = false;
        for (Contact contact : addressBook) {
            checkEmail = contact.getEmail();
            if (email.equalsIgnoreCase(checkEmail)) {
                do {

                    System.out.println("A:Update First name" + "\n" + "B:Update Last name" + "\n" + "C:Update Address " + "\n" + "D:Update City " + "\n" + "E:Update State" + "\n" + "F:Update Zipcode " + "\n" + "G:Update Phone_number" + "\n" + "h:Exit" + "\n" + "Enter your ch:");
                    choice = scanner.nextLine();
                    boolean value;
                    if (choice.equalsIgnoreCase("A") == true) {
                        System.out.println("Enter updated first name:");
                        String newFirstName = scanner.nextLine();
                        contact.setFirstName(newFirstName);
                        System.out.println(contact);

                    } else if (choice.equalsIgnoreCase("B") == true) {
                        System.out.println("Enter updated last name:");
                        String newLastName = scanner.nextLine();
                        contact.setLastName(newLastName);

                    } else if (choice.equalsIgnoreCase("C") == true) {
                        System.out.println("Enter address you want to update:");
                        String newAddress = scanner.nextLine();
                        contact.setAddress(newAddress);
                    } else if (choice.equalsIgnoreCase("D") == true) {
                        System.out.println("Enter city you want to update:");
                        String newCity = scanner.nextLine();
                        contact.setCity(newCity);

                    } else if (choice.equalsIgnoreCase("E") == true) {
                        System.out.println("Enter state you want to update:");
                        String newState = scanner.nextLine();
                        contact.setState(newState);

                    } else if (choice.equalsIgnoreCase("F") == true) {
                        System.out.println("Enter zipcode you want to update:");
                        String newZipcode = scanner.nextLine();
                        contact.setZip(newZipcode);
                    } else if (choice.equalsIgnoreCase("G") == true) {
                        System.out.println("Enter phone number you want to update:");
                        String newPhone = scanner.nextLine();
                        contact.setPhoneNumber(newPhone);
                    } else if (choice.equalsIgnoreCase("H") == true) {
                        System.out.println("Enter mail id you want to update:");
                        String newEmail = scanner.nextLine();
                        contact.setEmail(newEmail);
                    }
                } while (!choice.equalsIgnoreCase("I"));
                System.out.println(contact);
                status = true;
            } else {
                System.out.println("No any user belongs to this " + email + " mail id Try Again !!");
                status = false;
            }
        }
        return status;
    }

    public boolean deleteContact() {
        String checkEmail;
        boolean status = false;
        System.out.println("Enter E-mail id you want to delete");
        String emailDelete = scanner.nextLine();
        for (Contact contact1 : addressBook) {
            checkEmail = contact1.getEmail();
            System.out.println(checkEmail);
            if (emailDelete.equalsIgnoreCase(checkEmail)) {
                addressBook.remove(contact1);
                status = true;
            } else {
                System.out.println("No any user belongs to this " + emailDelete + " mail id Try Again !!");
                status = false;
            }
        }
        return true;
    }
}