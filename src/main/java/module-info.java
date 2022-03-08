module Menu {

    requires javafx.fxml;
    requires javafx.controls;
    requires lombok;
    requires javafx.graphics;

    exports labyGame.menu;
    opens labyGame.menu to javafx.fxml;

}

