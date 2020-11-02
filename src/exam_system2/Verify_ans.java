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

public class Verify_ans extends JFrame
{
    private Container c;
    private JButton bn1, bn2, exit, back, next;
    private Font f1, f2, f3, f4, f5;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4, jn;
    private BufferedReader br;
    private JButton mcq, code, submit;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer;
    String st1, st2, sto, username,course;
    private JTextArea Area;
    private JScrollPane scp;
     Timer t;
    int i=0;
    
    Verify_ans(String u_name,String cs_name)
    {
        st2 = u_name;
        course = cs_name;
        
        initComponents(st2,course);
    }
    
    void initComponents(String name,String cs_name)
    {
        username = name;
        course = cs_name;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,25);
        f5 = new Font("Arial", Font.BOLD,30);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        jn = new JLabel();
        //jn.setText(username);
        jn.setBounds(600,40,190,80);
        jn.setForeground(Color.WHITE);
        jn.setFont(f4);
        
        
       t = new Timer(1000, new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                jn.setText(Integer.toString(i));
                i++;
                
                if(i==10){
                    //t.stop();
                    i=0;
                }
            }
        });
       
       
        mcq = new JButton("MCQ Checking");
        mcq.setBounds(450,230,280,90);
        mcq.setBackground(Color.LIGHT_GRAY);
        mcq.setForeground(Color.BLACK);
        mcq.setFont(f5);
        
        mcq.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Mcq_checking check = new Mcq_checking(username,course);
            }
        });
        
        
        
        code = new JButton("Code Analysis");
        code.setBounds(450,380,280,90);
        code.setBackground(Color.LIGHT_GRAY);
        code.setForeground(Color.BLACK);
        code.setFont(f5);
        
        code.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Code_analysis check = new Code_analysis(username,course,0,0,0);
            }
        });
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem03 es = new ExamSystem03(username);
            }
            
        });
    
        JLabel j1 = new JLabel();
        j1.setText("Student Name:");
        j1.setBounds(100,40,190,80);
        j1.setForeground(Color.YELLOW);
        j1.setFont(f4);

        
        JLabel j2 = new JLabel();
        j2.setText(username);
        j2.setBounds(300,40,190,80);
        j2.setForeground(Color.WHITE);
        j2.setFont(f4);
        
        JLabel j3 = new JLabel();
        j3.setText("Course:");
        j3.setBounds(100,120,190,80);
        j3.setForeground(Color.YELLOW);
        j3.setFont(f4);
        
        JLabel j4 = new JLabel();
        j4.setText(course);
        j4.setBounds(300,120,190,80);
        j4.setForeground(Color.WHITE);
        j4.setFont(f4);

    
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        
        c.add(mcq);
        c.add(code);
        c.add(back);
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(jn);
        c.add(bn1);
    
    }
    
    
    
     /*public static void main(String []args)
    {
        String sto = "C";
        String name = "Jabbar";
        
        Verify_ans up = new   Verify_ans(sto,name);
        
        up = new   Verify_ans(name,sto);
        up.setVisible(true);
    }*/
}

class Mcq_checking extends JFrame
{
    
    private Container c;
    private JButton bn1, bn2, back;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm, submit, next, save;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer;
    String st, sto, course, username;
    private JTextArea Area;
    private JScrollPane scp;
    private JLabel total_ques, each_mark, correct_ans, obtained_mark, percentage;
    int y, t_marks, obtained_marks;
    
    Mcq_checking(String nm, String crs)
    {
        String name = nm;
        String crs1 = crs;
        initComponents(name,crs1);
    }
    
    void initComponents(String str2,String cors)
    {
        username = str2;
        course = cors; 
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,24);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        j2 = new JLabel();
        j2.setText("Answers:");
        j2.setBounds(50,20,170,60);
        j2.setFont(f3);
        j2.setForeground(Color.GREEN);
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem03 es = new ExamSystem03(username);
            }
            
        });
        
        Area = new JTextArea();
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBounds(50,85,600,500);
        
                
        String f_name = username+"_mcq.txt";
        String line;
         
        try{
                     
                     File mcq = new File("Students/"+username+"/"+f_name);
                     //File question = new File("D:/Java Programming/Exam_System2/Questions/C/C.txt");
                     
                     reader = new BufferedReader(new FileReader(mcq));
                         
                     
                         while((line = reader.readLine())!=null)
                         {
                              
                             String sd[] = line.split("\n");
                             
                             for(String temp: sd)
                             {
                                 Area.append("\n\n"+temp);
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
               
                 Area.setEditable(false);
       
        total_ques = new JLabel();
        total_ques.setText("Total Questions:");
        total_ques.setBounds(700,90,190,60);
        total_ques.setFont(f3);
        total_ques.setForeground(Color.GREEN);
        
        tx1 = new JTextField();
        tx1.setBounds(940,100,190,40);
        tx1.setBackground(Color.LIGHT_GRAY);
        tx1.setFont(f4);
        
        each_mark = new JLabel();
        each_mark.setText("Each Ques. Mark:");
        each_mark.setBounds(700,190,200,60);
        each_mark.setFont(f3);
        each_mark.setForeground(Color.GREEN);
        
        tx2 = new JTextField("3");
        tx2.setBounds(940,200,190,40);
        tx2.setBackground(Color.LIGHT_GRAY);
        tx2.setFont(f4);
        tx2.setEditable(false);
        
        correct_ans = new JLabel();
        correct_ans.setText("Wrong Answers:");
        correct_ans.setBounds(700,290,200,60);
        correct_ans.setFont(f3);
        correct_ans.setForeground(Color.GREEN);
        
        tx3 = new JTextField();
        tx3.setBounds(940,300,190,40);
        tx3.setBackground(Color.LIGHT_GRAY);
        tx3.setFont(f4);
        
        
        obtained_mark = new JLabel();
        obtained_mark.setText("Obtained Marks:");
        obtained_mark.setBounds(700,390,200,60);
        obtained_mark.setFont(f3);
        obtained_mark.setForeground(Color.GREEN);
        
        tx4 = new JTextField();
        tx4.setBounds(940,400,190,40);
        tx4.setBackground(Color.LIGHT_GRAY);
        tx4.setFont(f4);
        
        
        percentage = new JLabel();
        percentage.setText("Percentage:");
        percentage.setBounds(700,490,200,60);
        percentage.setFont(f3);
        percentage.setForeground(Color.GREEN);
        
        tx5 = new JTextField();
        tx5.setBounds(940,500,190,40);
        tx5.setBackground(Color.LIGHT_GRAY);
        tx5.setFont(f4);
       
        save = new JButton("Save");
        save.setBounds(530,640,100,40);
        save.setBackground(Color.YELLOW);
        save.setForeground(Color.darkGray);
        save.setFont(f2);
        
        save.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent ae)
            {
                String st1 = tx2.getText();
                int x = Integer.parseInt(st1);
                
                String st2 = tx3.getText();
                y = Integer.parseInt(st2);
                
                obtained_marks = x*y;
                String st3 = Integer.toString(obtained_marks);
                
                tx4.setText(st3);
                
                String st4 = tx1.getText();
                int t_qs = Integer.parseInt(st4);
                
                t_marks = x * t_qs;
                
                int percent = (obtained_marks*100)/t_marks;
                String st5 = Integer.toString(percent);
                
                tx5.setText(st5+"%");
            }
        
        });
        
        next = new JButton("Next");
        next.setBounds(1050,640,100,40);
        next.setBackground(Color.green);
        next.setForeground(Color.darkGray);
        next.setFont(f2);
        
        next.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Code_analysis code = new Code_analysis(username,course,t_marks,obtained_marks,y);
                
            }
            
        });
        

        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(back);
        c.add(scp);
        //c.add(j1);
        c.add(j2);
        //c.add(submit);
        c.add(save);
        c.add(next);
        c.add(total_ques);
        c.add(each_mark);
        c.add(correct_ans);
        c.add(obtained_mark);
        c.add(percentage);
        c.add(tx1);
        c.add(tx2);
        c.add(tx3);
        c.add(tx4);
        c.add(tx5);
        
    }
    
    
    
}

class Code_analysis extends JFrame
{
    private Container c;
    private JButton bn1, bn2, exit, back, next, save;
    private Font f1, f2, f3, f4, f5;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton mcq, code, submit;
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
    
    Code_analysis(String u_name, String course, int t_mq, int o_mq, int cr)
    {
        st2 = u_name;
        cs1 = course;
        crct = cr;
        t_marks = t_mq;
        o_marks = o_mq;
        
        initComponents(st2,cs1,t_marks, o_marks, crct);
    }
    
    void initComponents(String name, String cors, int t_mcq, int o_mcq, int cr1)
    {
        username = name;
        course = cors;
        cr_mcq = cr1;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        j2 = new JLabel();
        j2.setText("Code:");
        j2.setBounds(50,20,170,60);
        j2.setFont(f3);
        j2.setForeground(Color.GREEN);
        
                
        Area = new JTextArea();
        Area.setBackground(Color.WHITE);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setFont(f4);
        
        scp = new JScrollPane(Area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBounds(50,85,580,500);
       
        String f_name = username+"_code.txt";
        String line;
         
        try{
                     
                     File mcq = new File("Students/"+username+"/"+f_name);
                     //File question = new File("D:/Java Programming/Exam_System2/Questions/C/C.txt");
                     
                    reader = new BufferedReader(new FileReader(mcq));
                         
                     
                         while((line = reader.readLine())!=null)
                         {
                              
                             String sd[] = line.split("\n");
                            
                             
                             for(String temp: sd)
                             {
                                 Area.append("\n\n"+temp);
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
               
                 Area.setEditable(false);
       
        total_ques = new JLabel();
        total_ques.setText("Total Questions:");
        total_ques.setBounds(700,90,190,60);
        total_ques.setFont(f4);
        total_ques.setForeground(Color.GREEN);
        
        tx1 = new JTextField();
        tx1.setBounds(940,100,190,40);
        tx1.setBackground(Color.LIGHT_GRAY);
        tx1.setFont(f4);
        
        each_mark = new JLabel();
        each_mark.setText("Each Ques. Mark:");
        each_mark.setBounds(700,190,200,60);
        each_mark.setFont(f4);
        each_mark.setForeground(Color.GREEN);
        
        tx2 = new JTextField("8");
        tx2.setBounds(940,200,190,40);
        tx2.setBackground(Color.LIGHT_GRAY);
        tx2.setFont(f4);
        tx2.setEditable(false);
        
        
        error = new JLabel();
        error.setText("Error:");
        error.setBounds(700,290,200,60);
        error.setFont(f4);
        error.setForeground(Color.GREEN);
        
        tx3 = new JTextField();
        tx3.setBounds(940,300,190,40);
        tx3.setBackground(Color.LIGHT_GRAY);
        tx3.setFont(f4);
        
        obtained_mark = new JLabel();
        obtained_mark.setText("Obtained Marks:");
        obtained_mark.setBounds(700,390,200,60);
        obtained_mark.setFont(f4);
        obtained_mark.setForeground(Color.GREEN);
        
        tx4 = new JTextField();
        tx4.setBounds(940,400,190,40);
        tx4.setBackground(Color.LIGHT_GRAY);
        tx4.setFont(f4);
        
        
        percentage = new JLabel();
        percentage.setText("Percentage:");
        percentage.setBounds(700,490,200,60);
        percentage.setFont(f4);
        percentage.setForeground(Color.GREEN);
        
        tx5 = new JTextField();
        tx5.setBounds(940,500,190,40);
        tx5.setBackground(Color.LIGHT_GRAY);
        tx5.setFont(f4);
        
                 
        save = new JButton("Save");
        save.setBounds(530,640,100,40);
        save.setBackground(Color.YELLOW);
        save.setForeground(Color.darkGray);
        save.setFont(f2);
        
        save.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent ae)
            {
                String st8 = tx2.getText();
                int x = Integer.parseInt(st8);
                
                String st9 = tx1.getText();
                int y = Integer.parseInt(st9);
                
                total_marks = x*y;
                String st30 = Integer.toString(total_marks);
                
                String st45 = tx4.getText();
                obtained_marks = Integer.parseInt(st45);
                
                int percent = (obtained_marks*100)/total_marks;
                String st56 = Integer.toString(percent);
                
                tx5.setText(st56+"%"); 
            }
        
        });
        
        next = new JButton("Next");
        next.setBounds(1050,640,100,40);
        next.setBackground(Color.green);
        next.setForeground(Color.darkGray);
        next.setFont(f2);
        
        next.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                error_no = Integer.parseInt(tx3.getText());
                dispose();
                Total_result tr = new Total_result(username,course,t_mcq,o_mcq,total_marks,obtained_marks,cr_mcq,error_no,1);
                
            }
            
        });
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                Mcq_checking es = new  Mcq_checking(username,course);
            }
            
        });
        
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(scp);
        c.add(save);
        c.add(back);
        c.add(next);
        c.add(j2);
        
        c.add(total_ques);
        c.add(each_mark);
        c.add(error);
        c.add(obtained_mark);
        c.add(percentage);
        c.add(tx1);
        c.add(tx2);
        c.add(tx3);
        c.add(tx4);
        c.add(tx5);
    }
    
    }

class Total_result extends JFrame
{
    private Container c;
    private JButton bn1, bn2, exit, back, next, save;
    private Font f1, f2, f3, f4, f5;
    private JComboBox cb;
    private JLabel j0,j1, j2, j3, j4, j5 ,j7, j8, j6, j9, j10, j11, j12, j13, j14, j15,j16;
    private BufferedReader br;
    private JButton mcq, code, submit;
    String St, cs, cr;
    private JTextField tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    private BufferedReader reader;
    private PrintWriter writer, writer2;
    String st1, st2, sto, username,course;
    private JTextArea Area;
    private JScrollPane scp;
    int percentage;
    
    Total_result(String u_name,String cs_name,int t_marks_mcq, int obt_marks_mcq, int t_marks_code, int obt_marks_code, int err_mcq, int err_code, int flag)
    {
        st2 = u_name;
        course = cs_name;
        int t_marks = t_marks_mcq+t_marks_code;
        int o_marks = obt_marks_mcq+obt_marks_code;
        int er_mq = err_mcq;
        int er_cd = err_code;
        int fg = flag;
        
        initComponents(st2,course,t_marks,o_marks,er_mq,er_cd,fg);
    }
    
    void initComponents(String name,String cs_name,int total_marks, int obt_marks,int err_mcq, int err_code, int flag)
    {
        username = name;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,25);
        f5 = new Font("Arial", Font.BOLD,30);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        
        exit = new JButton("Back");
        exit.setBounds(50,640,100,40);
        exit.setBackground(Color.CYAN);
        exit.setForeground(Color.darkGray);
        exit.setFont(f2);
        
        exit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem03 es = new ExamSystem03(username);
            }
            
        });
        
        
        JLabel j0 = new JLabel();
        j0.setText("Full Result:");
        j0.setBounds(200,30,190,80);
        j0.setForeground(Color.ORANGE);
        j0.setFont(f5);

        
        JLabel j1 = new JLabel();
        j1.setText("Student Name:");
        j1.setBounds(400,90,190,80);
        j1.setForeground(Color.YELLOW);
        j1.setFont(f4);

        
        JLabel j2 = new JLabel();
        j2.setText(username);
        j2.setBounds(650,90,190,80);
        j2.setForeground(Color.WHITE);
        j2.setFont(f4);
        
        JLabel j3 = new JLabel();
        j3.setText("Course:");
        j3.setBounds(400,150,190,80);
        j3.setForeground(Color.YELLOW);
        j3.setFont(f4);
        
        JLabel j4 = new JLabel();
        j4.setText(cs_name);
        j4.setBounds(650,150,190,80);
        j4.setForeground(Color.WHITE);
        j4.setFont(f4);
        
        JLabel j5 = new JLabel();
        j5.setText("Topics:");
        j5.setBounds(400,210,190,80);
        j5.setForeground(Color.YELLOW);
        j5.setFont(f4);

        JLabel j6 = new JLabel();
        j6.setText("MCQ + Code");
        j6.setBounds(650,210,190,80);
        j6.setForeground(Color.WHITE);
        j6.setFont(f4);
        
        JLabel j7 = new JLabel();
        j7.setText("Wrong (MCQ):");
        j7.setBounds(400,270,190,80);
        j7.setForeground(Color.YELLOW);
        j7.setFont(f4);
        
        JLabel j8 = new JLabel();
        j8.setText(Integer.toString(err_mcq));
        j8.setBounds(650,270,190,80);
        j8.setForeground(Color.WHITE);
        j8.setFont(f4);
        
        JLabel j9 = new JLabel();
        j9.setText("Error (Code):");
        j9.setBounds(400,330,190,80);
        j9.setForeground(Color.YELLOW);
        j9.setFont(f4);
        
        JLabel j10 = new JLabel();
        j10.setText(Integer.toString(err_code));
        j10.setBounds(650,330,190,80);
        j10.setForeground(Color.WHITE);
        j10.setFont(f4);
        
        JLabel j11 = new JLabel();
        j11.setText("Total Marks:");
        j11.setBounds(400,390,190,80);
        j11.setForeground(Color.YELLOW);
        j11.setFont(f4);
        
        JLabel j12 = new JLabel();
        j12.setText(Integer.toString(total_marks));
        j12.setBounds(650,390,190,80);
        j12.setForeground(Color.WHITE);
        j12.setFont(f4);
        
        JLabel j13 = new JLabel();
        j13.setText("Obtained Marks:");
        j13.setBounds(400,450,210,80);
        j13.setForeground(Color.YELLOW);
        j13.setFont(f4);
        
        JLabel j14 = new JLabel();
        j14.setText(Integer.toString(obt_marks));
        j14.setBounds(650,450,190,80);
        j14.setForeground(Color.WHITE);
        j14.setFont(f4);
        
        percentage = (obt_marks*100)/total_marks;
        
        JLabel j15 = new JLabel();
        j15.setText("Percentage:");
        j15.setBounds(400,510,190,80);
        j15.setForeground(Color.YELLOW);
        j15.setFont(f4);
        
        j16 = new JLabel();
        j16.setText(Integer.toString(percentage)+"%");
        j16.setBounds(650,510,190,80);
        j16.setForeground(Color.WHITE);
        j16.setFont(f4);
         
        save = new JButton("Save");
        save.setBounds(530,640,100,40);
        save.setBackground(Color.YELLOW);
        save.setForeground(Color.darkGray);
        save.setFont(f2);
        
        save.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent ae)
            {
                
                String file_name = username+"_result.txt";
                String st_name = "Student:";
                String course_name = "Course:";
                String topic = "Topic:     MCQ + Code";
                String wrong_mcq = "Wrong (MCQ):";
                String error_code = "Error (Code):";
                String total_mark = "Total Marks:";
                String obtained_mrk = "Obtained Marks:";
                String prcntg = "Percentage:";
                
                try
                {
                    writer = new PrintWriter(new FileWriter("Students/"+name+"/"+file_name));
                    //writer2 = new PrintWriter(new FileWriter("Results.txt",true));
                    
                    /*writer2.printf(username);
                    writer2.printf("    "+cs_name);
                    writer2.printf("    "+err_mcq);
                    writer2.printf("    "+err_code);
                    writer2.printf("    "+total_marks);
                    writer2.printf("    "+obt_marks);
                    writer2.printf("    "+Integer.toString(percentage)+"%"+"\n\n");*/
                    
                    writer.println("   "+st_name+"     "+username);
                    writer.println("   "+course_name+"     "+cs_name);
                    writer.println("   "+topic);
                    writer.println("   "+wrong_mcq+"     "+err_mcq);
                    writer.println("   "+error_code+"     "+err_code);
                    writer.println("   "+total_mark+"     "+total_marks);
                    writer.println("   "+obtained_mrk+"    "+obt_marks);
                    writer.println("   "+prcntg+"     "+Integer.toString(percentage)+"%");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                
                finally{
                    try{
                        writer.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                
                  JOptionPane.showMessageDialog(null, "Result has been saved", "Confirmation", 1);
               }
        
        });

        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        
        c.add(save);
        c.add(exit);
        c.add(j0);
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(j5);
        c.add(j6);
        c.add(j7);
        c.add(j8);
        c.add(j9);
        c.add(j10);
        c.add(j11);
        c.add(j12);
        c.add(j13);
        c.add(j14);
        c.add(j15);
        c.add(j16);
    }
    
    /*public static void main(String[] args)
    {
        String name = "Jabbar";
        Verify_ans v1 = new Verify_ans(name);
    }*/
}

