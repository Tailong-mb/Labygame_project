package com.labygame.demo.scenes;

import com.labygame.demo.decor.Chest;
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

import static com.labygame.demo.mainLabyGame.CREDITS_SCENE;

@Setter
public class GameScene extends GeneralScene{

    private GameTray gameBoard;
    private Image background;
    private Hero hero;
    private Monster monster;
    private Tree tree;
    private Chest chest;

    public GameScene(){
        super();
        background = new Image("file:doc/images/grass_template.jpg");
        hero = new Hero(50, CharacterState.NORMAL,"TheChosenOne",20,200,200);
        monster = new Monster(20,"Le Monstre",10,450,350);
        tree = new Tree(50,50);
        chest = new Chest();
        gameBoard = new GameTray();
    }

    @Override
    public void draw() {
        activeKeys.clear();
        hero.getMainCharacter().moveTo(hero.getPositionX(),hero.getPositionY());
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);
                gameBoard.getGameBoard()[0][0].draw(gc);
                /*
                gc.drawImage(monster.getMyImages()[3],31,29,monster.WIDTH,monster.HEIGHT,monster.getPositionX(),monster.getPositionY(),100,100);
                gc.drawImage(tree.getMyImage(), tree.getPositionX(),tree.getPositionY());
                gc.drawImage(chest.getMyImage(),1, 1, chest.getWidthSprite(), chest.getHeightSprite(),chest.getPositionX(), chest.getPositionY(), chest.getWidthSprite()*1.2, chest.getHeightSprite()*1.2);
                //gc.drawImage(hero.getMyImage(),0,0,16,30,250,250,32,60);
                hero.getMainCharacter().draw(gc);

                 */

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
                    if(hero.getMainCharacter().getX() > 2) {
                        hero.move(hero.LEFT);
                    }
                }
                else if(activeKeys.contains(KeyCode.D)){
                    hero.getMainCharacter().setSpriteY(38);
                    if(hero.getMainCharacter().getX() < GAME_WIDTH - (hero.getMainCharacter().getWidth()*2)) {
                        if(hero.getPositionX())
                        hero.move(hero.RIGHT);
                    }
                }
                else if(activeKeys.contains(KeyCode.Z)){
                    hero.getMainCharacter().setSpriteY(69);
                    if(hero.getMainCharacter().getY() > 2) {
                        hero.move(hero.UP);
                    }
                }
                else if(activeKeys.contains(KeyCode.S)){
                    hero.getMainCharacter().setSpriteY(6);
                    if(hero.getMainCharacter().getY() < GAME_HEIGHT - (hero.getMainCharacter().getHeight()*2)) {
                        hero.move(hero.DOWN);
                    }
                }
            }
        };timer.start();
    }
}
