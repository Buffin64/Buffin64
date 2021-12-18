package com.hms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kise
 */
public class Login extends JFrame implements KeyListener{
    
    JLabel lblImg;
    JTextField txtUser;
    JPasswordField txtPass;
    GridBagLayout gbl;
    GridBagConstraints c;
    ConnectionPool cp;

    public Login() {
        
//        MAXIMIZED_HORIZ
//        MAXIMIZED_VERT
//        MAXIMIZED_BOTH
        
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setContentPane(new JLabel(new ImageIcon("images/Tulips.jpg")));
        
        gbl = new GridBagLayout();
        c = new GridBagConstraints();
        
        setLayout(gbl);
        
        lblImg = new JLabel(new ImageIcon("images/1626349347405.jpg"));
	c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
	add(lblImg, c);
        
        txtUser = new JTextField();
        txtUser.setFont(new Font("Arial", Font.BOLD, 30));
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtUser, c);
        
        txtPass = new JPasswordField();
        txtPass.addKeyListener(this);
        txtPass.setFont(new Font("Arial", Font.BOLD, 30));
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 10, 10, 10);
        add(txtPass, c);
        
        
        setVisible(true);        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        
        String username = txtUser.getText();
        String password = String.valueOf(txtPass.getPassword());
      
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
        
            if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "Cannot be blank! Please type correct username and password");
            }else{
               
                cp = new ConnectionPool(username, password, "hospital_management_system");
                
                if(cp.createCon2()){
                    
                    JOptionPane.showMessageDialog(null, "Login successful");
                    
                    dispose();
                    
                    new Main(cp.con); 
                    
                }
                
                }
        
        }
        
    }
    
}
