/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

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
            }

            case KeyEvent.VK_DOWN -> {
                System.out.println("down");
            }

            case KeyEvent.VK_LEFT -> {
                System.out.println("left");
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("right");
            }

            case KeyEvent.VK_ENTER -> {
            }

            case KeyEvent.VK_SPACE -> {
            }

            case KeyEvent.VK_W -> {
                System.out.println("up w");
            }

            case KeyEvent.VK_A -> {
                System.out.println("left a");
                gamePanel.megaman.setSpeedX(-5);
            }

            case KeyEvent.VK_S -> {
                System.out.println("down s");
            }

            case KeyEvent.VK_D -> {
                System.out.println("right d");
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
            }

            case KeyEvent.VK_RIGHT -> {
                System.out.println("Release right");
            }

            case KeyEvent.VK_ENTER -> {
            }

            case KeyEvent.VK_SPACE -> {
            }

            case KeyEvent.VK_W -> {
            }

            case KeyEvent.VK_A -> {
            }

            case KeyEvent.VK_S -> {
            }

            case KeyEvent.VK_D -> {
            }

            // nút bắn
            case KeyEvent.VK_J -> {
            }

            default -> {
            }
        }
    } // processKeyRelease

} // class
