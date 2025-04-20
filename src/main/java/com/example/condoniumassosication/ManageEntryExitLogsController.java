package com.example.condoniumassosication;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class ManageEntryExitLogsController
{

    @javafx.fxml.FXML
    private ListView visitorListView;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField purposeField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private ArrayList<String> visitorLog = new ArrayList<>();


    @javafx.fxml.FXML
    public void markVisitorExit(ActionEvent actionEvent) {
        int selectedIndex = visitorListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            showAlert("Please select a visitor to mark exit.");
            return;
        }

        String original = visitorLog.get(selectedIndex);
        if (original.contains("(OUT)")) {
            showAlert("This visitor has already exited.");
            return;
        }

        String updated = original.replace("(IN)", "(OUT)");
        visitorLog.set(selectedIndex, updated);
        visitorListView.getItems().set(selectedIndex, updated);
    }

    @javafx.fxml.FXML
    public void logVisitorEntry(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String purpose = purposeField.getText().trim();

        if (name.isEmpty() || purpose.isEmpty()) {
            showAlert("Please enter both name and purpose.");
            return;
        }

        String entry = name + " - " + purpose + " (IN)";
        visitorLog.add(entry);
        visitorListView.getItems().add(entry);

        nameField.clear();
        purposeField.clear();
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}