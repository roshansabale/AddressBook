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

    public static void searchContactByCityOrState(String city, String name) {
        List<Contact> contactList=new ArrayList<>();

        for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
            contactList=entry.getValue().getAddressBook().stream().filter(p -> p.getCity().equalsIgnoreCase(city)).filter(p -> (p.getFirstName() + p.getLastName()).equals(name)).collect(Collectors.toList());
        }
        for (Contact contact: contactList) {
            System.out.println("Search result:"+contact);
            System.out.println(contactList);
        }
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBookMain addressBookMain=new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1:Add new contact" + "\n" + "2:Update/Modify contact details" + "\n" + "3:Delete contact details" + "\n" + "4:Serach Contact by City or State" +"\n"+ "5:Exit" + "\n" + "Enter your choice:");
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
                    System.out.println("Enter E-mail id you want to delete");
                    String email1 = scanner.next();
                    System.out.println("Enter the addressbook name (city)");
                    String city1 = scanner.next();
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        if(entry.getKey().equals(city1)) {
                            entry.getValue().deleteContact(email1);

                        }else {
                            System.out.println("The"+ city1 +" addressbook does not present.");
                        }
                    }
                    break;
                case 4:
                    String name1;
                    System.out.println("Enter City , First+Last Name you want to search:");
                    String city2 = scanner.next();
                    name1= scanner.next();
                    searchContactByCityOrState(city2,name1);
                default:
                    System.out.println(Arrays.asList(addressBookHashMap)); // method 1
                    System.out.println(Collections.singletonList(addressBookHashMap)); // method 2
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        System.out.println(entry.getKey()+"\t"+entry.getValue().getAddressBook()); }

            }
        }while(choice != 5);
    }
}
