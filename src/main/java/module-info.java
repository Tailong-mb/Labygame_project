module com.labygame{
    requires static lombok;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires com.google.gson;

    opens com.labygame.demo to javafx.fxml;
    opens com.labygame.demo.scenes to javafx.fxml;
    exports com.labygame.demo;
    exports com.labygame.demo.scenes;
    exports com.labygame.personnage;
    exports com.labygame.items;

}