package exam_system2;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ExamSystem extends JFrame {
    
   private Container c;
   private JLabel l;
   private Font f, f1;
   private JButton userLogin,adminLogin;
    
    ExamSystem(String name)
    {
        String u_name = name;
        initComponents(u_name);
    }
    
    void initComponents(String username)
    {
       
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(null);
        
        f = new Font("Arial",Font.BOLD, 64);
        f1 = new Font("Arial",Font.BOLD, 30);
        
        
        l = new JLabel();
        c.add(l);
        
        l.setText("Login");
        l.setBounds(510,100,300,100);
        l.setForeground(Color.orange);
        l.setFont(f);
        
        userLogin = new JButton("User Login");
        userLogin.setBounds(420,250,350,100);
        userLogin.setBackground(Color.lightGray);
        userLogin.setForeground((Color.BLACK));
        userLogin.setFont(f1);
        c.add(userLogin);
        
        userLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                ExamSystem02 userFrame = new ExamSystem02();
                userFrame.setVisible(true);
            }
        
         });
        
        adminLogin = new JButton("Admin Login");
        adminLogin.setBounds(420,400,350,100);
        adminLogin.setBackground(Color.lightGray);
        adminLogin.setForeground((Color.BLACK));
        adminLogin.setFont(f1);
        c.add(adminLogin);
        
        adminLogin.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                ExamSystem01 adminFrame = new ExamSystem01(username);
                adminFrame.setVisible(true);
            }
        
        });
        
     }
    
    /*public static void main(String args[])
    {
        ExamSystem frame = new ExamSystem();
        
    }*/
}
