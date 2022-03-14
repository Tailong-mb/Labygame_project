package com.labygame.menu;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class button extends StackPane {

    public button(String name) {

        //Initialisation Text
        Text myText  = new Text(name);
        myText.setFont(Font.font(20));
        myText.setFill(Color.rgb(72, 184, 250));

        //Initialisation button container
        Rectangle myContainer = new Rectangle(250, 30);
        myContainer.setOpacity(0.6);
        myContainer.setFill(Color.WHITE);
        myContainer.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER);
        setRotate(-0.5);
        getChildren().addAll(myContainer,myText);

        setOnMouseEntered(event -> {
            myContainer.setTranslateX(10);
            myText.setTranslateX(10);
            myContainer.setFill(Color.rgb(124, 212, 52));
            myText.setFill(Color.WHITE);
        });

        setOnMouseExited(event -> {
            myContainer.setTranslateX(0);
            myText.setTranslateX(0);
            myContainer.setFill(Color.WHITE);
            myText.setFill(Color.rgb(72, 184, 250));
        });

        DropShadow drop = new DropShadow(50, Color.rgb(174, 174, 179));
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));

    }
}
