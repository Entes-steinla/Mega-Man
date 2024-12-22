/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.userinterface;

import com.minh.effect.CacheDataLoader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class GameFrame extends JFrame {

    // static: truy xuất trực tiếp
    // final: hằng
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;

    GamePanel gamePanel;

    public GameFrame() {
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize(); // lưu cặp giá trị

        /* lấy tọa độ screen của game
           (chiều cao màn hình hiện tại - chiều cao mong muốn) / 2 */
        this.setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);

        // thoát bằng nút close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        gamePanel = new GamePanel();
        add(gamePanel);

        this.addKeyListener(gamePanel);
    } // game frame

    public void startGame() {
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();

        // hiện frame
        gameFrame.setVisible(true);
        gameFrame.startGame();
    } // main

} // class
