package com.labygame.menu;

import com.labygame.sound.Music;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GMenu extends Parent {

    Music msc = new Music();

    public GMenu() {

        VBox menu0 = new VBox(15);
        VBox menu1 = new VBox(15);
        VBox menu2 = new VBox(15);

        menu0.setTranslateX(500);
        menu0.setTranslateY(300);
        menu1.setTranslateX(500);
        menu1.setTranslateY(300);
        menu2.setTranslateX(500);
        menu2.setTranslateY(200);

        final int offset = 200;

        menu1.setTranslateX(offset);

        button btnRes = new button("Resume");
        btnRes.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();
        });

        button btnR = new button("Return Main Menu");
        //btnR.setOnMouseClicked(event -> {
        //TODO
        //});

        button btnOpt = new button("Options");
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

        button btnE = new button("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        button btnBk = new button("Back");
        btnBk.setOnMouseClicked(event -> {
            getChildren().add(menu0);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
            tt.setToX(menu2.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
            tt1.setToX(menu2.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu2));
        });

        button btnS = new button("Sound");
        btnS.setOnMouseClicked(event -> {
            getChildren().add(menu2);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menu1));

        });

        button btnM = new button("Mute");
        btnM.setOnMouseClicked(event -> msc.stopMusic());

        button btnU = new button("Unmute");
        btnU.setOnMouseClicked(event -> msc.playMusic());

        menu0.getChildren().addAll(btnRes, btnOpt, btnR, btnE);
        menu1.getChildren().addAll(btnS);
        menu2.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menu0);

    }

}
