package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class Set_Q1 extends JFrame {
    
    private Container c;
    private JButton bn1, bn2, back;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm;
    String St, St1;
         
    Set_Q1(String name)
    {
        String n = name;
        
        initComponents(n);
    }
    
    void initComponents(String name)
    {
         Add_Course ac = new Add_Course(name);
         
         f2 = new Font("Arial",Font.BOLD,20);
         f1 = new Font("Arial",Font.BOLD,35);
         f3 = new Font("Arial", Font.BOLD,25);
         f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        jn = new JButton("Select Course");
        jn.setBounds(488,130,210,60);
        jn.setFont(f3);
        jn.setBackground(Color.lightGray);
        
        jn.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                 
                 try{
                     File f = new File("Course.txt");
                     //f.getParentFile().mkdirs();
                     
                     FileReader c = new FileReader("Course.txt");
                     br = new BufferedReader(new FileReader("Course.txt"));
                     
                     while(c.read()!=-1){
                         String be = br.readLine();
                         ac.programming_lang.add(be);
                     }
                }
                
                catch(IOException e){
                    e.printStackTrace();
                }
                
                finally{
                    try{
                        br.close();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
        
             }
        
        
        
        });
        
        
        cb = new JComboBox(ac.programming_lang);
        cb.setBounds(445,240,300,60);
        cb.setFont(f4);
        cb.setEditable(false);
        
        bn1 = new JButton("Log Out");
        bn1.setBounds(1020,40,140,50);
        bn1.setFont(f2);
        bn1.setBackground(Color.ORANGE);
        
        bn1.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                  
                 dispose();
                 ExamSystem03 e2 = new ExamSystem03(name);
             }
        
        
        });
        
        bn2 = new JButton("Set Ques.");
        bn2.setBounds(510,360,160,60);
        bn2.setBackground(Color.lightGray);
        bn2.setFont(f4);
        
        bn2.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                 
                 St = cb.getSelectedItem().toString();
                 St1 = name;
                 
                 try
                 {
                     File fl =  new File("Questions\\"+St);
                     
                     if(!fl.exists())
                     {
                         fl.mkdir();
                     }
                 }
                 
                 catch(Exception e)
                 {
                     e.printStackTrace();
                 }
                 
                 dispose();
                 Set_Ques sq = new Set_Ques(St,St1);
             }
        
        
        
        });
        
        //String name1 = St1;
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem03 e = new ExamSystem03(name);
            }
            
        });
       
       
        c = getContentPane();
        c.setBackground(Color.darkGray);
        c.setLayout(null);
        
        c.add(bn1);
        c.add(bn2);
        c.add(jn);
        c.add(cb);
        c.add(back);
    }
    
    /*public static void main(String[]args)
    {
        Set_Q1 up = new Set_Q1();
        up.setVisible(true);
    }*/
}

