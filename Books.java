
package mdi;

import authenticate.ConnectionPool;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Books extends JInternalFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderLayout blyt;
    GridBagLayout gbl;
    GridBagConstraints c;
    Dimension d;
    JPanel panInsertBook;
    JTextField tfBookId,tfBookName;
    JLabel lbBookId,lbBookName,lbCategory,lbTitle;
    JComboBox cmbCategory;
    JButton btnSubmit;
    String[] bookCategory;
    JTable tb;
    static DefaultTableModel tbmodel;
    JScrollPane sp;
   Books(){
      super("Books",true,true,true,true); 
      d=Toolkit.getDefaultToolkit().getScreenSize();
      
      gbl=new GridBagLayout();
      c=new GridBagConstraints();
      
      panInsertBook=new JPanel();
      panInsertBook.setLayout(gbl);
      panInsertBook.setBorder(BorderFactory.createEtchedBorder());
      
      lbTitle=new JLabel("Insert Book");
      lbTitle.setFont(new Font("arial",Font.BOLD,50)); 
     c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=0;
      c.gridx=1;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(lbTitle,c);
      
      lbBookId=new JLabel("Book ID");
      lbBookId.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=2;
      c.gridx=0;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(lbBookId,c);
      
      tfBookId=new JTextField(20);
      tfBookId.setBorder(BorderFactory.createLoweredSoftBevelBorder());
      tfBookId.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=2;
      c.gridx=1;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(tfBookId,c);
      
      lbBookName=new JLabel("Book Name");
      lbBookName.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=3;
      c.gridx=0;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(lbBookName,c);
      
      tfBookName=new JTextField(20);
      tfBookName.setBorder(BorderFactory.createLoweredSoftBevelBorder());
      tfBookName.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=3;
      c.gridx=1;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(tfBookName,c);
      
      
      lbCategory=new JLabel("CATEGORY");
      lbCategory.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=4;
      c.gridx=0;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(lbCategory,c);
      
      bookCategory=new String[]{"ICT Books",
    		  "SE Books",
    		  "Graphics Books"
    		  ,"Artisan Books"};
      cmbCategory=new JComboBox(bookCategory);
      cmbCategory.setBorder(BorderFactory.createLoweredSoftBevelBorder());
      cmbCategory.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=4;
      c.gridx=1;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(cmbCategory,c);
      
      btnSubmit=new JButton("Submit");
      btnSubmit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
      btnSubmit.setFont(new Font("arial",Font.BOLD,20));
      c.anchor=GridBagConstraints.NORTH;
      c.fill=GridBagConstraints.BOTH;
      c.gridy=5;
      c.gridx=1;
      c.insets=new Insets(5,5,5,5);
      panInsertBook.add(btnSubmit,c);
      btnSubmit.addActionListener(this);
      
      tbmodel=new DefaultTableModel();
      tbmodel.addColumn("Book ID");
      tbmodel.addColumn("Book Name");
      tbmodel.addColumn("Book Category");
      
      boolean rows=Books.bookDetails();
      
      tb = new JTable(tbmodel);
      sp = new JScrollPane(tb);
      sp.setBorder(BorderFactory.createEtchedBorder());
      
      add(sp,BorderLayout.CENTER);
      add(panInsertBook,BorderLayout.WEST);
      //setLayout(new BorderLayout());
      pack();
      setVisible(true);
   }
private static boolean bookDetails() {
	PreparedStatement ps;
	ConnectionPool cpool=new ConnectionPool("root","");
	Connection con = cpool.connector();
	String query="select * from books";
	
	if(con!=null){
	try {
		ps=con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		String id = rs.getString("bookId");
		String bname=rs.getString("bookName");
		String bcat=rs.getString("bookCat");
		Books.tbmodel.addRow(new Object[]{id,bname,bcat});
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}else{
		JOptionPane.showMessageDialog(null,"Connection Failed");		
	}
	
	return true;
}
public void actionPerformed(ActionEvent e) {
	String bname=tfBookName.getText();
	String bid=tfBookId.getText();
	String bcat=(String) cmbCategory.getSelectedItem();
	PreparedStatement ps;
	ConnectionPool cpool=new ConnectionPool("root","");
	Connection con = cpool.connector();
	if(e.getSource() == btnSubmit){
		
		if(bname.equals("")||bid.equals("")){
		JOptionPane.showMessageDialog(null, "One or more fields is required");	
		}else{
			if(con!=null){
	String query1="select bookId from books where bookId=?";			
	String query="insert into books(bookId,bookName,bookCat)"
		+"values(?,?,?)";
	
	try {
		ps = con.prepareStatement(query1);
		ps.setInt(1, Integer.parseInt(bid));
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			JOptionPane.showMessageDialog(null,"Book exists");	
		}else{
			try {
				ps = con.prepareStatement(query);
				ps.setString(1,bid);
				ps.setString(2,bname);
				ps.setString(3,bcat);
				int insert=ps.executeUpdate();
			if(insert==1){
				JOptionPane.showMessageDialog(null,"Book Inserted");			
				tbmodel.setRowCount(0);
				Books.bookDetails();
			   }else{
				JOptionPane.showMessageDialog(null,"Book Insert Failed");				
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1);	
				}	}
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}   
		}else{
			JOptionPane.showMessageDialog(null,"Connection Failed");	
			}
		}
	}
	}}
