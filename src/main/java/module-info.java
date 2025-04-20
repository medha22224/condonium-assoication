module com.example.condoniumassosication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.condoniumassosication to javafx.fxml;
    exports com.example.condoniumassosication;
}