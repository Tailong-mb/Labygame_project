package com.labygame.demo.button;

import com.labygame.demo.scenes.FightScene;
import com.labygame.items.Item;
import com.labygame.personnage.Hero;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ItemButtonLaby extends StackPane {

    public ItemButtonLaby(Item itemToUse, FightScene fightScene, Hero hero){
        //Initialisation Text
        Text myText  = new Text("USE");
        myText.setFont(Font.font(14));
        myText.setFill(Color.DARKBLUE);

        //Initialisation Button container
        Rectangle myContainer = new Rectangle(30, 27);
        myContainer.setOpacity(0.6);
        myContainer.setFill(Color.WHITE);
        myContainer.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER);
        setRotate(-0.5);
        getChildren().addAll(myContainer,myText);


        //Change color when mouse ont it
        setOnMouseEntered(event -> myContainer.setFill(Color.LIGHTGREY));

        setOnMouseExited(event -> myContainer.setFill(Color.WHITE));

        DropShadow drop = new DropShadow(50, Color.rgb(174, 174, 179));
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));

        //Event when Mouse Click
        setOnMouseClicked(event -> {
            if(hero.canUseItem(itemToUse))
                hero.useItem(itemToUse);
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5));
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();

            fightScene.gameDrawScene();
        });
    }
}

