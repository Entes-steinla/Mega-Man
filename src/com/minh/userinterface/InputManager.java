/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

import com.minh.gameobjects.GameWorld;
import com.minh.gameobjects.Megaman;
import java.awt.event.KeyEvent;

/**
 *
 * @author DELL
 */
public class InputManager {

    private GameWorld gameWorld;

    public InputManager(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public void processKeyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                System.out.println("up");
                gameWorld.megaman.setSpeedY(-3);
                gameWorld.megaman.setPosY(gameWorld.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_DOWN -> {
                System.out.println("down");
            }

            case KeyEvent.VK_LEFT -> {
                System.out.println("left");
                gameWorld.megaman.setDirection(Megaman.LEFT_DIR);
                gameWorld.megaman.setSpeedX(-5);
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("right");
                gameWorld.megaman.setDirection(Megaman.RIGHT_DIR);
                gameWorld.megaman.setSpeedX(5);
            }

            case KeyEvent.VK_ENTER -> {
            }

            case KeyEvent.VK_SPACE -> {
                gameWorld.megaman.setSpeedY(-3);
                gameWorld.megaman.setPosY(gameWorld.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_W -> {
                System.out.println("up w");
                gameWorld.megaman.setSpeedY(-3);
                gameWorld.megaman.setPosY(gameWorld.megaman.getPosY() - 3);
            }

            case KeyEvent.VK_S -> {
                System.out.println("down s");
            }

            case KeyEvent.VK_A -> {
                System.out.println("left a");
                // khi animation ngưng chuyển động thì xác định nhân vật đứng hướng nào
                gameWorld.megaman.setDirection(Megaman.LEFT_DIR);
                gameWorld.megaman.setSpeedX(-5);
            }

            case KeyEvent.VK_D -> {
                System.out.println("right d");
                // khi animation ngưng chuyển động thì xác định nhân vật đứng hướng nào
                gameWorld.megaman.setDirection(Megaman.RIGHT_DIR);
                gameWorld.megaman.setSpeedX(5);
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
                gameWorld.megaman.setSpeedX(0);
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("Release right");
                gameWorld.megaman.setSpeedX(0);
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
                gameWorld.megaman.setSpeedX(0);
            }

            case KeyEvent.VK_D -> {
                System.out.println("Release right d");
                gameWorld.megaman.setSpeedX(0);
            }

            // nút bắn
            case KeyEvent.VK_J -> {
            }

            default -> {
            }
        }
    } // processKeyRelease

} // class
