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

        //Set menu Container
        VBox menuMain = new VBox(15);
        VBox menuOption = new VBox(15);
        VBox menuSoundOption = new VBox(15);

        menuMain.setTranslateX(500);
        menuMain.setTranslateY(300);
        menuOption.setTranslateX(500);
        menuOption.setTranslateY(300);
        menuSoundOption.setTranslateX(500);
        menuSoundOption.setTranslateY(200);

        final int offset = 200;

        menuOption.setTranslateX(offset);

        //"Resume" button
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
            getChildren().add(menuOption);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuMain);
            tt.setToX(menuMain.getTranslateX()+offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuOption);
            tt1.setToX(menuMain.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuMain));
        });

        button btnE = new button("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        button btnBk = new button("Back");
        btnBk.setOnMouseClicked(event -> {
            getChildren().add(menuMain);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuSoundOption);
            tt.setToX(menuSoundOption.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuMain);
            tt1.setToX(menuSoundOption.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuSoundOption));
        });

        button btnS = new button("Sound");
        btnS.setOnMouseClicked(event -> {
            getChildren().add(menuSoundOption);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuOption);
            tt.setToX(menuOption.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuSoundOption);
            tt1.setToX(menuOption.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuOption));

        });

        button btnM = new button("Mute");
        //btnM.setOnMouseClicked(event ->
        /**
         * music."music of the game scene".getMusic();
         * music.stopMusic();
         */
        //);

        button btnU = new button("Unmute");
        btnU.setOnMouseClicked(event -> msc.playMusic());

        menuMain.getChildren().addAll(btnRes, btnOpt, btnR, btnE);
        menuOption.getChildren().addAll(btnS);
        menuSoundOption.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);

    }

}
