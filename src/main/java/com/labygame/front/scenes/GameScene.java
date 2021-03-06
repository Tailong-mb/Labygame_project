package com.labygame.front.scenes;

import com.labygame.items.Item;
import com.labygame.items.ItemName;
import com.labygame.personnage.CharacterState;
import com.labygame.personnage.Hero;
import com.labygame.personnage.Monster;
import com.labygame.personnage.Wizard;
import com.labygame.sauvegarde.Save;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import com.labygame.trayEnvironnement.GameTray;
import com.labygame.trayEnvironnement.GameTrayPiece;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.labygame.Labygame.*;

@Setter
@Getter
public class GameScene extends GeneralScene {

    private GameTray gameBoard;
    private GameTrayPiece currentTray;
    private Image background;
    private Integer[] positions;
    private int trayX;
    private int trayY;
    private final Music music = new Music(MusicType.BASIC);
    private final Random random = new Random();
    public GameScene(){
        super();
        background = new Image("file:doc/images/nature/grass_template.jpg");
        gameBoard = new GameTray();
        trayX = 0;
        trayY = 0;
        hero = new Hero(200,
                CharacterState.NORMAL,
                "basic",
                20,
                50,
                400,
                new HashMap<>() {{
                    put(new Item(2, ItemName.ENERGYDRINK, ""), 2);
                    put(new Item(10, ItemName.ANTIDOTE, ""), 1);
                    put(new Item(40, ItemName.HEALPOTION, ""), 3);
                }});
    }

    @Override
    public void draw() {
        activeKeys.clear();
        hero.getMainCharacter().moveTo(hero.getPositionX(),hero.getPositionY());
        currentTray = gameBoard.getGameBoard()[trayX][trayY];
        positions = new Integer[currentTray.getMyCoordinates().size()];
        positions = currentTray.getMyCoordinates().toArray(positions);
        music.playMusic();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                boolean checkX = ((!hero.collisionX(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3})) && (!hero.collisionX(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collisionX(new Integer[]{positions[12], positions[13], positions[14], positions[15]})));
                boolean checkY = ((!hero.collisionY(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3})) && (!hero.collisionY(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collisionY(new Integer[]{positions[12], positions[13], positions[14], positions[15]})));
                boolean checkChestX = currentTray.getMyChest().isVisible() && hero.collisionX(new Integer[]{positions[12], positions[13], positions[14], positions[15]});
                boolean checkChestY = currentTray.getMyChest().isVisible() && hero.collisionY(new Integer[]{positions[12], positions[13], positions[14], positions[15]});
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);
                currentTray.draw(gc);
                hero.getMainCharacter().draw(gc);

                //Verify if the character open the key chest
                if(checkChestX) {
                    collisionKeyChest();
                }
                if(checkChestY) {
                    collisionKeyChest();
                }

                //Verify if the character is dead
                if(hero.theCharacterIsDead())
                {
                    this.stop();
                    music.stopMusic();
                    setScene(CREDITS_SCENE);
                }

                //Go to menu
                if(activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    music.stopMusic();
                    Save.saveHero(hero);
                    setScene(MENU_SCENE);
                }

                //Left movement
                else if(activeKeys.contains(KeyCode.Q) || activeKeys.contains(KeyCode.LEFT)){
                    hero.getMainCharacter().setSpriteY(102);
                    if(hero.getMainCharacter().getX() > 40) {
                        if(checkX || hero.isStuckR())
                        {
                            checkCollisionTrap();
                            hero.setStuckR(false);
                            hero.move(Hero.LEFT);
                            if(random1000())
                            {
                                this.stop();
                                music.stopMusic();
                                changeToFightScene();
                            }
                        }
                        else if(hero.collisionX(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(Hero.LEFT);
                        }
                        else
                            hero.setStuckL(true);
                    }
                    else if(currentTray.isExitLeft() && hero.getMainCharacter().getY() > 320 && hero.getMainCharacter().getY() < 450)
                    {
                        if(trayX > 0) {
                            trayX -= 1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setX(GAME_WIDTH - (hero.getMainCharacter().getWidth() * 3));
                        }
                    }
                }

                //Right movement
                else if(activeKeys.contains(KeyCode.D) || activeKeys.contains(KeyCode.RIGHT)){
                    hero.getMainCharacter().setSpriteY(38);
                    if(hero.getMainCharacter().getX() < GAME_WIDTH - (hero.getMainCharacter().getWidth()*3) - 40) {
                        if(checkX || hero.isStuckL())
                        {
                            checkCollisionTrap();
                            hero.setStuckL(false);
                            hero.move(Hero.RIGHT);
                            if(random1000())
                            {
                                this.stop();
                                music.stopMusic();
                                changeToFightScene();
                            }
                        }
                        else if(hero.collisionX(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(Hero.RIGHT);
                        }
                        else
                            hero.setStuckR(true);
                    }
                    else if(currentTray.isExitRight() && hero.getMainCharacter().getY() > 320 && hero.getMainCharacter().getY() < 450)
                    {
                        if(trayX == 4 && trayY == 3) {
                            this.stop();
                            music.stopMusic();
                            setScene(CREDITS_SCENE);
                        }

                        if(trayX<4) {
                            trayX+=1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setX(10);
                        }
                    }
                }

                //Up movement
                else if(activeKeys.contains(KeyCode.Z) || activeKeys.contains(KeyCode.UP)){
                    hero.getMainCharacter().setSpriteY(69);
                    if(hero.getMainCharacter().getY() > 40) {
                        if(checkY || hero.isStuckD())
                        {
                            checkCollisionTrap();
                            hero.setStuckD(false);
                            hero.move(Hero.UP);
                            if(random1000())
                            {
                                this.stop();
                                music.stopMusic();
                                changeToFightScene();
                            }
                        }
                        else if(hero.collisionY(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(Hero.UP);
                        }
                        else
                            hero.setStuckU(true);
                    }
                    else if(currentTray.isExitUp() && hero.getMainCharacter().getX() > 500 && hero.getMainCharacter().getX() < 660)
                    {
                        if(trayY>0)
                        {
                            trayY -= 1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setY(GAME_HEIGHT - hero.getMainCharacter().getHeight() * 3);
                        }
                    }
                }

                //Down movement
                else if(activeKeys.contains(KeyCode.S) || activeKeys.contains(KeyCode.DOWN)){
                    hero.getMainCharacter().setSpriteY(6);
                    if(hero.getMainCharacter().getY() < GAME_HEIGHT - (hero.getMainCharacter().getHeight()*3) - 40) {
                        if(checkY || hero.isStuckU())
                        {
                            checkCollisionTrap();
                            hero.setStuckU(false);
                            hero.move(Hero.DOWN);
                            if (random1000()) {
                                this.stop();
                                music.stopMusic();
                                changeToFightScene();
                            }
                        }
                        else if(hero.collisionY(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(Hero.DOWN);
                        }
                        else
                            hero.setStuckD(true);
                    }
                    else if(currentTray.isExitDown() && hero.getMainCharacter().getX() > 500 && hero.getMainCharacter().getX() < 660)
                    {
                        if(trayY<4){
                            trayY +=1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setY(10);
                        }
                    }
                }
            }
        };timer.start();
    }

    /**
     * this method create a new Monster with random stats
     * @return a Monster in order to create a FightScene
     */
    public Monster createRandomMonster(){
        List<String> possibleMonsterName = Arrays.asList("Barbling","Duskvine","Warptaur","CavernSoul","The Sick Vermin");
        return new Monster(random.nextInt(50) + 50,
                CharacterState.NORMAL,
                possibleMonsterName.get(random.nextInt(4)),
                random.nextInt(20)+10
        );
    }

    public boolean random1000(){
        return ((int) (Math.random() * 1000)) == 1;
    }

    /**
     * this method create a new FightScene against a monster or a wizard
     */
    public void changeToFightScene(){
        if(random.nextBoolean()){
            FightScene fightScene = new FightScene(hero, createRandomMonster());
            scenes[FIGHT_SCENE] = fightScene;
            setScene(FIGHT_SCENE);
        } else {
            Wizard wizard = new Wizard(400,CharacterState.NORMAL,"Merlin",30);
            FightScene fightScene = new FightScene(hero,wizard);
            scenes[FIGHT_SCENE] = fightScene;
            setScene(FIGHT_SCENE);
        }
    }

    /**
     * this method check if the hero enter in collision with the key chest using an attribute of the current gameTrayPiece
     */
    public void collisionKeyChest(){
        currentTray.getMyChest().setOpened(true);
        hero.setHaveMagicKey(true);

        Text textObtainKey = new Text("You got the KEY !\nFind the exit");
        textObtainKey.setFont(Font.font("Arial", FontWeight.BOLD,30));
        textObtainKey.setTranslateX(0);
        textObtainKey.setTranslateY(-100);
        textObtainKey.setFill(Color.BLACK);
        FadeTransition ft = new FadeTransition(Duration.seconds(2.5), textObtainKey);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
        root.getChildren().addAll(textObtainKey);
        this.setRoot(root);

        gameBoard.getGameBoard()[4][3].setExitRight(true);
    }

    /**
     * this method check if the hero enter in collision with a trap using an attribute of the current gameTrayPiece
     */
    public void checkCollisionTrap(){
        if(hero.collisionX(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
            currentTray.getMyTrap().hurtHero(hero);
            currentTray.getMyTrap().setVisible(false);
            hero.setCurrentStatus(CharacterState.POISON);

            Text textDamageTrap = new Text(" - 5 + POISON");
            textDamageTrap.setFont(Font.font("Arial", FontWeight.BOLD,30));
            textDamageTrap.setTranslateX(0);
            textDamageTrap.setTranslateY(-100);
            textDamageTrap.setFill(Color.RED);
            FadeTransition ft = new FadeTransition(Duration.seconds(2.5), textDamageTrap);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
            root.getChildren().addAll(textDamageTrap);
            this.setRoot(root);
        }
    }
}