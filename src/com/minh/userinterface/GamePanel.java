/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

import com.minh.effect.Animation;
import com.minh.effect.FrameImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    private Thread thread;

    private boolean isRunning;

    private InputManager inputManager;

    public GamePanel() {
        inputManager = new InputManager();

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);

        Graphics2D g2 = (Graphics2D) g;

    }

    public void startGame() {
        if (thread == null) {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {

        // frames per second
        long FPS = 80;
        long period = 1000 * 1000000 / FPS; // chu kì
        long beginTime;
        long sleepTime;

        int a = 1;

        beginTime = System.nanoTime(); // lấy tg hệ thống
        // game loop
        while (isRunning) {
//            System.out.println("a = " + (a++));

            // update
            // render
//            repaint(); // vẽ lại

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            // Tfamre = update + draw + sleep
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                } else {
                    Thread.sleep(period / 2000000);
                }
            } catch (InterruptedException ex) {
                beginTime = System.nanoTime();
            }
        }
    } // run

    // bộ lắng nghe sự kiện
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // nhấn
        inputManager.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // thả
        inputManager.processKeyRelease(e.getKeyCode());
    }

} // class
