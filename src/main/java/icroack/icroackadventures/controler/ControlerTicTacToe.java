package icroack.icroackadventures.controler;

import icroack.icroackadventures.view.ViewTicTacToe;

import java.io.IOException;

/**
 * @author FroggyTeam
 */

public class ControlerTicTacToe {
    ViewTicTacToe view ;

    public ControlerTicTacToe() throws IOException {
        this.view = new ViewTicTacToe();
        view.fenetre();
    }
}
