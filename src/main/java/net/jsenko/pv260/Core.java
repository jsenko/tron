package net.jsenko.pv260;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Core {

    private Drawable drawable;

    private boolean running;

    protected ScreenManager sm;

	private static final DisplayMode modes[] = 
		{
		//new DisplayMode(1920,1080,32,0),
		new DisplayMode(1680,1050,32,0),
		//new DisplayMode(1280,1024,32,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0),
		};




    public Core(Drawable drawable) {
        this.drawable = drawable;
    }



    public void stop(){
		running = false;
	}
	
	public void run(){
		try{
			//init();
			gameLoop();
		}finally{
			sm.restoreScreen();
		}
	}
	
	public ScreenManager init(){
		sm = new ScreenManager();
		DisplayMode dm = sm.findFirstCompatibaleMode(modes);
		sm.setFullScreen(dm);
		Window w = sm.getFullScreenWindow();
		w.setFont(new Font("Arial",Font.PLAIN,20));
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null")); 
		running = true;
        return sm;
	}
	
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while (running){
			long timePassed = System.currentTimeMillis()-cumTime;
			cumTime+= timePassed;
			update(timePassed);
			Graphics2D g = sm.getGraphics();
			drawable.draw(g);
			g.dispose();
			sm.update();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	
	public void update(long timePassed){}
	
	//public abstract void draw(Graphics2D g);
	
}
