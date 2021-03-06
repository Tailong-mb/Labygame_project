package com.labygame.front.scenes;

import com.labygame.personnage.Hero;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import java.util.HashSet;
import java.util.Set;

public abstract class GeneralScene extends Scene {
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 850;

    protected StackPane root;
    protected GraphicsContext gc;
    protected Set<KeyCode> activeKeys;
    protected Set<KeyCode> releasedKeys;
    protected Hero hero;

    public GeneralScene() {
        super(new StackPane(), GAME_WIDTH, GAME_HEIGHT);
        this.root = new StackPane();
        this.setRoot(root);

        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        activeKeys = new HashSet<>();
        releasedKeys = new HashSet<>();
        this.setOnKeyPressed(e -> activeKeys.add(e.getCode()));
        this.setOnKeyReleased(e ->{
            activeKeys.remove(e.getCode());
            releasedKeys.add(e.getCode());
        });
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero(){
        return hero;
    }
    public abstract void draw();
}
