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

public class Front_Page extends JFrame {
    
   private Container c;
   private JLabel l;
   private Font f, f1, f3;
   private JButton userLogin,adminLogin, about, enter;
    
    Front_Page()
    {
        initComponents();
    }
    
    void initComponents()
    {
       
        String str = null;
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setBackground(Color.darkGray);
        c.setLayout(null);
        
        f = new Font("Arial",Font.BOLD, 64);
        f1 = new Font("Arial",Font.BOLD, 30);
        f3 = new Font("Arial",Font.BOLD,23);
        
        
        l = new JLabel();
        c.add(l);
        
        l.setText("Examination System");
        l.setBounds(295,200,800,100);
        l.setForeground(Color.WHITE);
        l.setBackground(Color.darkGray);
        l.setFont(f);
        
        
        about = new JButton("About");
        about.setBounds(50,640,140,50);
        about.setBackground(Color.CYAN);
        about.setForeground(Color.darkGray);
        about.setFont(f3);
        c.add(about);
        
        /*about.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem02 e = new ExamSystem02();
            }
            
        });*/
        
        enter = new JButton("Enter");
        enter.setBounds(1000,630,140,50);
        enter.setBackground(Color.CYAN);
        enter.setForeground(Color.darkGray);
        enter.setFont(f3);
        c.add(enter);
        
        enter.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem e = new ExamSystem(str);
            }
            
        });


        
     }
    
    public static void main(String[] args)
    {
        Front_Page frame = new Front_Page();
        
    }
}
