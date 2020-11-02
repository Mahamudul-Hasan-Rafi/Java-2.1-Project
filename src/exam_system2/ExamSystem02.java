package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class ExamSystem02 extends JFrame
{
    private Container  c;
    private JLabel jl;
    private JButton jbn, back, registration;
    private Font f1, f2, f3, f4;
    private JTextField userName, pf;
    private JPasswordField password;
    BufferedReader br, br1;
    String uPass,uNO;
    PrintWriter writer, writer1;
    int i, j;
    
    ExamSystem02()
    {
        initComponents();
    }
    
    void initComponents()
    {
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        this.setResizable(false);
        
        f1 = new Font("Arial",Font.BOLD,44);
        f2 = new Font("Arial",Font.BOLD,32);
        f3 = new Font("Arial", Font.BOLD,20);
        f4 = new Font("Arial", Font.BOLD,27);
        
        c = getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(null);
        
        jl = new JLabel();
        jl.setText("User Login");
        jl.setBounds(480,100,300,100);
        jl.setForeground(Color.ORANGE);
        jl.setFont(f1);
        
        jbn = new JButton("Login");
        jbn.setBounds(536,420,140,60);
        jbn.setBackground(Color.ORANGE);
        jbn.setForeground(Color.BLACK);
        jbn.setFont(f4);
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.BLACK);
        back.setFont(f3);
        
        registration = new JButton("Register Now");
        registration.setBounds(453,530,300,75);
        registration.setBackground(Color.orange);
        registration.setForeground(Color.BLACK);
        registration.setFont(f2);
        
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String n = null;
                dispose();
                ExamSystem e = new ExamSystem(n);
            }
        
         });
        
        registration.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Registration rg = new Registration();
            }
        });
        
        userName = new JTextField("Username");
        userName.setBounds(420,212,370,80);
        userName.setHorizontalAlignment(JTextField.LEFT);
        userName.setBackground(Color.white);
        userName.setFont(f3);
        
        password = new JPasswordField("password");
        password.setEchoChar('*');
        password.setBounds(420,307,370,80);
        password.setHorizontalAlignment(JPasswordField.LEFT);
        password.setBackground(Color.white);
        password.setFont(f3);
        
        jbn.addActionListener(new ActionListener(){
            private Object JOption;

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String um = userName.getText();
                String pwd = password.getText();
                String ume = um+".txt";
                
                try{
                    br = new BufferedReader(new FileReader("Students/"+um+"/"+ume));
                    br1 = new BufferedReader(new FileReader("No.txt"));
                    uPass = br.readLine();
                    uNO = br1.readLine();
                    j = Integer.parseInt(uNO);
                }
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null, "This User does not exist", "Warning", 2);
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
                
                i = j;
                if(pwd.equals(uPass))
                {
                    i++;
                    String f_no = Integer.toString(i);
                    String um1 = um;
                    String f_std = f_no+".txt";
                    
                    JOptionPane.showMessageDialog(null,"Correct Password !!","Confirm",1);
                    
                    try
                    {
                        writer = new PrintWriter(new FileWriter("Joined_Students/"+f_std));
                        writer1 = new PrintWriter(new FileWriter("No.txt"));
                        
                        writer.println(um1);
                        writer1.println(i);
                    }
                    
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                
                finally{
                    try{
                        writer.close();
                        writer1.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                
                    UPanel1 up = new UPanel1(um1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong Password !!","Warning",2);
                }
                
            }
        
        
        });
        
        c.add(back);
        c.add(jl);
        c.add(jbn);
        c.add(userName);
        c.add(password);
        c.add(registration);
        
    }
    
   /* public  static  void   main(String args[])
    {
        
        ExamSystem02 frame3 = new ExamSystem02();
        
        frame3.setVisible(true);
        frame3.setBounds(300,200,1200,750);
        frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame3.setTitle("Examination System");
        frame3.setResizable(false);
    }*/
    
}
