package com.framework.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.objects.size(); i++){
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
				
				if(key == KeyEvent.VK_SPACE){
					handler.addObject(new Bullet(tempObject.getX()+12, tempObject.getY()-35, ID.Bullet, handler));
					
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.objects.size(); i++){
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
			}
		}
	}

}
