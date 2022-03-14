package com.labygame.demo.scenes;

import com.labygame.personnage.Hero;
import com.labygame.personnage.Monster;
import com.labygame.personnage.Role;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        gc.setFont(myFontStats);

        //Draw BackGround
        gc.drawImage(backgroundImage,0,0);

        //Draw Hero Stats
        Image hpImage = new Image("file:doc/images/gfx/gfx/fightScene/hpImage.png");
        Image swordImage = new Image("file:doc/images/gfx/gfx/fightScene/swordnormal.png");
        Image statusImage = new Image("file:doc/images/gfx/gfx/fightScene/strenght.png");
        gc.drawImage(hpImage,20,50);
        gc.drawImage(swordImage,20,100);
        gc.drawImage(statusImage,20,150);

        gc.setFill(Color.WHITE);
        gc.fillText(String.format("%2d",hero.getHp()),65,75);
        gc.fillText(String.format("%d",hero.getPower()),65,122);
        gc.fillText(hero.getCurrentStatus().getNameState(),65,175);
        gc.fillText(hero.getName(), 170,350);

        //Draw opponent Stats
        gc.drawImage(hpImage,1135,50);
        gc.drawImage(swordImage,1135,100);
        gc.drawImage(statusImage,1135,150);

        gc.fillText(String.format("%2d",opponent.getHp()),1095,75);
        gc.fillText(String.format("%d",opponent.getPower()),1095,122);
        gc.fillText(opponent.getCurrentStatus().getNameState(),1020,175);
        gc.fillText(opponent.getName(),960,350);

        //Draw Monster
        if(opponent instanceof Monster){
            ArrayList<String> possibleMonsterList = new ArrayList<>(List.of(
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/chainBeast.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/dracomachina.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/eelWielder.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/fishbone.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/shredSquid.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/strangeGhost.png"));

            Random myRandom = new Random();
            int randomPath = myRandom.nextInt(6);
            Image monsterImage = new Image(possibleMonsterList.get(randomPath));
            gc.drawImage(monsterImage,950,450);
        }else{
            //draw wizard
            Image wizardImage = new Image("file:doc/images/gfx/gfx/fightScene/wizardRdyToFight.png");
            gc.drawImage(wizardImage,900,390);
        }

        //Draw Hero
        Image myHero = new Image("file:doc/images/gfx/gfx/fightScene/heroRdyToFight.png");
        gc.drawImage(myHero,-100,275);
    }
}
