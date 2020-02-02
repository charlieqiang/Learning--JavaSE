package tankGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTankGame1 extends JFrame{

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame1 mtg = new MyTankGame1();
	}
	
	public MyTankGame1() {
		mp = new MyPanel();
		
		this.add(mp);
		this.setSize(400,300);
		this.setVisible(true);
		
	}
}

//game main panel
class MyPanel extends JPanel{	
	//set my tank
	Hero hero = null;
	//
	public MyPanel() {
		hero = new Hero(100, 100);
		
	}
	
	//
	public void paint(Graphics g) {
		//this cant be ignore
		//1.init
		super.paint(g);
		
		//game main backgroundcolor
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}


	public void drawTank(int x, int y, Graphics g, int direct, int type) { 
		// 
		switch(type) 
		{ 
			case 0:
				//enme 
				g.setColor(Color.cyan); 
				break; 
			case 1:
				//hero 
				g.setColor(Color.yellow); 
				break; 
		} 
		// 
		switch (direct) 
		{ 
			case 0: 
				//draw my tank
				//1.draw left rect
				g.fill3DRect(x, y, 5, 30, false);
				//2.draw right rect
				g.fill3DRect(x+17, y, 5, 30, false);
				//3.draw mid rect
				g.fill3DRect(x+5, y+5, 12, 20, false);
				//4.draw mid O
				g.fillOval(x+5, y+10, 10, 10);
				//5.draw line
				g.drawLine(x+10, y+15, x+10, y);
				break; 
		} 
	}

}
//tank parent
class Tank
{
	//
	int x = 0;
	int y = 0;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	
}

//my tank
class Hero extends Tank
{
	public Hero(int x,int y) {
		super(x, y);
	}
}


