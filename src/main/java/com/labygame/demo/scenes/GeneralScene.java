package com.labygame.demo.scenes;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import java.util.HashSet;
import java.util.Set;

public abstract class GeneralScene extends Scene {
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 600;

    protected GraphicsContext gc;
    protected Set<KeyCode> activeKeys;
    protected Set<KeyCode> releasedKeys;

    public GeneralScene() {
        super(new StackPane(), GAME_WIDTH, GAME_HEIGHT);
        StackPane root = new StackPane();
        this.setRoot(root);

        Canvas canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        activeKeys = new HashSet<>();
        releasedKeys = new HashSet<>();
        this.setOnKeyPressed(e ->{
            activeKeys.add(e.getCode());
        });
        this.setOnKeyReleased(e ->{
            activeKeys.remove(e.getCode());
            releasedKeys.add(e.getCode());
        });
    }

    public abstract void draw();
}