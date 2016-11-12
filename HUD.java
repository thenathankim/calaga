package com.framework.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	public int POINTS = 0;
	
	private int level = 1;
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH-215, Game.HEIGHT-70, 200, 32);
		
		g.setColor(Color.gray);
		g.fillRect(Game.WIDTH-215, Game.HEIGHT-70, 200-HEALTH*2, 32);
		
		g.drawString(POINTS + " Funds Misused!", 15, Game.HEIGHT-70);
		g.drawString("Level: " + level, 15, Game.HEIGHT - 40);
	}
	
	public void setScore(int score){
		POINTS = score;
	}
	
	public int getScore(){
		return POINTS;
	}
	
	public void setLevel(int lvl){
		level = lvl;
	}
	
	public int getLevel(){
		return level;
	}

}
