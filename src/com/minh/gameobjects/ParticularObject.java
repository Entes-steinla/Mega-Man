/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import com.minh.effect.Animation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author DELL
 */
public abstract class ParticularObject extends GameObject { // doi tuong cu the

    public static final int LEAGUE_TEAM = 1; // cùng phe ex: bắn k mất máu
    public static final int ENEMY_TEAM = 2; // khác phe

    // hướng
    public static final int LEFT_DIR = 0;
    public static final int RIGHT_DIR = 1;

    // trạng thái 
    public static final int ALIVE = 0;
    public static final int BEHURT = 1;
    public static final int FEY = 2; // sắp chết
    public static final int DEATH = 3;
    public static final int NOBEHURT = 4; // không bị ảnh hưởng bởi sát thương
    public int state = ALIVE; // xác định xem nv ở trạng thái nào

    private float width;
    private float height;
    private float mass;
    private float speedX;
    private float speedY;
    private int blood;

    private int damage; // sat thuong

    private int direction;

    protected Animation behurtForwardAnim, behurtBackAnim;

    private int teamType; // o team nao

    private long startTimeNoBeHurt;
    private long timeForNoBeHurt;

    public ParticularObject(float width, float height, float mass, int blood, float x, float y, GameWorld gameWorld) {
        super(x, y, gameWorld);
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.blood = blood;

        direction = RIGHT_DIR;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Animation getBehurtForwardAnim() {
        return behurtForwardAnim;
    }

    public void setBehurtForwardAnim(Animation behurtForwardAnim) {
        this.behurtForwardAnim = behurtForwardAnim;
    }

    public Animation getBehurtBackAnim() {
        return behurtBackAnim;
    }

    public void setBehurtBackAnim(Animation behurtBackAnim) {
        this.behurtBackAnim = behurtBackAnim;
    }

    public int getTeamType() {
        return teamType;
    }

    public void setTeamType(int teamType) {
        this.teamType = teamType;
    }

    public long getStartTimeNoBeHurt() {
        return startTimeNoBeHurt;
    }

    public void setStartTimeNoBeHurt(long startTimeNoBeHurt) {
        this.startTimeNoBeHurt = startTimeNoBeHurt;
    }

    public long getTimeForNoBeHurt() {
        return timeForNoBeHurt;
    }

    public void setTimeForNoBeHurt(long timeForNoBeHurt) {
        this.timeForNoBeHurt = timeForNoBeHurt;
    }

    public abstract void attack();

    public Rectangle getBoundForCollisionWithMap() {
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth() / 2));
        bound.y = (int) (getPosY() - (getWidth() / 2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }

    public void beHurt(int damgeEat) {
        setBlood(getBlood() - damgeEat);
        state = BEHURT;
        hurtingCallBack();
    }

    @Override
    public void Update() {
        switch (state) {
            case ALIVE -> {
            }
            case BEHURT -> {
                if (behurtBackAnim == null) {
                    state = NOBEHURT;
                    startTimeNoBeHurt = System.nanoTime();
                    if (getBlood() == 0) {
                        state = FEY;
                    }
                } else {
                    behurtForwardAnim.Update(System.nanoTime());
                    if (behurtForwardAnim.isLastFrame()) {
                        behurtForwardAnim.reset();
                        state = NOBEHURT;
                        if (getBlood() == 0) {
                            state = FEY;
                        }
                        startTimeNoBeHurt = System.nanoTime();
                    }
                }
            } // behurt
            case FEY -> {
                state = DEATH;
            }
            case DEATH -> {
            }
            case NOBEHURT -> {
                System.out.println("state = nobehurt");
                if (System.nanoTime() - startTimeNoBeHurt > timeForNoBeHurt) {
                    state = ALIVE;
                }
            }
        }
    }

    public void drawBoundForCollisionWithMap(Graphics2D g2) {
        Rectangle rect = getBoundForCollisionWithMap();
        g2.setColor(Color.BLUE);
    }

    public void drawBoundForCollisionWithEnemy(Graphics2D g2) {
        Rectangle rect = getBoundForCollisionWithEnemy();
        g2.setColor(Color.RED);
    }

    public abstract Rectangle getBoundForCollisionWithEnemy();

    public abstract void draw(Graphics2D g2);

    public void hurtingCallBack() {
    }
;
}
