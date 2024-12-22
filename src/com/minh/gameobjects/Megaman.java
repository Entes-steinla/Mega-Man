/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;

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

    public Megaman(float posX, float posY, float width, float height, float mass) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.mass = mass;
    }
    
    public void update(){
        setPosX(getPosX() + speedX);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect((int) posX, (int) posY, (int) width, (int) height);
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
