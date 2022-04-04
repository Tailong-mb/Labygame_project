package com.labygame.demo.scenes;

import com.labygame.demo.decor.Chest;
import com.labygame.demo.decor.Hedges;
import com.labygame.demo.mainLabyGame;
import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import com.labygame.demo.decor.Tree;
import com.labygame.demo.trayEnvironnement.GameTray;
import com.labygame.demo.trayEnvironnement.GameTrayPiece;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import lombok.Setter;

import static com.labygame.demo.mainLabyGame.*;

@Setter
public class GameScene extends GeneralScene{

    private GameTray gameBoard;
    private GameTrayPiece currentTray;
    private Image background;
    private Hero hero;
    private Monster monster;
    private Tree tree;
    private Chest chest;
    private Integer[] positions;
    private int trayX;
    private int trayY;

    private boolean allowMoves = false;

    public GameScene(){
        super();
        background = new Image("file:doc/images/nature/grass_template.jpg");
        hero = new Hero(5, CharacterState.NORMAL,"TheChosenOne",20,50,400);
        monster = new Monster(20,"Le Monstre",10,450,350);
        tree = new Tree(50,50);
        chest = new Chest();
        gameBoard = new GameTray();
        trayX = 0;
        trayY = 0;
    }

    @Override
    public void draw() {
        activeKeys.clear();
        hero.getMainCharacter().moveTo(hero.getPositionX(),hero.getPositionY());
        currentTray = gameBoard.getGameBoard()[trayX][trayY];
        positions = new Integer[currentTray.getMyCoordinates().size()];
        positions = currentTray.getMyCoordinates().toArray(positions);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);
                currentTray.draw(gc);
                hero.getMainCharacter().draw(gc);

                if(hero.getHp() <= 0)
                {
                    this.stop();
                    mainLabyGame.setScene(CREDITS_SCENE);
                }
                if(activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    mainLabyGame.exit();
                    //Labygame.setScene(Labygame.MENU_SCENE);
                }
                else if(activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    mainLabyGame.setScene(CREDITS_SCENE);
                }
                else if(activeKeys.contains(KeyCode.Q)){
                    hero.getMainCharacter().setSpriteY(102);
                    if(hero.getMainCharacter().getX() > 40) {
                        if (((!hero.collision(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3}) && (!hero.collision(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))) || hero.isStuckR()))
                        {
                            if (currentTray.getMyChest().isVisible() && hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))
                                currentTray.getMyChest().setOpened(true);
                            if(hero.collision(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
                                currentTray.getMyTrap().hurtHero(hero);
                                currentTray.getMyTrap().setVisible(false);
                            }
                            hero.setStuckR(false);
                            hero.move(hero.LEFT);
                            if(((int)(Math.random()*1000)) == 1)
                            {
                                this.stop();
                                mainLabyGame.setScene(FIGHT_SCENE);
                            }
                        }
                        else if(hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(hero.LEFT);
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
                else if(activeKeys.contains(KeyCode.D)){
                    hero.getMainCharacter().setSpriteY(38);
                    if(hero.getMainCharacter().getX() < GAME_WIDTH - (hero.getMainCharacter().getWidth()*3) - 40) {
                        if((!hero.collision(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3})&& (!hero.collision(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))) || hero.isStuckL())
                        {
                            if(currentTray.getMyChest().isVisible() && hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))
                                currentTray.getMyChest().setOpened(true);
                            if(hero.collision(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
                                currentTray.getMyTrap().hurtHero(hero);
                                currentTray.getMyTrap().setVisible(false);
                            }
                            hero.setStuckL(false);
                            hero.move(hero.RIGHT);
                            if(((int)(Math.random()*1000)) == 1)
                            {
                                this.stop();
                                mainLabyGame.setScene(FIGHT_SCENE);
                            }
                        }
                        else if(hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(hero.RIGHT);
                        }
                        else
                            hero.setStuckR(true);
                    }
                    else if(currentTray.isExitRight() && hero.getMainCharacter().getY() > 320 && hero.getMainCharacter().getY() < 450)
                    {
                        if(trayX == 4 && trayY == 3) {
                            this.stop();
                            mainLabyGame.setScene(CREDITS_SCENE);
                        }

                        if(trayX<4) {
                            trayX+=1;
                            currentTray = gameBoard.getGameBoard()[trayX][trayY];
                            hero.getMainCharacter().setX(10);
                        }
                    }
                }
                else if(activeKeys.contains(KeyCode.Z)){
                    hero.getMainCharacter().setSpriteY(69);
                    if(hero.getMainCharacter().getY() > 40) {
                        if(((!hero.collision(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3})) && (!hero.collision(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))) || hero.isStuckD())
                        {
                            if(currentTray.getMyChest().isVisible() && hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))
                                currentTray.getMyChest().setOpened(true);
                            if(hero.collision(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
                                currentTray.getMyTrap().hurtHero(hero);
                                currentTray.getMyTrap().setVisible(false);
                            }
                            hero.setStuckD(false);
                            hero.move(hero.UP);
                            if(((int)(Math.random()*1000)) == 1)
                            {
                                this.stop();
                                mainLabyGame.setScene(FIGHT_SCENE);
                            }
                        }
                        else if(hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(hero.UP);
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
                else if(activeKeys.contains(KeyCode.S)){
                    hero.getMainCharacter().setSpriteY(6);
                    if(hero.getMainCharacter().getY() < GAME_HEIGHT - (hero.getMainCharacter().getHeight()*3) - 40) {
                        if((!hero.collision(new Integer[]{positions[0], positions[1], positions[2]*3, positions[3]*3}) && (!hero.collision(new Integer[]{positions[4], positions[5], positions[6]*6, positions[7]*6})) && (!hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))) || hero.isStuckU()) {
                            if (currentTray.getMyChest().isVisible() && hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}))
                                currentTray.getMyChest().setOpened(true);
                            if (hero.collision(new Integer[]{positions[8], positions[9], positions[10], positions[11]}) && currentTray.getMyTrap().isVisible()) {
                                currentTray.getMyTrap().hurtHero(hero);
                                currentTray.getMyTrap().setVisible(false);
                            }
                            hero.setStuckU(false);
                            hero.move(hero.DOWN);
                            if (((int) (Math.random() * 1000)) == 1) {
                                this.stop();
                                mainLabyGame.setScene(FIGHT_SCENE);
                            }
                        }
                        else if(hero.collision(new Integer[]{positions[12], positions[13], positions[14], positions[15]}) && !currentTray.getMyChest().isVisible())
                        {
                            hero.move(hero.DOWN);
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
}
