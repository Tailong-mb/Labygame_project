module com.labygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.jetbrains.annotations;
    requires com.google.gson;

    opens com.labygame to javafx.fxml;
    exports com.labygame;
}