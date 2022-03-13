package com.labygame.demo;

import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 850;
    protected GraphicsContext gc;

    private MainCharacter hero;

    @Override
    public void start(Stage stage) throws IOException {
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        Hero myHero = new Hero(50,CharacterState.NORMAL,"Bam", 20, 50, 50);

        Image heroImg = myHero.getMyImage();


        //hero = new MainCharacter(16,30);
        Pane root = new Pane();
        Canvas canvas = new Canvas(GAME_WIDTH,GAME_HEIGHT);

        root.getChildren().addAll(new ImageView(heroImg), canvas);
        gc = canvas.getGraphicsContext2D();

        gc.drawImage(heroImg,0,0,16,30,250,250,32,60);

        Scene heroScene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        stage.setTitle(myMonster.getName());
        stage.setScene(heroScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}