package com.labygame.demo.trayEnvironnement;

import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import com.labygame.demo.personnage.Wizard;
import com.labygame.demo.trayEnvironnement.Decor.Trap;
import com.labygame.demo.trayEnvironnement.Decor.Tree;
import com.labygame.demo.trayEnvironnement.Decor.Water;

import java.util.Random;

public class gameTrayPiece {
    private Hero hero;
    private Monster monster;
    private Wizard wizard;
    private Tree tree;
    private Water water;
    private Trap trap;

    public gameTrayPiece(){
        Random rd = new Random();
    }
}
