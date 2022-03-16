package com.asin.smallwar.soldiers;

import com.asin.smallwar.map.MapImage;

import javax.swing.*;

public class SoldiersImage {
    public static ImageIcon soldier1 = new ImageIcon(SoldiersImage.class.getResource("soldier1.png"));

    public static ImageIcon getImage(){
        ImageIcon image = soldier1;
        return image;
    }
}
