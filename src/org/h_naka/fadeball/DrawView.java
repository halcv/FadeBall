package org.h_naka.fadeball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;

public class DrawView extends View {

    private MainActivity m_activity;
    private int m_width;
    private int m_height;
    
	public DrawView(Context context) {
		super(context);
        m_activity = (MainActivity)context;
    }

    public DrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
        m_activity = (MainActivity)context;
    }

	public DrawView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
        m_activity = (MainActivity)context;
    }

    public void setViewSize(int width,int height) {
        m_width = width;
        m_height = height;
    }

    public int getWidthSize() {
        return m_width;
    }

    public int getHeightSize() {
        return m_height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Ball [] ball = m_activity.getBall();
        if (ball == null) {
            return;
        }
        for (int i = 0;i < ball.length;i++) {
            canvas.drawCircle(ball[i].getPosX(),
                              ball[i].getPosY(),
                              ball[i].getRadius(),
                              ball[i].getPaint());
            
            ball[i].update();
        }
    }
}
