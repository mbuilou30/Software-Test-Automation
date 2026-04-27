import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact sampleContact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        sampleContact = new Contact("C001", "Alice", "Smith", "1234567890", "123 Main St");
    }

    // ── addContact ──────────────────────────────────────────────────────────

    @Test
    void testAddContact_Success() {
        service.addContact(sampleContact);
        assertEquals(sampleContact, service.getContact("C001"));
    }

    @Test
    void testAddContact_DuplicateID_ThrowsException() {
        service.addContact(sampleContact);
        Contact duplicate = new Contact("C001", "Bob", "Jones", "0987654321", "456 Oak Ave");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    void testAddMultipleContacts_UniqueIDs_Success() {
        Contact c2 = new Contact("C002", "Bob", "Jones", "0987654321", "456 Oak Ave");
        service.addContact(sampleContact);
        service.addContact(c2);
        assertEquals(sampleContact, service.getContact("C001"));
        assertEquals(c2,            service.getContact("C002"));
    }

    // ── deleteContact ───────────────────────────────────────────────────────

    @Test
    void testDeleteContact_Success() {
        service.addContact(sampleContact);
        service.deleteContact("C001");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("C001"));
    }

    @Test
    void testDeleteContact_NotFound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NONE"));
    }

    // ── updateFirstName ─────────────────────────────────────────────────────

    @Test
    void testUpdateFirstName_Success() {
        service.addContact(sampleContact);
        service.updateFirstName("C001", "Carol");
        assertEquals("Carol", service.getContact("C001").getFirstName());
    }

    @Test
    void testUpdateFirstName_ContactNotFound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("NONE", "Carol"));
    }

    @Test
    void testUpdateFirstName_InvalidValue_ThrowsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("C001", null));
    }

    // ── updateLastName ──────────────────────────────────────────────────────

    @Test
    void testUpdateLastName_Success() {
        service.addContact(sampleContact);
        service.updateLastName("C001", "Brown");
        assertEquals("Brown", service.getContact("C001").getLastName());
    }

    @Test
    void testUpdateLastName_ContactNotFound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("NONE", "Brown"));
    }

    @Test
    void testUpdateLastName_InvalidValue_ThrowsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("C001", "SmithTooLong"));
    }

    // ── updatePhone ─────────────────────────────────────────────────────────

    @Test
    void testUpdatePhone_Success() {
        service.addContact(sampleContact);
        service.updatePhone("C001", "5555555555");
        assertEquals("5555555555", service.getContact("C001").getPhone());
    }

    @Test
    void testUpdatePhone_ContactNotFound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("NONE", "5555555555"));
    }

    @Test
    void testUpdatePhone_InvalidValue_ThrowsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("C001", "123"));
    }

    // ── updateAddress ───────────────────────────────────────────────────────

    @Test
    void testUpdateAddress_Success() {
        service.addContact(sampleContact);
        service.updateAddress("C001", "789 Elm St");
        assertEquals("789 Elm St", service.getContact("C001").getAddress());
    }

    @Test
    void testUpdateAddress_ContactNotFound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("NONE", "789 Elm St"));
    }

    @Test
    void testUpdateAddress_InvalidValue_ThrowsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("C001", "1234567890123456789012345678901"));
    }
}
