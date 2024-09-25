package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){
        this.setTitle("Sudokusolver");
        this.setSize(420,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //closes Programm when exit out from GUI
        this.setResizable(true);  //if it were false, window not resizable(default is true)
        this.setVisible(true);


        ImageIcon image = new ImageIcon("images/TUMLogo.png");
        this.setIconImage(image.getImage());  //change icon from java default Logo to TUM

        this.getContentPane().setBackground(Color.WHITE);
    }


    public static void main(String[] args) {
        //MyFrame myFrame = new MyFrame();
        ImageIcon logo = new ImageIcon("images/TUMLogo.png");

        ImageIcon zeroAsImage = new ImageIcon("images/ZeroTest.png");

        Border border = BorderFactory.createLineBorder(Color.green, 3);

        /**JLabels*/
        /**JLabel label = new JLabel();
        label.setText("Gelöstes Sudoku");
        label.setIcon(zeroAsImage);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.BLACK); //text color
        label.setFont(new Font("MV Boli", Font.ITALIC, 20)); //text font, including size
        label.setIconTextGap(10); //set Gap of text to image
        label.setBackground(Color.WHITE); //set backgroundColor
        label.setOpaque(true); //display background color
        label.setBorder(border); //lets you see the border of label
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);*/
        //label.setBounds(0,0, 1000, 1000); //set x,y position and dimensions

        //---for combination with JPanels
        JLabel label = new JLabel();
        label.setText("Hi");
        label.setForeground(Color.BLUE);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setIconTextGap(-30);
        label.setIcon(logo);

        /**JPanels*/
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0,0,250,250);
        redPanel.add(label);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);

        JFrame frame = new JFrame("SudokuTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null); //combined with setBounds
        frame.setIconImage(logo.getImage());
        frame.setVisible(true);
        //frame.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        //TODO how does pack affect JPanels
        //frame.pack(); //after adding components
    }
}
