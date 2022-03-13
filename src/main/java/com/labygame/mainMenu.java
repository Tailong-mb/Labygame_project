package com.labygame;

import com.labygame.menu.GameMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class mainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(1332, 850);

        Image img = new Image("file: doc/images/wallpaper/menu_wallpaper.jpg");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1332);
        imgView.setFitHeight(850);

        GameMenu gameMenu = new GameMenu();

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}