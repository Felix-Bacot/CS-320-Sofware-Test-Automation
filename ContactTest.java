package Module6;

public class ContactTest {

}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        assertEquals("C001", contact.getContactId());
        assertEquals("Felix", contact.getFirstName());
        assertEquals("Mena", contact.getLastName());
        assertEquals("4125551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Felix", "Mena", "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Felix", "Mena", "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", null, "Mena", "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Christopher", "Mena", "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", null, "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", "Christopher", "4125551234", "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", "Mena", null, "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", "Mena", "12345", "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", "Mena", "4125551234", null);
        });
    }

    @Test
    public void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Felix", "Mena", "4125551234",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        contact.setFirstName("Pedro");
        assertEquals("Pedro", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        contact.setLastName("Lopez");
        assertEquals("Lopez", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        contact.setPhone("7245559999");
        assertEquals("7245559999", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        contact.setAddress("456 Oak Avenue");
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    public void testSetInvalidFirstName() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetInvalidLastName() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("12345678901");
        });
    }

    @Test
    public void testSetInvalidPhone() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("abc");
        });
    }

    @Test
    public void testSetInvalidAddress() {
        Contact contact = new Contact("C001", "Felix", "Mena", "4125551234", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}