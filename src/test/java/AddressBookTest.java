import com.bridgelabz.AddressBook;
import com.bridgelabz.Contact;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    public void test_Contact_Object_Return_Correct_Data() {
        Contact contact = new Contact("Roshan","Sabale","Panchvati","Nashik","Maharshtra","422003","8527419630","rs@gmail.com");
        //AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook addressBook=new AddressBook();
        boolean contact_status = addressBook.addContact(contact);
        Assert.assertTrue(contact_status);
    }
   /* @Test
    public void given_ContactName_IsPresentOrNot(){
        Contact contact1 = new Contact("Roshan","Sabale","Panchvati","Nashik","Maharshtra","422003","8527419630","rs@gmail.com");
        AddressBook addressBook=new AddressBook();
        addressBook.addContact(contact1);
        //boolean status1 = addressBook.editContactByEmail("rs@gmail.com");
       // boolean status1 = addressBook.deleteContactByEmail("rs@gmail.com");
        Assert.assertEquals(true,status1);
    }*/
}
