/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import java.awt.Graphics2D;

/**
 *
 * @author DELL
 */
public abstract class Bullet extends ParticularObject {

    public Bullet(float width, float height, float mass, int blood, float x, float y, GameWorld gameWorld) {
        super(width, height, mass, blood, x, y, gameWorld);
        setDamage(damage);

    }

    public abstract void draw(Graphics2D g2d);

    public void Update() {
        super.Update();
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
//        ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
//        if(object!=null && object.getState() == ALIVE){
//            setBlood(0);
//            object.beHurt(getDamage());
//            System.out.println("Bullet set behurt for enemy");
//        }
    }

}
