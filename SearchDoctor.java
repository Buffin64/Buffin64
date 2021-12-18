package com.hms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SearchDoctor extends JInternalFrame implements ActionListener{
    
    Connection con;
    Statement st;
    ResultSet rs;
    JButton btnSearch;
    GridBagLayout gbl;
    GridBagConstraints c;
    JLabel lblID, lblFName, lblLName, lblPhoto;
    JTextField txtID;

    
     public SearchDoctor(Connection cn){
        super("New Doctor Form", true, true, true, true);
        
        this.con = cn;
        
        setSize(500, 700);
        
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
        
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnSearch.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(btnSearch, c);
        
        lblFName = new JLabel();
        lblFName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblFName, c);
        
        lblLName = new JLabel();
        lblLName.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblLName, c);
        
        lblPhoto = new JLabel();
        lblPhoto.setFont(new Font("Consolas", Font.BOLD, 30));
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10);
        add(lblPhoto, c);
        
        setVisible(true);
    
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    if(e.getSource() == btnSearch){
        
        try {
            
            st = con.createStatement();
            
            String query = "select * from Doctors where Doctor_Id = '"+txtID.getText()+"'         ";
            
            rs = st.executeQuery(query);
            
            while(rs.next()){
                
                lblFName.setText(rs.getString("FirstName"));
                
                lblLName.setText(rs.getString("LastName"));
                
                lblPhoto.setIcon(new ImageIcon(rs.getString("photo")));
                
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    }
}