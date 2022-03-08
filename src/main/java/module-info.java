module Menu {

    requires javafx.fxml;
    requires javafx.controls;
    requires lombok;

    exports labyGame.menu;
    opens labyGame.menu to javafx.fxml;

}

