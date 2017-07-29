package aniruddho.race_game;

import java.awt.Color;

public class Grid {

	int posX,posY,width,height;
	Color color;
	public Grid(int posX,int posY,Color color,int width,int height){
		this.posX=posX;
		this.posY=posY;
		this.color=color;
		this.width=width;
		this.height=height;
	}
}