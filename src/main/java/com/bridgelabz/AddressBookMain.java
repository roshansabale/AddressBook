package com.bridgelabz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    private static int option = 0;

    Scanner scanner = new Scanner(System.in);

    /*   public Contact takeInputFromUser(){
     *//* System.out.println("Enter the details of person\nEnter 1.Mumbai 2.Nashik");
            option = scanner.nextInt();

            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter address name:");
            String address = scanner.nextLine();
            System.out.println("Enter city name:");
            String city = scanner.nextLine();
            System.out.println("Enter state name:");
            String state = scanner.nextLine();
            System.out.println("Enter zip code:");
            String zipcode = scanner.nextLine();
            System.out.println("Enter phone number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter emailId number:");
            String emailID = scanner.nextLine();
            Contact contact = new Contact(firstName, lastName, address, city, state, zipcode, phoneNumber, emailID);
            System.out.println("Contact added successfully!!");*//*
           // return contact;
    }*/
    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBook[] addressBook = new AddressBook[3];
        addressBook[0] = new AddressBook("Mumbai");
        addressBook[1] = new AddressBook("Nashik");
        AddressBookMain addressBookMain = new AddressBookMain();
        HashMap<String, AddressBook> addressBookMap = new HashMap<>();
        addressBookMap.put("Mumbai", addressBook[0]);
        addressBookMap.put("Chennai", addressBook[1]);


        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1:Add new contact" + "\n" + "2:Update/Modify contact details" + "\n" + "3:Delete contact details" + "\n" + "4:Add Multiple Contact in AddressBook" + "\n" + "5:Exit" + "\n" + "Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter how many contact you want to create");
                    int contactCount = scanner.nextInt();
                    for (int count = 0; count < contactCount; count++) {
                        System.out.println("Enter the details of person\nEnter 1.Mumbai 2.Nashik");
                        option = scanner.nextInt();

                        System.out.println("Enter first name:");
                        String firstName = scanner.next();
                        System.out.println("Enter last name:");
                        String lastName = scanner.next();
                        System.out.println("Enter address name:");
                        String address = scanner.next();
                        System.out.println("Enter city name:");
                        String city = scanner.next();
                        System.out.println("Enter state name:");
                        String state = scanner.next();
                        System.out.println("Enter zip code:");
                        String zipcode = scanner.next();
                        System.out.println("Enter phone number:");
                        String phoneNumber = scanner.next();
                        System.out.println("Enter emailId number:");
                        String emailID = scanner.next();
                        Contact contact = new Contact(firstName, lastName, address, city, state, zipcode, phoneNumber, emailID);

                        if (option == 1) {
                            addressBook[0].addContact(contact);
                        } else {
                            addressBook[1].addContact(contact);
                        }
                        System.out.println("Contact added successfully!!");
                    }
                    break;

                case 2:
                    System.out.println("Enter E-mail id you want to update");
                    String email = scanner.nextLine();
                    if (option == 1) {
                        addressBook[0].editContactByEmail(email);
                    } else {
                        addressBook[1].editContactByEmail(email);
                    }
                    break;

                case 3:
                    if (option == 1) {
                        addressBook[0].deleteContact();
                    } else {
                        addressBook[1].deleteContact();
                    }
                    break;
                default:
                    System.out.println("List of Contacts in Address Book of Mumbai :");
                    System.out.println(addressBook[0].getAddressBook());
                    System.out.println("List of Contacts in Address Book of Nashik :");
                    System.out.println(addressBook[1].getAddressBook());
                    //  System.out.println("AddressBook:"+addressBook.getAddressBook());
            }
        }while(choice != 5);
    }
}
