/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Akash
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;    //for Resultset execute query


public class Login extends JFrame implements ActionListener  {
    
    JTextField jfusername,jfpassword; //taken outside for access  globally
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);//backgroud color
        setLayout(null);  //avoid swing gaidlines
        
        //login username
        JLabel username=new JLabel("USERNAME"); 
        username.setBounds(50, 30, 100, 50);
        add(username);
        
        //text boxes
        jfusername=new JTextField();
        jfusername.setBounds(150, 40, 150, 30);
        add(jfusername);
        
        //login password
        JLabel password=new JLabel("PASSWORD");
        password.setBounds(50, 70, 100, 50);
        add(password);
        
        //text box
        jfpassword=new JTextField();
        jfpassword.setBounds(150, 80, 150, 30);
        add(jfpassword);
        
        //button
        JButton button=new JButton("LOGIN");
        button.setBounds(190, 130, 90, 35);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);
        
        //Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 20,100,150);
        add(image);
        
        setSize(500,300);
        setLocation(400,250);
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae){
        try{
            //getting the value from text field
            String username1=jfusername.getText(); //getText gives which values present in text field
            String password1=jfpassword.getText();
            
            Conn con=new Conn(); // create this object to execute query
            String query="select * from login where username='"+username1+"' and password= '"+password1+"'";
            
         ResultSet rs=con.stmt.executeQuery(query);
         if(rs.next()){  // used if not used while because value only one
             JOptionPane.showConfirmDialog(null, "succsessful Login");
             setVisible(false); //if values are present then open next frame
             new Home();
             
         }else{
             JOptionPane.showConfirmDialog(null,"Invalid username or Password");//use when username & password are wrong
         setVisible(false); //close frame
         }
         
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }
}
