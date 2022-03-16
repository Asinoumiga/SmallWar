package com.asin.smallwar.soldiers;

import com.asin.smallwar.common.Constance;

public class Position {

    private int x;
    private int y;
    private int mapX;
    private int mapY;

    private Integer direct;
    private Position prePosition;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMapX() {
        return Constance.MAP_GAP*x+Constance.MAP_GAP/2;
    }

    public int getMapY() {
        return Constance.MAP_GAP*y+Constance.MAP_GAP/2;
    }

    public Position getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(Position prePosition) {
        this.prePosition = prePosition;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
