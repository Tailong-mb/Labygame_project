package com.labygame.front.scenes;

import com.labygame.front.Labygame;
import com.labygame.front.button.ItemButton;
import com.labygame.front.button.StandardButtonMenu;
import com.labygame.items.Item;
import com.labygame.personnage.Hero;
import com.labygame.personnage.Monster;
import com.labygame.personnage.Role;
import com.labygame.personnage.Wizard;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.animation.FadeTransition;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
public class FightScene extends GeneralScene{

    private Role opponent;
    private Image backgroundImage;
    private int typeMonster;
    private int lastHpHero;
    private int lastHpOpponent;

    private final Music music = new Music(MusicType.FIGHT);
    private final String PATH_BACKGROUND_IMAGE = "file:doc/images/gfx/gfx/fightScene/backgroundFightScene.png";

    public FightScene(Hero hero, Role opponent){
        super();
        this.hero = hero;
        this.opponent = opponent;
        this.backgroundImage = new Image(PATH_BACKGROUND_IMAGE);
        Random myRand = new Random();
        typeMonster = myRand.nextInt(6);
        this.lastHpHero = hero.getHp();
        this.lastHpOpponent = opponent.getHp();
    }

    @Override
    public void draw() {
        //Reset Key
        activeKeys.clear();
        music.playMusic();

        //Draw Scene
        gameDrawScene();

        //The scene changes according to the type of opponent
        if(opponent instanceof Monster)
            gameChoiceMonster();
        else
            gameChoiceWizard((Wizard)opponent);
    }

    /**
     * Interface when the hero fight a Monster
     */
    public void gameChoiceMonster(){
        //Set Button attackChoice
        StandardButtonMenu buttonNormalAttack = new StandardButtonMenu("NORMAL ATTACK");
        buttonNormalAttack.buttonAttackAnimation(false,hero,opponent,this);

        StandardButtonMenu buttonSpecialAttack = new StandardButtonMenu("SPECIAL ATTACK");
        buttonSpecialAttack.buttonAttackAnimation(true,hero,opponent,this);

        HBox containerButtonAttack = new HBox(buttonNormalAttack,buttonSpecialAttack);
        containerButtonAttack.setSpacing(200);
        containerButtonAttack.setTranslateX(250);
        containerButtonAttack.setTranslateY(250);

        root.getChildren().addAll(containerButtonAttack);
        this.setRoot(root);
    }

    /**
     * Set the interface when the hero face a wizard
     * @param opponent a wizard.
     */
    public void gameChoiceWizard(Wizard opponent){
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

        answerToRiddle.setOnKeyPressed( event -> {
            //when he validates his answer
            if (event.getCode() == KeyCode.ENTER) {
                //Check the answer
                if(opponent.ansVerification(answerToRiddle.getText())){
                    //If he won change scene
                    Labygame.setScene(Labygame.GAME_SCENE);
                } else{
                    //If the answer is bad the wizard hit him
                    Random rand = new Random();
                    if(rand.nextBoolean())
                        opponent.basicAttack(hero);
                    else
                        opponent.secretAttack(hero);
                }
            }
            this.gameDrawScene();
        });

        root.getChildren().addAll(questionPane,answerToRiddle);
        this.setRoot(root);
    }

    /**
     * Draw the game Scene.
     */
    public void gameDrawScene(){
        showDamage();
        //Check if one of the character is dead
        if(hero.isDead() || hero.getPower() <= 0) {
            Labygame.setScene(Labygame.GAME_OVER_SCENE);
            music.stopMusic();
        }
        else if(opponent.isDead()) {
            hero.setHp(hero.getHp() + 20);
            hero.setPower(hero.getPower() + 5);
            Labygame.setScene(Labygame.GAME_SCENE);
            music.stopMusic();
        }

        //Set new font
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
        gc.drawImage(healPotionImage,20,740);

        Image antidotePotionImage = new Image("file:doc/images/gfx/gfx/item/antidotePotion.png");
        gc.drawImage(antidotePotionImage,20,710);

        Image energyDrinkPotionImage = new Image("file:doc/images/gfx/gfx/item/energyDrinkPotion.png");
        gc.drawImage(energyDrinkPotionImage,20,675);

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
        int yPositionItemNumber = 762;
        for(int i = 0; i < 3;i++){
            gc.fillText(String.format("= %d",numberOfItem.get(i)),50,yPositionItemNumber);
            yPositionItemNumber -= 35;
        }

        //Draw Button to use potion (Heal/Antidote/EnergyDrink)
        ItemButton healUseButton = new ItemButton(itemType.get(2),this,hero);
        ItemButton antidoteUseButton = new ItemButton(itemType.get(1),this,hero);
        ItemButton energyDrinkUseButton = new ItemButton(itemType.get(0),this,hero);
        VBox itemUseBox = new VBox(healUseButton,antidoteUseButton,energyDrinkUseButton);
        itemUseBox.setSpacing(8);
        itemUseBox.setTranslateX(-495);
        itemUseBox.setTranslateY(675);

        root.getChildren().addAll(itemUseBox);
        this.setRoot(root);
    }

    /**
     * Draw damage with faded event
     */
    public void showDamage(){
        int heroDamage = hero.getHp() - lastHpHero;
        int opponentDamage = opponent.getHp() - lastHpOpponent;
        lastHpHero = hero.getHp();
        lastHpOpponent = opponent.getHp();
        if((heroDamage != 0) || (opponentDamage != 0)){
            //Initialisation text for hero value
            Text textDamageHero  = new Text(Integer.toString(heroDamage));
            textDamageHero.setFont(Font.font("Arial",FontWeight.BOLD,30));
            textDamageHero.setTranslateX(-300);

            //Initialisation text for opponent value
            Text textDamageOpponent = new Text(Integer.toString(opponentDamage));
            textDamageOpponent.setFont(Font.font("Arial",FontWeight.BOLD,30));
            textDamageOpponent.setTranslateX(300);
            textDamageOpponent.setTranslateY(20);

            //Text will be green if the value is positive otherwise red
            if(heroDamage >= 0) {
                textDamageHero.setFill(Color.GREEN);
                textDamageHero.setText("+" + heroDamage);
            }
            else
                textDamageHero.setFill(Color.RED);

            if(opponentDamage >= 0)
                textDamageOpponent.setFill(Color.GREEN);
            else
                textDamageOpponent.setFill(Color.RED);

            transitionDamage(textDamageHero);
            transitionDamage(textDamageOpponent);

            root.getChildren().addAll(textDamageHero,textDamageOpponent);
            this.setRoot(root);
        }
    }

    /**
     * Fade Transition for a text
     * @param myText the text to show
     */
    public void transitionDamage(Text myText){
        FadeTransition ft = new FadeTransition(Duration.seconds(2), myText);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
    }
}

