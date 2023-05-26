module com.example.appventadecochesvisual {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appventadecochesvisual to javafx.fxml;
    exports com.example.appventadecochesvisual;
    exports controller;
    opens controller to javafx.fxml;
}