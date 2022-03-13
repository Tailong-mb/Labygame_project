package com.labygame.sound;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class musicPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(1200, 850);

        InputStream is = Files.newInputStream(Paths.get("doc/music/cover.png"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1200);
        imgView.setFitHeight(850);


        Media media = new Media(new File("file: doc/music/GamerInstincts.wav").toURI().toString());

        MediaPlayer mp = new MediaPlayer(media);

        mp.setAutoPlay(true);

        root.getChildren().add(imgView);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
