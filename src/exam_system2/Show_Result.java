package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Show_Result extends JFrame{
    
    private Container c;
    private JButton bn1, bn2, exit, back, next, save;
    private Font f1, f2, f3, f4, f5;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton mcq, code, show, submit;
    String St, cs, cr, cs1;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer;
    String st1, st2, sto, username, course;
    private JTextArea Area;
    private JScrollPane scp;
    private JLabel total_ques, each_mark, error, obtained_mark, percentage;
    int total_marks, obtained_marks, error_no, cr_mcq, crct, x, y, percent, t_mcq, o_mcq;
    int t_marks, o_marks;
    
     Show_Result(String u_name)
    {
        st2 = u_name;
        initComponents(st2);
    }
    
    void initComponents(String name)
    {
        username = name;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        back = new JButton("Back");
        back.setBounds(30,630,90,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                UPanel1 es = new  UPanel1(username);
            }
            
        });
        
        Area = new JTextArea();
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scp.setBounds(50,75,900,500);
       
        
        show = new JButton("Show");
        show.setBounds(980,150,90,40);
        show.setBackground(Color.CYAN);
        show.setForeground(Color.darkGray);
        show.setFont(f2);
        
        show.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                String f_name = username+"_result.txt";
                String line;
         
             try{
                     
                     File result = new File("Students/"+username+"/"+f_name);
                     
                    reader = new BufferedReader(new FileReader(result));
                         
                     
                         while((line = reader.readLine())!=null)
                         {
                              
                             String sd[] = line.split("\n");
                            
                             
                             for(String temp: sd)
                             {
                                 Area.append("\n\n\t\t   "+temp);
                             }
                         
                         }
                     
                         
                     
                 }
                 
                 catch(Exception e)
                 {
                     e.printStackTrace();
                 }
                 
                 finally
                 {
                     try
                     {
                         reader.close();
                          
                     }
                     catch(IOException e){
                         e.printStackTrace();
                     }
                 }
               
        
            }
            
        });
        
        Area.setEditable(false);
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(scp);
        c.add(back);
        c.add(show);
        
      }
    /* public static void main(String args[])
     {
         String name = "Jabbar";
         
         Show_Result srt = new Show_Result(name);
     }*/
    }


