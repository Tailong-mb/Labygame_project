package com.labygame.demo.trayEnvironnement;

import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import com.labygame.demo.personnage.Wizard;
import com.labygame.demo.trayEnvironnement.Decor.Trap;
import com.labygame.demo.trayEnvironnement.Decor.Tree;
import com.labygame.demo.trayEnvironnement.Decor.Water;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class gameTrayPiece {
    private Hero myHero;
    private Monster myMonster;
    private Wizard myWizard;
    private Tree myTree;
    private Water myWater;
    private Trap myTrap;

    public gameTrayPiece(){

    }

    public void draw(GraphicsContext gc){
        gc.drawImage(myMonster.getMyImages()[0], myMonster.getPositionX(), myMonster.getPositionY());
        gc.drawImage(myWizard.getMyImage(), myWizard.getPositionX(), myWizard.getPositionY());
        gc.drawImage(myTree.getMyImage(), myTree.getPositionX(), myTree.getPositionY());
        gc.drawImage(myWater.getMyImage(), myWater.getPositionX(), myWater.getPositionY());
        //gc.drawImage(myTrap.getMyImage(), myTrap.getPositionX(), myTrap.getPositionY());
    }
}
