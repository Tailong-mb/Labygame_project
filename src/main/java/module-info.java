module com.labygame{
    requires static lombok;
    requires javafx.controls;
    requires org.jetbrains.annotations;
    requires javafx.media;
    requires javafx.graphics;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    exports com.labygame.front;
    exports com.labygame.front.scenes;
    exports com.labygame.personnage;
    exports com.labygame.items;
    exports com.labygame.riddles;

}