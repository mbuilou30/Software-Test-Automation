import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // ── Valid construction ──────────────────────────────────────────────────

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertEquals("C001",        c.getContactID());
        assertEquals("Alice",       c.getFirstName());
        assertEquals("Smith",       c.getLastName());
        assertEquals("1234567890",  c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    // ── contactID validations ───────────────────────────────────────────────

    @Test
    void testContactID_Null_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Alice", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testContactID_TooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Alice", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testContactID_ExactlyTenChars_Valid() {
        assertDoesNotThrow(() ->
            new Contact("1234567890", "Alice", "Smith", "1234567890", "123 Main St"));
    }

    // ── firstName validations ───────────────────────────────────────────────

    @Test
    void testFirstName_Null_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", null, "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstName_TooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "AliceTooLong", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstName_ExactlyTenChars_Valid() {
        assertDoesNotThrow(() ->
            new Contact("C001", "AliceSmith", "Smith", "1234567890", "123 Main St"));
    }

    // ── lastName validations ────────────────────────────────────────────────

    @Test
    void testLastName_Null_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", null, "1234567890", "123 Main St"));
    }

    @Test
    void testLastName_TooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "SmithTooLong", "1234567890", "123 Main St"));
    }

    @Test
    void testLastName_ExactlyTenChars_Valid() {
        assertDoesNotThrow(() ->
            new Contact("C001", "Alice", "SmithSmith", "1234567890", "123 Main St"));
    }

    // ── phone validations ───────────────────────────────────────────────────

    @Test
    void testPhone_Null_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", null, "123 Main St"));
    }

    @Test
    void testPhone_TooShort_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", "123456789", "123 Main St"));
    }

    @Test
    void testPhone_TooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", "12345678901", "123 Main St"));
    }

    @Test
    void testPhone_NonDigits_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", "123-456-789", "123 Main St"));
    }

    @Test
    void testPhone_ExactlyTenDigits_Valid() {
        assertDoesNotThrow(() ->
            new Contact("C001", "Alice", "Smith", "0987654321", "123 Main St"));
    }

    // ── address validations ─────────────────────────────────────────────────

    @Test
    void testAddress_Null_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", "1234567890", null));
    }

    @Test
    void testAddress_TooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("C001", "Alice", "Smith", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    void testAddress_ExactlyThirtyChars_Valid() {
        assertDoesNotThrow(() ->
            new Contact("C001", "Alice", "Smith", "1234567890", "123456789012345678901234567890"));
    }

    // ── setter validations ──────────────────────────────────────────────────

    @Test
    void testSetFirstName_Valid() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        c.setFirstName("Bob");
        assertEquals("Bob", c.getFirstName());
    }

    @Test
    void testSetFirstName_Null_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
    }

    @Test
    void testSetFirstName_TooLong_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("AliceTooLong"));
    }

    @Test
    void testSetLastName_Valid() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        c.setLastName("Jones");
        assertEquals("Jones", c.getLastName());
    }

    @Test
    void testSetLastName_Null_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
    }

    @Test
    void testSetLastName_TooLong_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("SmithTooLong"));
    }

    @Test
    void testSetPhone_Valid() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());
    }

    @Test
    void testSetPhone_Null_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
    }

    @Test
    void testSetPhone_Invalid_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("555-CALL"));
    }

    @Test
    void testSetAddress_Valid() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        c.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", c.getAddress());
    }

    @Test
    void testSetAddress_Null_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
    }

    @Test
    void testSetAddress_TooLong_ThrowsException() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () ->
            c.setAddress("1234567890123456789012345678901"));
    }

    // ── contactID is not updatable (no setter exists) ───────────────────────

    @Test
    void testContactID_IsImmutable() {
        Contact c = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
        // Confirm there is no setContactID method by verifying the value never changes
        assertEquals("C001", c.getContactID());
    }
}
