package contact;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactController {
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    private Contact contactSelected;

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact newContact = new Contact();
        newContact.setFirstName(firstNameTextField.getText().trim());
        newContact.setLastName(lastNameTextField.getText().trim());
        newContact.setEmail(emailTextField.getText().trim());
        newContact.setPhoneNumber(phoneNumberTextField.getText().trim());
        contacts.add(newContact);
    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactSelected);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        contactSelected.setFirstName(firstNameTextField.getText().trim());
        contactSelected.setLastName(lastNameTextField.getText().trim());
        contactSelected.setEmail(emailTextField.getText().trim());
        contactSelected.setPhoneNumber(phoneNumberTextField.getText().trim());
    }

    public void initialize() {
        contacts.add(new Contact("attique", "Ahmed", "attique@ahmed.com", "(92) 12345123"));

        contactsListView.setItems(contacts);

        contactsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {

            @Override
            public void changed(ObservableValue<? extends Contact> arg0, Contact oldValue, Contact newValue) {
                contactSelected = newValue;
                firstNameTextField.setText(newValue.getFirstName());
                lastNameTextField.setText(newValue.getLastName());
                emailTextField.setText(newValue.getEmail());
                phoneNumberTextField.setText(newValue.getPhoneNumber());
            }
        });
    }

}