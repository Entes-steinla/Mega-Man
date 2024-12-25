/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

import com.minh.effect.Animation;
import com.minh.effect.FrameImage;
import com.minh.gameobjects.GameWorld;
import com.minh.gameobjects.Megaman;
import com.minh.gameobjects.PhysicalMap;
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

    private BufferedImage buffImage;
    private Graphics2D buffG2D;

    public GameWorld gameWorld;

    public GamePanel() {
        gameWorld = new GameWorld();
        
        inputManager = new InputManager(gameWorld);

        buffImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.drawImage(buffImage, 0, 0, this);

    }

    public void UpdateGame() {
        gameWorld.Update();
    }

    public void RenderGame() {
        if (buffImage == null) {
            buffImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }

        if (buffImage != null) {
            buffG2D = (Graphics2D) buffImage.getGraphics();
        }

        if (buffG2D != null) {
            buffG2D.setColor(Color.WHITE); // xoa nen
//            buffG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);

            gameWorld.Render(buffG2D);

        }
//        buffG2D.dispose(); // giải phóng tài nguyên
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
        long FPS = 120;
        long period = 1000 * 1000000 / FPS; // chu kì
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime(); // lấy tg hệ thống
        // game loop
        while (isRunning) {

            UpdateGame();

            RenderGame();

            repaint(); // vẽ lại
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            // Tfamre = update + draw + sleep
            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000L);
                } else {
                    Thread.sleep(period / 2000000L);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            beginTime = System.nanoTime();
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
