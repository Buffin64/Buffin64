import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

class LoginFrm extends JFrame{
GridBagLayout gbl;
GridBagConstraints c;
JLabel luser,lpass;
JTextField tuser,tpass;
   LoginFrm(){
   c= GridBagConstraints();
   gbl=GridBagLayout();
   setLayout(gbl);
   
   
  luser = new JLabel();
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=0;
  c.insets=new Insets(5,5,5,5);
  add(luser,c);

  tuser = new JTextField();
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=1;
  c.gridy=0;
  c.insets=new Insets(5,5,5,5);
  add(tuser,c);

  lpass = new JLabel();
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=1;
  c.insets=new Insets(5,5,5,5);
  add(lpass,c);

  tpass = new JTextField();
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=1;
  c.gridy=1;
  c.insets=new Insets(5,5,5,5);
  add(tpass,c);
  
  btnlogin = new JButton();
  c.anchor=GridBagConstraints.CENTER;
  c.fill=GridBagConstraints.BOTH;
  c.gridx=0;
  c.gridy=2;
  c.insets=new Insets(5,5,5,5);
  add(btnlogin,c);

btnlogin.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e){
 String user = tuser.getText();
 String pass = tpass.getText();

if(user.equals("admin") && pass.equals("admin")){
JOPtionPane.showMessageDialog(LoginFrm.this,"Successful");
}else{
JOPtionPane.showMessageDialog(LoginFrm.this,"Failed");
}
 }});
  setSize(300,400);
  setLocationRelative(null);
  setVisible(true);
   }

public static void main(String[] args){
 new LoginFrm();
}
}