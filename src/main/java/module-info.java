module org.calma.ui.paysage {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.calma.ui.paysage to javafx.fxml;
    exports org.calma.ui.paysage;
}