package com.labygame.demo.scenes;

import com.labygame.personnage.Hero;
import com.labygame.personnage.Role;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FightScene extends GeneralScene{

    private Hero hero;
    private Role opponent;
    private Image backgroundImage;

    private final String PATH_BACKGROUND_IMAGE = "file:doc/images/gfx/gfx/fightScene/backgroundFightScene.png";

    public FightScene(Hero hero, Role opponent){
        super();
        this.hero = hero;
        this.opponent = opponent;
        this.backgroundImage = new Image(PATH_BACKGROUND_IMAGE);
    }

    public FightScene(){
        super();
        this.backgroundImage = new Image(PATH_BACKGROUND_IMAGE);
    }

    @Override
    public void draw() {
        //Reset Key
        activeKeys.clear();

        //Init Font
        Font myFontStats = Font.font("Arial", FontWeight.BOLD, 24);

        //Draw BackGround
        gc.drawImage(backgroundImage,0,0);

        //Draw Hero Stats
        Image hpImage = new Image("file:doc/images/gfx/gfx/fightScene/hpImage.png");
        Image swordImage = new Image("file:doc/images/gfx/gfx/fightScene/swordnormal.png");
        gc.drawImage(hpImage,20,50);
        gc.drawImage(swordImage,20,100);

        gc.setFont(myFontStats);
        gc.setFill(Color.WHITE);
        gc.fillText(String.format("%2d",hero.getHp()),65,75);
        gc.fillText(String.format("%d",hero.getPower()),65,122);

    }
}
