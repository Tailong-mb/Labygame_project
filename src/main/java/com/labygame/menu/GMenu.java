package com.labygame.menu;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GMenu extends Parent {

    public GMenu() {

        VBox menu0 = new VBox(15);
        VBox menu1 = new VBox(15);

        menu0.setTranslateX(550);
        menu0.setTranslateY(300);
        menu1.setTranslateX(550);
        menu1.setTranslateY(300);

        final int offset = 200;

        menu1.setTranslateX(offset);

        menuBtn btnRes = new menuBtn("Resume");
        btnRes.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();
        });

        menuBtn btnR = new menuBtn("Return Main Menu");
        //btnR.setOnMouseClicked(event -> {
        //TODO
        //});

        menuBtn btnOpt = new menuBtn("Options");
        btnOpt.setOnMouseClicked(evnt -> {
            getChildren().add(menu1);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
            tt.setToX(menu0.getTranslateX()+offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
            tt1.setToX(menu0.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu0));
        });

        menuBtn btnE = new menuBtn("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        menuBtn btnBk = new menuBtn("Back");
        btnBk.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX()+offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu1));
        });

        menuBtn btnS = new menuBtn("Sound");
        //btnS.setOnMouseClicked(event -> {
        //TODO
        //});

        menu0.getChildren().addAll(btnRes, btnOpt, btnR, btnE);
        menu1.getChildren().addAll(btnBk,btnS);

        Rectangle r = new Rectangle(1332, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menu0);

    }

}
