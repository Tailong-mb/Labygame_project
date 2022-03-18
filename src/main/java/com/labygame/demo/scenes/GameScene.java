package com.labygame.demo.scenes;

import com.labygame.demo.mainLabyGame;
import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.trayEnvironnement.Decor.Tree;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import lombok.Setter;

import static com.labygame.demo.mainLabyGame.CREDITS_SCENE;

@Setter
public class GameScene extends GeneralScene{

    private Image background;
    private Hero hero;
    private Tree tree;

    public GameScene(){
        super();
        background = new Image("file:doc/images/grass_template.jpg");
        hero = new Hero(50, CharacterState.NORMAL,"TheChosenOne",20,200,200);
        tree = new Tree(50,50);
    }

    @Override
    public void draw() {
        activeKeys.clear();
        hero.getMainCharacter().moveTo(hero.getPositionX(),hero.getPositionY());
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);
                gc.drawImage(tree.getMyImage(), tree.getPositionX(),tree.getPositionY());
                //gc.drawImage(hero.getMyImage(),0,0,16,30,250,250,32,60);
                hero.getMainCharacter().draw(gc);

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
