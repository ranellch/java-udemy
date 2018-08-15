package com.chrisranella.contacts;

import com.chrisranella.contacts.datamodel.Contact;
import com.chrisranella.contacts.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class contactDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesArea;

    public Contact addNewResults() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesArea.getText().trim();

        Contact newContact = new Contact(firstName,lastName,phoneNumber,notes);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }

    public Contact addEditedResults(int i) {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesArea.getText().trim();

        Contact editedContact = new Contact(firstName,lastName,phoneNumber,notes);
        ContactData.getInstance().getContacts().set(i,editedContact);
        return editedContact;
    }

    public void populateFields(Contact selectedContact) {
        firstNameField.setText(selectedContact.getFirstName());
        lastNameField.setText(selectedContact.getLastName());
        phoneNumberField.setText(selectedContact.getPhoneNumber());
        notesArea.setText(selectedContact.getNotes());
    }
}
