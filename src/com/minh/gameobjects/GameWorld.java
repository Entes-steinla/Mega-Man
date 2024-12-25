/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import com.minh.userinterface.GameFrame;
import java.awt.Graphics2D;

/**
 *
 * @author DELL
 */
public class GameWorld {

    public Megaman megaman;
    public PhysicalMap physicalMap;

    public Camera camera;

    public GameWorld() {
        megaman = new Megaman(300, 300, this);
        physicalMap = new PhysicalMap(0, 0, this);
        camera = new Camera(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, this);
    }

    public void Update() {
        megaman.Update();
        camera.Update();
    }

    public void Render(Graphics2D g2) {
        physicalMap.draw(g2);
        megaman.draw(g2);
    }
}
