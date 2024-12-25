/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.gameobjects;

import com.minh.effect.CacheDataLoader;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author DELL
 */
public class PhysicalMap extends GameObject {

    public int[][] phys_map;
    private int tileSize;

    public PhysicalMap(float x, float y, GameWorld gameWorld) {
        super(x, y, gameWorld); // super dẫn xuất
        this.tileSize = 30;
        phys_map = CacheDataLoader.getInstance().getPhysicalMap();
    }

    public int getTileSize() {
        return tileSize;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.gray);
        for (int i = 0; i < phys_map.length; i++) {
            for (int j = 0; j < phys_map[0].length; j++) {
                if (phys_map[i][j] != 0) {
                    g2.fillRect((int) getPosX() + j * tileSize, (int) getPosY() + i * tileSize, tileSize, tileSize);
                }
            }
        }
    }

    // xử lý va chạm với map land
    public Rectangle haveCollisionWithLand(Rectangle rect) {
        // thuật toán lặp từ cột x1 tới cột x2
        int posX1 = rect.x / tileSize; // idx của cột đầu tiên
        posX1 -= 2; // trừ sai số
        int posX2 = (rect.x + rect.width) / tileSize; // cột đầu cộng width
        posX2 += 2; // cộng sai số

        int posY1 = (rect.y + rect.height) / tileSize;
        if (posX1 < 0) {
            posX1 = 0;
        }

        if (posX2 >= phys_map[0].length) {
            posX2 = phys_map[0].length - 1;
        }

        for (int y = posY1; y < phys_map.length; y++) {
            for (int x = posX1; x < posX2; x++) {
                if (phys_map[y][x] == 1) {
                    Rectangle r = new Rectangle((int) posX + x * tileSize, (int) posY + y * tileSize, tileSize, tileSize);
                    // intersects nhận một rectangle khác trả về true nếu rect khác khác có va chạm
                    if (rect.intersects(r)) {
                        return r;
                    }
                }
            }
        }
        return null; // không có phần tử nào va chạm
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
