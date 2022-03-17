package com.labygame.menu;

import com.labygame.mainLabyGame;
import com.labygame.personnage.CharacterState;
import com.labygame.personnage.Hero;
import com.labygame.sound.Music;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMenu extends Parent {

    Music music = new Music();
    Hero newHero;
    Hero oldHero;

    public GameMenu() {

        //Play main music
        music.playMusic();

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

        //"Continue" button
        button btnCtn = new button("Continue");
        btnCtn.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
            //TODO
        });

        //"New Game" button
        button btnNG = new button("New Game");
        btnNG.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();

            StackPane secondaryLayout = new StackPane();

            Scene secondScene = new Scene(secondaryLayout, 230, 100);

            // New window (Stage) which opens when "New Game" has chosen, it's to give a name at the hero
            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");
            newWindow.setScene(secondScene);

            newWindow.initModality(Modality.WINDOW_MODAL);

            newWindow.setAlwaysOnTop(true);

            Label label = new Label("Name your hero ");

            //Field for the hero name
            TextField txtField = new TextField();
            label.setTranslateY(-25);
            final String[] nameHero = new String[1];

            //"Enter" button to validate the hero name and launch the game
            button btnEnter = new button("Enter");
            btnEnter.setTranslateY(30);
            btnEnter.setOnMouseClicked(evt -> {
                nameHero[0] = txtField.getText();
                newWindow.close();

                mainLabyGame.setScene(1);
            });

            newHero = new Hero(100, CharacterState.NORMAL, nameHero[0], 20, 50, 50, null);

            secondaryLayout.getChildren().addAll(label, txtField, btnEnter);

            newWindow.setTitle("New Hero");
            newWindow.show();

        });


        //"Glossary" button
        button btnGlossary = new button("Glossary");
        btnGlossary.setOnMouseClicked(event ->{
            mainLabyGame.setScene(5);
        });

        //"Options" button
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

        //"Credits" button
        button btnC = new button("Credits");
        btnC.setOnMouseClicked(event -> {
            mainLabyGame.setScene(6);
        });

        //"Exit" button to exit the game
        button btnE = new button("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        //"Back" button
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

        //"Sound" button
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

        //"Mute" button to stop the music
        button btnM = new button("Mute");
        btnM.setOnMouseClicked(event -> music.stopMusic());
        /**
         * music."music of the game scene".getMusic();
         * music.stopMusic();
         */

        //"Unmute" button to play the music if it was muted
        button btnU = new button("Unmute");
        btnU.setOnMouseClicked(event -> music.playMusic());


        menuMain.getChildren().addAll(btnCtn, btnNG, btnGlossary, btnOpt, btnC, btnE);
        menuOption.getChildren().addAll(btnS);
        menuOptionSound.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 850);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);


    }

}

