package stuManager2;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialog extends JDialog implements ActionListener{
	
	//set swing
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JPanel jp1,jp2,jp3;
	//owner is parent window
	//modal set 模式窗口 or 非模式
	public StuAddDialog(Frame owner, String title, boolean mobal) {
		
		super(owner,title,mobal);
		jl1 = new JLabel("学号");
		jl2 = new JLabel("姓名");
		jl3 = new JLabel("性别");
		jl4 = new JLabel("生日");
		jl5 = new JLabel("记过次数");
		
		//
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		
		//
		jb1 = new JButton("添加");
		jb2 = new JButton("取消");
		
		//
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		
		//
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		
		//
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		
		//
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST); 
		this.add(jp2,BorderLayout.CENTER); 
		this.add(jp3,BorderLayout.SOUTH);
		
		//
		jb1.addActionListener(this);
		
		//
		this.setSize(300,200);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
