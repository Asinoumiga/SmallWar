package com.asin.smallwar.listener;

import com.asin.smallwar.SmallWarGamePanel;
import com.asin.smallwar.soldiers.Soldier;
import com.asin.smallwar.utils.MovingUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class smallWarActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!SmallWarGamePanel.redSodList.isEmpty()){
            for (Soldier sol :SmallWarGamePanel.redSodList){
                    MovingUtil.soliderMoving(sol);
            }
        }
        if(!SmallWarGamePanel.blueSodList.isEmpty()){
            for (Soldier sol :SmallWarGamePanel.blueSodList){
                MovingUtil.soliderMoving(sol);
            }
        }
        SmallWarGamePanel.getInstance().repaint();
    }
}
