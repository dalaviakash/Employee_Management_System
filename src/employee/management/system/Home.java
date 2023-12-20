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



public class Home extends JFrame implements ActionListener {
    //declare globlly for acseess
    JButton add,view,update,remove;
    
    Home(){
        
        setLayout(null);
        
        //adding image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1160, 630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1160, 630);
        add(image);
        
        //write message
        JLabel heading=new JLabel("Emloyee Management System");
        heading.setBounds(610, 50, 500, 40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,30));
        image.add(heading);
        
        //adding 4 Buttons for operation
         add=new JButton("Add Employee");
        add.setBounds(650, 100, 150, 40);
        add.setBackground(Color.YELLOW);
        add.addActionListener(this);
        image.add(add);
        
        //add display
         view=new JButton("View Employee");
        view.setBounds(850, 100, 150, 40);
        view.setBackground(Color.YELLOW);
        view.addActionListener(this);
        image.add(view);
        
        //add update
         update=new JButton("Update Employee");
        update.setBounds(650, 170, 150, 40);
        update.setBackground(Color.YELLOW);
        update.addActionListener(this);
        image.add(update);
        
        //add remove
         remove=new JButton("Remove Employee");
        remove.setBounds(850, 170, 150, 40);
        remove.setBackground(Color.YELLOW);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
        setSize(1160,630);
        setLocation(100,40);
        setVisible(true);
    }
    //ovverrid method intrface
     public void actionPerformed(ActionEvent en){
         //when click on the perticular button that source get
         if(en.getSource()==add){
     // this method get the clikeble option
             setVisible(false);
             new AddEmployee();
         }else if(en.getSource()==view){
             setVisible(false);
             new ViewEmployee();
         }else if(en.getSource()==update){
             new ViewEmployee();
         }else{
             setVisible(false);
             new RemoveEmployee();
         }
     }
    public static void main(String[] args) {
        new Home();
    }
    
}
