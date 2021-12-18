package com.hms;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author kise
 */
public class StartupScreen extends JWindow{
    
    JProgressBar bar;

    public StartupScreen() {
        
        createUI();
        createProgressBar();
        initiateProgress();
        
    }
    
    public void createUI(){
        setSize(600, 600);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon("images/Penguins.jpg")));
        setLayout(null);
        
        setVisible(true);
    }
    
    
    public JProgressBar createProgressBar(){
        bar = new JProgressBar();
        bar.setBounds(10, 560, 580, 30);
        bar.setBorderPainted(true);
        bar.setStringPainted(true);
        bar.setBackground(Color.WHITE);
        bar.setForeground(Color.red);
        bar.setValue(0);        
        add(bar);  
        
        return bar;
        
    }
    
    
    public void initiateProgress(){
        
        int i = 1;
        
        while(i <= 100){
            
            try {
                
                Thread.sleep(50);
                bar.setValue(i);
                
                i++;
                
                 if(i == 100){
            
                    dispose();
                    
                    new Login();
            
                }              
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(StartupScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//while
        
    }
   
    public static void main(String[] args) {
       new StartupScreen();
    }
}