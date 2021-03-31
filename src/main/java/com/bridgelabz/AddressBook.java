package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    //UC:1 Ability to create contact

    Scanner scanner = new Scanner(System.in);
    public String name;

    public ArrayList<Contact> addressBook = new ArrayList<>();

    public AddressBook(String name) {
        this.name=name;
    }
    public ArrayList<Contact> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(ArrayList<Contact> addressBook) {
        this.addressBook = addressBook;
    }

    public boolean checkDuplicateEntry(Contact contact) {
        boolean status=false;
        for(int count = 0; count < addressBook.size(); count++) {
            if(addressBook.get(count).equals(contact)) {
                status=true;
            }else {
                status=false;
            }
        }
        return status;
    }
    public boolean addContact(Contact contact) {
        boolean duplicateStatus= checkDuplicateEntry(contact);
            if (duplicateStatus==false) {
                addressBook.add(contact);
            }else {
                System.out.println("The person already exists!!!");
            }
            System.out.println("AddressBook Data:"+addressBook);
            for(Contact contact1 : addressBook) {
                System.out.println(contact1);
            }
            System.out.println("Contact added successfully!!");
        return  true;
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

    public void deleteContact(String email) {
        String checkEmail;

        for (Contact contact : addressBook) {
            checkEmail = contact.getEmail();
            System.out.println(checkEmail);
            if (email.equalsIgnoreCase(checkEmail)) {
                System.out.println("Address Book Before"+addressBook);
                addressBook.remove(contact);
                System.out.println("Contact Deleted!!");
                System.out.println("Address Book after"+addressBook);
            } else {
                System.out.println("No any user belongs to this " + email + " mail id Try Again !!");
            }
        }
    }
}