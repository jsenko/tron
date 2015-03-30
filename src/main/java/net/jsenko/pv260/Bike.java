package net.jsenko.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static net.jsenko.pv260.Direction.*;

public class Bike implements Drawable, KeyListener, MouseListener,
		MouseMotionListener {


    private ScreenManager sm;

	int centrex1;
	int centrey1;

	Direction currentDirection1;

	int moveAmount = 5;
	ArrayList<Integer> pathx1 = new ArrayList();
	ArrayList<Integer> pathy1 = new ArrayList();

    private int keyUp;
    private int keyLeft;
    private int keyRight;
    private int keyDown;
    private Color color;


    public Bike(int centrex1, int centrey1, Direction currentDirection1,
                int keyUp, int keyLeft, int keyRight, int keyDown, Color color) {
        this.keyUp = keyUp;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyDown = keyDown;
        this.centrex1 = centrex1;
        this.color = color;
        this.centrey1 = centrey1;
        this.currentDirection1 = currentDirection1;
    }

    public void init(ScreenManager sm) {
        this.sm = sm;
        Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
	}




	public void draw(Graphics2D g) {
		switch(currentDirection1){
		case UP:
			if (centrey1>0){
			centrey1-=moveAmount;
			} else {
				centrey1 = sm.getHeight();
			}
			break;
		case RIGHT:
			if (centrex1 < sm.getWidth()){
			centrex1+=moveAmount;
			} else {
				centrex1 = 0;
			}
			break;
		case DOWN:
			if (centrey1 < sm.getHeight()){
			centrey1+=moveAmount;
			} else {
				centrey1 = 0;
			}
			break;
		case LEFT:
			if (centrex1>0){
			centrex1-=moveAmount;
			} else {
				centrex1 = sm.getWidth();
			}
			break;
		}


		pathx1.add(centrex1);
		pathy1.add(centrey1);

		for (int x = 0;x<pathx1.size();x++){
		g.setColor(color);
		g.fillRect(pathx1.get(x), pathy1.get(x), 10, 10);

		}
	}


	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == keyUp) {
			if (currentDirection1 != DOWN){
			currentDirection1 = UP;
			}
		} else if (e.getKeyCode() == keyDown) {
			if (currentDirection1 != UP){
				currentDirection1 = DOWN;
				}
		} else if (e.getKeyCode() == keyRight) {
			if (currentDirection1 != LEFT){
				currentDirection1 = RIGHT;
				}
		} else if (e.getKeyCode() == keyLeft) {
			if (currentDirection1 != RIGHT){
				currentDirection1 = LEFT;
				}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}
