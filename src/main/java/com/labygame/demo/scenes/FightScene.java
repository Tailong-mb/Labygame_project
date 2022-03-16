package com.labygame.demo.scenes;

import com.labygame.demo.button.ItemButtonLaby;
import com.labygame.demo.button.StandardButtonLaby;
import com.labygame.items.Item;
import com.labygame.personnage.Hero;
import com.labygame.personnage.Monster;
import com.labygame.personnage.Role;
import com.labygame.personnage.Wizard;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Setter
@Getter
public class FightScene extends GeneralScene{

    private Hero hero;
    private Role opponent;
    private Image backgroundImage;
    private int typeMonster;

    private final String PATH_BACKGROUND_IMAGE = "file:doc/images/gfx/gfx/fightScene/backgroundFightScene.png";

    public FightScene(Hero hero, Role opponent){
        super();
        this.hero = hero;
        this.opponent = opponent;
        this.backgroundImage = new Image(PATH_BACKGROUND_IMAGE);
        Random myRand = new Random();
        typeMonster = myRand.nextInt(6);
    }

    //No args constructor
    public FightScene(){
        super();
        this.backgroundImage = new Image(PATH_BACKGROUND_IMAGE);
    }

    @Override
    public void draw() {
        //Reset Key
        activeKeys.clear();

        gameDrawScene();

        if(opponent instanceof Monster)
            gameChoiceMonster();
        else
            gameChoiceWizard((Wizard) opponent);
    }

    public void gameChoiceMonster(){
        StandardButtonLaby buttonNormalAttack = new StandardButtonLaby("NORMAL ATTACK");
        buttonNormalAttack.buttonAttackAnimation(false,hero,opponent,this);

        StandardButtonLaby buttonSpecialAttack = new StandardButtonLaby("SPECIAL ATTACK");
        buttonSpecialAttack.buttonAttackAnimation(true,hero,opponent,this);

        HBox containerButtonAttack = new HBox(buttonNormalAttack,buttonSpecialAttack);
        containerButtonAttack.setSpacing(200);
        containerButtonAttack.setTranslateX(250);
        containerButtonAttack.setTranslateY(250);

        root.getChildren().addAll(containerButtonAttack);
        this.setRoot(root);
    }

    public void gameChoiceWizard(@NotNull Wizard opponent){
        //Textquesiton
        Text myText  = new Text(opponent.askQuestion());
        myText.setFont(Font.font(20));
        myText.setFill(Color.BLACK);

        //TextRectangleContainer
        Rectangle myContainerQuestion = new Rectangle(opponent.getCurrentRiddle().getRid().length()*8.5, 30);
        myContainerQuestion.setOpacity(0.6);
        myContainerQuestion.setFill(Color.WHITE);
        myContainerQuestion.setEffect(new GaussianBlur(3.5));

        //TextContainer
        StackPane questionPane = new StackPane();
        questionPane.getChildren().addAll(myContainerQuestion,myText);
        questionPane.setMaxWidth(800);
        questionPane.setMaxHeight(80);
        questionPane.setTranslateY(-250);

        //TextAnswer
        TextField answerToRiddle = new TextField();
        answerToRiddle.setFont(Font.font(15));
        answerToRiddle.setMaxWidth(300);
        answerToRiddle.setTranslateX(0);
        answerToRiddle.setTranslateY(225);
        questionPane.setMaxHeight(80);


        root.getChildren().addAll(questionPane,answerToRiddle);
        this.setRoot(root);

    }

    /**
     * Draw the game Scene.
     */
    public void gameDrawScene(){
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

        //Draw Monster
        if(opponent instanceof Monster){
            ArrayList<String> possibleMonsterList = new ArrayList<>(List.of(
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/chainBeast.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/dracomachina.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/eelWielder.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/fishbone.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/shredSquid.png",
                    "file:doc/images/gfx/gfx/fightScene/extraCreatures/strangeGhost.png"));

            Image monsterImage = new Image(possibleMonsterList.get(typeMonster));
            gc.drawImage(monsterImage,950,450);
            gc.fillText(opponent.getName(),975,425);
        }else{
            //draw wizard
            Image wizardImage = new Image("file:doc/images/gfx/gfx/fightScene/wizardRdyToFight.png");
            gc.drawImage(wizardImage,900,390);
            gc.fillText(opponent.getName(),960,350);
        }

        //Draw Hero
        Image myHero = new Image("file:doc/images/gfx/gfx/fightScene/heroRdyToFight.png");
        gc.drawImage(myHero,-100,275);

        //Draw item Hero Image
        Image healPotionImage = new Image("file:doc/images/gfx/gfx/item/hpPotion.png");
        gc.drawImage(healPotionImage,20,775);

        Image antidotePotionImage = new Image("file:doc/images/gfx/gfx/item/antidotePotion.png");
        gc.drawImage(antidotePotionImage,20,740);

        Image energyDrinkPotionImage = new Image("file:doc/images/gfx/gfx/item/energyDrinkPotion.png");
        gc.drawImage(energyDrinkPotionImage,20,705);

        //Draw item stats
        myFontStats = Font.font("Arial", FontWeight.BOLD, 17);
        gc.setFont(myFontStats);
        gc.setFill(Color.WHITE);
        //Search all values
        ArrayList<Integer> numberOfItem = new ArrayList<>();
        ArrayList<Item> itemType = new ArrayList<>();
        for(Map.Entry<Item,Integer> entry: hero.getMyItem().entrySet()){
            numberOfItem.add(entry.getValue());
            itemType.add(entry.getKey());
        }

        //Print all values
        int yPositionItemNumber = 792;
        for(int i = 0; i < 3;i++){
            gc.fillText(String.format("= %d",numberOfItem.get(i)),50,yPositionItemNumber);
            yPositionItemNumber -= 35;
        }

        ItemButtonLaby healUseButton = new ItemButtonLaby(itemType.get(2),this,hero);
        ItemButtonLaby antidoteUseButton = new ItemButtonLaby(itemType.get(1),this,hero);
        ItemButtonLaby energyDrinkUseButton = new ItemButtonLaby(itemType.get(0),this,hero);
        VBox itemUseBox = new VBox(healUseButton,antidoteUseButton,energyDrinkUseButton);
        itemUseBox.setSpacing(8);
        itemUseBox.setTranslateX(-495);
        itemUseBox.setTranslateY(675);

        root.getChildren().addAll(itemUseBox);
        this.setRoot(root);
    }
}
