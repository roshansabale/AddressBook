package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    public static Map<String, AddressBook> addressBookHashMap = new HashMap<>();
    public static Map<String, Map<String, AddressBook>> stateBookHashMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addDataToAddressBook() {

        String chooseContact, chooseCity,chooseState;
        do {
            System.out.println("Enter the name of state");
            String stateName = scanner.next();
            do {
                System.out.println("Enter the name of city");
                String cityName = scanner.next();
                AddressBook addressBook = new AddressBook(cityName);
                for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                    if (entry.getKey().equals(cityName)) {
                        addressBook = entry.getValue();
                    }
                }
                addressBookHashMap.put(cityName, addressBook);
                do {
                    System.out.println("Enter first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter last name:");
                    String lastName = scanner.next();
                    System.out.println("Enter address name:");
                    String address = scanner.next();
                   // System.out.println("Enter city name:");
                    String city = cityName;
                    //System.out.println("Enter state name:");
                    String state = stateName;
                    System.out.println("Enter zip code:");
                    String zipcode = scanner.next();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter emailId number:");
                    String emailID = scanner.next();
                    Contact contact = new Contact(firstName, lastName, address, city, state, zipcode, phoneNumber, emailID);
                    for (Map.Entry<String, AddressBook> entry : addressBookHashMap.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(cityName)) {
                            entry.getValue().addContact(contact);
                        }
                    }
                    System.out.println("Do you want to add contact again? Yes|No");
                    chooseContact = scanner.next();
                } while (chooseContact.equals("yes"));
                System.out.println("Do you want to add another city Yes|No");
                chooseCity = scanner.next();
            } while (chooseCity.equals("yes"));
            stateBookHashMap.put(stateName, addressBookHashMap);
            System.out.println("Do you want to add for another state Yes|No");
            chooseState = scanner.next();
        }while (chooseState.equals("yes"));
        System.out.println(addressBookHashMap+"\t"+stateBookHashMap);
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

    public static void viewContactByCityOrState(String city) {
        List<Contact> list = new ArrayList<>();
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        }
        for(Contact contact : list) {
            System.out.println(contact);
        }
    }

    public static void viewPersonByState(String state) {
        List<Contact> list = new ArrayList<Contact>();
        for(Map.Entry<String,Map<String, AddressBook>> entries : stateBookHashMap.entrySet()) {
            if(entries.getKey().equalsIgnoreCase(state)) {
                for(Map.Entry<String,AddressBook> Entry : addressBookHashMap.entrySet()) {
                    System.out.println("The List for city "+ Entry.getKey()+" is :"+Entry.getValue());
                }
            }
            for(Contact contact : list) {
                System.out.println(contact);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBookMain addressBookMain=new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1:Add new contact" + "\n" + "2:Update/Modify contact details" + "\n" + "3:Delete contact details" + "\n" + "4:Serach Contact by City or State" +"\n"+ "5:View Contact by City or State"+"\n"+ "6:Exit" + "\n" + "Enter your choice:");
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
                    break;
                case 5:
                    System.out.println("Enter the city you want to view");
                    String city3 = scanner.next();
                    viewContactByCityOrState(city3);
                    break;
                case 6:
                    System.out.println("Enter the state you want view");
                    String state=scanner.next();
                    viewPersonByState(state);
                    break;
                default:
                    System.out.println(Arrays.asList(addressBookHashMap)); // method 1
                    System.out.println(Collections.singletonList(addressBookHashMap)); // method 2
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        System.out.println(entry.getKey()+"\t"+entry.getValue().getAddressBook()); }

            }
        }while(choice != 7);
    }
}
