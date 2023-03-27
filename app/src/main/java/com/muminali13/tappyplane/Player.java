package com.muminali13.tappyplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player {

    private final int GRAVITY = -12;

    private final int MAX_SPEED = 20;
    private final int MIN_SPEED = 0;

    private int MAX_Y;
    private int MIN_Y;

    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;

    private boolean boosting;

    public Player(Context context, int screenX, int screenY) {

        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane_blue1);

        this.x = 50;
        this.y = 50;
        this.speed = 1;
        this.boosting = false;

        this.MAX_Y = screenY - bitmap.getHeight();
        this.MIN_Y = 0;
    }

    public void update() {

        if (boosting) {
            speed += 2;
        } else {
            speed -= 5;
        }

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        } else if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        if (y < MIN_Y) {
            y = MIN_Y;
        } else if (y > MAX_Y) {
            y = MAX_Y;
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBoosting() {
        boosting = true;
    }

    public void stopBoosting() {
        boosting = false;
    }
}
