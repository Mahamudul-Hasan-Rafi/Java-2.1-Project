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
import java.io.PrintWriter;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

public class Set_Ques extends JFrame {
    
    private Container c;
    private JButton bn1, bn2, back;
    private Font f1, f2, f3, f4;
    private JComboBox cb;
    private JLabel j1, j2, j3, j4;
    private BufferedReader br;
    private JButton jn, jm;
    String St, cs, cr, u_name;
    private JTextField tx1;
    private BufferedReader reader;
    private PrintWriter writer;
         
    Set_Ques(String crs, String name)
    {
        cs = crs;
        String n = name;
        initComponents(cs, n);
    }

    void initComponents(String cs, String name)
    {
        cr = cs;
        u_name = name;
        
        f2 = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,35);
        f3 = new Font("Arial", Font.BOLD,26);
        f4 = new Font("Arial", Font.BOLD,23);
        
        this.setVisible(true);
        this.setBounds(300,200,1200,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Examination System");
        
        j1 = new JLabel();
        j1.setBounds(150,250,500,60);
        j1.setText("File Address");
        j1.setForeground(Color.yellow);
        j1.setFont(f1);
        
        tx1 = new JTextField();
        tx1.setBounds(400,250,700,60);
        tx1.setFont(f3);
        
        back = new JButton("Back");
        back.setBounds(50,640,100,40);
        back.setBackground(Color.CYAN);
        back.setForeground(Color.darkGray);
        back.setFont(f2);
        
        back.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
                ExamSystem03 e = new ExamSystem03(u_name);
            }
            
        });
        
        bn1 = new JButton("Log Out");
        bn1.setBounds(1020,40,140,50);
        bn1.setFont(f2);
        bn1.setBackground(Color.ORANGE);
        
        bn1.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                  
                 dispose();
                 ExamSystem e2 = new ExamSystem(u_name);
             }
        
        
        });
        
        bn2 = new JButton("Upload");
        bn2.setBounds(520,380,140,60);
        bn2.setFont(f3);
        bn2.setBackground(Color.GREEN);
        
        bn2.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent ae) {
                  
                 String path = tx1.getText();
                 String f_name = cr+".txt";
                 String line;
                 
                 try{
                     File source_file = new File(path);
                     File destination_file = new File("D:/Java Programming/Exam_System2/Questions/"+cr+"/"+f_name);
                     
                     //System.out.println(path);
                     
                     if(destination_file.createNewFile() || !destination_file.createNewFile())
                     {
                         writer = new PrintWriter(new FileWriter(destination_file));
                         reader = new BufferedReader(new FileReader(source_file));
                         //writer = new PrintWriter(new FileWriter(destination_file));
                     
                         while((line = reader.readLine())!=null)
                         {
                             writer.println(line);
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
                         writer.close(); 
                     }
                     catch(IOException e){
                         e.printStackTrace();
                     }
                 }
                 JOptionPane.showMessageDialog(null,"File Uploaded Succesfully!!", "Confirmation", 1);
             }
        
        
        });
        
        
       
        
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        
        c.add(j1);
        c.add(tx1);
        c.add(back);
        c.add(bn1);
        c.add(bn2);
    }
    
     /*public static void main(String[]args)
    {
        Set_Ques up = new Set_Ques(St1);
        
        up.setVisible(true);
    }*/
}
