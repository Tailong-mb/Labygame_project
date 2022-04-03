package com.labygame.demo.trayEnvironnement;

import com.labygame.demo.decor.Chest;
import com.labygame.demo.items.Item;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import com.labygame.demo.personnage.Wizard;
import com.labygame.demo.decor.Trap;
import com.labygame.demo.decor.Tree;
import com.labygame.demo.decor.Water;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameTrayPiece {
    private Hero myHero;
    private Wizard myWizard;
    private Tree myTree;
    private Water myWater;
    private Trap myTrap;
    private Chest myChest;
    private ArrayList<Integer> myCoordinates;

    public GameTrayPiece(Tree tree, Water water, Trap trap, Chest chest) {
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
    }

    public void draw (GraphicsContext gc)
    {
        if(myTree != null)
            gc.drawImage(myTree.getMyImage(), 0, 0, myTree.getWIDTH(), myTree.getHEIGHT(), myTree.getPositionX(), myTree.getPositionY(), myTree.getWIDTH() * 3, myTree.getHEIGHT() * 3);
        if(myWater != null)
            gc.drawImage(myWater.getMyImage(), 0, 0, myWater.getWIDTH(), myWater.getHEIGHT(), myWater.getPositionX(), myWater.getPositionY(), myWater.getWIDTH() * 2, myChest.getHEIGHT() * 2);
        //if(myTrap != null)
            //gc.drawImage(myTrap.getMyImage(), 0, 0, myTrap.getWIDTH(), myTrap.getHEIGHT(), myTrap.getPositionX(), myTrap.getPositionY(), myTrap.getWIDTH() * 2, myTrap.getHEIGHT() * 2);
        if(myChest != null)
            gc.drawImage(myChest.getMyImage(), 0, 0, myChest.getWIDTH(), myChest.getHEIGHT(), myChest.getPositionX(), myChest.getPositionY(), myChest.getWIDTH(), myChest.getHEIGHT());
    }
}
