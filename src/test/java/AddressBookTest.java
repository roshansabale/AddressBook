import com.bridgelabz.AddressBook;
import com.bridgelabz.AddressBookMain;
import com.bridgelabz.Contact;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AddressBookTest {
    @Test
    public void Test_contact_object_return_correct_data() {
        Contact contact = new Contact("Roshan","Sabale","Panchvati","Nashik","Maharshtra","422003","8527419630","rs@gmail.com");
        //AddressBookMain addressBookMain = new AddressBookMain();
        AddressBook addressBook=new AddressBook();
        boolean contact_status = addressBook.addContact(contact);
        Assert.assertTrue(contact_status);
    }
}
