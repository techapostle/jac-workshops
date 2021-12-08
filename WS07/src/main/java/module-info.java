module ca.senecacollege.ws07 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires validatorfx;

    opens ca.senecacollege.ws07 to javafx.fxml;
    exports ca.senecacollege.ws07;
}