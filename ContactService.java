import java.util.HashMap;

public class ContactService {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) {
        getContact(contactID).setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        getContact(contactID).setLastName(lastName);
    }

    public void updatePhone(String contactID, String phone) {
        getContact(contactID).setPhone(phone);
    }

    public void updateAddress(String contactID, String address) {
        getContact(contactID).setAddress(address);
    }

    public Contact getContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contacts.get(contactID);
    }
}
