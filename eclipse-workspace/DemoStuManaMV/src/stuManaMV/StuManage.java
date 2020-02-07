/**
 * @Description stumanager3.0
 * 1.impliment crul
 * 		1.1add
 * @author Charlie
 * @date 2020-02-07 10:39
 */
package stuManaMV;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StuManage extends JFrame implements ActionListener{

	//define view
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	StuModel sm=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuManage d01=new StuManage();
	}
	//
	//constructor01
	public StuManage(){
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
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);


		//add
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		//new a obj
		sm = new StuModel();
 		String[] paras= {"1"};
		sm.queryStu("select * from stu where 1=?", paras);
		
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
			//System.out.println("ok");
			
			//
			String name = this.jtf.getText().trim();
			//input your sql
			String sql = "select * from stu where stuName=?";
			String paras[]= {name};
			//reload new data model
			sm = new StuModel();
			sm.queryStu(sql, paras);
			//update jt
			jt.setModel(sm);
		}
		//when add
		else if(e.getSource()==jb2) {
			//only if true will brock!! 
			StuAddDialog sa = new StuAddDialog(this,"添加学生", true); 
			//reload new data model
			//update jt
			//new a obj
			sm=new StuModel();
			
			String[] paras02= {"1"};
			sm.queryStu("select * from stu where 1=?", paras02);
			
			//update jt
			jt.setModel(sm);
		}
		
		//when change
		else if(e.getSource()==jb3) {
			
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			
			//disp dialog
			new StuUpdDialog(this, "修改学生", true, sm, rowNum);
			//reload new data model
			sm = new StuModel();
			String[] paras02= {"1"};
			sm.queryStu("select * from stu where 1=?", paras02);
			//update jt
			jt.setModel(sm);
		}
		
		//when add
		else if(e.getSource()==jb4) {
			//delete
			//1.get id obj
			int rowNum = this.jt.getSelectedRow();
			if(rowNum == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			
			//get id num
			String stuId = (String)sm.getValueAt(rowNum, 0);
			//new a sql
			String sql = "delete from stu where stuid=?";
			String[] paras02= {stuId};
			StuModel temp=new StuModel();
			temp.updStu(sql, paras02);
			
			//reload new data model
			sm = new StuModel();
			String[] paras0= {"1"};
			sm.queryStu("select * from stu where 1=?", paras0);
			jt.setModel(sm);
			
		}
	}
}
