package tankGame4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

//recorder can remember your set
class Recorder{
	//how much enemy
	private static int enNum=3;
	//how much life
	private static int myLife=3;
	//goal
	private static int allEnNum=0;
	//
	private static FileWriter fw=null;
	private static FileReader fr=null;
	private static BufferedWriter bw=null;
	private static BufferedReader br=null;

	private Vector<EnemyTank> ets = new Vector<EnemyTank>();

	public Vector<EnemyTank> getEts() {
		return ets;
	}

	public void setEts(Vector<EnemyTank> ets_debug) {
		
		this.ets = ets_debug;
		System.out.println("ok!");
	}

	//save pos direct
	public void keepRecAndEnemyTank() {
		try {
			fw = new FileWriter(".\\src\\myRecording.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(enNum+"\r\n");
			
			//save living pos
			for(int i=0;i<ets.size();i++) {
				
				//get first etank
				EnemyTank et = ets.get(i);
				if(et.isLive) {
					String record = et.x+" "+et.y;
					//in
					bw.write(record+"\r\n");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//后开先关
				bw.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	//recode
	public static void keepRecording() {
		try {
			fw = new FileWriter(".\\src\\myRecording.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				//后开先关
				bw.close();
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	//get record
	public static void getRecording() {
		try {
			fr =new FileReader(".\\src\\myRecording.txt");
			br = new BufferedReader(fr);
			String n = br.readLine();
			
			allEnNum=Integer.parseInt(n);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}

	//
	public static void reduceEnNum() {
		enNum--;
	}
	//
	public static void addEnNum() {
		allEnNum++;
	}	
	

	
}

//
class Bomb{
	
	int x,y;
	int life = 10;
	boolean isLive = true;
	
	public Bomb(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void lifeDown() {
		if(life > 0) {
			life--;
		}else {
			this.isLive=false;
		}
	}
}

//shot parent (tips:if after new it change it should runnable)
class Shot implements Runnable {
	int x = 0;
	int y = 0;
	int direct;
	int speed=1;
	int type=1;
	
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
//				System.out.println("pos:x="+x+",y="+y);
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
	
	Shot s = null;
	
	Vector<Shot> ss = new Vector<Shot>();
	
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
	
	public Hero(int x,int y) {
		super(x, y);
		color=1;
	}
	
	//fire
	public void shotEnemy() {
		
		switch (this.direct) {
		case 0:
			//
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

//the pos should change must runnable
class EnemyTank extends Tank implements Runnable{
	
	int shotTime=0;
	
	//get msg from panel
	Vector<EnemyTank> est = new Vector<EnemyTank>();
	
	//
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void setEts(Vector<EnemyTank> vv) {
		this.est=vv;
	}

	public boolean isTouchOtherEnemy() {
		boolean b=false;
		
		switch (this.direct) {
		case 0:
			//w
			for(int i=0;i<est.size();i++) {
				//pull a etank
				EnemyTank et=est.get(i);
					
				if(et!=this) {
					//et w or s
					if(et.direct==0||et.direct==2) {
						//left
						if(this.x>=et.x&&this.x<et.x+20&&this.y>=et.y&&this.y<=et.y+30) {
							return true;
						}
						//right
						if(this.x+20>=et.x&&this.x+20<et.x+20&&this.y>=et.y&&this.y<=et.y+30) {
							return true;
						}
						
					}
					//et a or d
					if(et.direct==3||et.direct==1) {
						if(this.x>=et.x&&this.x<et.x+30&&this.y>=et.y&&this.y<=et.y+20) {
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<et.x+30&&this.y>=et.y&&this.y<=et.y+20) {
							return true;
						}
							
					}
				}
			}
			
			break;
		case 1:
			//d
			for(int i=0;i<est.size();i++) {
				//pull a etank
				EnemyTank et=est.get(i);
					
				if(et!=this) {
					//w or s
					if(et.direct==0||et.direct==2) {
						//upP
						if(this.x+30>=et.x&&this.x+30<et.x+20&&this.y>=et.y&&this.y<=et.y+30) {
							return true;
						}
						//downP
						if(this.x+30>=et.x&&this.x+30<et.x+20&&this.y+20>=et.y&&this.y<=et.y+30) {
							return true;
						}
						
					}
					if(et.direct==3||et.direct==1) {
						if(this.x+30>=et.x&&this.x+30<et.x+30&&this.y>=et.y&&this.y<=et.y+20) {
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20) {
							return true;
						}
							
					}
				}
			}
			
			break;
		case 2:
			//s
			for(int i=0;i<est.size();i++) {
				//pull a etank
				EnemyTank et=est.get(i);
					
				if(et!=this) {
					//w or s
					if(et.direct==0||et.direct==2) {
						//leftP
						if(this.x>=et.x&&this.x<et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30) {
							return true;
						}
						//RightP
						if(this.x+20>=et.x&&this.x+20<et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30) {
							return true;
						}
						
					}
					if(et.direct==3||et.direct==1) {
						if(this.x>=et.x&&this.x<et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20) {
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20) {
							return true;
						}
							
					}
				}
			}
			break;	
		case 3:
			//a
			for(int i=0;i<est.size();i++) {
				//pull a etank
				EnemyTank et=est.get(i);
					
				if(et!=this) {
					//w or s
					if(et.direct==0||et.direct==2) {
						//upPoint
						if(this.x>=et.x&&this.x<et.x+20&&this.y>=et.y&&this.y<=et.y+30) {
							return true;
						}
						//downPoint
						if(this.x>=et.x&&this.x<et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30) {
							return true;
						}
						
					}
					if(et.direct==3||et.direct==1) {
						if(this.x>=et.x&&this.x<et.x+30&&this.y>=et.y&&this.y<=et.y+20) {
							return true;
						}
						if(this.x>=et.x&&this.x<et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20) {
							return true;
						}
							
					}
				}
			}
			break;	
		default:
			break;
		}
		return b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			switch (this.direct) {
			case 0:
				//w
				for(int i=0;i<30;i++) {
					//keep in panel
					if(y>0&&!this.isTouchOtherEnemy()) {
						//moveUp
						y-=speed;
					}
					
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					}
				}
				break;
			case 1:
				//d
				for(int i=0;i<30;i++) {
					if(x<400&&!this.isTouchOtherEnemy()) {
						x+=speed;
					}
					
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
				break;
			case 2:
				//s
				for(int i=0;i<30;i++) {
					
					//
					if(y<300&&!this.isTouchOtherEnemy()) {
						y+=speed;
					}
					
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					}
				}
				break;
			case 3:
				//a
				for(int i=0;i<30;i++) {
					
					if(x>0&&!this.isTouchOtherEnemy()) {
						x-=speed; 
					}
					
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					}
				}
				break;
			default:
				break;
			}
			
			this.shotTime++;
			
			//check should add shot
			if(shotTime%2==0) {
				if(isLive) {
					if(ss.size()<5) {
						Shot s = null;
						
						switch (direct) {
						case 0:
							//
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
						
						Thread etstr = new Thread(s);
						etstr.start();
					}
				}
			}
			
//			for(int i=0;i<est.size();i++) {
//				EnemyTank et = est.get(i);
//			}
			
			//random direct
			this.direct=(int)(Math.random()*4);
			//check if etank died
			if(this.isLive==false) {
				break;
			}
			//check have shot
			if(ss.size()<1) {
				
			}
			
		}
	}

}
