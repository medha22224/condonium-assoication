module com.example.condoniumassosication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.condoniumassosication to javafx.fxml;
    exports com.example.condoniumassosication;
}