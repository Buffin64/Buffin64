package mdi;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
public class Main extends JFrame{
    Dimension d;
    JDesktopPane dtpane;
    JInternalFrame frmBooks;
    Main(){
    super("DashBoard");
    d = Toolkit.getDefaultToolkit().getScreenSize();
    dtpane = new JDesktopPane();
    frmBooks=new Books();
    dtpane.add(frmBooks);
    
    add(dtpane);
    setSize(d);
    setVisible(true);
    }
    public static void main(String[] args){
       new Main();
    }}
