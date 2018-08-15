package com.chrisranella.contacts;

import com.chrisranella.contacts.datamodel.Contact;
import com.chrisranella.contacts.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private TableView<Contact> contactTableView;
    @FXML
    private TableColumn firstNameCol;
    @FXML
    private TableColumn lastNameCol;
    @FXML
    private TableColumn phoneNumberCol;
    @FXML
    private TableColumn notesCol;


    public void initialize() {

        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("firstName")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("lastName")
        );
        phoneNumberCol.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("phoneNumber")
        );
        notesCol.setCellValueFactory(
                new PropertyValueFactory<Contact,String>("notes")
        );

        contactTableView.setItems(ContactData.getInstance().getContacts());
    }

    public void showNewContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setHeaderText("Use this dialog to create a new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            contactDialogController controller = fxmlLoader.getController();
            Contact newContact = controller.addNewResults();
            contactTableView.getSelectionModel().select(newContact);
        }
    }

    public void showEditContactDialog() {
        Contact selectedContact = contactTableView.getSelectionModel().getSelectedItem();
        if(selectedContact == null) {
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setHeaderText("Use this dialog to edit existing contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        contactDialogController controller = fxmlLoader.getController();
        controller.populateFields(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            int index = ContactData.getInstance().getContacts().indexOf(selectedContact);
            Contact editedContact = controller.addEditedResults(index);
            contactTableView.getSelectionModel().select(editedContact);
        }
    }

    public void handleKeyPressed(KeyEvent keyEvent) {
        Contact selectedContact = contactTableView.getSelectionModel().getSelectedItem();
        if(selectedContact != null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteContact(selectedContact);
            }
        }
    }

    public void handleMenuDelete() {
        Contact selectedContact = contactTableView.getSelectionModel().getSelectedItem();
        if(selectedContact != null) {
            deleteContact(selectedContact);
        }
    }

    public void deleteContact(Contact contact) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact");
        alert.setHeaderText("Delete contact: " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm or cancel to back out");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(contact);
        }
    }
}
