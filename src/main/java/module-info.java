module Menu {

    requires javafx.fxml;
    requires javafx.controls;
    requires lombok;
    opens menu to javafx.fxml;
    exports labyGame.menu;

}

