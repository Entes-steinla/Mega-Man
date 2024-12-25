/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import java.awt.Rectangle;

/**
 *
 * @author DELL
 */
public abstract class Human extends ParticularObject {
    
    private boolean isJumping; // dang nhay, tren khong
    private boolean isDicking; // dang ngoi

    private boolean isLanding; // tiep dat, hanh dong luc roi cham dat

    public Human(float width, float height, float mass, int blood, float x, float y, GameWorld gameWorld) {
        super(width, height, mass, blood, x, y, gameWorld);
        setState(ALIVE);
    }
    
    public abstract void run();
    
    public abstract void jump();
    
    public abstract void dick();
    
    public abstract void standUp();
    
    public abstract void stopRun();
    
    public boolean isIsJumping() {
        return isJumping;
    }
    
    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }
    
    public boolean isIsDicking() {
        return isDicking;
    }
    
    public void setIsDicking(boolean isDicking) {
        this.isDicking = isDicking;
    }
    
    public boolean isIsLanding() {
        return isLanding;
    }
    
    public void setIsLanding(boolean isLanding) {
        this.isLanding = isLanding;
    }
    
    @Override
    public void Update() {
        super.Update();

        // hanh dong chi xay ra khi nhan vat dang song
        if (getState() == ALIVE || getState() == NOBEHURT) {
            // khac trang thai tiep dat
            if (!isLanding) {
                setPosX(getPosX() + getSpeedX());

                // phuong ngang
                // huong ben trai va co va cham xay ra
                if (getDirection() == LEFT_DIR && getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap()) != null) {
                    Rectangle rectLeftWall = getGameWorld().physicalMap.haveCollisionWithLeftWall(getBoundForCollisionWithMap());
                    setPosX(rectLeftWall.x + rectLeftWall.width + getWidth() / 2); // set lai huong va cham
                }
                // huong ben phai
                if (getDirection() == RIGHT_DIR && getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap()) != null) {
                    Rectangle rectRightWall = getGameWorld().physicalMap.haveCollisionWithRightWall(getBoundForCollisionWithMap());
                    setPosX(rectRightWall.x - getWidth() / 2);
                }

                // phuong doc
                // do lon vung bao quanh nhan vat trong tuong lai
                Rectangle boundForCollsisionWithMapFuture = getBoundForCollisionWithMap();
                boundForCollsisionWithMapFuture.y += (getSpeedY() != 0 ? getSpeedY() : 2);
                Rectangle rectLand = getGameWorld().physicalMap.haveCollisionWithLand(boundForCollsisionWithMapFuture);
                
                Rectangle rectTop = getGameWorld().physicalMap.haveCollisionWithTop(boundForCollsisionWithMapFuture);
                
                if (rectTop != null) {
                    setSpeedY(0);
                    setPosY(rectTop.y + getGameWorld().physicalMap.getTileSize() + getHeight() / 2);
                } else if (rectLand != null) {
                    setIsJumping(false);
                    if (getSpeedY() > 0) {
                        setIsLanding(true);
                    }
                    setSpeedY(0);
                    setPosY(rectLand.y - getHeight() / 2 - 1);
                } else {
                    setIsJumping(true);
                    setSpeedY(getSpeedY() + getMass());
                    setPosY(getPosY() + getSpeedY());
                }
                
            }
            
        }
    } // update
}
