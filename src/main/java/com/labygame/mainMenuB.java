package com.labygame;

import com.labygame.menu.GameMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainMenuB extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        root.setPrefSize(1200, 600);

        Image img = new Image("file:doc/images/wallpaper/mainMenu.jpg", 1200, 600, false, false);

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1200);
        imgView.setFitHeight(600);

        GameMenu gameMenu = new GameMenu();

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }



}