package com.labygame.menu;

import com.labygame.demo.Labygame;
import com.labygame.demo.button.StandardButtonMenu;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GMenu extends Parent {

    Music music = new Music(MusicType.MENU); //msc."music of the game scene".getMusic();

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

        //"Resume" StandardButtonMenu
        StandardButtonMenu btnRes = new StandardButtonMenu("Resume");
        btnRes.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();
        });

        //"Save" StandardButtonMenu
        StandardButtonMenu btnSave = new StandardButtonMenu("Save");
        btnSave.setOnMouseClicked(event -> {
            //TODO
        });

        //"Glossary" StandardButtonMenu
        StandardButtonMenu btnGlossary = new StandardButtonMenu("Glossary");
        btnGlossary.setOnMouseClicked(event ->
            Labygame.setScene(6)
        );

        //"Return Main menu" StandardButtonMenu
        StandardButtonMenu btnR = new StandardButtonMenu("Return Main Menu");
        btnR.setOnMouseClicked(event ->
            Labygame.setScene(Labygame.MENU_SCENE)
        );

        //"Options" StandardButtonMenu
        StandardButtonMenu btnOpt = new StandardButtonMenu("Options");
        btnOpt.setOnMouseClicked(event -> {
            getChildren().add(menuOption);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuMain);
            tt.setToX(menuMain.getTranslateX()+offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuOption);
            tt1.setToX(menuMain.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuMain));
        });

        //"Exit" StandardButtonMenu to exit the game
        StandardButtonMenu btnE = new StandardButtonMenu("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        //"Back" StandardButtonMenu
        StandardButtonMenu btnBk = new StandardButtonMenu("Back");
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

        //"Sound" StandardButtonMenu
        StandardButtonMenu btnS = new StandardButtonMenu("Sound");
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

        //"Mute" StandardButtonMenu to stop the music
        StandardButtonMenu btnM = new StandardButtonMenu("Mute");
        btnM.setOnMouseClicked(event -> music.stopMusic());

        //"Unmute" StandardButtonMenu to play the music if it was muted
        StandardButtonMenu btnU = new StandardButtonMenu("Unmute");
        btnU.setOnMouseClicked(event -> music.playMusic());

        menuMain.getChildren().addAll(btnRes, btnSave, btnGlossary, btnOpt, btnR, btnE);
        menuOption.getChildren().addAll(btnS);
        menuSoundOption.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 600);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);

    }

}
