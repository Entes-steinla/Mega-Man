/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

import com.minh.gameobjects.Megaman;
import java.awt.event.KeyEvent;

/**
 *
 * @author DELL
 */
public class InputManager {

    private GamePanel gamePanel;

    public InputManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void processKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                System.out.println("up");
                gamePanel.megaman.setSpeedY(-3);
                gamePanel.megaman.setPosY(gamePanel.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_DOWN -> {
                System.out.println("down");
            }

            case KeyEvent.VK_LEFT -> {
                System.out.println("left");
                gamePanel.megaman.setDirection(Megaman.DIR_LEFT);
                gamePanel.megaman.setSpeedX(-5);
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("right");
                gamePanel.megaman.setDirection(Megaman.DIR_RIGHT);
                gamePanel.megaman.setSpeedX(5);
            }

            case KeyEvent.VK_ENTER -> {
            }

            case KeyEvent.VK_SPACE -> {
                gamePanel.megaman.setSpeedY(-3);
                gamePanel.megaman.setPosY(gamePanel.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_W -> {
                System.out.println("up w");
                gamePanel.megaman.setSpeedY(-3);
                gamePanel.megaman.setPosY(gamePanel.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_S -> {
                System.out.println("down s");
            }

            case KeyEvent.VK_A -> {
                System.out.println("left a");
                // khi animation ngưng chuyển động thì xác định nhân vật đứng hướng nào
                gamePanel.megaman.setDirection(Megaman.DIR_LEFT);
                gamePanel.megaman.setSpeedX(-5);
            }

            case KeyEvent.VK_D -> {
                System.out.println("right d");
                // khi animation ngưng chuyển động thì xác định nhân vật đứng hướng nào
                gamePanel.megaman.setDirection(Megaman.DIR_RIGHT);
                gamePanel.megaman.setSpeedX(5);
            }

            // nút bắn
            case KeyEvent.VK_J -> {
            }

            default -> {
            }
        }
    } // processKeyPressed

    public void processKeyRelease(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                System.out.println("Release up");
            }

            case KeyEvent.VK_DOWN -> {
                System.out.println("Release down");
            }

            case KeyEvent.VK_LEFT -> {
                System.out.println("Release left");
                gamePanel.megaman.setSpeedX(0);
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("Release right");
                gamePanel.megaman.setSpeedX(0);
            }

            case KeyEvent.VK_ENTER -> {
            }

            case KeyEvent.VK_SPACE -> {
            }

            case KeyEvent.VK_W -> {
                System.out.println("Release up w");
            }

            case KeyEvent.VK_S -> {
                System.out.println("Release down s");
            }

            case KeyEvent.VK_A -> {
                System.out.println("Release left a");
                gamePanel.megaman.setSpeedX(0);
            }

            case KeyEvent.VK_D -> {
                System.out.println("Release right d");
                gamePanel.megaman.setSpeedX(0);
            }

            // nút bắn
            case KeyEvent.VK_J -> {
            }

            default -> {
            }
        }
    } // processKeyRelease

} // class
