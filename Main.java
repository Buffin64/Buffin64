package com.hms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author kise
 */
public class Main extends JFrame implements ActionListener{
    
    Dimension d;
    JDesktopPane desk;
    JMenuBar bar;
    JMenu mnuDoctor, mnuPatient;
    JMenuItem docAdd, docSearch, docUpdate, docDelete;
    JToolBar toolBar;
    JButton btnA, btnB, btnC;
    
    Connection con;
    
    public Main(Connection c)  {
        super("Main Window");
        
        this.con = c;
        
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);    
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        bar = new JMenuBar();

/////////// doctor menu ////////////////        
        mnuDoctor = new JMenu("Doctor");
        
        docAdd = new JMenuItem("Add Doctor");
        docAdd.addActionListener(this);
        mnuDoctor.add(docAdd);
        
        docSearch = new JMenuItem("Search for Doctor");
        docSearch.addActionListener(this);
        mnuDoctor.add(docSearch);
        
        docUpdate = new JMenuItem("Update Doctor");
        docUpdate.addActionListener(this);
        mnuDoctor.add(docUpdate);
        
        docDelete = new JMenuItem("Delete a Doctor");
        docDelete.addActionListener(this);
        mnuDoctor.add(docDelete);
        
        
        bar.add(mnuDoctor);
        
        
        
//////////// patient menu ////////////////        
        mnuPatient = new JMenu("Patient");
        
        bar.add(mnuPatient);
        
        setJMenuBar(bar);
        
        
        toolBar = new JToolBar();
        
        btnA = new JButton("Button A");
        btnA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btnB = new JButton("Button B");
        btnB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btnC = new JButton("Button C");
        btnC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        toolBar.add(btnA);
        toolBar.add(btnB);
        toolBar.add(btnC);
        
        
        add(toolBar, BorderLayout.NORTH);
        
        
        
        
        
        
        
        desk = new JDesktopPane();       
        
        add(desk);
        
        
        setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source == docAdd){
            desk.add(new NewDoctor(con));
        }else if(source == docSearch){
            desk.add(new SearchDoctor(con));
        }
        
    }
    
}
