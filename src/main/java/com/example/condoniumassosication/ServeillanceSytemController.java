package com.example.condoniumassosication;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ServeillanceSytemController
{
    @javafx.fxml.FXML
    private ListView cameraListView;
    @javafx.fxml.FXML
    private TextArea logArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ArchiveFootage(ActionEvent actionEvent) {
        String selected = cameraListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a camera feed to archive.");
            return;
        }

        archivedFootage.add(selected);
        log("Archived footage: " + selected);
    }

    private void log(String message) {
        logArea.appendText(message + "\n");

    }

    @javafx.fxml.FXML
    public void FlagFootage(ActionEvent actionEvent){
        String selected = cameraListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Select a camera feed to flag.");
            return;
        }
    }


    @javafx.fxml.FXML
    public void Zoom(ActionEvent actionEvent) {
            String selected = cameraListView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Please select a camera feed to zoom.");
                return;
            }
            log("Zoomed in on: " + selected);
        }
    }

    @javafx.fxml.FXML
    public void GenerateReport(ActionEvent actionEvent) {
        String[] GenerateReport;
        if (GenerateReport.isEmpty()) {
            showAlert("No flagged footage to generate report.");
            return;

        }

        log("=== Incident Report ===");
        for (String feed : GenerateReport) {
            log("- " + feed);
        }
        GenerateReport.clear();
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}