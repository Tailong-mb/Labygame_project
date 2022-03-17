package com.labygame.menu;

import com.labygame.sound.Music;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class menuInGame extends Application {

    GMenu gameMenu;
    Music music;

    @Override
    public void start(Stage stage) throws Exception {

        music.playMusic();

        Pane root = new Pane();
        root.setPrefSize(1200, 850);

        InputStream is = Files.newInputStream(Paths.get("doc/images/wallpaper/background_menuInGame.png"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1200);
        imgView.setFitHeight(850);

        gameMenu = new GMenu();
        gameMenu.setVisible(false);

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                if(!gameMenu.isVisible()){
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    ft.setFromValue(0);
                    ft.setToValue(1);

                    gameMenu.setVisible(true);
                    ft.play();
                }else{
                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5),gameMenu);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt -> gameMenu.setVisible(false));
                    ft.play();
                }
            }
        });

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
