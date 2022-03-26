package com.labygame.demo.trayEnvironnement.gameTrayPieces;

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
public abstract class gameTrayPieceGeneral {
    private Hero myHero;
    private Monster myMonster;
    private Wizard myWizard;
    private Tree myTree;
    private Water myWater;
    private Trap myTrap;

    public abstract void draw(GraphicsContext gc);
}
