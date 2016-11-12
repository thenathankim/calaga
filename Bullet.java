package com.framework.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends GameObject{
	
	Handler handler;
	private BufferedImage img = null; 
	private static int speed = 20;
		
	public Bullet(int x, int y, ID id, Handler handler){
		super(x, y, id);
		this.handler = handler;
			
		try{
			img = ImageIO.read(new File("/Users/Nate/Documents/Sprites/Cash.png"));
		}catch(IOException e){	
		}
			
	}
		
		public Rectangle getBounds(){
			return new Rectangle(x, y, img.getWidth(), img.getHeight());
		}

		public void tick(){
			y -= speed;
			
			x = Game.clamp(x, 0, Game.WIDTH-43);
			
			if(y<=0) handler.objects.remove(this);
			collision();
		}
		
		private void collision(){
			for(int i = 0; i < handler.objects.size(); i++){
				GameObject tempObject = handler.objects.get(i);
				
				if(tempObject.getId() == ID.BasicEnemy){
					if(getBounds().intersects(tempObject.getBounds())){
						//hud.POINTS += 1;
						handler.objects.remove(tempObject);
						handler.objects.remove(this);
						return;
					}
				}
			}
		}
		
		public void render(Graphics g){
			//g.setColor(Color.white);
			//g.fillRect(x, y, 32, 32);
			if (img==null){
				g.setColor(Color.blue);
				g.fillRect(x, y, 3, 3);
			}
			else{
				g.drawImage(img,  x,  y, null);
			}
		}

	}
