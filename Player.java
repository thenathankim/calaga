package com.framework.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	
	Handler handler;
	
	private BufferedImage img = null; 
	
	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		
		try{
			img = ImageIO.read(new File("/Users/Nate/Documents/Sprites/Dirks.png"));
		}catch(IOException e){	
		}
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, img.getWidth(), img.getHeight());
	}

	public void tick(){
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH-43);
		y = Game.clamp(y, 0, Game.HEIGHT-80);
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.objects.size(); i++){
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
					handler.objects.remove(tempObject);
				}
			}
		}
	}
	
	public void render(Graphics g){
		//g.setColor(Color.white);
		//g.fillRect(x, y, 32, 32);
		if (img==null){
			g.setColor(Color.white);
			g.fillRect(x, y, 32, 32);
		}
		else{
			g.drawImage(img,  x,  y, null);
		}
	}

}
