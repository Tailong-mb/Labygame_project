package com.labygame.menu;

import com.labygame.front.Labygame;
import com.labygame.front.button.StandardButtonMenu;
import com.labygame.front.scenes.CreditsScene;
import com.labygame.front.scenes.GameOverScene;
import com.labygame.front.scenes.GameScene;
import com.labygame.items.Item;
import com.labygame.items.ItemName;
import com.labygame.personnage.CharacterState;
import com.labygame.personnage.Hero;
import com.labygame.sauvegarde.Save;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.util.HashMap;

import static com.labygame.front.Labygame.*;

public class GameMenu extends Parent {

    private final Music music = new Music(MusicType.MENU);

    public GameMenu() {

        //Play main music
        music.playMusic();

        //Set menu Container
        VBox menuMain = new VBox(15);
        VBox menuOption = new VBox(15);
        VBox menuOptionSound = new VBox(15);
        VBox createNewGame = new VBox(15);

        final int MENU_POSITION_X = 475;
        final int MENU_POSITION_Y = 200;

        menuMain.setTranslateX(MENU_POSITION_X);
        menuMain.setTranslateY(MENU_POSITION_Y);
        menuOption.setTranslateX(MENU_POSITION_X);
        menuOption.setTranslateY(MENU_POSITION_Y);
        menuOptionSound.setTranslateX(MENU_POSITION_X);
        menuOptionSound.setTranslateY(MENU_POSITION_Y);
        createNewGame.setTranslateX(MENU_POSITION_X);
        createNewGame.setTranslateY(MENU_POSITION_Y);

        //"Continue" StandardButtonMenu
        StandardButtonMenu buttonContinue = new StandardButtonMenu("Continue");
        buttonContinue.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> this.setVisible(false));
            ft.play();
            music.stopMusic();

            Hero hero = Save.recuperationSaveHero();
            scenes[GAME_SCENE].setHero(hero);
            scenes[GAME_OVER_SCENE] = new GameOverScene();
            scenes[CREDITS_SCENE] = new CreditsScene();
            setScene(GAME_SCENE);
        });

        //"New Game" StandardButtonMenu
        StandardButtonMenu buttonNewGame = new StandardButtonMenu("New Game");
        buttonNewGame.setOnMouseClicked(event -> animationFadeMenu(menuMain,createNewGame));
        //"Options" StandardButtonMenu
        StandardButtonMenu buttonOption = new StandardButtonMenu("Options");
        buttonOption.setOnMouseClicked(event -> animationFadeMenu(menuMain,menuOption));

        //"Credits" StandardButtonMenu
        StandardButtonMenu buttonCredit = new StandardButtonMenu("Credits");
        buttonCredit.setOnMouseClicked(event -> {
            scenes[CREDITS_SCENE] = new CreditsScene();
            music.stopMusic();
            Labygame.setScene(CREDITS_SCENE);
        });

        //"Exit" StandardButtonMenu to exit the game
        StandardButtonMenu buttonExit = new StandardButtonMenu("Exit");
        buttonExit.setOnMouseClicked(event -> System.exit(0));

        //"Back" StandardButtonMenu from sound.
        StandardButtonMenu buttonBackFromSound = new StandardButtonMenu("Back");
        buttonBackFromSound.setOnMouseClicked(event -> animationFadeMenu(menuOptionSound,menuMain));

        //"Sound" StandardButtonMenu
        StandardButtonMenu buttonSound = new StandardButtonMenu("Sound");
        buttonSound.setOnMouseClicked(event -> animationFadeMenu(menuOption,menuOptionSound));

        //"Mute" StandardButtonMenu to stop the music
        StandardButtonMenu buttonMute = new StandardButtonMenu("Mute");
        buttonMute.setOnMouseClicked(event -> music.stopMusic());

        //"Unmute" StandardButtonMenu to play the music if it was muted
        StandardButtonMenu buttonUnMute = new StandardButtonMenu("Unmute");
        buttonUnMute.setOnMouseClicked(event -> music.playMusic());

        //Create area to set hero name
        TextField heroNameText = new TextField();
        heroNameText.setFont(Font.font(15));
        heroNameText.setMaxWidth(300);

        Text instructionHeroNameText = new Text("Put the name of your hero !\n(3 to 15 characters)") ;
        instructionHeroNameText.setFont(Font.font(20));
        instructionHeroNameText.setFill(Color.BLACK);

        heroNameText.setOnKeyPressed(event -> {
            //when he validates his answer
            if(event.getCode() == KeyCode.ENTER){
                //Check the name
                String heroName = heroNameText.getText();
                if(heroName.matches("^[A-Za-z][A-Za-z0-9_]{3,15}$")) {
                    Hero hero = new Hero(200,
                            CharacterState.NORMAL,
                            heroName,
                            20,
                            50,
                            400,
                            new HashMap<>() {{
                                put(new Item(2, ItemName.ENERGYDRINK, ""), 2);
                                put(new Item(10, ItemName.ANTIDOTE, ""), 1);
                                put(new Item(40, ItemName.HEALPOTION, ""), 3);
                            }});
                    scenes[GAME_OVER_SCENE] = new GameOverScene();
                    scenes[GAME_SCENE] = new GameScene();
                    scenes[GAME_SCENE].setHero(hero);
                    music.stopMusic();
                    setScene(GAME_SCENE);
                }
            }
        });

        createNewGame.getChildren().addAll(instructionHeroNameText,heroNameText);
        menuMain.getChildren().addAll(buttonContinue, buttonNewGame, buttonOption, buttonCredit, buttonExit);
        menuOption.getChildren().addAll(buttonSound);
        menuOptionSound.getChildren().addAll(buttonMute, buttonUnMute, buttonBackFromSound);

        getChildren().addAll(menuMain);
    }

    /**
     * animation for the menu
     * @param menuOut the menu who will appear
     * @param menuIn the menu who will disappear
     */
    public void animationFadeMenu(VBox menuOut,VBox menuIn){

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), menuOut);
        translateTransition.setToX(menuOut.getTranslateX() + 200);

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuIn);
        translateTransition1.setToX(menuOut.getTranslateX());

        translateTransition.play();
        translateTransition1.play();

        translateTransition.setOnFinished(evt -> getChildren().remove(menuOut));
        getChildren().add(menuIn);
    }

}

