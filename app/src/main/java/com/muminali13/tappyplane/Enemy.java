package com.muminali13.tappyplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {

    private Bitmap bitmap;
    private int x, y;
    private int speed = 1;

    private int maxX;
    private int minX;

    private int maxY;
    private int minY;

    public Enemy(Context context, int screenX, int screenY) {
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane_red1);

        maxX = screenX;
        maxY = screenY;

        minX = -bitmap.getWidth();
        maxX = 0;

        Random rand = new Random();
        speed = rand.nextInt(6) + 10;
        x = screenX;
        y = rand.nextInt(maxY - bitmap.getHeight());
    }

    public void update(int playerSpeed) {

        x -= playerSpeed;
        x -= speed;

        if (x < minX) {

        }

    }

    public void draw() {

    }

    public Bitmap getBitmap() {
        return bitmap;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
