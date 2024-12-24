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
public class GameWorld {

    public Megaman megaman;
    public PhysicalMap physicalMap;

    public GameWorld() {
        megaman = new Megaman(300, 300, 100, 100, 0.1f);
        physicalMap = new PhysicalMap(0, 0);
    }

    public void Update() {
        megaman.update();

    }

    public void Render(Graphics2D g2) {
        megaman.draw(g2);
        physicalMap.draw(g2);
    }
}
