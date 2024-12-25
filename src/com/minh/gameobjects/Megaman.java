/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author DELL
 */
public class Megaman {

    private float posX;
    private float posY;

    private float width;
    private float height;
    private float mass;

    private float speedX;
    private float speedY;

    public static int DIR_LEFT;
    public static int DIR_RIGHT;
    private int direction; // hướng

    GameWorld gameWorld;

    public Megaman(float posX, float posY, float width, float height, float mass, GameWorld gameWorld) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.gameWorld = gameWorld;
    }

    public Rectangle getBoundForCollisionWithMap() {
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth() / 2));
        bound.y = (int) (getPosY() - (getWidth() / 2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }

    public void update() {
        setPosX(getPosX() + speedX);

        Rectangle futureRect = getBoundForCollisionWithMap();
        futureRect.y += getSpeedY(); // doan truoc tuong lai xem co cham chuong ngai vat khong
        Rectangle rectLand = gameWorld.physicalMap.haveCollisionWithLand(futureRect); // mat dat
        Rectangle rectTop = gameWorld.physicalMap.haveCollisionWithTop(futureRect); // tran

        if (rectLand != null) {
            setPosY(rectLand.y - getHeight() / 2);
        } else {
            setPosY(getPosY() + speedY);
            setSpeedY(getSpeedY() + mass);
        }

        if (rectTop != null) {
            setSpeedY(0);
            setPosY(getPosY());
            setSpeedY(getSpeedY() + 100);

        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect((int) (posX - getWidth() / 2), (int) (posY - getHeight() / 2), (int) width, (int) height);

        g2.setColor(Color.black);
        g2.fillRect((int) posX, (int) posY, 5, 5);
    }

    // pos x
    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    // pos y
    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    // width
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    // height
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    // mass
    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    // speed x
    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    // speed y
    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    // direction
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
