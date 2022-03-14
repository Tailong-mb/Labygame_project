module com.labygame{
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.jetbrains.annotations;
    requires com.google.gson;

    opens com.labygame.demo to javafx.fxml;
    exports com.labygame.demo;
    exports com.labygame.demo.scenes;
    opens com.labygame.demo.scenes to javafx.fxml;
}