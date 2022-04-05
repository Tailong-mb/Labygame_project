package com.labygame.trayEnvironnement;

import com.labygame.decor.*;
import lombok.Getter;

@Getter
public class GameTray {

    private final GameTrayPiece[][] gameBoard;

    //Constructor
    public GameTray(){
        Tree myTree = new Tree(900, 200);
        Trap myTrap = new Trap(true);
        Water myWater = new Water(50, 600);
        Chest myChest = new Chest();
        Chest secondChest = new Chest();
        Hedges myHedges = new Hedges();
        gameBoard = new GameTrayPiece[5][5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++) {
                gameBoard[i][j] = new GameTrayPiece(myTree, myWater, myTrap, myChest, myHedges);
                gameBoard[i][j].setExitUp(true);
                gameBoard[i][j].setExitDown(true);
                gameBoard[i][j].setExitLeft(true);
                gameBoard[i][j].setExitRight(true);
            }
        }
        gameBoard[1][0] = new GameTrayPiece(myTree, myWater, myTrap, secondChest, myHedges);
        gameBoard[0][0].setExitLeft(false);
        gameBoard[0][0].setExitUp(false);
        gameBoard[0][0].setExitDown(false);
        gameBoard[0][0].getMyChest().setVisible(true);
        gameBoard[1][0].getMyChest().setVisible(false);
        gameBoard[1][0].setExitRight(false);
        gameBoard[1][0].setExitUp(false);
        gameBoard[1][0].setExitLeft(true);
        gameBoard[1][0].setExitDown(false);
    }
}
