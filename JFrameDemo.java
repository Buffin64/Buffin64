import javax.swing.*;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class JFrameDemo extends JFrame implements ActionListener{
	JButton btnSend;
	JPasswordField tf;
	JButton south;
	JTextField north;
	GridBagLayout gbl;
	GridBagConstraints c;
	JFrameDemo(){
     //properties of jframe
		super("JFrame");
       gbl = new GridBagLayout();
       c = new GridBagConstraints();
       setLayout(new GridBagLayout());

		north=new JTextField(10);
		c.anchor=GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		add(north,c);

		tf = new JPasswordField(10);
		c.anchor=GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		add(tf,c);
		//tf.setBounds(10,20,50,20);
		btnSend = new JButton("Send");
		c.anchor=GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(5,5,5,5);
		add(btnSend,c);

		btnSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
      String user = north.getText();
      String pass = tf.getText();

      if(user.equals("admin") && pass.equals("admin")){
       JOptionPane.showMessageDialog(JFrameDemo.this,
   	   "Login successful");	
      }else{
      	JOptionPane.showMessageDialog(JFrameDemo.this,
   	   "Login failed");	
      }
  
			}
		});
		//btnSend.setBounds(10,40,100,20);
		south = new JButton("South");
        c.anchor=GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=1;
		c.gridy=1;
		c.insets=new Insets(5,5,5,5);
		add(south,c);
		
		south.addActionListener(this);
		setSize(300,400);
		

    addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){
  int d = JOptionPane.showConfirmDialog(JFrameDemo.this,
  	   "Do you want to exit","Alert",JOptionPane.YES_NO_OPTION);
    if(d==JOptionPane.YES_OPTION){
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }else{
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
    }
    }
    });

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JFrameDemo();
	}
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(JFrameDemo.this,
   	   "Thank you");	
	}
}
