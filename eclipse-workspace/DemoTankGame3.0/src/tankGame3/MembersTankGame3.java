package tankGame3;

import java.awt.Color;
import java.util.Vector;

//shot parent
class Shot implements Runnable {
	int x = 0;
	int y = 0;
	int direct;
	int speed=1;
	
	//if exist
	boolean isLive = true;
	
	public Shot(int x,int y,int direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
			switch (direct) {
			case 0:
				//w
				y-=speed;
				break;
			case 1:
				//d
				x+=speed;
				break;
			case 2:
				//s
				y+=speed;
				break;
			case 3:
				//a
				x-=speed;
				break;
			default:
				break;
			}
			
			//when does shot die? 
			if(x<0||x>400||y<0||y>300) {
				this.isLive = false;
				System.out.println("pos:x="+x+",y="+y);
				break;
			}
			
		}
	}
	
}

//tank parent
class Tank
{
	//
	int x = 0;
	int y = 0;
	int direct = 0;
	int color = 0;
	int speed = 1;
	boolean isLive=true;
	
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
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

	public void moveUp() {
		// TODO Auto-generated method stub
		y-=speed;
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		x+=speed;
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		y+=speed;
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		x-=speed;
	}
	
}

//my tank
class Hero extends Tank
{
	//
	//Shot s = null;
	Vector<Shot> ss = new Vector<Shot>();
	Shot s = null;
	public Hero(int x,int y) {
		super(x, y);
		color=1;
	}
	
	//fire
	public void shotEnemy() {
		
		switch (this.direct) {
		case 0:
			//注意不同分支的s指向不同的空间
			s = new Shot(x+10, y,0);
			ss.add(s);
			break;
		case 1:
			s = new Shot(x+30, y+10,1);
			ss.add(s);
			break;
		case 2:
			s = new Shot(x+10, y+30,2);
			ss.add(s);
			break;
		case 3:
			s = new Shot(x, y+10,3);
			ss.add(s);
			break;
		default:
			break;
		}
		Thread t = new Thread(s);
		t.start();
	}

}

class EnemyTank extends Tank{
	
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

}
