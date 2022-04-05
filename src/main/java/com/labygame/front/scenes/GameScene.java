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
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.labygame.front.Labygame.*;

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

                if(checkChestX) {
                    collisionChest();
                }
                if(checkChestY) {
                    collisionChest();
                }

                if(hero.isDead())
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

                        if(trayX<1) {
                            trayX+=1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setX(10);
                        }
                        else
                            setScene(CREDITS_SCENE);
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
                    else if(currentTray.isExitUp() && hero.getMainCharacter().getY() > 320 && hero.getMainCharacter().getY() < 450)
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
                    else if(currentTray.isExitDown() && hero.getMainCharacter().getX() > 320 && hero.getMainCharacter().getX() < 450)
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

    public void changeToFightScene(){
        if(random.nextBoolean()){
            FightScene fightScene = new FightScene(hero, createRandomMonster());
            scenes[FIGHT_SCENE] = fightScene;
            setScene(FIGHT_SCENE);
        } else {
            Wizard wizard = new Wizard(1000,CharacterState.NORMAL,"Merlin",30);
            FightScene fightScene = new FightScene(hero,wizard);
            scenes[FIGHT_SCENE] = fightScene;
            setScene(FIGHT_SCENE);
        }
    }

    public void collisionChest(){
        currentTray.getMyChest().setOpened(true);
        hero.setHaveMagicKey(true);
        gameBoard.getGameBoard()[1][0].setExitRight(true);
    }

    public void checkCollisionTrap(){
        if(hero.collisionX(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
            currentTray.getMyTrap().hurtHero(hero);
            currentTray.getMyTrap().setVisible(false);
        }
    }
}
