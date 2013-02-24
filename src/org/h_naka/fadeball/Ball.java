package org.h_naka.fadeball;
import android.graphics.Paint;
import android.graphics.Color;

public class Ball {
    private MainActivity m_activity;
	private int step;
	private int size;
	private int posX;
	private int posY;
	private int now_size;
    private int red,blue,green;
    private Paint paint;
    private int alpha;
    
	public Ball(MainActivity activity) {
        m_activity = activity;
        paint = new Paint();
        init();
    }

    private void init() {
        step = (int)(Math.random() * 3.0 + 1.0);
        size = (int)(Math.random() * 121 + 60);
        posX = (int)(Math.random() * m_activity.getDrawView().getWidthSize());
        posY = (int)(Math.random() * m_activity.getDrawView().getHeightSize());
        red   = (int)(Math.random() * 206.0 + 50.0);
        green = (int)(Math.random() * 206.0 + 50.0);
        blue  = (int)(Math.random() * 206.0 + 50.0);
        alpha = 0;
        now_size = 0;
        paint.setColor(Color.argb(alpha,red,green,blue));
    }
	
	public void update() {
        now_size += step;
        if (now_size <= 0) {
			init();
		} else if (now_size >= size) {
			step *= -1;
		}

        alpha = (255 * now_size) / size;
        if (alpha >= 255) {
            alpha = 255;
        } else if (alpha < 0) {
            alpha = 0;
        }
        paint.setColor(Color.argb(alpha,red,green,blue));
	}

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getRadius() {
        return now_size;
    }
    
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public Paint getPaint() {
        return paint;
    }
 }

