package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class Add_Course extends JFrame
{
    private JButton bn1, back, bn2, course;
    private Container c;
    private Font f1, f2, f3;
    private JTextField tf1, tf2;
    private JComboBox cb1;
    private JLabel lb1;
    private BufferedWriter br, br2;
    private BufferedReader br1;
     
    public Vector<String> programming_lang = new Vector<String>(100);
    public String pro_Lang, time;
        
    
    public Add_Course(String name)
    {
        String c_name = name;
        initComponents(name);
    }
    
    void initComponents(String name)
    {
        f1 = new Font("Arial",Font.BOLD,25);
        f2 = new Font("Arial",Font.BOLD,20);
        f3 = new Font("Arial",Font.BOLD,30);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        tf1 = new JTextField("Course");
        tf1.setBounds(285, 180, 370, 60);
        tf1.setFont(f2);
       
        
        tf2 = new JTextField("Time(min)");
        tf2.setBounds(285, 250, 370, 60);
        tf2.setFont(f2);
        
        
        
        course = new JButton("Course");
        course.setBounds(720, 400, 120, 70);
        course.setBackground(Color.YELLOW);
        course.setFont(f1); 
        
        course.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                
                try{
                     File f = new File("Course.txt");
                     //f.getParentFile().mkdirs();
                     
                     FileReader c = new FileReader("Course.txt");
                     br1 = new BufferedReader(new FileReader("Course.txt"));
                     
                     while(c.read()!=-1){
                         String be = br1.readLine();
                         programming_lang.add(be);
                     }
                     
                          
        
                }
                
                catch(IOException e){
                    e.printStackTrace();
                }
                
                finally{
                    try{
                        br1.close();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
            
        });
       
        
        bn1 = new JButton("Add");
        bn1.setBounds(720,180,120,80);
        bn1.setFont(f1);
        bn1.setBackground(Color.LIGHT_GRAY);
        
        
        bn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                pro_Lang = tf1.getText();
                time = tf2.getText();
               
               //cb1.addItem(pro_Lang);
                //JOptionPane.showMessageDialog(null, "Added Succesfully !!", "Confirmation", 1);
                
                try{
                     File f = new File("Course.txt");
                     
                     br = new BufferedWriter(new FileWriter("Course.txt",true));
                     br.write(pro_Lang);
                     br.newLine();
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
                JOptionPane.showMessageDialog(null, "Added Succesfully !!", "Confirmation", 1);
                
                dispose();
                ExamSystem03 e = new ExamSystem03(name);
            }
        
         });
        
        
        bn2 = new JButton("Delete");
        bn2.setBounds(900,180,120,80);
        bn2.setFont(f1);
        bn2.setBackground(Color.LIGHT_GRAY);
        
        bn2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                pro_Lang = tf1.getText();
                time = tf2.getText();
                
                cb1.removeItem(pro_Lang);
                programming_lang.remove(pro_Lang);
                
                try{
                    
                    br2 = new BufferedWriter(new FileWriter("Course.txt",false));
                    
                    for(String x: programming_lang)
                    {
                        br2.write(x);
                        br2.newLine();
                    }
                }
                catch(IOException ew)
                {
                     ew.getStackTrace();
                }
                
                finally{
                    try{
                        br2.close();
                    }
                    catch(IOException ew){
                        ew.getStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(null, "Deleted Succesfully !!", "Confirmation", 1);
                
                dispose();
                ExamSystem03 e = new ExamSystem03(name);
            }

            
        
         });
        
        cb1 = new JComboBox(programming_lang);
        cb1.setBounds(285, 400, 370, 60);
        cb1.setFont(f2);
        
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
        
        c.add(tf1);
        c.add(bn1);
        c.add(bn2);
        c.add(tf2);
        c.add(cb1);
        c.add(back);
        c.add(course);
    }
    
    /*public static void main(String args[])
    {
        Add_Course ac = new Add_Course();
    }*/
}
