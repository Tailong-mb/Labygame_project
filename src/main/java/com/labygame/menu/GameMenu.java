package com.labygame.menu;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameMenu extends Parent {

    public GameMenu() {

        VBox menu0 = new VBox(15);
        VBox menu1 = new VBox(15);

        menu0.setTranslateX(500);
        menu0.setTranslateY(200);
        menu1.setTranslateX(500);
        menu1.setTranslateY(200);

        final int offset = 200;

        menu1.setTranslateX(offset);

        MenuButton btnCtn = new MenuButton("Continue");
        btnCtn.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
            //ft.Save.recuperationSaveHero();
        });

        MenuButton btnNG = new MenuButton("New Game");
        //btnNG.setOnMouseClicked(event -> {
        //FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
        //ft.setFromValue(1);
        //ft.setToValue(0);
        //ft.setOnFinished(evt -> this.setVisible(false));
        //ft.play();
        //});

        MenuButton btnOpt = new MenuButton("Options");
        btnOpt.setOnMouseClicked(event -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu0));
        });

        MenuButton btnC = new MenuButton("Credits");
        btnC.setOnMouseClicked(event -> {
            //TODO
        });

        MenuButton btnE = new MenuButton("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        MenuButton btnBk = new MenuButton("Back");
        btnBk.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu1));
        });

        MenuButton btnS = new MenuButton("Sound");
        //btnS.setOnMouseClicked(event -> {
        //TODO
        //});

        menu0.getChildren().addAll(btnCtn, btnNG, btnOpt, btnC, btnE);
        menu1.getChildren().addAll(btnBk, btnS);

        Rectangle r = new Rectangle(1200, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menu0);

    }

}

