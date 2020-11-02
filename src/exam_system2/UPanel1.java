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
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UPanel1 extends JFrame {
    
    private Container c;
    private JButton bn1, bn2, bn3;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm;
    private PrintWriter writer;
    String St;
         
    UPanel1(String um)
    {
        String un = um;
        initComponents(un);
    }
    
    void initComponents(String un)
    {
        String un1 = un;
        String f_name = un+"_result.txt";
        
        File f = new File("Students/"+un1+"/"+f_name);
        
        Add_Course ac = new Add_Course(un1);
         
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
        
        j2 = new JLabel();
        j2.setText("1. There are 10-15 questions and more than one Code will given to write in each course.");
        j2.setBounds(120,470,1100,80);
        j2.setFont(f3);
        j2.setForeground(Color.cyan);
        
        j3 = new JLabel();
        j3.setText("2. Maximum time is 5 minutes for each.");
        j3.setBounds(120,510,700,80);
        j3.setFont(f3);
        j3.setForeground(Color.cyan);
        
        j4 = new JLabel();
        j4.setText("3. After time you will be automatically logged out.");
        j4.setBounds(120,550,700,80);
        j4.setFont(f3);
        j4.setForeground(Color.cyan);
        
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
                 ExamSystem02 e2 = new ExamSystem02();
             }
        
        
        });
        
        
        
        bn2 = new JButton("Start Test");
        bn2.setBounds(515,330,150,60);
        bn2.setBackground(Color.lightGray);
        bn2.setFont(f4);
        
        bn2.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                 
                 St = cb.getSelectedItem().toString();
                 int flag = 1;
                 //System.out.print(St);
                 
                 for(String x: ac.programming_lang)
                 {
                     if(x.equals(St))
                     {
                         String file_name = un1+"_selected_course.txt";
                         File f_course;
                         
                         try
                         {
                             f_course = new File("Students/"+un1+"/"+file_name);
                             f_course.createNewFile();
                             
                             writer = new PrintWriter(new FileWriter(f_course));
                             writer.println(x);
                         }
                         catch(IOException e)
                         {
                             e.printStackTrace();
                         }                
                         
                         finally
                         {
                             try{
                                   writer.close();
                             }
                         catch(Exception e)
                         {
                             e.printStackTrace();
                         }
                }
                
                         
                         dispose();
                         Test t = new Test(x,un1);
                         break;
                     }
                 }
                 
             }
        
        
        
        });
        
        bn3 = new JButton("Show Result");
        bn3.setBounds(20,50,250,50);
        bn3.setFont(f2);
        bn3.setBackground(Color.ORANGE);
        
        bn3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(f.exists())
                {
                    dispose();
                    Show_Result sr = new Show_Result(un1);
                }
                else
                    JOptionPane.showMessageDialog(null, "Result has not published yet !!", "Information", 1);
            }
        
            
        
        });
        
        
        c = getContentPane();
        c.setBackground(Color.darkGray);
        c.setLayout(null);
        
        c.add(bn1);
        c.add(bn2);
        c.add(bn3);
        c.add(jn);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(cb);
    }
    
    /*public static void main(String[]args)
    {
        UPanel1 up = new UPanel1();
        up.setVisible(true);
    }*/
}
