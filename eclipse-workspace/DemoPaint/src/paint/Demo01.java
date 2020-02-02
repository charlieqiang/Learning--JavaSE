/**
 * @author Charlie
 * feature paint
 */
package paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo01 extends JFrame{

	MyPanel mp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo01 demo01 = new Demo01();
		
									
	}
	
	public Demo01()
	{
		mp = new MyPanel();
		
		this.add(mp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.setVisible(true);
		  
	}
}

class MyPanel extends JPanel
{
	//override paint
	//Graphics is a pen		
	public void paint(Graphics g) {
		//this cant be ignore
		//1.init
		super.paint(g);
		//2.draw a round
		//g.drawOval(10, 10, 30, 30);
		//3.draw a rect
		//g.setColor(Color.blue);
		//g.fillRect(10, 10, 40, 60);
		//4.draw a picture
		Image im = Toolkit.
				getDefaultToolkit().
				getImage(Panel.class.getResource("/shoes.jpeg"));
		g.drawImage(im, 90, 90, 200, 200, this);
		//5.draw font
		g.setFont(new Font("»ªÎÄ²ÊÔÆ",Font.BOLD,50));
		g.drawString("hello", 100, 100);
		
	}
}