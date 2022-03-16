package com.asin.smallwar.soldiers;

import com.asin.smallwar.common.Constance;

import javax.swing.*;
import java.util.Stack;

public abstract class Soldier {

//    ������Ӫ:0/1
    private int side;

//    ����λ��
    private int nowX;
    private int nowY;

//    Ѱ·λ��
    private int posX;
    private int posY;

//    ����
private int direct;

//    Ŀ��·
private Stack<Position> targetRoad;

//    ����
private int life;

//    �ķ�
private int cast;

//    ������
private int attack;

//    ������Χ
private int attackRange;

//    Ѱ�з�Χ
private int findRange;

//    �ٶ�
private int speed;

//    �����ٶ�
private int attackSpeed;

    /*
        gapΪ��ͼÿ����Ԫ����
     */
    public Soldier(int side, Position pos, Stack<Position> targetRoad) {
        this.side = side;
        this.targetRoad = targetRoad;
        this.posX = pos.getX();
        this.posY = pos.getY();
        this.nowX = pos.getX() * Constance.MAP_GAP + Constance.MAP_GAP/2;
        this.nowY = pos.getY() * Constance.MAP_GAP + Constance.MAP_GAP/2;
        if(side==0){
            this.direct = 6;
        }else{
            this.direct = 2;
        }
    }

    public abstract ImageIcon getWalkImage();

    public abstract ImageIcon getAttackImage();

    public abstract ImageIcon getDieImage();

    public abstract Soldier searchEnemy();

    public abstract void attackEnemy(Soldier soldier);

    public abstract void initSideDirectImage();

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getNowX() {
        return nowX;
    }

    public void setNowX(int nowX) {
        this.nowX = nowX;
    }

    public int getNowY() {
        return nowY;
    }

    public void setNowY(int nowY) {
        this.nowY = nowY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Stack<Position> getTargetRoad() {
        return targetRoad;
    }

    public void setTargetRoad(Stack<Position> targetRoad) {
        this.targetRoad = targetRoad;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getFindRange() {
        return findRange;
    }

    public void setFindRange(int findRange) {
        this.findRange = findRange;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
