package exam_system2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class cng_password01 extends JFrame
{
    private Container c;
    private JLabel j1, j2, j3;
    private Font f1, f3;
    private JTextField p_password, n_password, c_password;
    private JButton save, back;
    public String previous_pw, new_pw, confirm_pw, old_pwd;
    BufferedReader br;
    BufferedWriter brw;
    PrintWriter pw;
    
    cng_password01(String n)
    {
        try
        {
            br = new BufferedReader(new FileReader("Admin.txt"));
            old_pwd = br.readLine(); 
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
        String nm = n;
        initComponents(nm);
    }
    
    void initComponents(String name)
    {
        f1 = new Font("Arial",Font.BOLD,26);
        f3 = new Font("Arial", Font.BOLD,20);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        j1 = new JLabel();
        j1.setText("Previous Password");
        j1.setBounds(250,170,270,80);
        j1.setForeground(Color.WHITE);
        j1.setFont(f1);
        
        p_password = new JTextField();
        p_password.setBounds(555,170,300,70);
        p_password.setBackground(Color.lightGray);
        p_password.setFont(f1);
        
        j2 = new JLabel();
        j2.setText("New Password");
        j2.setBounds(250,280,270,80);
        j2.setForeground(Color.WHITE);
        j2.setFont(f1);
        
        n_password = new JTextField();
        n_password.setBounds(555,280,300,70);
        n_password.setBackground(Color.lightGray);
        n_password.setFont(f1);
        
        j3 = new JLabel();
        j3.setText("Confirm Password");
        j3.setBounds(250,390,270,80);
        j3.setForeground(Color.WHITE);
        j3.setFont(f1);
        
        c_password = new JTextField();
        c_password.setBounds(555,390,300,70);
        c_password.setBackground(Color.lightGray);
        c_password.setFont(f1);
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f3);
        
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
               
                dispose();
                ExamSystem03 e1 = new ExamSystem03(name);
            }
        
        
        });
        
        save = new JButton("Save");
        save.setBounds(1050,640,100,40);
        save.setBackground(Color.YELLOW);
        save.setForeground(Color.darkGray);
        save.setFont(f3);
        
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                previous_pw = p_password.getText();
                new_pw = n_password.getText();
                confirm_pw = c_password.getText();
                
                if(!previous_pw.equals(old_pwd))
                {
                    JOptionPane.showMessageDialog(null,"Wrong Old Password !!","Warning",2);
                }
                
                else if(!new_pw.equals(confirm_pw))
                {
                    JOptionPane.showMessageDialog(null,"Wrong Confirmation !!","Warning",2);
                }
                
                else
                {
                    try
                    {
                        /*brw = new BufferedWriter(new FileWriter("Admin.txt"));
                        brw.write(confirm_pw);*/
                        pw = new PrintWriter("Admin.txt");
                        pw.println(confirm_pw);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                    finally
                    {
                       /* try
                        {
                            //brw.close();
                            //pw.close();
                        }
                        catch(IOException e1)
                        {
                            e1.printStackTrace();
                        }*/
                        pw.close();
                    }
                    
                    dispose();
                    ExamSystem01 ex = new ExamSystem01(name);
                }
                
            }
        
        
        });
        
        c = getContentPane();
        c.setBackground(Color.darkGray);
        c.setLayout(null);
        
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(p_password);
        c.add(n_password);
        c.add(c_password);
        c.add(save);
        c.add(back);
        
    }
    
    /*public static void main(String args[])
    {
        cng_password01 cp = new cng_password01();
        cp.setVisible(true);
    }*/
}
