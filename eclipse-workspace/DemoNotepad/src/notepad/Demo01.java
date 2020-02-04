package notepad;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Demo01 extends JFrame{

	//define the components
	JTextArea jta=null;
	//menuBar
	//menu
	//item
	JMenuBar jmb=null;
	JMenu jm01=null;
	JMenuItem jmi01=null;
	JMenuItem jmi02=null;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo01 demo01 = new Demo01();
									
	}
	//constructor function
	public Demo01() {
		//new com
		jta = new JTextArea();//defualt border layout
		jmb = new JMenuBar();
		jm01 = new JMenu("文件");
		//shotcut
		jm01.setMnemonic('F');
		jmi01 = new JMenuItem("打开");
		jmi02 = new JMenuItem("保存");
		
		//add menu
		this.setJMenuBar(jmb);
		jmb.add(jm01);
		jm01.add(jmi01);
		jm01.add(jmi02);
		
		//add com into JFrame 
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
	}

}
