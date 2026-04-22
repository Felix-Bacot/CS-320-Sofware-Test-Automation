package Module6;

public class ContactServiceTest {

}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);

        assertEquals("Felix", service.getContact("C001").getFirstName());
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        Contact contact2 = new Contact("C001", "Maria", "Lopez", "7245551234", "456 Oak Street");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testAddNullContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);
        service.deleteContact("C001");

        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("C001");
        });
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("BADID");
        });
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);

        service.updateFirstName("C001", "Pedro");
        assertEquals("Pedro", service.getContact("C001").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);

        service.updateLastName("C001", "Lopez");
        assertEquals("Lopez", service.getContact("C001").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);

        service.updatePhone("C001", "7245559999");
        assertEquals("7245559999", service.getContact("C001").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        service.addContact(contact);

        service.updateAddress("C001", "456 Oak Avenue");
        assertEquals("456 Oak Avenue", service.getContact("C001").getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("BADID", "Pedro");
        });
    }
}