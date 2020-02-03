/**
 * @author Charlie
 * 1.draw the tank
 * 2.my tank can fire and move
 * 3.i can keep shoting 
 * 4.the etank will boom
 * 5.the etank will shot
 * 6.测试我的utf-8,haha	
 * 7.avoid crash(*)
 * 		7.1 i will check crack in enemyTankclass 
 * 8.design level
 *      8.1 level panel
 *      8.2 twinkle
 * 9.pause(*)
 * 10.record(*)
 * 11.can add wav(*) 
 */
package tankGame4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyTankGame4 extends JFrame{

	MyPanel mp = null;

	MyStartPanel msp = null;
	
	//menu
	JMenuBar jmb=null;
	
	//item
	JMenu jm01=null;
	JMenuItem jmi01=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame4 mtg = new MyTankGame4();
	}
	
	public MyTankGame4() {
//		mp = new MyPanel();
		
		//run
//		Thread t = new Thread(mp);
//		t.start();
//		
//		this.add(mp);
//		
//		//Register to monitor
//		this.addKeyListener((KeyListener) mp);
		
		//new menu and item
		jmb = new JMenuBar();
		jm01 = new JMenu("游戏（G）");
		//shotcut
		jm01.setMnemonic('G');
		//
		jmi01 = new JMenuItem("开始新游戏（N）");
		
		jm01.add(jmi01);
		
		jmb.add(jm01);
		
		
		
		msp = new MyStartPanel();
		Thread mspTr = new Thread(msp);
		mspTr.start();
		
		//
		this.add(msp);
		this.setSize(600,500);
		this.setVisible(true);
		
	}
}

//
class MyStartPanel extends JPanel implements Runnable{
	
	int twinFlag=0;
	
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		if(twinFlag%2==0) {
			g.setColor(Color.yellow);
			Font myFont = new Font("华文新魏", Font.BOLD, 30);
			g.setFont(myFont);
			g.drawString("stage:1", 150, 150);
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			twinFlag++;
			this.repaint();
		}
	}
}
//game main panel
class MyPanel extends JPanel implements KeyListener,Runnable{	
	
	int enSize = 3;
	//set my tank
	Hero hero = null;
	//set enemy tank
	Vector<EnemyTank> est = new Vector<EnemyTank>();
	//set boom set
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	//set boom gif
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	public MyPanel() {
		
		//my tank
		hero = new Hero(100, 100);
		//enem tanks
		for(int i=0;i<enSize;i++) {
			//new a etank
			EnemyTank et = new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(2);
			//push msg to enemytank class
			et.setEts(est);
			
			est.add(et);
			//run a etank
			Thread ettr = new Thread(et);
			ettr.start();
			//add a shot
			Shot s = new Shot(et.x+10, et.y+30, et.direct);
			Thread estr = new Thread(s);
			estr.start();
			//join ets
			est.add(et);

		}
		//boom gif
//		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
//		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
//		image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
		try {
			image1 = ImageIO.read(new File("./src/bomb_1.gif"));
			image2 = ImageIO.read(new File("./src/bomb_2.gif"));
			image3 = ImageIO.read(new File("./src/bomb_3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		if(hero.isLive) {
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, this.hero.color);
		}
		
		//draw shots
		for(int i=0;i<hero.ss.size();i++) {
		
			Shot myShot = hero.ss.get(i);
			//draw a shot
			if(myShot!=null&&myShot.isLive==true) {
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			
			if(myShot.isLive==false) {
				hero.ss.remove(myShot);
			}
			
		}
		
		//draw bomb
		for(int i=0;i<bombs.size();i++) {
			
			System.out.println("bombs.size():"+bombs.size());
			//get bomb
			Bomb b = bombs.get(i);
			
			//the first time it not display!!
			if(b.life>6) {
				g.drawImage(image1, b.x, b.y, 30, 30, this);
				//System.out.println("b.life:"+b.life);
			}
			if(b.life>3) {
				g.drawImage(image2, b.x, b.y, 30, 30, this);				
			}
			if(b.life>0){
				g.drawImage(image3, b.x, b.y, 30, 30, this);	
				
			}
			//
			b.lifeDown();
			//if die remove bombs
			if(b.life<=0) {
				bombs.remove(b);
			}
			
		}
		
		//draw enmey tank;check if enemy should add shot
		for(int i=0;i<est.size();i++)
		{
			EnemyTank et = est.get(i);
			if(et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.direct, et.color);
				//draw eshot
				for(int j=0;j<et.ss.size();j++) {
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive	) {
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}else {
						et.ss.remove(enemyShot);
					}
				}
			}	
		}
		
		
	}
	
	//
	public void hitEnemy() {
		
		//check if shot
		for(int i=0;i<hero.ss.size();i++) {
			//get shot
			Shot myShot = hero.ss.get(i);
			//check shot is live
			if(myShot.isLive) {
				for(int j=0;j<est.size();j++) {
					//get every enemy
					EnemyTank et = est.get(j);
					if(et.isLive) {
						this.hitTank(myShot,et);
					}
				}
			}
		}
		
	}
	
	//check if shot me
	public void hitMe() {
		//get etank
		for(int i=0;i<this.est.size();i++) {
			//get etank
			EnemyTank et = est.get(i);
			
			//get etanksshot
			for(int j=0;j<et.ss.size();j++) {
				//get
				Shot eneShot=et.ss.get(j);
				
				this.hitTank(eneShot, hero);
			}
		}
	}
	//check if shot enemy
	public void hitTank(Shot s, Tank et) {
		switch (et.direct) {
		//w or s
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30) {
				//shot!
				//s die
				s.isLive=false;
				//enemy tank will die and boom
				et.isLive=false;
				//new boom
				Bomb b = new Bomb(et.x, et.y);
				//push into vector
				bombs.add(b);
			}
			break;
		//a or d
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20) {
				//shot!
				//s die
				s.isLive=false;
				//enemy tank will die and boom
				et.isLive=false;
				//new boom
				Bomb b = new Bomb(et.x, et.y);
				//push into vector
				bombs.add(b);
				
			}
			break;
		default:
			break;
		}
	}
	
	//design a drawtank function
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
			
			if(this.hero.ss.size()<=5) {
				this.hero.shotEnemy();
			}
		}
		//this.repaint();
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
				e.printStackTrace();
			}
			
			//check if shot enemy
			this.hitEnemy();
			//check if i was shoted
			this.hitMe();
			
			//dynamic
			this.repaint();
		}
	}

	

}




