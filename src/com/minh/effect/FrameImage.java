/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author DELL
 */
public class FrameImage {

    private String name;
    
    private BufferedImage image;

    public FrameImage(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }

    // copy constructor
    // hàm khởi tạo truyền vào một đối tượng giống nó   
    public FrameImage(FrameImage frameImage) {
        image = new BufferedImage(frameImage.getImageWidth(), frameImage.getImageHeight(), frameImage.getImage().getType());

        Graphics g = image.getGraphics();
        g.drawImage(frameImage.getImage(), 0, 0, null);
    }

    public void draw(Graphics2D g2, int x, int y) {
        g2.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
    }

    // lấy độ rộng ảnh
    public int getImageWidth() {
        return image.getWidth();
    }

    // lấy chiều cao ảnh
    public int getImageHeight() {
        return image.getHeight();
    }

    // tên ảnh
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // buffered
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
