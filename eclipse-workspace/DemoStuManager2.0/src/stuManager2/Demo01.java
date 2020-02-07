/**
 * @Description stumanager2.0
 * impliment crul
 * @author Charlie
 * @date 2020-02-07 10:39
 */
package stuManager2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Demo01 extends JFrame implements ActionListener{

	//define view
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo01 d01=new Demo01();
	}
	//
	//constructor01
	public Demo01(){
		//jp1
		jp1 = new JPanel();
		jl1 = new JLabel("请输入名字");
		jtf = new JTextField(10);
		
		jb1 = new JButton("查询");
		jb1.addActionListener(this);
		
		//add
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		//jp2
		jp2=new JPanel();
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb4=new JButton("删除");

		//add
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);

		//new a obj
		StuModel sm=new StuModel();
		//init JTable
		jt = new JTable(sm);
		//init jsp
		jsp = new JScrollPane(jt);
		//add jsp into jframe
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
			
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//check
		if (e.getSource()==jb1) {
			System.out.println("ok");
			
			//
			String name = this.jtf.getText().trim();
			//input your sql
			String sql = "select * from stu where stuName='"+name+"'";
			//
			StuModel sm = new StuModel(sql);
			//update jt
			jt.setModel(sm);
		}
		//when add
		else if(e.getSource()==jb2) {
			StuAddDialog sa = new StuAddDialog(this,"添加学生", true); 
			//reload new data model
		
		}
		
	}
}
