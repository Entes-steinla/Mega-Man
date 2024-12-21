/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.effect;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Animation {

    private String name;

    private boolean isRepeated;

    private ArrayList<FrameImage> frameImages;
    private int currentFrame; // frame hiện tại đang vẽ trên màn hình

    private ArrayList<Boolean> ignoreFrames; // animation bỏ lặp

    private ArrayList<Double> delayFrames; // độ trễ khi chuyển sang frame khác

    private long beginTime;

    private boolean drawRectFrame;

    public Animation() {
        delayFrames = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;

        ignoreFrames = new ArrayList<Boolean>();

        frameImages = new ArrayList<FrameImage>();

        drawRectFrame = false;

        isRepeated = true;
    }

    public Animation(Animation animation) {
        beginTime = animation.beginTime;
        currentFrame = animation.currentFrame;
        drawRectFrame = animation.drawRectFrame;
        isRepeated = animation.isRepeated;

        delayFrames = new ArrayList<Double>();
        for (Double d : animation.delayFrames) {
            delayFrames.add(d);
        }

        ignoreFrames = new ArrayList<Boolean>();
        for (Boolean b : animation.ignoreFrames) {
            ignoreFrames.add(b);
        }

        frameImages = new ArrayList<FrameImage>();
        for (FrameImage f : frameImages) {
            frameImages.add(new FrameImage(f));
        }
    } // copy animation

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // repeated
    public boolean getIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    // arr frame image
    public ArrayList<FrameImage> getFrameImages() {
        return frameImages;
    }

    public void setFrameImages(ArrayList<FrameImage> frameImages) {
        this.frameImages = frameImages;
    }

    // cur frame
    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if (currentFrame >= 0 && currentFrame < frameImages.size()) {
            this.currentFrame = currentFrame;
        } else {
            this.currentFrame = 0;
        }
    }

    // ignore frames
    public ArrayList<Boolean> getIgnoreFrames() {
        return ignoreFrames;
    }

    public void setIgnoreFrames(ArrayList<Boolean> ignoreFrames) {
        this.ignoreFrames = ignoreFrames;
    }

    // delay frames
    public ArrayList<Double> getDelayFrames() {
        return delayFrames;
    }

    public void setDelayFrames(ArrayList<Double> delayFrames) {
        this.delayFrames = delayFrames;
    }

    // begin time
    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    // draw react frame
    public boolean getDrawRectFrame() {
        return drawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        this.drawRectFrame = drawRectFrame;
    }

    public boolean isIgnoreFrame(int id) {
        return ignoreFrames.get(id);
    }

    // kiểm tra frame nào muốn bỏ qua
    public void setIgnoreFrame(int id) {
        if (id >= 0 && id < ignoreFrames.size()) {
            ignoreFrames.set(id, true);
        }
    }

    public void unIgnoreFrame(int id) {
        if (id >= 0 && id < ignoreFrames.size()) {
            ignoreFrames.set(id, false);
        }
    }

    // reset
    public void reset() {
        currentFrame = 0;
        beginTime = 0;

        // không còn frame nào bị bỏ qua
        for (int i = 0; i < ignoreFrames.size(); i++) {
            ignoreFrames.set(i, false);
        }
    }

    // tg tới frame tiếp theo
    public void add(FrameImage frameImage, double timeToNextFrame) {
        ignoreFrames.add(false);
        frameImages.add(frameImage);
        delayFrames.add(new Double(timeToNextFrame));
    }

    // hình hiện tại
    public BufferedImage getCurrentImage() {
        return frameImages.get(currentFrame).getImage();
    }

    // deltaTime tham số thời gian hệ thống truyền vào để update
    public void Update(long currentTime) {
        if (beginTime == 0) {
            beginTime = currentTime;
        } else {
            // nếu tg hiện tại trừ thời gian bắt đầu lớn hơn tg delay giữa các frame thì chuyển sang frame khác
            if (currentTime - beginTime > delayFrames.get(currentFrame));
            nextFrame();
            beginTime = currentTime;
        }
    }

    private void nextFrame() {
        // frame hiện tại có bằng pt cuối cùng của mảng k
        if (currentFrame >= frameImages.size() - 1) {
            // lặp animation
            if (isRepeated) {
                currentFrame = 0;
            }
        } else {
            currentFrame++;
        }

        // nếu là một frame bỏ qua thì chuyển sang frame tiếp theo luôn
        if (ignoreFrames.get(currentFrame)) {
            nextFrame();
        }
    }

    // kiểm tra xem animation đã xong chưa
    public boolean isLastFrame() {
        if (currentFrame == frameImages.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    // lật ngược hình
    public void flipAllImage() {
        for (int i = 0; i < frameImages.size(); i++) {
            BufferedImage image = frameImages.get(i).getImage();

            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(), 0);

            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            image = op.filter(image, null);

            frameImages.get(i).setImage(image);
        }
    }

    // vẽ animation
    public void draw(int x, int y, Graphics2D g2) {
        
        // animation sẽ vẽ hình hiện tại
        BufferedImage image = getCurrentImage();

        g2.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
        if (drawRectFrame) {
            g2.drawRect(x - image.getWidth() / 2, x - image.getWidth() / 2, image.getWidth(), image.getHeight());
        }
    }
} // class
