package com.labygame.menu;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class menuInGame{

    GMenu gameMenu;

    public void menuInGame() {

        Pane root = new Pane();
        root.setPrefSize(1200, 600);

        gameMenu = new GMenu();
        gameMenu.setVisible(false);

        root.getChildren().addAll(gameMenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                if(!gameMenu.isVisible()){
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    gameMenu.setVisible(true);
                    ft.play();
                }else{
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5),gameMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });
    }
}
