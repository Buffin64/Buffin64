package com.hms;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kise
 */
public class NewDoctor extends JInternalFrame implements ActionListener{
    
    /*
    mysql> desc Doctors;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| Doctor_ID  | varchar(10)  | NO   | PRI | NULL    |       |
| FirstName  | varchar(50)  | YES  |     | NULL    |       |
| LastName   | varchar(50)  | YES  |     | NULL    |       |
| Department | varchar(100) | YES  |     | NULL    |       |
| BirthDate  | date         | YES  |     | NULL    |       |
| HireDate   | date         | YES  |     | NULL    |       |
| address    | varchar(100) | YES  |     | NULL    |       |
| Phone      | varchar(100) | YES  |     | NULL    |       |
| photo      | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
9 rows in set (0.00 sec)

    */
    
    
    JLabel lblID, lblFName, lblLName, lblDpt, lblBD, lblHD, lbladdress, lblPhone, lblPhoto;
    JTextField txtID, txtFName, txtLName, txtDpt, txtBD, txtHD, txtaddress, txtPhone, txtPhoto;
    JButton btnAdd;
    GridBagLayout gbl;
    GridBagConstraints c;
    Image img;
    
    Connection con;
    Statement st;
    
    public NewDoctor(Connection cn){
        super("New Doctor Form", false, true, true, true);
        
        this.con = cn;
        
        setSize(500, 700);
        
        
        img = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
		
		this.setContentPane(new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}
			
				
		});
        
        
        gbl = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(gbl);
        
        lblID = new JLabel("Doctor ID");
        lblID.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblID, c);
        
        txtID = new JTextField();
        txtID.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtID, c);
        
        
        lblFName = new JLabel("First Name");
        lblFName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblFName, c);
        
        txtFName = new JTextField();
        txtFName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtFName, c);
                
        lblLName = new JLabel("Last Name");
        lblLName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblLName, c);
        
        txtLName = new JTextField();
        txtLName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtLName, c);
        
        lblDpt = new JLabel("Department");
        lblDpt.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblDpt, c);
        
        txtDpt = new JTextField();
        txtDpt.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtDpt, c);
        
        lblBD = new JLabel("Birth Date");
        lblBD.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblBD, c);
        
        txtBD = new JTextField();
        txtBD.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtBD, c);
         
        lblHD = new JLabel("Hire Date");
        lblHD.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblHD, c);
        
        txtHD = new JTextField();
        txtHD.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtHD, c);
                
        lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(10, 10, 10, 10);
        add(lbladdress, c);
        
        txtaddress = new JTextField();
        txtaddress.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtaddress, c);
                
        lblPhone = new JLabel("Phone No");
        lblPhone.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPhone, c);
        
        txtPhone = new JTextField();
        txtPhone.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtPhone, c);
        
                
        lblPhoto = new JLabel("Photo");
        lblPhoto.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPhoto, c);
        
        txtPhoto = new JTextField();
        txtPhoto.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtPhoto, c);
        
        btnAdd = new JButton("Add Doctor");
        btnAdd.addActionListener(this);
        btnAdd.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 9;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnAdd, c);
        
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //String id = txtID.getText();
        String fn = txtFName.getText();
        String ln = txtLName.getText();
        String dpt = txtDpt.getText();
        String birthday = txtBD.getText();
        String employed = txtHD.getText();
        String add = txtaddress.getText();
        String simu = txtPhone.getText();
        String picha = txtPhoto.getText();
    
        if(e.getSource() == btnAdd){
            
        
        try {
           
            
            st = con.createStatement();
            
            String insertStatement = "insert into Doctors values('"+txtID.getText()+"', '"+fn+"', '"+ln+"', '"+dpt+"', '"+birthday+"', '"+employed+"', '"+add+"', '"+simu+"', '"+picha+"')";
        
            
            int rowsAffected = st.executeUpdate(insertStatement);
        
            JOptionPane.showMessageDialog(null, rowsAffected + " record added successfully");
        
            
        txtID.setText("");
        txtFName.setText("");
        txtLName.setText("");
        txtDpt.setText("");
        txtBD.setText("");
        txtHD.setText("");
        txtaddress.setText("");
        txtPhone.setText("");
        txtPhoto.setText("");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewDoctor.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        }
    
        }//end of if block
    
    
    }
    
}
