package pl.nataliajablonska.testy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MyActivity extends Activity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private View view;
    private float viewX;
    private float viewY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        gestureDetector = new GestureDetector(this, this);
        view = findViewById(R.id.text);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        viewX = view.getX();
        viewY = view.getY();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent start, MotionEvent now, float distanceX, float distanceY) {
        float dx = now.getX() - start.getX();
        float dy = now.getY() - start.getY();
        view.setX(viewX + dx);
        view.setY(viewY + dy );
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}