module menu {

    requires javafx.fxml;
    requires javafx.controls;
    requires lombok;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;

    opens labyGame.menu to javafx.fxml;
    exports labyGame.menu;

}


