package com.asin.smallwar.listener;

import com.asin.smallwar.SmallWarGamePanel;
import com.asin.smallwar.common.Constance;
import com.asin.smallwar.soldiers.Position;
import com.asin.smallwar.soldiers.Soldier;
import com.asin.smallwar.soldiers.SwordMan;
import com.asin.smallwar.utils.MapPlaceCheck;
import com.asin.smallwar.utils.ShortestRoad;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;

public class SmallWarMouseListener implements MouseMotionListener , MouseListener {

    public static SmallWarMouseListener instance = new SmallWarMouseListener();

    private SmallWarGamePanel smallWarGamePanel;

    private SmallWarMouseListener(){
        smallWarGamePanel = SmallWarGamePanel.getInstance();
    }

    public static SmallWarMouseListener getInstance(){
        return instance;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        boolean isValid = MapPlaceCheck.checkValidMapPlace(mouseX,mouseY,null);
        if(isValid){
            if(mouseX<Constance.GAME_WINDOW_X/2){
                Position thisPos = new Position((mouseX-Constance.GAME_WINDOW_X_GAP)/Constance.MAP_GAP,(mouseY-Constance.GAME_WINDOW_Y_GAP)/Constance.MAP_GAP);
                Position position = ShortestRoad.getRoad(smallWarGamePanel.map,thisPos,smallWarGamePanel.redEnemys);
                Stack<Position> positions = ShortestRoad.getPositonStack(position);
                Soldier soliderA = new SwordMan(0,thisPos,positions);
                smallWarGamePanel.redSodList.add(soliderA);
            } else{
                Position thisPos = new Position((mouseX-Constance.GAME_WINDOW_X_GAP)/Constance.MAP_GAP,(mouseY-Constance.GAME_WINDOW_Y_GAP)/Constance.MAP_GAP);
                Position position = ShortestRoad.getRoad(smallWarGamePanel.map,thisPos,smallWarGamePanel.blueEnemys);
                Stack<Position> positions = ShortestRoad.getPositonStack(position);
                Soldier soliderB = new SwordMan(1,thisPos,positions);
                smallWarGamePanel.blueSodList.add(soliderB);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
