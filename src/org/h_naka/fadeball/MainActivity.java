package org.h_naka.fadeball;

import android.os.Bundle;
import android.app.Activity;
import java.util.Timer;
//import android.util.Log;

public class MainActivity extends Activity {

    private static final int BALL_SIZE = 100;

    private DrawView m_drawView;
    private Ball [] m_ball;
    private Timer m_timer;
    private DrawTimer m_drawTimer;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        
        initInstance();
    }

    @Override 
    public void onWindowFocusChanged(boolean hasFocus) { 
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus == true) {
            m_drawView.setViewSize(m_drawView.getWidth(),m_drawView.getHeight());
            initBall();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 念の為
        startTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 念の為
        stopTimer();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 念の為
        stopTimer();
    }

    private void initInstance() {
        m_drawView = (DrawView)findViewById(R.id.drawView);
        m_timer = null;
        m_drawTimer = null;
        m_ball = null;
    }

    private void initBall() {
        if (m_ball != null) {
            return;
        }

        m_ball = new Ball[BALL_SIZE];
        for (int i = 0;i < m_ball.length;i++) {
            m_ball[i] = new Ball(this);
        }
    }

    private void startTimer() {
        if (m_timer != null) {
            return;
        }
        m_timer = new Timer(true);
        m_drawTimer = new DrawTimer(this);
        m_timer.schedule(m_drawTimer,0,10);
    }

    private void stopTimer() {
        if (m_timer == null) {
            return;
        }

        m_drawTimer.cancel();
        m_drawTimer = null;
        m_timer.cancel();
        m_timer = null;
    }
    
    public DrawView getDrawView() {
        return m_drawView;
    }

    public Ball [] getBall() {
        return m_ball;
    }

	public void updateView() {
		runOnUiThread(new Runnable() {
			public void run() {
				m_drawView.invalidate();
			}
		});
	}
}
