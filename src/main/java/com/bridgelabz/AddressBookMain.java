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
            contactList=entry.getValue().getAddressBook().stream().filter(p -> p.getCity().equalsIgnoreCase(city))
                    .filter(p -> (p.getFirstName() + p.getLastName()).equals(name)).collect(Collectors.toList());
        }
        for (Contact contact: contactList) {
            System.out.println("Search result:"+contact);
            System.out.println(contactList);
        }
    }

    public static void viewContactByCity(String city) {
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
                    System.out.println("The List for city "+ Entry.getKey()+" is :"+Entry.getValue().getAddressBook());
                }
            }
            for(Contact contact : list) {
                System.out.println(contact);
            }
        }
    }

    public static void  getCountByCity(String city4) {
        long count1 = 0;
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            long count = entries.getValue().getAddressBook().stream().filter(p -> p.getCity().equals(city4)).count();
            count1 += count;
        }
        System.out.println(count1 + " Contacts in " + city4);
    }

    public static void getCountByState(String state4) {
        long count1 = 0;
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            long count = entries.getValue().getAddressBook().stream().filter(p -> p.getState().equals(state4)).count();
            count1 += count;
        }
        System.out.println(count1 + " Contacts in " + state4);

    }

    public static void sortByName() {
        List<Contact> list = new ArrayList<>();
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1, p2) -> ((String)p1.getFirstName()).compareTo(p2.getFirstName()))
                .forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
    }

    public static void sortByZip() {
        List<Contact> list = new ArrayList<>();
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1, p2) -> ((String)p1.getZip()).compareTo(p2.getZip()))
                .forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
    }

    public static void sortByState() {
        List<Contact> list = new ArrayList<>();
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1, p2) -> ((String)p1.getState()).compareTo(p2.getState()))
                .forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
    }

    public static void sortByCity() {
        List<Contact> list = new ArrayList<>();
        for(Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list = entries.getValue().getAddressBook().stream().collect(Collectors.toList());
        }
        list.stream().sorted((p1, p2) -> ((String)p1.getCity()).compareTo(p2.getCity()))
                .forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome To AddressBook System ***");
        AddressBookMain addressBookMain=new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1:Add new contact" + "\n" + "2:Update/Modify contact details" + "\n" + "3:Delete contact details" + "\n" + "4:Serach Contact by City or State" +"\n"+ "5:View Contact by City"+"\n"+"6:View Contact by State"+"\n"+ "7:Get contact count for city" +"\n"+ "8:Get contact count for state" +"\n"+"9:Sort contact by name"+"\n"+"10:Sort Contact By City|Zip|State" +"\n"+"11:Exit"+"\n"+"Enter your choice:");
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
                    viewContactByCity(city3);
                    break;
                case 6:
                    System.out.println("Enter the state you want view");
                    String state=scanner.next();
                    viewPersonByState(state);
                    break;
                case 7:
                    System.out.println("Enter the city for you want to count contact");
                    String city4 = scanner.next();
                    getCountByCity(city4);
                    break;
                case 8:
                    System.out.println("Enter the state for you want to count contact");
                    String state4 = scanner.next();
                    getCountByState(state4);
                    break;
                case 9:
                    System.out.println("Sort by name");
                    sortByName();
                    break;
                case 10:
                    System.out.println("Sort By Zip:");
                    sortByZip();
                    System.out.println("Sort By City:");
                    sortByCity();
                    System.out.println("Sort By State:");
                    sortByState();
                    break;
                default:
                    System.out.println(Arrays.asList(addressBookHashMap)); // method 1
                    System.out.println(Collections.singletonList(addressBookHashMap)); // method 2
                    for (Map.Entry<String,AddressBook> entry : addressBookHashMap.entrySet()) {
                        System.out.println(entry.getKey()+"\t"+entry.getValue().getAddressBook()); }

            }
        }while(choice != 11);
    }
}
