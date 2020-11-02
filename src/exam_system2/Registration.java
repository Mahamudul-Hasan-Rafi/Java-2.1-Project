package exam_system2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class Registration extends JFrame {

    private Container c;
    private JLabel j1, j2, j3, j4, j5;
    private Font f1, f2, f3;
    private JTextField userName, password;
    private JButton save, back;
    private JComboBox cb1, cb2;
    
    private String year[] = {"1","2","3","4"}, un;
    private String semester[] = {"1","2","3"}, pw;
    
    File f_dir, f, f_mcq, f_code, f_markinmcq, f_markincode;
    BufferedWriter br;
    
    Registration()
    {
        initComponent();
    }
    
    void initComponent()
    {
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        this.setResizable(false);
        
        f1 = new Font("Arial",Font.BOLD,36);
        f2 = new Font("Arial", Font.BOLD,25);
        f3 = new Font("Arial", Font.BOLD,20);
        
        c = getContentPane();
        c.setBackground(Color.darkGray);
        c.setLayout(null);
        
        j1 = new JLabel();
        j1.setText("Registration Form");
        j1.setBounds(446,48,400,80);
        j1.setForeground(Color.GREEN);
        j1.setFont(f1);
        
        j2 = new JLabel();
        j2.setText("Username");
        j2.setBounds(330,179,300,80);
        j2.setForeground(Color.ORANGE);
        j2.setFont(f2);
        
        userName = new JTextField();
        userName.setBounds(480,190,300,60);
        userName.setHorizontalAlignment(JTextField.LEFT);
        userName.setBackground(Color.lightGray);
        userName.setFont(f2);
        
        j3 = new JLabel();
        j3.setText("Password");
        j3.setBounds(330,279,300,80);
        j3.setForeground(Color.ORANGE);
        j3.setFont(f2);
        
        password = new JTextField();
        password.setBounds(480,290,300,60);
        password.setHorizontalAlignment(JTextField.LEFT);
        password.setBackground(Color.lightGray);
        password.setFont(f2);
        
        j4 = new JLabel();
        j4.setText("Year");
        j4.setBounds(330,379,300,80);
        j4.setForeground(Color.ORANGE);
        j4.setFont(f2);
        
        cb1 = new JComboBox(year);
        cb1.setBounds(480,399,100,40);
        cb1.setBackground(Color.lightGray);
        cb1.setEditable(true);
        cb1.setFont(f3);
        
        j5 = new JLabel();
        j5.setText("Semester");
        j5.setBounds(700,379,300,80);
        j5.setForeground(Color.ORANGE);
        j5.setFont(f2);
        
        cb2 = new JComboBox(semester);
        cb2.setBounds(850,399,100,40);
        cb2.setBackground(Color.lightGray);
        cb2.setEditable(true);
        cb2.setFont(f3);
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f3);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem02 e = new ExamSystem02();
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
                
                un = userName.getText();
                pw = password.getText();
                String name = un;
                String file_name = un+".txt";
                String file_name1 = un+"_mcq.txt";
                String file_name2 = un+"_code.txt";
                String file_name3 = un+"_markinmcq.txt";
                String file_name4 = un+"_markincode.txt";
                
                try{
                    /* f = new File("Students/"+name+"/"+file_name);
                     f.getParentFile().mkdirs();*/
                    
                     f_dir = new File("Students/"+name);

                     if(f_dir.exists()==false){
                     
                     f_dir.mkdirs();
                     
                     f = new File("Students/"+name+"/"+file_name);
                     f.createNewFile();
                     
                     f_mcq = new File("Students/"+name+"/"+file_name1);
                     f_mcq.createNewFile();
                     
                     f_code = new File("Students/"+name+"/"+file_name2);
                     f_code.createNewFile();
                     
                     f_markinmcq = new File("Students/"+name+"/"+file_name3);
                     f_markinmcq.createNewFile();
                     
                     f_markincode = new File("Students/"+name+"/"+file_name4);
                     f_markincode.createNewFile();
                   
                     br = new BufferedWriter(new FileWriter("Students/"+name+"/"+file_name));
                     br.write(pw);
                     }
                     
                     else
                     {
                          JOptionPane.showMessageDialog(null, "This username exists!!!", "Confirmation", 1);
                     }
                }
                
                catch(IOException e){
                    e.printStackTrace();
                }
                
                finally{
                    try{
                        if(f.exists()==true){
                                 br.close();
                                 JOptionPane.showMessageDialog(null, "Your information has been saved", "Confirmation", 1);
                        }
                        
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
                
                
                dispose();
                
                ExamSystem02 e2 = new ExamSystem02();
            }
        
        
        });
        
        
        c.add(userName);
        c.add(password);
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(j5);
        c.add(cb1);
        c.add(cb2);
        c.add(back);
        c.add(save);
    }
    
   /* public static void main(String args[])
    {
        Registration rg = new Registration();
        
        rg.setVisible(true);
        rg.setBounds(300,200,1200,750);
        rg.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rg.setTitle("Examination System");
        rg.setResizable(false);
        
    }*/
}
