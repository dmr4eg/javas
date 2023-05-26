module com.example.chatik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.chatik to javafx.fxml;
    exports com.example.chatik;
}