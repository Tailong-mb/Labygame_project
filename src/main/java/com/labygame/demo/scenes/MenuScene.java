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
        Image backgroundMenu = new Image("file:doc/images/wallpaper/mainMenu.jpg", 1200, 850, false, false);

        Pane root = new Pane();
        root.setPrefSize(1200, 850);

        GameMenu gameMenu = new GameMenu();
        root.getChildren().addAll(new ImageView(backgroundMenu),gameMenu);
        this.setRoot(root);

        /**AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime){
                if(activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    mainLabyGame.setScene(GAME_SCENE);
                }
            }
        };timer.start();**/
    }
}
