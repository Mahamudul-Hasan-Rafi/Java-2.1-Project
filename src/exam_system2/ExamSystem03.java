package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExamSystem03 extends JFrame
{
    private Container c;
    private JButton bn1, bn2, bn3, bn4, bn5, bn6;
    private Font f1, f2;
    private BufferedReader reader;
    String course;
    
    ExamSystem03(String name)
    {
        String u_name = name;
        
        initComponents(u_name);
    }
    
    void initComponents(String c_name)
    {
        f1 = new Font("Arial",Font.BOLD,30);
        f2 = new Font("Arial",Font.BOLD,20);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        
        bn1 = new JButton("Add Course");
        bn1.setBounds(465,125,250,80);
        bn1.setFont(f1);
        bn1.setBackground(Color.ORANGE);
        
        bn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                Add_Course crs = new Add_Course(c_name);
            }
        
             
        
        });
        
        bn2 = new JButton("Set Question");
        bn2.setBounds(465,260,250,80);
        bn2.setFont(f1);
        bn2.setBackground(Color.ORANGE);
        
        bn2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                Set_Q1 crs = new Set_Q1(c_name);
            }
        
             
        
        });
        
        bn3 = new JButton("Verification");
        bn3.setBounds(465,395,250,80);
        bn3.setFont(f1);
        bn3.setBackground(Color.ORANGE);
        
        bn3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String file_name = c_name+"_selected_course.txt";
                
                
                try
                {
                    reader = new BufferedReader(new FileReader("Students/"+c_name+"/"+file_name));
                    
                    course = reader.readLine();
                }
                
                 catch(IOException e){
                    e.printStackTrace();
                }
                
                finally{
                    try{
                        reader.close();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
                
                dispose();
                Verify_ans v_ans = new Verify_ans(c_name,course);
            }
        
             
        
        });
        
        bn4 = new JButton("Results");
        bn4.setBounds(465,530,250,80);
        bn4.setFont(f1);
        bn4.setBackground(Color.ORANGE);
        
        bn4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                Result_Students e = new Result_Students(c_name);
            }
        
             
        
        });
        
        bn5 = new JButton("Log Out");
        bn5.setBounds(1020,40,140,50);
        bn5.setFont(f2);
        bn5.setBackground(Color.GREEN);
        
        bn5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                ExamSystem e = new ExamSystem(c_name);
            }
        
             
        
        });
        
        bn6 = new JButton("Change Password");
        bn6.setBounds(20,50,250,50);
        bn6.setFont(f2);
        bn6.setBackground(Color.GREEN);
        
        bn6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                cng_password01 cnp = new cng_password01(c_name);
            }
        
            
        
        });
        
        
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);
        
        c.add(bn1);
        c.add(bn2);
        c.add(bn3);
        c.add(bn4);
        c.add(bn5);
        c.add(bn6);
        
    }
   
   /*public static void main(String args[])
    {
        String name = "Jabbar";
        
        ExamSystem03 frame = new ExamSystem03(name);
        frame.setVisible(true);
    }*/
}
