package com.labygame.menu;

import com.labygame.sound.Music;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameMenu extends Parent {

    Music msc = new Music();

    public GameMenu() {

        //Set menu Container
        VBox menuMain = new VBox(15);
        VBox menuOption = new VBox(15);
        VBox menuOptionSound = new VBox(15);

        menuMain.setTranslateX(500);
        menuMain.setTranslateY(50);
        menuOption.setTranslateX(500);
        menuOption.setTranslateY(50);
        menuOptionSound.setTranslateX(500);
        menuOptionSound.setTranslateY(50);

        final int offset = 200;

        menuOption.setTranslateX(offset);

        button btnCtn = new button("Continue");
        btnCtn.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
        });

        button btnNG = new button("New Game");
        btnNG.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();

        });

        button btnGlossary = new button("Glossary");
        btnGlossary.setOnMouseClicked(event ->{
            //TODO
        });

        button btnOpt = new button("Options");
        btnOpt.setOnMouseClicked(event -> {
            getChildren().add(menuOption);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuMain);
            tt.setToX(menuMain.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuOption);
            tt1.setToX(menuMain.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuMain));
        });

        button btnC = new button("Credits");
        btnC.setOnMouseClicked(event -> {
            //TODO
        });

        button btnE = new button("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        button btnBk = new button("Back");
        btnBk.setOnMouseClicked(event -> {
            getChildren().add(menuMain);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuOptionSound);
            tt.setToX(menuOptionSound.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuMain);
            tt1.setToX(menuOptionSound.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuOptionSound));
        });

        button btnS = new button("Sound");
        btnS.setOnMouseClicked(event -> {
            getChildren().add(menuOptionSound);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menuOption);
            tt.setToX(menuOption.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menuOptionSound);
            tt1.setToX(menuOption.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> getChildren().remove(menuOption));

        });

        button btnM = new button("Mute");
        btnM.setOnMouseClicked(event -> msc.stopMusic());

        button btnU = new button("Unmute");
        btnU.setOnMouseClicked(event -> msc.playMusic());


        menuMain.getChildren().addAll(btnCtn, btnNG, btnGlossary, btnOpt, btnC, btnE);
        menuOption.getChildren().addAll(btnS);
        menuOptionSound.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);

    }

}

