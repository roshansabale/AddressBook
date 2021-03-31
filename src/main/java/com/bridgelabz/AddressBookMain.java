package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    public static Map<String, AddressBook> addressBookHashMap = new HashMap<>();
    public static Map<String, Map<String, AddressBook>> stateBookHashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addDataToAddressBook() {

        String chooseContact, chooseCity;

            do {
                System.out.println("Enter the name of city");
                String cityForMap = scanner.nextLine();
                AddressBook addressBook = new AddressBook(cityForMap);
                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                    if (entry.getKey().equals(cityForMap)) {
                        addressBook = entry.getValue();
                    }
                }
                addressBookHashMap.put(cityForMap, addressBook);
                do {
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter address name:");
                    String address = scanner.nextLine();
                    System.out.println("Enter city name:");
                    String city = cityForMap;
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
                    for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(cityForMap)) {
                            entry.getValue().addContact(contact);
                        }
                    }
                    System.out.println("Do you want to add contact again? Yes|No");
                    chooseContact = scanner.nextLine();
                } while (chooseContact.equals("yes"));
                System.out.println("Do you want to add another city Yes|No");
                chooseCity = scanner.nextLine();
            } while (chooseCity.equals("yes"));

            System.out.println(addressBookHashMap);
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBookMain addressBookMain=new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1:Add new contact" + "\n" + "2:Update/Modify contact details" + "\n" + "3:Delete contact details" + "\n" + "4:Add Multiple Contact in AddressBook and Create Multiple AddressBook" + "\n" + "5:Exit" + "\n" + "Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new AddressBookMain().addDataToAddressBook();//Add Contact Details
                    break;
                case 2:
                    System.out.println("Enter E-mail id you want to update");
                    String email = scanner.next();
                    System.out.println("Enter the addressbook name (city)");
                    String city = scanner.next();
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        if(entry.getKey().equalsIgnoreCase(city)) {
                            entry.getValue().editContactByEmail(email);
                        }else {
                            System.out.println("The"+ city +" addressbook does not present.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter E-mail id you want to update");
                    email = scanner.next();
                    System.out.println("Enter the addressbook name (city)");
                    city = scanner.next();
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        if(entry.getKey().equalsIgnoreCase(city)) {
                            entry.getValue().deleteContact(email);
                        }else {
                            System.out.println("The"+ city +" addressbook does not present.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter how many contact you want add");
                    int count = scanner.nextInt();
                    for (int count1=0;count1<count;count++) {
                        new AddressBookMain().addDataToAddressBook();
                    }
                default:
                    System.out.println(Arrays.asList(addressBookHashMap)); // method 1
                    System.out.println(Collections.singletonList(addressBookHashMap)); // method 2
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        System.out.println(entry.getKey()+"\t"+entry.getValue().getAddressBook()); }

            }
        }while(choice != 5);
    }
}
