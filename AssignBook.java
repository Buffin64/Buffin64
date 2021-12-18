package mdi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AssignBook extends JInternalFrame{
JLabel lbstdName,lbstdId,lbstdCourse,lbTitle,lbbname,lbcat;
JComboBox cmbStdname,cmbBookName,cmbCategory;
JPanel panBook;
GridBagConstraints c;
GridBagLayout gbl;
AssignBook(){
	panBook=new JPanel();
	c=new GridBagConstraints();
	gbl=new GridBagLayout();
	panBook.setLayout(gbl);
	 //assign a book
    lbstdName=new JLabel("Student Name");
    lbstdName.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=0;
    c.gridx=0;
    c.insets=new Insets(5,5,5,5);
    panBook.add(lbstdName,c);
    
    cmbStdname=new JComboBox();
    cmbStdname.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    cmbStdname.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=0;
    c.gridx=1;
    c.insets=new Insets(5,5,5,5);
    panBook.add(cmbStdname,c);
    
    lbbname=new JLabel("Book Name");
    lbbname.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=1;
    c.gridx=0;
    c.insets=new Insets(5,5,5,5);
    panBook.add(lbbname,c);
    
    cmbBookName=new JComboBox();
    cmbBookName.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    cmbBookName.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=1;
    c.gridx=1;
    c.insets=new Insets(5,5,5,5);
    panBook.add(cmbBookName,c);
    
  
    lbcat=new JLabel("Student Course");
    lbcat.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=2;
    c.gridx=0;
    c.insets=new Insets(5,5,5,5);
    panBook.add(lbcat,c);
    
    cmbCategory=new JComboBox();
    cmbCategory.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    cmbCategory.setFont(new Font("arial",Font.BOLD,20));
    c.anchor=GridBagConstraints.NORTH;
    c.fill=GridBagConstraints.BOTH;
    c.gridy=2;
    c.gridx=1;
    c.insets=new Insets(5,5,5,5);
    panBook.add(cmbCategory,c);
    
    pack();
    add(panBook,BorderLayout.NORTH);
    setVisible(true);
}
}
