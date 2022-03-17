package com.labygame.menu;

import com.labygame.mainLabyGame;
import com.labygame.sound.Music;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GMenu extends Parent {

    Music msc = new Music(); //msc."music of the game scene".getMusic();

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

        //"Save" button
        button btnSave = new button("Save");
        btnSave.setOnMouseClicked(event -> {
            //TODO
        });

        //"Glossary" button
        button btnGlossary = new button("Glossary");
        btnGlossary.setOnMouseClicked(event ->{
            mainLabyGame.setScene(5);
        });

        //"Return Main menu" button
        button btnR = new button("Return Main Menu");
        btnR.setOnMouseClicked(event -> {
            mainLabyGame.setScene(0);
        });

        //"Options" button
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

        //"Exit" button to exit the game
        button btnE = new button("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        //"Back" button
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

        //"Sound" button
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

        //"Mute" button to stop the music
        button btnM = new button("Mute");
        btnM.setOnMouseClicked(event ->msc.stopMusic());

        //"Unmute" button to play the music if it was muted
        button btnU = new button("Unmute");
        btnU.setOnMouseClicked(event -> msc.playMusic());

        menuMain.getChildren().addAll(btnRes, btnSave, btnGlossary, btnOpt, btnR, btnE);
        menuOption.getChildren().addAll(btnS);
        menuSoundOption.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 600);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);

    }

}
