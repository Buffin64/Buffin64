import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Card2 {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.setSize(550, 300);
      JPanel panel = new JPanel();
             panel.setBackground(Color.blue);
             panel.setSize(200,300);
      JPanel panel1 = new JPanel();
      panel1.setBackground(Color.blue);
      JPanel panel2 = new JPanel();
      panel2.setBackground(Color.GREEN);
      JPanel panel3 = new JPanel();
      panel3.setBackground(Color.gray);
      JPanel panel4 = new JPanel();
      panel4.setBackground(Color.MAGENTA);
      JPanel panel5 = new JPanel();
      panel5.setBackground(Color.PINK);
      JPanel btnPanel = new JPanel();
      JLabel label1 = new JLabel("Content of Card 1 is visible now!");
      JLabel label2 = new JLabel("Content of Card 2 is visible now!");
      JLabel label3 = new JLabel("Content of Card 3 is visible now!");
      JLabel label4 = new JLabel("Content of Card 4 is visible now!");
      JLabel label5 = new JLabel("Content of Card 5 is visible now!");
      JButton btn1 = new JButton("Display Card 1");
      JButton btn2 = new JButton("Display Card 2");
      JButton btn3 = new JButton("Display Card 3");
      JButton btn4 = new JButton("Display Card 4");
      JButton btn5 = new JButton("Display Card 5");
      CardLayout cardLayout = new CardLayout();
      panel.setLayout(cardLayout);
      panel1.add(label1);
      panel2.add(label2);
      panel3.add(label3);
      panel4.add(label4);
      panel5.add(label5);
      panel.add(panel1, "link1");
      panel.add(panel2, "link2");
      panel.add(panel3, "link3");
      panel.add(panel4, "link4");
      panel.add(panel5, "link5");
      btn1.addActionListener(e -> cardLayout.show(panel, "link"));
      btn2.addActionListener(e -> cardLayout.show(panel, "link2"));
      btn3.addActionListener(e -> cardLayout.show(panel, "link3"));
      btn4.addActionListener(e -> cardLayout.show(panel, "link4"));
      btn5.addActionListener(e -> cardLayout.show(panel, "link5"));
      btnPanel.add(btn1);
      btnPanel.add(btn2);
      btnPanel.add(btn3);
      btnPanel.add(btn4);
      btnPanel.add(btn5);
      frame.add(panel);
      frame.add(btnPanel, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
