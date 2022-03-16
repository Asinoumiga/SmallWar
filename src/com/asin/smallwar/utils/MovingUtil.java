package com.asin.smallwar.utils;

import com.asin.smallwar.common.Constance;
import com.asin.smallwar.soldiers.Position;
import com.asin.smallwar.soldiers.Soldier;

import java.lang.annotation.Target;

public class MovingUtil {

    public static void soliderMoving(Soldier sol){
        if(sol.getTargetRoad()==null||sol.getTargetRoad().isEmpty()){
            return;
        }
        Position target = sol.getTargetRoad().peek();
        if(sol.getNowX()/Constance.MAP_GAP ==target.getX()&&sol.getNowY()/Constance.MAP_GAP==target.getY()){
            int littleX = sol.getNowX()%Constance.MAP_GAP;
            int littleY = sol.getNowY()%Constance.MAP_GAP;
            if(littleX==Constance.MAP_GAP/2&&littleY==Constance.MAP_GAP/2){
                sol.getTargetRoad().pop();
                soliderMoving(sol);
                return;
            }else {
                sol.setDirect(getDirect(littleX,littleY,Constance.MAP_GAP));
            }
        }else{
            sol.setDirect(target.getDirect());
        }
        moving(sol,target);
    }

    private static int getDirect(int littleX, int littleY, int mapGap){
        if(littleX==mapGap/2){
            if(littleY>mapGap/2){
                return 0;
            }else{
                return 4;
            }
        }else if(littleX>mapGap/2){
            if(littleY<mapGap/2){
                return 5;
            }else if(littleY==mapGap/2){
                return 6;
            }else{
                return 7;
            }
        }else{
            if(littleY<mapGap/2){
                return 3;
            }else if(littleY==mapGap/2){
                return 2;
            }else{
                return 1;
            }
        }
    }

    private static void moving(Soldier sol,Position target){
        switch (sol.getDirect()) {
            case 0:
                sol.setNowY(Math.max(sol.getNowY() - sol.getSpeed(),target.getMapY()));
                break;
            case 1:
                sol.setNowX(Math.min(sol.getNowX() + sol.getSpeed(),target.getMapX()));
                sol.setNowY(Math.max(sol.getNowY() - sol.getSpeed(),target.getMapY()));
                break;
            case 2:
                sol.setNowX(Math.min(sol.getNowX() + sol.getSpeed(),target.getMapX()));
                break;
            case 3:
                sol.setNowX(Math.min(sol.getNowX() + sol.getSpeed(),target.getMapX()));
                sol.setNowY(Math.min(sol.getNowY() + sol.getSpeed(),target.getMapY()));
                break;
            case 4:
                sol.setNowY(Math.min(sol.getNowY() + sol.getSpeed(),target.getMapY()));
                break;
            case 5:
                sol.setNowX(Math.max(sol.getNowX() - sol.getSpeed(),target.getMapX()));
                sol.setNowY(Math.min(sol.getNowY() + sol.getSpeed(),target.getMapY()));
                break;
            case 6:
                sol.setNowX(Math.max(sol.getNowX() - sol.getSpeed(),target.getMapX()));
                break;
            case 7:
                sol.setNowX(Math.max(sol.getNowX() - sol.getSpeed(),target.getMapX()));
                sol.setNowY(Math.max(sol.getNowY() - sol.getSpeed(),target.getMapY()));
                break;
        }
        sol.setPosX(sol.getNowX()/Constance.MAP_GAP);
        sol.setPosY(sol.getNowY()/Constance.MAP_GAP);
    }
}
