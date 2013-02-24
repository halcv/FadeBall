package org.h_naka.fadeball;

import java.util.TimerTask;

public class DrawTimer extends TimerTask {

    private MainActivity m_activity;
    
    public DrawTimer(MainActivity activity) {
        m_activity = activity;
    }
    
	@Override
	public void run() {
        m_activity.updateView();
	}

}
