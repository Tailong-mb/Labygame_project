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
        secondChest.setVisible(false);
        Hedges myHedges = new Hedges();
        gameBoard = new GameTrayPiece[5][5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++) {
                gameBoard[i][j] = new GameTrayPiece(myTree, myWater, myTrap, secondChest, myHedges);
                if(i==0)
                    gameBoard[i][j].setExitLeft(false);
                if(i==4)
                    gameBoard[i][j].setExitRight(false);
                if(j==0)
                    gameBoard[i][j].setExitUp(false);
                if(j==4)
                    gameBoard[i][j].setExitDown(false);
            }
        }
        gameBoard[0][0] = new GameTrayPiece(myTree, myWater, myTrap, myChest, myHedges);
        gameBoard[0][0].getMyChest().setVisible(true);
        gameBoard[0][0].setExitUp(false);
        gameBoard[0][0].setExitLeft(false);

        gameBoard[4][3].setExitRight(true);
    }
}
