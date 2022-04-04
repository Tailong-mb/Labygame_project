package com.labygame.demo.trayEnvironnement;

import com.labygame.demo.decor.*;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Wizard;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import static com.labygame.demo.scenes.GeneralScene.GAME_HEIGHT;
import static com.labygame.demo.scenes.GeneralScene.GAME_WIDTH;

@Getter
@Setter
public class GameTrayPiece {
    private Hero myHero;
    private Wizard myWizard;
    private Tree myTree;
    private Water myWater;
    private Trap myTrap;
    private Chest myChest;
    private Hedges myHedges;
    private ArrayList<Integer> myCoordinates;
    private boolean exitLeft;
    private boolean exitRight;
    private boolean exitUp;
    private boolean exitDown;

    public GameTrayPiece(Tree tree, Water water, Trap trap, Chest chest, Hedges hedges) {
    myCoordinates = new ArrayList<Integer>();

        if(tree != null) {
            myTree = tree;
            myCoordinates.add(myTree.getPositionX());
            myCoordinates.add(myTree.getPositionY());
            myCoordinates.add(myTree.getWIDTH());
            myCoordinates.add(myTree.getHEIGHT());
        }
        if(water != null) {
            myWater = water;
            myCoordinates.add(myWater.getPositionX());
            myCoordinates.add(myWater.getPositionY());
            myCoordinates.add(myWater.getWIDTH());
            myCoordinates.add(myWater.getHEIGHT());
        }
        if(trap != null) {
            myTrap = trap;
            myCoordinates.add(myTrap.getPositionX());
            myCoordinates.add(myTrap.getPositionY());
            myCoordinates.add(myTrap.getWIDTH());
            myCoordinates.add(myTrap.getHEIGHT());
        }
        if(chest != null) {
            myChest = chest;
            myCoordinates.add(myChest.getPositionX());
            myCoordinates.add(myChest.getPositionY());
            myCoordinates.add(myChest.getWIDTH());
            myCoordinates.add(myChest.getHEIGHT());
        }
        myHedges = hedges;
    }

    public void draw (GraphicsContext gc)
    {
        if(myTree != null)
            gc.drawImage(myTree.getMyImage(), 0, 0, myTree.getWIDTH(), myTree.getHEIGHT(), myTree.getPositionX(), myTree.getPositionY(), myTree.getWIDTH() * 3, myTree.getHEIGHT() * 3);
        if(myWater != null)
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    gc.drawImage(myWater.getMyImage(), 0, 0, myWater.getWIDTH(), myWater.getHEIGHT(), myWater.getPositionX()+myWater.getWIDTH()*2*i, myWater.getPositionY()+myWater.getHEIGHT()*2*j, myWater.getWIDTH() * 2, myWater.getHEIGHT() * 2);
            }
        if(myTrap != null && myTrap.isVisible())
            gc.drawImage(myTrap.getMyImage(), 0, 0, myTrap.getWIDTH(), myTrap.getHEIGHT(), myTrap.getPositionX(), myTrap.getPositionY(), myTrap.getWIDTH() * 2, myTrap.getHEIGHT() * 2);
        if(myChest != null && myChest.isVisible()) {
            if (!myChest.isOpened())
                gc.drawImage(myChest.getMyImage(), 0, 0, myChest.getWIDTH(), myChest.getHEIGHT(), myChest.getPositionX(), myChest.getPositionY(), myChest.getWIDTH(), myChest.getHEIGHT());
            else
                gc.drawImage(myChest.getMyImage(), myChest.getWIDTH() + 2, 0, myChest.getWIDTH(), myChest.getHEIGHT(), myChest.getPositionX(), myChest.getPositionY(), myChest.getWIDTH(), myChest.getHEIGHT());
        }
        //Horizontal hedges
        for(int i = 0; i < 12; i++)
            gc.drawImage(myHedges.getMyImage(),myHedges.getSpriteXHorizontal(), myHedges.getSpriteYHorizontal(), 100, 50, i*100, 0, 100, 50);
        for(int i = 0; i < 12; i++)
            gc.drawImage(myHedges.getMyImage(),myHedges.getSpriteXHorizontal(), myHedges.getSpriteYHorizontal(), 100, 50, i*100, GAME_HEIGHT - 50, 100, 50);
        //Vertival hedges
        for(int i = 0; i < 12; i++) {
            if (exitLeft) {
                if (i != 4 && i != 5)
                    gc.drawImage(myHedges.getMyImage(), myHedges.getSpriteXVertical(), myHedges.getSpriteYVertical(), 40, 120, 0, i * 80, 40, 120);
            } else {
                gc.drawImage(myHedges.getMyImage(), myHedges.getSpriteXVertical(), myHedges.getSpriteYVertical(), 40, 120, 0, i * 80, 40, 120);
            }
        }
        for(int i = 0; i < 12; i++) {
            if (exitRight) {
                if (i != 4 && i != 5)
                    gc.drawImage(myHedges.getMyImage(), myHedges.getSpriteXVertical(), myHedges.getSpriteYVertical(), 40, 120, GAME_WIDTH - 40, i * 80, 40, 120);
            } else {
                gc.drawImage(myHedges.getMyImage(), myHedges.getSpriteXVertical(), myHedges.getSpriteYVertical(), 40, 120, GAME_WIDTH - 40, i * 80, 40, 120);
            }
        }
    }
}
