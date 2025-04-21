package com.example.condoniumassosication;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;


public class ServeillanceSytemController {
    @javafx.fxml.FXML
    private ListView<String> cameraListView;
    @javafx.fxml.FXML
    private TextArea logArea;

    private ArrayList<String> flaggedFootage = new ArrayList<>();
    private ArrayList<String> archive = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        cameraListView.getItems().addAll(
                "Camera 1 - Front Gate",
                "Camera 2 - Parking Lot",
                "Camera 3 - Lobby",
                "Camera 4 - Back Entrance"
        );
    }

    @javafx.fxml.FXML
    public void ArchiveFootage(ActionEvent actionEvent) {
        String selected = cameraListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a camera feed to archive footage.");
            return;
        }

        String entry = selected + " - Archived";
        archive.add(entry);
        log("Archived: " + entry);
    }

    @javafx.fxml.FXML
    public void FlagFootage(ActionEvent actionEvent) {
        String selected = cameraListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a camera feed to flag suspicious activity.");
            return;
        }

        flaggedFootage.add(selected);
        log("Flagged suspicious footage on: " + selected);
    }


    @javafx.fxml.FXML
    public void Zoom(ActionEvent actionEvent) {
        String selected = cameraListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a camera feed to zoom.");
            return;
        }

        log("Zoomed on: " + selected);
    }

    @javafx.fxml.FXML
    public void GenerateReport(ActionEvent actionEvent) {
        if (flaggedFootage.isEmpty()) {
            showAlert("No flagged footage available to generate a report.");
            return;
        }

        StringBuilder report = new StringBuilder("Incident Report:\n");
        for (String feed : flaggedFootage) {
            report.append("- ").append(feed).append("\n");
        }

        log(report.toString());
        flaggedFootage.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }
    private void log(String message) {
        logArea.appendText(message + "\n");
    }
}
