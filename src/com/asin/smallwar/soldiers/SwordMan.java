package com.asin.smallwar.soldiers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SwordMan extends Soldier{

    private int walkNum;

    private ImageIcon[][] walkingImage = new ImageIcon[2][3];

    public SwordMan(int side, Position pos, Stack<Position> targetRoad) {
        super(side,pos,targetRoad);
        this.setLife(100);
        this.setCast(4);
        this.setAttack(10);
        this.setAttackRange(2);
        this.setFindRange(8);
        this.setSpeed(2);
        this.setAttackSpeed(4);
        this.walkNum = 2;
        initSideDirectImage();
    }

    @Override
    public ImageIcon getWalkImage() {
        this.walkNum = (++this.walkNum)%15;

        if(this.getDirect()<5){
            return walkingImage[0][walkNum/5];
        }else{
            return walkingImage[1][walkNum/5];
        }
    }

    @Override
    public ImageIcon getAttackImage() {
        return new ImageIcon(SwordMan.class.getResource("soldier1.png"));
    }

    @Override
    public ImageIcon getDieImage() {
        return null;
    }

    @Override
    public Soldier searchEnemy() {
        return null;
    }

    @Override
    public void attackEnemy(Soldier soldier) {

    }

    @Override
    public void initSideDirectImage() {
        List<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(SwordMan.class.getResource("swordManWalking0.png")));
            imageList.add(ImageIO.read(SwordMan.class.getResource("swordManWalking1.png")));
            imageList.add(ImageIO.read(SwordMan.class.getResource("swordManWalking2.png")));
            if(this.getSide()==1){
                for (BufferedImage image:imageList) {
                    int k;
                    for (int i = 0; i < image.getHeight(); i++) {
                        for (int j = 0; j < image.getWidth(); j++) {//ÐÐÉ¨Ãè
                            k = image.getRGB(i, j);
                            if(k==-2877152){
                                image.setRGB(i,j,-13024840);
                            }
                        }
                    }
                }
            }
            int k = 0;
            for (BufferedImage image:imageList) {
                walkingImage[0][k] = new ImageIcon(image);
                int height = image.getHeight();
                int width = image.getWidth();
                BufferedImage flipImage = new BufferedImage(width,height,image.getType());
                for (int i = 0; i < height; i++) {
                    int start = 0;
                    int end = width-1;
                    while(start<end){
                        flipImage.setRGB(start,i,image.getRGB(end, i));
                        flipImage.setRGB(end--,i,image.getRGB(start++,i));
                    }
                }
                walkingImage[1][k++] = new ImageIcon(flipImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ºì£º-2877152 À¶£º-13024840
        Soldier sol = new SwordMan(0,new Position(1,2),null);
        sol.initSideDirectImage();
    }
}
