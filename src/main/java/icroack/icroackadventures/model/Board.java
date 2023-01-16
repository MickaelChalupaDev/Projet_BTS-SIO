/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.model;

/**
 *
 * @author FroggyTeam
 * Cette méthode génére le plateau de jeu, elle 
 * appele des éléments (square) de la classe Square
 * elle comprend 3 méthodes permettant de générer 
 * la liste des squares, de charger les images des squares
 * et dobtenir la taille du plateau
 */


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Board {



    private static int witdh;
    private static int height;

    static ArrayList<Square> squareList; // liste de cases
    static ArrayList<JLabel> labelList; // DÃ©claration de la collection de labels au nom labelList


    //constructeur
    public Board() {
        this.squareList=new ArrayList<Square>();
        this.labelList=new ArrayList<JLabel>();
    }

    public static ArrayList<Square> getSquareList() {
        return squareList;
    }

    public static void setSquareList(ArrayList<Square> squareList) {
        Board.squareList = squareList;
    }

    public static ArrayList<JLabel> getLabelList() {
        return labelList;
    }

    public static void setLabelList(ArrayList<JLabel> labelList) {
        Board.labelList = labelList;
    }


    // gives the width of the board
    public static int getWitdh() {
        return witdh;
    }

    public  void setWitdh(int width) {
        this.witdh = width;
    }
    // gives the height of the board
    public static int getHeight() {return height;}

    public void setHeight(int height) {
        this.height = height;
    }

    // use of a method to simulate a dice's roll
    public static int rollDice(){
        int x;

        x=1 + (int)(Math.random() * ((6 - 1) + 1));
        return x;
    }
    //generateur d'une liste de square statique (25 square)
    public void generateSquareList(Board b){
        Square s0 = new Square(0) ; // instance class Square, nouvel objet square(0) - 0 = Start
        s0.setSquarePosX(0);
        s0.setSquarePosY(0);
        s0.setSquareID(0);
        s0.setSquarePosXpix(263);
        s0.setSquarePosYpix(124);

        Square s1 = new Square(1);  // 1 = Normal
        s1.setSquarePosX(1);
        s1.setSquarePosY(0);
        s1.setSquareID(1);
        s1.setSquarePosXpix(353);
        s1.setSquarePosYpix(124);

        Square s2 = new Square(2);  // 2 = Bonus
        s2.setSquarePosX(2);
        s2.setSquarePosY(0);
        s2.setSquareID(2);
        s2.setSquarePosXpix(443);
        s0.setSquarePosYpix(124);

        Square s3 = new Square(3);  // 3 = Malus
        s3.setSquarePosX(3);
        s3.setSquarePosY(0);
        s3.setSquareID(3);
        s0.setSquarePosXpix(533);
        s0.setSquarePosYpix(124);

        Square s4 = new Square(1);  // 1 = Normal
        s4.setSquarePosX(4);
        s4.setSquarePosY(0);
        s4.setSquareID(4);
        s0.setSquarePosXpix(623);
        s0.setSquarePosYpix(124);

        Square s5 = new Square(4);  // 4 = Minigame
        s5.setSquarePosX(4);
        s5.setSquarePosY(1);
        s5.setSquareID(5);
        s0.setSquarePosXpix(623);
        s0.setSquarePosYpix(214);

        Square s6 = new Square(1);  // 1 = Normal
        s6.setSquarePosX(4);
        s6.setSquarePosY(2);
        s6.setSquareID(6);
        s0.setSquarePosXpix(623);
        s0.setSquarePosYpix(304);

        Square s7 = new Square(3);  // 3 = Malus
        s7.setSquarePosX(4);
        s7.setSquarePosY(3);
        s7.setSquareID(7);
        s0.setSquarePosXpix(623);
        s0.setSquarePosYpix(394);

        Square s8 = new Square(1);  // 1 = Normal
        s8.setSquarePosX(3);
        s8.setSquarePosY(3);
        s8.setSquareID(8);
        s0.setSquarePosXpix(533);
        s0.setSquarePosYpix(394);

        Square s9 = new Square(2);  // 2 = Bonus
        s9.setSquarePosX(2);
        s9.setSquarePosY(3);
        s9.setSquareID(9);
        s0.setSquarePosXpix(443);
        s0.setSquarePosYpix(394);

        Square s10 = new Square(1); // 1 = Normal
        s10.setSquarePosX(1);
        s10.setSquarePosY(3);
        s10.setSquareID(10);
        s0.setSquarePosXpix(353);
        s0.setSquarePosYpix(394);

        Square s11 = new Square(3); // 3 = Malus
        s11.setSquarePosX(0);
        s11.setSquarePosY(3);
        s11.setSquareID(11);
        s0.setSquarePosXpix(263);
        s0.setSquarePosYpix(394);

        Square s12 = new Square(4); // 4 = Minigame
        s12.setSquarePosX(0);
        s12.setSquarePosY(4);
        s12.setSquareID(12);
        s0.setSquarePosXpix(263);
        s0.setSquarePosYpix(484);

        Square s13 = new Square(2); // 2 = Bonus
        s13.setSquarePosX(0);
        s13.setSquarePosY(5);
        s13.setSquareID(13);
        s0.setSquarePosXpix(263);
        s0.setSquarePosYpix(574);

        Square s14 = new Square(1); // 1 = Normal
        s14.setSquarePosX(0);
        s14.setSquarePosY(6);
        s14.setSquareID(14);
        s0.setSquarePosXpix(263);
        s0.setSquarePosYpix(664);

        Square s15 = new Square(3); // 3 = Malus
        s15.setSquarePosX(1);
        s15.setSquarePosY(6);
        s15.setSquareID(15);
        s0.setSquarePosXpix(353);
        s0.setSquarePosYpix(664);

        Square s16 = new Square(1); // 1 = Normal
        s16.setSquarePosX(2);
        s16.setSquarePosY(6);
        s16.setSquareID(16);
        s0.setSquarePosXpix(443);
        s0.setSquarePosYpix(664);

        Square s17 = new Square(2); // 2 = Bonus
        s17.setSquarePosX(3);
        s17.setSquarePosY(6);
        s17.setSquareID(17);
        s0.setSquarePosXpix(533);
        s0.setSquarePosYpix(664);

        Square s18 = new Square(1); // 1 = Normal
        s18.setSquarePosX(4);
        s18.setSquarePosY(6);
        s18.setSquareID(18);
        s0.setSquarePosXpix(623);
        s0.setSquarePosYpix(664);

        Square s19 = new Square(4); // 4 = Minigame
        s19.setSquarePosX(5);
        s19.setSquarePosY(6);
        s19.setSquareID(19);
        s0.setSquarePosXpix(713);
        s0.setSquarePosYpix(664);

        Square s20 = new Square(1); // 1 = Normal
        s20.setSquarePosX(6);
        s20.setSquarePosY(6);
        s20.setSquareID(20);
        s0.setSquarePosXpix(803);
        s0.setSquarePosYpix(664);

        Square s21 = new Square(4); // 4 = Minigame
        s21.setSquarePosX(6);
        s21.setSquarePosY(5);
        s21.setSquareID(21);
        s0.setSquarePosXpix(803);
        s0.setSquarePosYpix(574);

        Square s22 = new Square(1); // 1 = Normal
        s22.setSquarePosX(6);
        s22.setSquarePosY(4);
        s22.setSquareID(22);
        s0.setSquarePosXpix(803);
        s0.setSquarePosYpix(484);

        Square s23 = new Square(3); // 3 = Malus
        s23.setSquarePosX(6);
        s23.setSquarePosY(3);
        s23.setSquareID(23);
        s0.setSquarePosXpix(803);
        s0.setSquarePosYpix(394);

        Square s24 = new Square(5); // instance de classe Square, nouvel objet square(5) - 5 = End
        s24.setSquarePosX(7);
        s24.setSquarePosY(3);
        s24.setSquareID(24);
        s0.setSquarePosXpix(893);
        s0.setSquarePosYpix(394);


        b.getSquareList().add(s0); //BoardPos 0,0 ; posListe : 0
        b.getSquareList().add(s1); //BoardPos 1,0 ; posListe : 1
        b.getSquareList().add(s2); //BoardPos 2,0 ; posListe : 2
        b.getSquareList().add(s3); //BoardPos 3,0 ; posListe : 3
        b.getSquareList().add(s4); // BoardPos 4,0 ; posListe : 4
        b.getSquareList().add(s5); // BoardPos 4,1 ; posListe : 5
        b.getSquareList().add(s6); //BoardPos 4,2 ; posListe : 6
        b.getSquareList().add(s7); //BoardPos 4,3 ; posListe : 7
        b.getSquareList().add(s8); //BoardPos 3,3 ; posListe : 8
        b.getSquareList().add(s9); //BoardPos 2,3 ; posListe : 9
        b.getSquareList().add(s10); //BoardPos 1;3 ; posListe : 10
        b.getSquareList().add(s11) ; //BoardPos 0;3 ; posListe : 11
        b.getSquareList().add(s12); //BoardPos O,4 ; posListe : 12
        b.getSquareList().add(s13) ; //BoardPos 0,5 ; posListe : 13
        b.getSquareList().add(s14) ; //Boardpos 0,6 ; posListe : 14
        b.getSquareList().add(s15); //Boardpos 1,6 ; posListe : 15
        b.getSquareList().add(s16); //Boardpos 2,6 ; posListe : 16
        b.getSquareList().add(s17); //Boardpos 3,6 ; posListe : 17
        b.getSquareList().add(s18); //Boardpos 4,6 ; posListe : 18
        b.getSquareList().add(s19); //Boardpos 5,6 ; posListe : 19
        b.getSquareList().add(s20); //Boardpos 6,6 ; posListe : 20
        b.getSquareList().add(s21); //Boardpos 6,5 ; posListe : 21
        b.getSquareList().add(s22); //Boardpos 6,4 ; posListe : 22
        b.getSquareList().add(s23) ; //Boardpos 6,3 ; posListe : 23
        b.getSquareList().add(s24); //Boardpos 7,3 ; posListe : 24
    }

    public void generateSquareIcons(Board b) throws IOException {
        /*   -----IMAGE NORMAL-----   */
        ImageIcon imageIconStart = new ImageIcon("resource/square90x90Start.png");

        /*   -----IMAGE END-----   */
        ImageIcon imageIconEnd = new ImageIcon("resource/square90x90End.png");

        /*   -----IMAGE NORMAL-----   */
        ImageIcon imageIconNormal = new ImageIcon("resource/square90x90Normal.png");

        /*   -----IMAGE MINIGAME-----   */
        ImageIcon imageIconMinigame = new ImageIcon("resource/square90x90Minigame.png");

        /*   -----IMAGE BONUS-----   */
        ImageIcon imageIconBonus = new ImageIcon("resource/square90x90Bonus.png");

        /*   -----IMAGE MALUS-----   */
        ImageIcon imageIconMalus = new ImageIcon("resource/square90x90Malus.png");

        for(int i=0; i<25; i++){
            b.getLabelList().add(new JLabel());
            switch (b.getSquareList().get(i).getSquareType()) {
                case 0 -> b.getLabelList().get(i).setIcon(imageIconStart);
                case 1 -> b.getLabelList().get(i).setIcon(imageIconNormal);
                case 2 -> b.getLabelList().get(i).setIcon(imageIconBonus);
                case 3 -> b.getLabelList().get(i).setIcon(imageIconMalus);
                case 4 -> b.getLabelList().get(i).setIcon(imageIconMinigame);
                case 5 -> b.getLabelList().get(i).setIcon(imageIconEnd);
            };
        }
    }

    public void setBoardHeight(Board b, double percent){
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screen = tool.getScreenSize();
        int screenHeight = screen.height;
        int screenWidth = screen.width;
        int newHeight = Math.toIntExact(Math.round(screenHeight * percent));
        b.setWitdh(screenWidth);
        b.setHeight(newHeight);
    }
}
