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
        }
        if(water != null) {
            myWater = water;
            myCoordinates.add(myWater.getPositionX());
            myCoordinates.add(myWater.getPositionY());
        }
        if(trap != null) {
            myTrap = trap;
            myCoordinates.add(myTrap.getPositionX());
            myCoordinates.add(myTrap.getPositionY());
        }
        if(chest != null) {
            myChest = chest;
            myCoordinates.add(myChest.getPositionX());
            myCoordinates.add(myChest.getPositionY());
        }
    }

    public void draw (GraphicsContext gc)
    {
        gc.drawImage(myTree.getMyImage(), myTree.getPositionX(), myTree.getPositionY());
        gc.drawImage(myWater.getMyImage(), myWater.getPositionX(), myWater.getPositionY());
        //gc.drawImage(myTrap.getMyImage(), myTrap.getPositionX(), myTrap.getPositionY());
        gc.drawImage(myChest.getMyImage(), myChest.getPositionX(), myChest.getPositionY());
    }
}
