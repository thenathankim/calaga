package com.framework.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicEnemy extends GameObject{
	
	Handler handler;
	private BufferedImage img = null;
	
	public BasicEnemy(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
		
		try{
			img = ImageIO.read(new File("/Users/Nate/Documents/Sprites/BasicOski.jpg"));
		}catch(IOException e){	
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, img.getWidth(), img.getHeight());
	}

	public void tick(){
		x += velX;
		y += velY;
		
		if(y <= -70 || y >= Game.HEIGHT+20 || x <= -70 || x >= Game.WIDTH+20){
			handler.objects.remove(this);
		}
	}
	
	public void render(Graphics g){
		if (img==null){
			g.setColor(Color.red);
			g.fillRect(x, y, 16, 16);
		}
		else{
			g.drawImage(img,  x,  y, null);
		}
	}
}
