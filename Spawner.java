package com.framework.main;

public class Spawner {
	
	private Handler handler;
	private HUD hud;
	
	private int scorekeep = 0;
	private int prev = 0;
	
	public Spawner(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scorekeep += hud.getScore() - prev;
		prev = hud.getScore();
		
		if(scorekeep >= 50){
			scorekeep = 0;
			hud.setLevel(hud.getLevel()+1);
		}
	}
}
