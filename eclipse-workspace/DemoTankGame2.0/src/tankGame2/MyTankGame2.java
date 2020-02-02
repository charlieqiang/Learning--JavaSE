package tankGame2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTankGame2 extends JFrame{

	MyPanel mp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame2 mtg = new MyTankGame2();
	}
	
	public MyTankGame2() {
		mp = new MyPanel();
		
		//run
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		
		//Register to monitor
		this.addKeyListener((KeyListener) mp);
		this.setSize(400,300);
		this.setVisible(true);
		
	}
}

//game main panel
class MyPanel extends JPanel implements KeyListener,Runnable{	
	
	int enSize = 3;
	//set my tank
	Hero hero = null;
	//set enemy tank
	Vector<EnemyTank> est = new Vector<EnemyTank>();
	
	
	public MyPanel() {
		
		//my tank
		hero = new Hero(100, 100);
		//enem
		for(int i=0;i<enSize;i++) {
			EnemyTank et = new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(2);
			est.add(et);
		}
		
	}
	
	//
	public void paint(Graphics g) {
		//this cant be ignore
		//1.init
		super.paint(g);
		
		//game main backgroundcolor
		g.fillRect(0, 0, 400, 300);
		
		//draw my tank
		this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, this.hero.color);
		
		//draw shot
		if(hero.s!=null&&hero.s.isLive==true) {
			
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		//draw enmey tank
		for(int i=0;i<est.size();i++)
		{
			this.drawTank(est.get(i).getX(), est.get(i).getY(), g, est.get(i).direct, est.get(i).color);
		}
	}

	//
	public void drawTank(int x, int y, Graphics g, int direct, int type) { 
		// check type
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
		
		// check direct
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
			case 1: 
				//d
				//draw my tank
				//1.draw left rect
				g.fill3DRect(x, y, 30, 5, false);
				//2.draw right rect
				g.fill3DRect(x, y+17, 30, 5, false);
				//3.draw mid rect
				g.fill3DRect(x+5, y+5, 20, 12, false);
				//4.draw mid O
				g.fillOval(x+10, y+5, 10, 10);
				//5.draw line
				g.drawLine(x+15, y+10, x+30, y+10);
				break; 
			case 2:
				//s
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
				g.drawLine(x+10, y+15, x+10, y+30);
				break; 
			case 3: 
				//a
				//draw my tank
				//1.draw left rect
				g.fill3DRect(x, y, 30, 5, false);
				//2.draw right rect
				g.fill3DRect(x, y+17, 30, 5, false);
				//3.draw mid rect
				g.fill3DRect(x+5, y+5, 20, 12, false);
				//4.draw mid O
				g.fillOval(x+10, y+5, 10, 10);
				//5.draw line
				g.drawLine(x+15, y+10, x, y+10);
				break; 
		} 
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_W) {
			this.hero.setDirect(0);
			this.hero.moveUp();
		}else if(arg0.getKeyCode()==KeyEvent.VK_D) {
			this.hero.setDirect(1);
			this.hero.moveRight();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S) {
			this.hero.setDirect(2);
			this.hero.moveDown();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A) {
			this.hero.setDirect(3);
			this.hero.moveLeft();
			
		}
		//check user press J
		if(arg0.getKeyCode()==KeyEvent.VK_J) {
			
			
			this.hero.shotEnemy();
		}
		
		this.repaint();
	}
	 
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//100ms refresh
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.repaint();
		}
	}

	

}




