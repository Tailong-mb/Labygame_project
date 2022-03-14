package com.labygame.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Plaque extends Application {
    @Override
    public void start(Stage stage){
        Pane racine = new Pane();
        Rectangle rectBorder = new Rectangle(10, 10, 330,50);
        Rectangle rectL = new Rectangle(10, 10, 20, 50);
        Rectangle rectR = new Rectangle(320, 10, 20, 50);

        rectBorder.setStroke(Color.BLACK);
        rectBorder.setStrokeWidth(0.2);
        rectBorder.setFill(Color.WHITE);
        rectL.setFill(Color.BLUE);
        rectR.setFill(Color.BLUE);

        Text txtPlaque = new Text("AB-123-CD");
        txtPlaque.setFont(Font.font("Official", FontWeight.BOLD, 50));
        txtPlaque.setX(40);
        txtPlaque.setY(53);

        Text txtFrance = new Text("F");
        txtFrance.setFont(Font.font("Official", 20));
        txtFrance.setX(15);
        txtFrance.setY(55);
        txtFrance.setFill(Color.WHITE);

        Text txtRegion = new Text("54");
        txtRegion.setFont(Font.font("Official", 18));
        txtRegion.setX(320);
        txtRegion.setY(52);
        txtRegion.setFill(Color.WHITE);

        racine.getChildren().addAll(rectBorder, rectL, rectR, txtPlaque, txtFrance, txtRegion);

        Scene scene = new Scene(racine, 350, 100);

        stage.setScene(scene);
        stage.setTitle("Plaque d'immatriculation");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
