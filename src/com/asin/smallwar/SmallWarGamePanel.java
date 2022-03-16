package com.asin.smallwar;

import com.asin.smallwar.common.Constance;
import com.asin.smallwar.listener.SmallWarMouseListener;
import com.asin.smallwar.listener.smallWarActionListener;
import com.asin.smallwar.map.MapImage;
import com.asin.smallwar.soldiers.Position;
import com.asin.smallwar.soldiers.Soldier;
import com.asin.smallwar.soldiers.SoldiersImage;
import com.asin.smallwar.soldiers.SwordMan;
import com.asin.smallwar.utils.MapLoader;
import com.asin.smallwar.utils.ShortestRoad;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallWarGamePanel extends JPanel {

    Timer timer = new Timer(Constance.DELAY_TIME, new smallWarActionListener());
    public static List<Soldier> redSodList;
    public static List<Soldier> blueSodList;
    public static List<Position> redEnemys;
    public static List<Position> blueEnemys;
    public static int[][] map;

    public static SmallWarGamePanel instance = new SmallWarGamePanel();

    private SmallWarGamePanel(){
        init();
        this.setFocusable(true);
        this.addMouseListener(SmallWarMouseListener.getInstance());
        this.addMouseMotionListener(SmallWarMouseListener.getInstance());
    }

    public static SmallWarGamePanel getInstance(){
        return instance;
    }

    void init() {
        redSodList = new ArrayList<Soldier>();
        blueSodList = new ArrayList<Soldier>();
        map = MapLoader.getLittleMap("D:\\java\\workspace\\SmallWar\\src\\com\\asin\\smallwar\\map\\map1.jpg");
        Position nowPosition = new Position(0,35);
        redEnemys = new ArrayList<>();
        redEnemys.add(new Position(59,1));
        redEnemys.add(new Position(59,39));
        redEnemys.add(new Position(59,20));
        blueEnemys = new ArrayList<>();
        blueEnemys.add(new Position(0,1));
        blueEnemys.add(new Position(0,39));
        blueEnemys.add(new Position(0,20));
        Position position = ShortestRoad.getRoad(map,nowPosition,redEnemys);
        Stack<Position> positions = ShortestRoad.getPositonStack(position);
        Soldier soliderA = new SwordMan(0,nowPosition,positions);
        redSodList.add(soliderA);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GRAY);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect( Constance.GAME_WINDOW_X_GAP,Constance.GAME_WINDOW_Y_GAP,Constance.GAME_WINDOW_X,Constance.GAME_WINDOW_Y);
        MapImage.getImage().paintIcon(this,g,Constance.GAME_WINDOW_X_GAP,Constance.GAME_WINDOW_Y_GAP);
        if(!redSodList.isEmpty()){
            if(!timer.isRunning()){
                timer.start();
            }
            for (Soldier sol :SmallWarGamePanel.redSodList) {
                ImageIcon solImage = sol.getWalkImage();
                int x = sol.getNowX()-solImage.getIconWidth()/2;
                int y = sol.getNowY()-solImage.getIconHeight();
                sol.getWalkImage().paintIcon(this,g,Constance.GAME_WINDOW_X_GAP+x,Constance.GAME_WINDOW_Y_GAP+y);
            }
        }
        if(!blueSodList.isEmpty()){
            if(!timer.isRunning()){
                timer.start();
            }
            for (Soldier sol :SmallWarGamePanel.blueSodList) {
                ImageIcon solImage = sol.getWalkImage();
                int x = sol.getNowX()-solImage.getIconWidth()/2;
                int y = sol.getNowY()-solImage.getIconHeight();
                sol.getWalkImage().paintIcon(this,g,Constance.GAME_WINDOW_X_GAP+x,Constance.GAME_WINDOW_Y_GAP+y);
            }
        }
    }

    public void doPaint(){
        repaint();
    }
}
