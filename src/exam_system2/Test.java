package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Test extends JFrame {
 
    private Container c;
    private JButton bn1, bn2, exit, back, next;
    private Font f1, f2, f3, f4, f5, f6;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm, submit;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10, tx11, tx12, tx13, tx14, tx15;
    private BufferedReader reader;
    private PrintWriter writer;
    String st1, st2, sto, username;
    private JTextArea Area;
    private JScrollPane scp;
    private JLabel t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;
    Timer t;
    int j=1, k=0;
    
    Test(String x, String u_name)
    {
        st1 = x;
        st2 = u_name;
        initComponents(st1,st2);
    }
    
    void initComponents(String str1, String str2)
    {
        cr = str1;
        username = str2;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        f5 = new Font("Arial", Font.BOLD,19);
        f6 = new Font("Arial", Font.BOLD,17);
        
        this.setVisible(true);
        this.setBounds(300,200,1290,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        
        j1 = new JLabel();
        j1.setText("Questions:");
        j1.setBounds(50,3,170,60);
        j1.setFont(f3);
        j1.setForeground(Color.ORANGE);
        
        j2 = new JLabel();
        j2.setText("Answers:");
        j2.setBounds(70,498,160,60);
        j2.setFont(f3);
        j2.setForeground(Color.GREEN);
        
        tx1 = new JTextField();
        tx1.setBounds(200,535,70,40);
        tx1.setFont(f4);
        tx1.setBackground(Color.LIGHT_GRAY);
        
        t1 = new JLabel();
        t1.setText("a)");
        t1.setBounds(180,540,20,20);
        t1.setFont(f5);
        t1.setForeground(Color.ORANGE);
        
        tx2 = new JTextField();
        tx2.setBounds(200,585,70,40);
        tx2.setFont(f4);
        tx2.setBackground(Color.LIGHT_GRAY);
        
        t2 = new JLabel();
        t2.setText("b)");
        t2.setBounds(180,590,20,20);
        t2.setFont(f5);
        t2.setForeground(Color.ORANGE);
        
        
        tx3 = new JTextField();
        tx3.setBounds(300,535,70,40);
        tx3.setFont(f4);
        tx3.setBackground(Color.LIGHT_GRAY);
        
        t3 = new JLabel();
        t3.setText("c)");
        t3.setBounds(280,540,20,20);
        t3.setFont(f5);
        t3.setForeground(Color.ORANGE);
        
        
        tx4 = new JTextField();
        tx4.setBounds(300,585,70,40);
        tx4.setFont(f4);
        tx4.setBackground(Color.LIGHT_GRAY);
        
        t4 = new JLabel();
        t4.setText("d)");
        t4.setBounds(280,590,20,20);
        t4.setFont(f5);
        t4.setForeground(Color.ORANGE);
        
        
        tx5 = new JTextField();
        tx5.setBounds(400,535,70,40);
        tx5.setFont(f4);
        tx5.setBackground(Color.LIGHT_GRAY);
        
        t5 = new JLabel();
        t5.setText("e)");
        t5.setBounds(380,540,20,20);
        t5.setFont(f5);
        t5.setForeground(Color.ORANGE);
        
        
        
        tx6 = new JTextField();
        tx6.setBounds(400,585,70,40);
        tx6.setFont(f4);
        tx6.setBackground(Color.LIGHT_GRAY);
        
        t6 = new JLabel();
        t6.setText("f)");
        t6.setBounds(380,590,20,20);
        t6.setFont(f5);
        t6.setForeground(Color.ORANGE);
        
        
        tx7 = new JTextField();
        tx7.setBounds(500,535,70,40);
        tx7.setFont(f4);
        tx7.setBackground(Color.LIGHT_GRAY);
        
        t7 = new JLabel();
        t7.setText("g)");
        t7.setBounds(480,540,20,20);
        t7.setFont(f5);
        t7.setForeground(Color.ORANGE);
        
        
        tx8 = new JTextField();
        tx8.setBounds(500,585,70,40);
        tx8.setFont(f4);
        tx8.setBackground(Color.LIGHT_GRAY);
        
        t8 = new JLabel();
        t8.setText("h)");
        t8.setBounds(480,590,20,20);
        t8.setFont(f5);
        t8.setForeground(Color.ORANGE);
        
        
        tx9 = new JTextField();
        tx9.setBounds(600,535,70,40);
        tx9.setFont(f4);
        tx9.setBackground(Color.LIGHT_GRAY);
        
        t9 = new JLabel();
        t9.setText("i)");
        t9.setBounds(580,540,20,20);
        t9.setFont(f5);
        t9.setForeground(Color.ORANGE);
        
        
        
        tx10 = new JTextField();
        tx10.setBounds(600,585,70,40);
        tx10.setFont(f4);
        tx10.setBackground(Color.LIGHT_GRAY);
        
        t10 = new JLabel();
        t10.setText("j)");
        t10.setBounds(580,590,20,20);
        t10.setFont(f5);
        t10.setForeground(Color.ORANGE);
        
        
        
        tx11 = new JTextField();
        tx11.setBounds(700,535,70,40);
        tx11.setFont(f4);
        tx11.setBackground(Color.LIGHT_GRAY);
        
        t11 = new JLabel();
        t11.setText("k)");
        t11.setBounds(680,540,20,20);
        t11.setFont(f5);
        t11.setForeground(Color.ORANGE);
        
        
        
        tx12 = new JTextField();
        tx12.setBounds(700,585,70,40);
        tx12.setFont(f4);
        tx12.setBackground(Color.LIGHT_GRAY);
        
        t12 = new JLabel();
        t12.setText("l)");
        t12.setBounds(680,590,20,20);
        t12.setFont(f5);
        t12.setForeground(Color.ORANGE);
        
        
        
        tx13 = new JTextField();
        tx13.setBounds(800,535,70,40);
        tx13.setFont(f4);
        tx13.setBackground(Color.LIGHT_GRAY);
        
        t13 = new JLabel();
        t13.setText("m)");
        t13.setBounds(780,540,20,20);
        t13.setFont(f6);
        t13.setForeground(Color.ORANGE);
        
        
        tx14 = new JTextField();
        tx14.setBounds(800,585,70,40);
        tx14.setFont(f4);
        tx14.setBackground(Color.LIGHT_GRAY);
        
        t14 = new JLabel();
        t14.setText("n)");
        t14.setBounds(780,590,20,20);
        t14.setFont(f5);
        t14.setForeground(Color.ORANGE);
        
        
        
        tx15 = new JTextField();
        tx15.setBounds(900,535,70,40);
        tx15.setFont(f4);
        tx15.setBackground(Color.LIGHT_GRAY);
        
        t15 = new JLabel();
        t15.setText("o)");
        t15.setBounds(880,540,20,20);
        t15.setFont(f5);
        t15.setForeground(Color.ORANGE);
        
        
        exit = new JButton("Exit");
        exit.setBounds(50,640,100,40);
        exit.setBackground(Color.CYAN);
        exit.setForeground(Color.darkGray);
        exit.setFont(f2);
        
        exit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem e = new ExamSystem(username);
            }
            
        });
        
        Area = new JTextArea();
        //Area.setBounds(50,78,900,450);
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBounds(50,55,900,450);
        
        JLabel jn20 = new JLabel();
        //jn20.setText("1");
        jn20.setBounds(1140,260,50,60);
        jn20.setForeground(Color.white);
        jn20.setFont(f4);
        
        JLabel jn30 = new JLabel();
        //jn30.setText("1");
        jn30.setBounds(1140,340,50,60);
        jn30.setForeground(Color.white);
        jn30.setFont(f4);
        
        t = new Timer(1000,new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae)
                    {
                        jn20.setText(Integer.toString(j));
                        j++;
                        
                        if(j==11)
                        {
                             jn30.setText(Integer.toString(k));
                             k++;
                             j=1;
                        }
                        
                        else if(k>=2)
                        {
                            t.stop();
                            JOptionPane.showMessageDialog(null, "Time's Up !!", "Information", 1);
                            dispose();
                            Test_code1 code = new Test_code1(cr,username);
                        }
                    }
                });
               
        
        
        bn1 = new JButton("Start");
        bn1.setBounds(1100,50,120,55);
        bn1.setForeground(Color.BLACK);
        bn1.setBackground(Color.yellow);
        bn1.setFont(f3);
        
        
        bn1.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                
                t.start();
                
                String f_name = cr+".txt";
                String line;
                 
                 try{
                     
                     File question = new File("D:/Java Programming/Exam_System2/Questions/"+cr+"/"+f_name);
                     //File question = new File("D:/Java Programming/Exam_System2/Questions/C/C.txt");
                     
                    reader = new BufferedReader(new FileReader(question));
                         
                     
                         while((line = reader.readLine())!=null)
                         {
                              
                             String sd[] = line.split("#");
                            
                             
                             for(String temp: sd)
                             {
                                 Area.append("\n"+temp);
                                 //System.out.println(temp);
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
       
        submit = new JButton("Submit");
        submit.setBounds(1050,640,100,40);
        submit.setBackground(Color.YELLOW);
        submit.setForeground(Color.darkGray);
        submit.setFont(f2);
        
        submit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null, "Submitted Successfully !!!", "Confirmation", 1);
                
                String answers[] = new String[15];
                
                for(int i=0; i<15; i++)
                {
                    switch(i){
                            case 0:
                                answers[i] = "a)"+tx1.getText();
                                break;
                            
                            case 1:
                                answers[i] = "a)"+tx2.getText();
                                break;
                            
                            case 2:
                                answers[i] = "a)"+tx3.getText();
                                break;
                            
                            case 3:
                                answers[i] = "a)"+tx4.getText();
                                break;
                                
                            case 4:
                                answers[i] = "a)"+tx5.getText();
                                break;
                                
                            case 5:
                                answers[i] = "a)"+tx6.getText();
                                break;
                                
                            case 6:
                                answers[i] = "a)"+tx7.getText();
                                break;
                                
                            case 7:
                                answers[i] = "a)"+tx8.getText();
                                break;
                                
                            case 8:
                                answers[i] = "a)"+tx9.getText();
                                break;
                                
                            case 9:
                                answers[i] = "a)"+tx10.getText();
                                break;
                             
                            case 10:
                                answers[i] = "a)"+tx11.getText();
                                break;
                                
                            case 11:
                                answers[i] = "a)"+tx12.getText();
                                break;
                                
                            case 12:
                                answers[i] = "a)"+tx13.getText();
                                break;
                                
                            case 13:
                                answers[i] = "a)"+tx14.getText();
                                break;
                                
                            case 14:
                                answers[i] = "a)"+tx15.getText();
                                break;
                    }
                }
                
                try
                {
                    writer = new PrintWriter(new FileWriter("Students/"+username+"/"+username+"_mcq.txt"));
                    
                    for(int i=0; i<15; i++)
                    {
                        writer.println(answers[i]);
                    }
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
                Test_code1 code = new Test_code1(cr, username);
            }
            
        });
        
        
        /*next = new JButton("Next");
        next.setBounds(530,640,100,40);
        next.setBackground(Color.green);
        next.setForeground(Color.darkGray);
        next.setFont(f2);
        
        next.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Test_code1 code = new Test_code1(cr,username,j,k);
            }
            
        });*/
        
         
        JLabel jn1 = new JLabel();
        jn1.setText("Time:  5 minutes");
        jn1.setBounds(1000,200, 200,60);
        jn1.setForeground(Color.GREEN);
        jn1.setFont(f4);
        
        JLabel jn2 = new JLabel();
        jn2.setText("Seconds:");
        jn2.setBounds(1000,260,120,60);
        jn2.setForeground(Color.ORANGE);
        jn2.setFont(f4);
        
        /*JLabel jn20 = new JLabel();
        //jn20.setText("1");
        jn20.setBounds(1140,260,50,60);
        jn20.setForeground(Color.YELLOW);
        jn20.setFont(f4);*/
        
        JLabel jn3 = new JLabel();
        jn3.setText("Minutes:");
        jn3.setBounds(1000,340,150,60);
        jn3.setForeground(Color.ORANGE);
        jn3.setFont(f4);
        
        /*JLabel jn30 = new JLabel();
        //jn30.setText("1");
        jn30.setBounds(1140,340,50,60);
        jn30.setForeground(Color.YELLOW);
        jn30.setFont(f4);*/
        
        
        
        
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        
        
        c.add(exit);
        c.add(scp);
        c.add(j1);
        c.add(j2);
        c.add(submit);
       // c.add(next);
        c.add(bn1);
        //c.add(jn);
        c.add(jn1);
        c.add(jn2);
        c.add(jn3);
        c.add(jn20);
        c.add(jn30);
               
        c.add(tx1);
        c.add(tx2);
        c.add(tx3);
        c.add(tx4);
        c.add(tx5);
        c.add(tx6);
        c.add(tx7);
        c.add(tx8);
        c.add(tx9);
        c.add(tx10);
        c.add(tx11);
        c.add(tx12);
        c.add(tx13);
        c.add(tx14);
        c.add(tx15);
        
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(t5);
        c.add(t6);
        c.add(t7);
        c.add(t8);
        c.add(t9);
        c.add(t10);
        c.add(t11);
        c.add(t12);
        c.add(t13);
        c.add(t14);
        c.add(t15);
        
    }
    
    /*public static void main(String []args)
    {
        String sto = "C";
        String name = "Jabbar";
        
        Test up = new Test(sto,name);
        up.setVisible(true);
    }*/
}

class Test_code1 extends JFrame
{
    private Container c;
    private JButton bn1, bn2, exit, back;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm, submit;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer;
    String st, sto;
    private JTextArea Area;
    private JScrollPane scp;
    Timer t;
    int j=1, k=1;
    
    Test_code1(String x, String nm)
    {
        String cs = x;
        String name = nm;
        
        initComponents(cs,name);
    }
    
    void initComponents(String cs, String name)
    {
        
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1280,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        Area = new JTextArea("Code: \n");
        //Area.setBounds(50,78,900,450);
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        Area.setEditable(false);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBounds(50,55,900,450);
        
        JLabel jn1 = new JLabel();
        jn1.setText("Time:  5 minutes");
        jn1.setBounds(1000,200,200,60);
        jn1.setForeground(Color.GREEN);
        jn1.setFont(f4);
        
        JLabel jn2 = new JLabel();
        jn2.setText("Seconds:");
        jn2.setBounds(1000,260,120,60);
        jn2.setForeground(Color.orange);
        jn2.setFont(f4);
        
        JLabel jn20 = new JLabel();
        //jn20.setText("1");
        jn20.setBounds(1140,260,50,60);
        jn20.setForeground(Color.white);
        jn20.setFont(f4);
        
        JLabel jn3 = new JLabel();
        jn3.setText("Minutes:");
        jn3.setBounds(1000,340,150,60);
        jn3.setForeground(Color.ORANGE);
        jn3.setFont(f4);
        
        JLabel jn30 = new JLabel();
        //jn30.setText("1");
        jn30.setBounds(1140,340,50,60);
        jn30.setForeground(Color.white);
        jn30.setFont(f4);
        
         
         t = new Timer(1000,new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae)
                    {
                        jn20.setText(Integer.toString(j));
                        j++;
                        
                        if(j==11)
                        {
                             jn30.setText(Integer.toString(k));
                             k++;
                             j=1;
                        }
                        
                        else if(k>=2)
                        {
                            t.stop();
                            JOptionPane.showMessageDialog(null, "Time's Up !!", "Information", 1);
                            dispose();
                            ExamSystem es = new ExamSystem(cs);
                        }
                    }
                });
               
        
        
        bn1 = new JButton("Start");
        bn1.setBounds(1100,50,120,55);
        bn1.setForeground(Color.BLACK);
        bn1.setBackground(Color.yellow);
        bn1.setFont(f3);
       
        bn1.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                
                t.start();
                
                Area.setEditable(true);
                
            }
        });
        
        
        
        submit = new JButton("Submit");
        submit.setBounds(1050,640,100,40);
        submit.setBackground(Color.YELLOW);
        submit.setForeground(Color.darkGray);
        submit.setFont(f2);
        
        submit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null, "Submitted Successfully !!!", "Information", 1);
                
                try
                {
                    writer = new PrintWriter(new FileWriter("Code.txt"));
                    
                    String str = Area.getText();
                    String std[] = str.split("\n");
                    
                    for(String x: std)
                    {
                        writer.println(x);
                    }
                    
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
                ExamSystem es = new ExamSystem(cs);
                //Test e = new Test(cs);
            }
            
        });
        
                
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(scp);
        c.add(submit);
        c.add(bn1);
        //c.add(jn);
        c.add(jn1);
        c.add(jn2);
        c.add(jn3);
        c.add(jn20);
        c.add(jn30);
        
        
    }
}

class Test_code2 extends JFrame
{
    private Container c;
    private JButton bn1, bn2, exit, back;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm, submit;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer;
    String st, sto;
    private JTextArea Area;
    private JScrollPane scp;
    
    
    Test_code2(String x, String nm)
    {
        String cs = x;
        String name = nm;
        
        initComponents(cs,name);
    }
    
    void initComponents(String cs, String name)
    {
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        
        submit = new JButton("Submit");
        submit.setBounds(1050,640,100,40);
        submit.setBackground(Color.YELLOW);
        submit.setForeground(Color.darkGray);
        submit.setFont(f2);
        
        submit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null, "Submitted Successfully !!!", "Information", 1);
                
                 try
                {
                    writer = new PrintWriter(new FileWriter("Students/"+name+"/"+name+"_code.txt"));
                    
                    String str = Area.getText();
                    String std[] = str.split("\n");
                    
                    for(String x: std)
                    {
                        writer.println(x);
                    }
                    
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
                ExamSystem es = new ExamSystem(name);
                //Test e = new Test(cs);
            }
            
        });
        
                
        Area = new JTextArea("Write your code: \n");
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBounds(50,55,900,450);
       
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(scp);
        c.add(submit);
        
    }
}