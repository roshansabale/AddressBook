package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {

    Scanner scanner=new Scanner(System.in);

    public Contact takeInputFromUser(){

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
            System.out.println("Contact added successfully!!");
            return contact;
    }
    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBook addressBook=new AddressBook();
        AddressBookMain addressBookMain=new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("A:Add new contact" + "\n" + "B:Update/Modify contact details" + "\n"+ "C:Delete contact details" +"\n" + "H:Exit" + "\n" + "Enter your choice:");
            choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("A")==true) {
                Contact contact = addressBookMain.takeInputFromUser();
                addressBook.addContact(contact);
            }else if(choice.equalsIgnoreCase("B")==true) {
                System.out.println("Enter E-mail id you want to update");
                String email = scanner.nextLine();
                addressBook.editContactByEmail(email);
            }else if(choice.equalsIgnoreCase("C")==true) {
                addressBook.deleteContact();
            }
        }while(!choice.equalsIgnoreCase("H"));
    }
}
