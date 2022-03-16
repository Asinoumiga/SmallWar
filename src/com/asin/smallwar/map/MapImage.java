package com.asin.smallwar.map;

import javax.swing.*;

public class MapImage {
    public static ImageIcon map1 = new ImageIcon(MapImage.class.getResource("map1.jpg"));

    public static ImageIcon getImage(){
        ImageIcon image = map1;
        return image;
    }
}
