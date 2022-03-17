package com.labygame.menu;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class menuInGame {

    GMenu gameMenu;

    public menuInGame() {

        this.gameMenu = new GMenu();
        this.gameMenu.setVisible(false);

    }

    /**
     * The scene with the menu in game appears only when "escape" key was pressed and disappears when "escape" key was pressed twice
     */
    public void accessMenu() {

        Pane root = new Pane();
        root.setPrefSize(1200, 600);
        root.getChildren().addAll(this.gameMenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                if (!this.gameMenu.isVisible()) {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this.gameMenu);
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    this.gameMenu.setVisible(true);
                    ft.play();
                } else {
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this.gameMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> this.gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });
    }
}