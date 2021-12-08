module task2.ws8 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens task2 to javafx.fxml;
    exports task2;
}