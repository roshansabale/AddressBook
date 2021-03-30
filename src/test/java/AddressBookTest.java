import com.bridgelabz.AddressBook;
import com.bridgelabz.AddressBookMain;
import com.bridgelabz.Contact;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddressBookTest {
    AddressBook addressBook=new AddressBook();
    @Test
    public void test_Contact_Object_Return_Correct_Data() {
        Contact contact = new Contact("Roshan","Sabale","Panchvati","Nashik","Maharshtra","422003","8527419630","rs@gmail.com");
        //AddressBookMain addressBookMain = new AddressBookMain();
        boolean contact_status = addressBook.addContact(contact);
        Assert.assertTrue(contact_status);
    }
    @Test
    public void given_ContactName_IsPresentOrNot(){
        Contact contact = new Contact("Roshan","Sabale","Panchvati","Nashik","Maharshtra","422003","8527419630","rs@gmail.com");
        addressBook.addContact(contact);
        boolean status = addressBook.editContactByEmail("rs@gmail.com");
        Assert.assertEquals(true,status);
    }
}
