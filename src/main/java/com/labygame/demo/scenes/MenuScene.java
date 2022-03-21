package com.labygame.demo.scenes;

import com.labygame.menu.GameMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class
MenuScene extends GeneralScene{

    public MenuScene(){
        super();
    }

    @Override
    public void draw() {

        //Reset Key
        activeKeys.clear();

        //Set backGround image Menu
        Image backgroundMenu = new Image("file:doc/images/wallpaper/mainMenu.jpg", 1200, 600, false, false);

        Pane root = new Pane();
        root.setPrefSize(1200, 600);

        GameMenu gameMenu = new GameMenu();
        root.getChildren().addAll(new ImageView(backgroundMenu),gameMenu);
        this.setRoot(root);
    }
}
