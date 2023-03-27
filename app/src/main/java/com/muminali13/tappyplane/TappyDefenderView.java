package com.muminali13.tappyplane;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TappyDefenderView extends SurfaceView implements Runnable {

    volatile boolean playing;
    Thread gameThread = null;

    private Player player;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    public TappyDefenderView(Context context, int x, int y) {
        super(context);

        ourHolder = getHolder();
        paint = new Paint();

        player = new Player(context, x, y);
    }



    public void pause() {
        playing = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        while (playing) {
            update();
            draw();
            control();
        }

    }

    private void update() {

        player.update();

    }

    private void draw() {

        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();

            // fill screen black
            canvas.drawColor(Color.argb(255, 190, 200, 230));

            // draw player
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint
            );

            ourHolder.unlockCanvasAndPost(canvas);
        }

    }

    private void control() {

        try {
            gameThread.sleep(17); // 1000ms / 60FPS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                player.stopBoosting();
                break;

            case MotionEvent.ACTION_DOWN:
                player.setBoosting();
                break;

        }

        return true;
    }
}
