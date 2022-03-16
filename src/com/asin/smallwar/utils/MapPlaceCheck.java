package com.asin.smallwar.utils;

import com.asin.smallwar.common.Constance;
import com.asin.smallwar.map.MapImage;

public class MapPlaceCheck {

    public static boolean checkValidMapPlace(int x, int y ,Integer side){
        if(y<Constance.GAME_WINDOW_Y_GAP&&y>Constance.GAME_WINDOW_Y_GAP+Constance.GAME_WINDOW_Y){
            return false;
        }
        //red ·½
        if(side==null||side==0){
            if(x>=Constance.GAME_WINDOW_X_GAP&&x<=Constance.GAME_WINDOW_X_GAP+Constance.VALID_X){
                return true;
            }
        }
        if(side==null||side==1){
            if(x>=Constance.GAME_WINDOW_X_GAP+ MapImage.getImage().getIconWidth() - Constance.VALID_X&&x<=Constance.GAME_WINDOW_X_GAP+MapImage.getImage().getIconWidth()){
                return true;
            }
        }
        return false;
    }

}
