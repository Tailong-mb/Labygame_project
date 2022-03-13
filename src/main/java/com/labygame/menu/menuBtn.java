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

public class menuBtn extends StackPane {

    Text txt;

    public menuBtn(String name) {

        txt = new Text(name);
        txt.setFont(Font.font(20));
        txt.setFill(Color.rgb(155,105,70));

        Rectangle r = new Rectangle(250, 30);
        r.setOpacity(0.6);
        r.setFill(Color.WHITE);
        r.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER);
        setRotate(-0.5);
        getChildren().addAll(r, txt);

        setOnMouseEntered(event -> {
            r.setTranslateX(10);
            txt.setTranslateX(10);
            r.setFill(Color.BLACK);
            txt.setFill(Color.WHITE);
        });

        setOnMouseExited(event -> {
            r.setTranslateX(0);
            txt.setTranslateX(0);
            r.setFill(Color.WHITE);
            txt.setFill(Color.rgb(155,105,70));
        });

        DropShadow drop = new DropShadow(50, Color.rgb(174, 174, 179));
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));

    }
}
