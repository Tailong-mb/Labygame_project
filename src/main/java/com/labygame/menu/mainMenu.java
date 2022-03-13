package com.labygame.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class mainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    GameMenu gameMenu;

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        root.setPrefSize(1200, 850);

        InputStream is = Files.newInputStream(Paths.get("doc/images/wallpaper/menu_wallpaper.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1200);
        imgView.setFitHeight(850);

        gameMenu = new GameMenu();

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}