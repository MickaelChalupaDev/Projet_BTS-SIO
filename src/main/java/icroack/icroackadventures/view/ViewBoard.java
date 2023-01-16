/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.view;

/**
 *
 * @author FroggyTeam
 */

import icroack.icroackadventures.model.Board;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ViewBoard extends JPanel {
    
    public ViewBoard() throws IOException {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight=1;
        gbc.gridwidth=1;
        Board b=new Board();
        b.generateSquareList(b);
        b.generateSquareIcons(b);
        double percent=0.8;
        b.setBoardHeight(b,percent);
        Dimension bDim=new Dimension(b.getWitdh(),b.getHeight());
        this.setPreferredSize(bDim);
        for(int i=0;i<25;i++){
            gbc.gridx=b.getSquareList().get(i).getSquarePosX();
            gbc.gridy=b.getSquareList().get(i).getSquarePosY();
            this.add(b.getLabelList().get(i),gbc);
        }
    }
}


