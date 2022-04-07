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
        Chest theChest = new Chest();
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

        //Set the Key chest
        gameBoard[1][4] = new GameTrayPiece(myTree, myWater, myTrap, theChest, myHedges);
        gameBoard[1][4].getMyChest().setVisible(true);
        gameBoard[1][4].setExitUp(false);
        gameBoard[1][4].setExitDown(false);
        gameBoard[1][4].setExitRight(false);

        //Set all wall of the labyrinth
        //first lane
        gameBoard[2][0].setExitDown(false);
        gameBoard[4][0].setExitDown(false);

        //second lane
        gameBoard[0][1].setExitRight(false);
        gameBoard[0][1].setExitDown(false);
        gameBoard[1][1].setExitLeft(false);
        gameBoard[1][1].setExitRight(false);
        gameBoard[2][1].setExitRight(false);
        gameBoard[2][1].setExitLeft(false);
        gameBoard[2][1].setExitUp(false);
        gameBoard[3][1].setExitLeft(false);
        gameBoard[4][1].setExitUp(false);

        //third lane
        gameBoard[0][2].setExitUp(false);
        gameBoard[0][2].setExitRight(false);
        gameBoard[1][2].setExitLeft(false);
        gameBoard[2][2].setExitRight(false);
        gameBoard[3][2].setExitRight(false);
        gameBoard[3][2].setExitLeft(false);
        gameBoard[4][2].setExitLeft(false);
        gameBoard[4][2].setExitDown(false);

        //fourth lane
        gameBoard[1][3].setExitDown(false);
        gameBoard[2][3].setExitRight(false);
        gameBoard[3][3].setExitLeft(false);
        gameBoard[4][3].setExitUp(false);
        gameBoard[4][3].setExitDown(false);

        //fifth lane
        gameBoard[2][4].setExitLeft(false);
        gameBoard[4][4].setExitUp(false);
    }
}
