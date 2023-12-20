/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Akash
 */

import java.awt.*;// color
import javax.swing.*;  // this is java extended pakages
import java.awt.event.*;

  //implemented in ActionListener because it is interface and i want to open login page
public class Splash extends JFrame implements ActionListener {   // JFrame is in swing package used for create frame 
    Splash(){    //default constructor jvm created automaically
        
        getContentPane().setBackground(Color.WHITE);  //Change the frame color
         
        
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");// this class is display the message on frame
        heading.setBounds(50,30,1000,50);   //four arguments, place the lable
        heading.setFont(new Font("serif",Font.PLAIN, 50)); //set font to message
        heading.setForeground(Color.RED); //give color to message
        
        add(heading); // to show heading on frame
        setLayout(null); //avoid swing gaidlines
       //message dispaly by default anywhwre because it swing gaidlines to stop this use setLayout null
       
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg")); //for image 
       Image i2=i.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //to scale that image 
       ImageIcon i3=new ImageIcon(i2); //image convert to image icon because we pass i3 in Jlabel only pass Icon
       JLabel image=new JLabel(i3);  //add image into frame
       image.setBounds(10, 100, 950, 500);
       add(image); //ading image on frame
       
       JButton clickhere=new JButton("CLICK HERE TO CONTINUE"); //adding button
       clickhere.setBounds(400, 400, 300, 80); //button height and length
       clickhere.setBackground(Color.BLACK);
       clickhere.setForeground(Color.WHITE);
       clickhere.addActionListener(this); // when click on button then this method call override method
       image.add(clickhere); //button fit on image
       
      
       
       
        setSize(1000,650); //size of frame open in top left called origin, it is by default,hieght,weight
        setLocation(200,50); //open frame on perticular location 1.distance from left 2.distance from top
        setVisible(true); //to visible frame 
        //To Blinking ,Differ the hading
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            
        }
        
    }
    //ovveride the method which present in ActionListevent
    public void actionPerformed(ActionEvent e){
        setVisible(false); //when click button that time this method call and close current frame
        new Login();// open login frame
    }
    
    public static void main(String[] args) {
     new Splash();  //created object no use of object variable 
    }
}
