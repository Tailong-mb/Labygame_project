module com.labygame{
    requires static lombok;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires javafx.media;
    requires javafx.graphics;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.labygame.front to javafx.fxml;
    opens com.labygame.front.scenes to javafx.fxml;
    exports com.labygame.front;
    exports com.labygame.front.scenes;
    exports com.labygame.personnage;
    exports com.labygame.items;

}