package mdi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegStudents extends JInternalFrame{
	JPanel panRegister,panBook,panHolder;
	JLabel lbstdName,lbstdId,lbstdCourse,lbTitle,lbbname,lbcat;
	JTextField tfstdName,tfstdId,tfstdCourse;
	JComboBox cmbStdname,cmbBookName,cmbCategory;
	JButton btnSubmit;
	JTable table;
	DefaultTableModel tbmodel;
	JScrollPane sp;
	GridBagConstraints c;
	GridBagLayout gbl;
	RegStudents(){
		super("Students",true,true,true,true);
		panRegister=new JPanel();
		panBook=new JPanel();
		panHolder = new JPanel();
		
		c=new GridBagConstraints();
		gbl=new GridBagLayout();
		panRegister.setLayout(gbl);
		panBook.setLayout(gbl);
		
		  lbTitle=new JLabel("Register Student");
	      lbTitle.setFont(new Font("arial",Font.BOLD,50)); 
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=0;
	      c.gridx=1;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(lbTitle,c);
	      
	      lbstdName=new JLabel("Student Name");
	      lbstdName.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=2;
	      c.gridx=0;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(lbstdName,c);
	      
	      tfstdName=new JTextField(20);
	      tfstdName.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	      tfstdName.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=2;
	      c.gridx=1;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(tfstdName,c);
	      
	      lbstdId=new JLabel("Student ID");
	      lbstdId.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=3;
	      c.gridx=0;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(lbstdId,c);
	      
	      tfstdId=new JTextField(20);
	      tfstdId.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	      tfstdId.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=3;
	      c.gridx=1;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(tfstdId,c);
	      
	      lbstdCourse=new JLabel("Student Course");
	      lbstdCourse.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=4;
	      c.gridx=0;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(lbstdCourse,c);
	      
	      tfstdCourse=new JTextField(20);
	      tfstdCourse.setBorder(BorderFactory.createLoweredSoftBevelBorder());
	      tfstdCourse.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=4;
	      c.gridx=1;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(tfstdCourse,c);
	      
	      btnSubmit=new JButton("Submit");
	      btnSubmit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	      btnSubmit.setFont(new Font("arial",Font.BOLD,20));
	      c.anchor=GridBagConstraints.NORTH;
	      c.fill=GridBagConstraints.BOTH;
	      c.gridy=5;
	      c.gridx=1;
	      c.insets=new Insets(5,5,5,5);
	      panRegister.add(btnSubmit,c);
	      //btnSubmit.addActionListener(this);
	     
	      //add jtable
	      
	      tbmodel=new DefaultTableModel();
	      
	      
	      tbmodel.addColumn("STUDENT NAME");
	      tbmodel.addColumn("STUDENT ID");
	      tbmodel.addColumn("STUDENT COURSE");
	     
	      table=new JTable(tbmodel);
	      sp=new JScrollPane(table);
	      
        panHolder.setLayout(new GridLayout(2,1));
	    panHolder.add(panRegister);
	    add(panHolder,BorderLayout.WEST);
	    add(sp,BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
