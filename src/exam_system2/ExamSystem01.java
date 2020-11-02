package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ExamSystem01 extends JFrame
{
    private Container c;
    private JLabel jl;
    private JButton jbn, back;
    private Font f1, f2, f3;
    private JTextField userName;
    private JPasswordField password;
    public String Password;
    BufferedReader br, br1;
    int i=1;
    String uName=null;
    
    ExamSystem01(String u_name)
    {
        try{
            br  = new BufferedReader(new FileReader("Admin.txt"));
            Password = br.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        String pw = Password;
        String un = u_name;
        initComponents(pw,u_name);
    }
    
    void initComponents(String passwd, String name)
    {
       
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        this.setResizable(false);
        
        
        f1 = new Font("Arial",Font.BOLD,44);
        f2 = new Font("Arial",Font.BOLD,32);
        f3 = new Font("Arial",Font.BOLD,20);
        
        c = getContentPane();
        c.setBackground(Color.BLACK);
        c.setLayout(null);
        
        jl = new JLabel();
        jl.setText("Admin Login");
        jl.setBounds(480,100,300,100);
        jl.setForeground(Color.YELLOW);
        jl.setFont(f1);
        
        jbn = new JButton("Login");
        jbn.setBounds(515,500,200,80);
        jbn.setBackground(Color.orange);
        jbn.setForeground(Color.BLACK);
        jbn.setFont(f2);
        
        jbn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                /*dispose();
                ExamSystem e = new ExamSystem();*/
                int choice=100;
                File file;
                String f_name;
                
                while(choice>0)
                {
                    f_name = Integer.toString(i)+".txt";
                    file = new File("Joined_Students/"+f_name);
                    
                    if(file.exists())
                    {
                        try
                        {
                           br1 = new BufferedReader(new FileReader(file)); 
                           uName = br1.readLine();
                        }
                        
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                        
                        finally
                        {
                            try{
                                br1.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        choice=0;
                        file.delete();
                    }
                    
                    i++;
                    choice--;
                }
                
                String username = userName.getText();
                String password1 = password.getText();
                
                if(username.equals("admin") && (password1.equals(passwd)))
                {
                    dispose();
                    ExamSystem03 e3 = new ExamSystem03(uName);
                }
                
                else if(!password1.equals(passwd) && !username.equals("admin"))
                {
                    JOptionPane.showMessageDialog(null, "Wrong Entry !!", "Warning", 2);
                }
                
                else if(!username.equals("admin"))
                {
                    JOptionPane.showMessageDialog(null, "Wrong Admin name !!", "Warning", 2);
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Password !!", "Warning", 2);
                }
            }
        
         });
        
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.setFont(f3);
        
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                dispose();
                ExamSystem e = new ExamSystem(name);
            }
        
         });
        
        userName = new JTextField("admin");
        userName.setBounds(420,212+35,370,80);
        userName.setHorizontalAlignment(JTextField.LEFT);
        userName.setBackground(Color.lightGray);
        userName.setFont(f3);
        
        
        password = new JPasswordField("admin");
        password.setEchoChar('*');
        password.setBounds(420,307+35,370,80);
        password.setHorizontalAlignment(JPasswordField.LEFT);
        password.setBackground(Color.lightGray);
        password.setFont(f3);
        
        
        c.add(back);
        c.add(jl);
        c.add(jbn);
        c.add(userName);
        c.add(password);
        
    }
    
    
   /* public static void main(String args[])
    {
        ExamSystem01 frame2 = new ExamSystem01();
        
        frame2.setVisible(true);
        frame2.setBounds(300,200,1200,750);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setTitle("Examination System");
        frame2.setResizable(false);
    }*/
    
}
