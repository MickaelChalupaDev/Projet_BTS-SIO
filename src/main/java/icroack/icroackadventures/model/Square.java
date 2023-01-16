/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

/**
 *
 * @author FroggyTeam
 * Cette classe permet d'afficher l'image définie pour la square en 
 * fonction d'un entier qui sera donné dans la classe Board
 */
import java.awt.*;

public class Square {

    Dimension squareDimension;
    int squarePosX;
    int squarePosY;

    int squareType;
    int squareID;

    int squarePosXpix;
    int squarePosYpix;

    Square(int type) {
        //INT INPUT => TYPE & IMAGE OF THE SQUARE
        //TYPE 0 => START
        //TYPE 1 => NORMAL
        //TYPE 2 => BONUS
        //TYPE 3 => MALUS
        //TYPE 4 => MINI-GAME
        //TYPE 5 => END
        this.squareType=type;
        //DEFAULT DIMENSION OF THE SQUARE
        this.squareDimension=new Dimension(100, 100);
        //DEFAULT POSITION OF THE SQUARE
        this.squarePosX=0;
        this.squarePosY=0;
        this.squarePosXpix = 0;
        this.squarePosY = 0;
        this.squareID=0;
    }

    public int getSquareID() {
        return squareID;
    }

    public void setSquareID(int squareID) {
        this.squareID = squareID;
    }

    public int getSquarePosX() {
        return squarePosX;
    }

    public void setSquarePosX(int squarePosX) {
        this.squarePosX = squarePosX;
    }

    public int getSquarePosY() {
        return squarePosY;
    }

    public void setSquarePosY(int squarePosY) {
        this.squarePosY = squarePosY;
    }

    public Dimension getSquareDimension() {
        return squareDimension;
    }

    public void setSquareDimension(Dimension squareDimension) {
        this.squareDimension = squareDimension;
    }

    public int getSquareType() {
        return squareType;
    }

    public int getSquarePosXpix() {return squarePosXpix;}

    public void setSquarePosXpix(int squarePosXpix) {this.squarePosXpix = squarePosXpix;}

    public int getSquarePosYpix() {return squarePosYpix;}

    public void setSquarePosYpix(int squarePosYpix) {this.squarePosYpix = squarePosYpix;}

    public void setSquareType(int squareType){
        //INT INPUT => TYPE OF THE SQUARE :
        //TYPE OF SQUARE IS SET TO FALSE BY DEFAULT

        switch (squareType) {
            case 0 -> this.squareType=0;
            case 1 -> this.squareType=1;
            case 2 -> this.squareType=2;
            case 3 -> this.squareType=3;
            case 4 -> this.squareType=4;
            case 5 -> this.squareType=5;
        }
    }

}
