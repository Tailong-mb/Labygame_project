package com.labygame.menu;

import com.labygame.demo.Labygame;
import com.labygame.demo.button.StandardButtonMenu;
import com.labygame.items.Item;
import com.labygame.items.ItemName;
import com.labygame.personnage.CharacterState;
import com.labygame.personnage.Hero;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
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

import java.util.HashMap;

import static com.labygame.demo.Labygame.CREDITS_SCENE;
import static com.labygame.demo.Labygame.GAME_SCENE;

public class GameMenu extends Parent {

    Music music = new Music(MusicType.MENU);
    Hero hero;

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

        //"Continue" StandardButtonMenu
        StandardButtonMenu btnCtn = new StandardButtonMenu("Continue");
        btnCtn.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
            music.stopMusic();
            //TODO : Take the save and launch the game.
        });

        //"New Game" StandardButtonMenu
        StandardButtonMenu btnNG = new StandardButtonMenu("New Game");
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

            //"Enter" StandardButtonMenu to validate the hero name and launch the game
            StandardButtonMenu btnEnter = new StandardButtonMenu("Enter");
            btnEnter.setTranslateY(30);
            btnEnter.setOnMouseClicked(evt -> {
                String nameHero = txtField.getText();
                newWindow.close();

                //Create the hero
                hero = new Hero(200,
                        CharacterState.NORMAL,
                        nameHero,
                        20,
                        0,
                        0,
                        new HashMap<>() {{
                            put(new Item(2, ItemName.ENERGYDRINK,""), 0);
                            put(new Item(10, ItemName.ANTIDOTE,""), 1);
                            put(new Item(40,ItemName.HEALPOTION,""),3);
                        }});

                //(GameScene)scenesController[GAME_SCENE].setHero(hero);
                music.stopMusic();
                Labygame.setScene(GAME_SCENE);
            });

            secondaryLayout.getChildren().addAll(label, txtField, btnEnter);

            newWindow.setTitle("New Hero");
            newWindow.show();

        });

        //"Options" StandardButtonMenu
        StandardButtonMenu btnOpt = new StandardButtonMenu("Options");
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

        //"Credits" StandardButtonMenu
        StandardButtonMenu btnC = new StandardButtonMenu("Credits");
        btnC.setOnMouseClicked(event -> Labygame.setScene(CREDITS_SCENE));

        //"Exit" StandardButtonMenu to exit the game
        StandardButtonMenu btnE = new StandardButtonMenu("Exit");
        btnE.setOnMouseClicked(event -> System.exit(0));

        //"Back" StandardButtonMenu
        StandardButtonMenu btnBk = new StandardButtonMenu("Back");
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

        //"Sound" StandardButtonMenu
        StandardButtonMenu btnS = new StandardButtonMenu("Sound");
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

        //"Mute" StandardButtonMenu to stop the music
        StandardButtonMenu btnM = new StandardButtonMenu("Mute");
        btnM.setOnMouseClicked(event -> music.stopMusic());

        //"Unmute" StandardButtonMenu to play the music if it was muted
        StandardButtonMenu btnU = new StandardButtonMenu("Unmute");
        btnU.setOnMouseClicked(event -> music.playMusic());


        menuMain.getChildren().addAll(btnCtn, btnNG, btnOpt, btnC, btnE);
        menuOption.getChildren().addAll(btnS);
        menuOptionSound.getChildren().addAll(btnM, btnU, btnBk);

        Rectangle r = new Rectangle(1200, 600);
        r.setFill(Color.GREY);
        r.setOpacity(0.4);

        getChildren().addAll(r, menuMain);

    }

}

