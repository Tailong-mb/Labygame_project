package com.labygame.demo.trayEnvironnement;

import com.labygame.demo.decor.Chest;
import com.labygame.demo.decor.Trap;
import com.labygame.demo.decor.Tree;
import com.labygame.demo.decor.Water;
import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Monster;
import com.labygame.demo.personnage.Wizard;
import lombok.Getter;

@Getter
public class GameTray {

    private GameTrayPiece[][] gameBoard;

    //Constructor
    public GameTray(){
        //Wizard myWizard = new Wizard(30,CharacterState.NORMAL,"merlin", 50,1000,350);
        Tree myTree = new Tree(900, 200);
        Trap myTrap = new Trap(true);
        Water myWater = new Water(200, 600);
        Chest myChest = new Chest();
        gameBoard = new GameTrayPiece[5][5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
                gameBoard[i][j] = new GameTrayPiece(myTree, myWater, myTrap, myChest);
        }
        gameBoard[1][0] = new GameTrayPiece(null,myWater,myTrap,myChest);
    }
}
