import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Log2 extends JFrame{
GridBagLayout gbl;
GridBagConstraints c;
JLabel luser,lpass;
JTextField tuser,tpass;
JButton btnlogin;
   Log2(){
   c= new GridBagConstraints();
   gbl=new GridBagLayout();
   setLayout(gbl);
   
   
  luser = new JLabel("Username");
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=0;
  c.insets=new Insets(5,5,5,5);
  add(luser,c);

  tuser = new JTextField(10);
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=1;
  c.gridy=0;
  c.insets=new Insets(5,5,5,5);
  add(tuser,c);

  lpass = new JLabel("Password");
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=1;
  c.insets=new Insets(5,5,5,5);
  add(lpass,c);

  tpass = new JTextField(10);
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=1;
  c.gridy=1;
  c.insets=new Insets(5,5,5,5);
  add(tpass,c);
  
  btnlogin = new JButton("Login");
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=2;
  c.insets=new Insets(5,5,5,5);
  add(btnlogin,c);

btnlogin.addActionListener(new ActionListener

(){
 public void actionPerformed(ActionEvent e){
 String user = tuser.getText();
 String pass = tpass.getText();

if(user.equals("admin") && pass.equals("admin")){
JOptionPane.showMessageDialog(Log2.this,"Successful");
}else{
JOptionPane.showMessageDialog(Log2.this,"Failed");
}
 }});
  setSize(300,400);
  setLocationRelativeTo(null);
  setVisible(true);
   }

public static void main(String[] args){
 new Log2();
}
}