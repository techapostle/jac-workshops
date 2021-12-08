module ca.jac444.ws6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ca.jac444.ws6 to javafx.fxml;
    exports ca.jac444.ws6;
}