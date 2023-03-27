package com.muminali13.tappyplane;


import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class GameActivity extends Activity {

    private TappyDefenderView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        gameView = new TappyDefenderView(this, size.x, size.y);
        setContentView(gameView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}