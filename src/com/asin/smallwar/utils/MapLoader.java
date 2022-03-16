package com.asin.smallwar.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MapLoader {

    public static int[][] getMap(String fileLocation){
        BufferedImage image;
        int[][] data = new int[400][600];
        try {
            image = ImageIO.read(new File(fileLocation));
            data = new int[image.getHeight()][image.getWidth()];
            int height = image.getHeight();
            int width = image.getWidth();
            System.out.println(height);
            System.out.println(width);
            int k;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {//ÐÐÉ¨Ãè
                    k = image.getRGB(j, i);
                    if (k == -1) {
                        data[i][j] = 0;
                    } else {
                        data[i][j] = 1;
                    }
                }
            }
            return data;
        } catch (Exception e){
          e.printStackTrace();
        }
        return data;
    }

    public static int[][] getLittleMap(String fileLocation){
        int[][] data = getMap(fileLocation);
        int[][] littleMap = new int[40][60];
        for (int i = 5,y=0; i < data.length; i+=10,y++) {
            for (int j = 5,x=0; j < data[0].length; j+=10,x++) {
                littleMap[y][x] = data[i][j];
            }
        }
        return littleMap;
    }

//    Position{x=0, y=20}null
//    Position{x=8, y=20}2
//    Position{x=14, y=26}3
//    Position{x=15, y=26}2
//    Position{x=17, y=28}3
//    Position{x=28, y=28}2
//    Position{x=30, y=26}1
//    Position{x=40, y=26}2
//    Position{x=42, y=28}3
//    Position{x=48, y=28}2
//    Position{x=50, y=26}1
//    Position{x=53, y=26}2
//    Position{x=59, y=20}1
    public static void main(String[] args) {
            int [][] data = getMap("D:\\java\\workspace\\SmallWar\\src\\com\\asin\\smallwar\\map\\img.png");
            for(int i=0;i<data.length;i++) {
                for (int j = 0; j < data[0].length; j++) {//ÐÐÉ¨Ãè
                    if(i>210&&i<260&&j>400&&j<450){
                        Color c = new Color(data[i][j],true);
                        if(c.getRed()>c.getBlue()*2&&c.getGreen()*2<c.getRed()){
                            System.out.print("O");
                        }else{
                            System.out.print("-");
                        }
                    }
                }
                if(i>210&&i<260){
                    System.out.println();
                }
            }

    }
}
