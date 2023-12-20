/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener {
    
     JButton add,back;  
    JTextField  jfname,jffname,jfsalary,jfaddress,jfemail,jfphone,jfdesignation,jfaddhar,tfeducation;
     JLabel jempid;
     String empId;
     
    
    UpdateEmployee(String empId){  //receice id from view using String
        this.empId=empId; 
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         //frame heading
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(330, 20, 500, 40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
      labelname.setBounds(50, 100, 100, 30);
      labelname.setFont(new Font("serif",Font.PLAIN,25));
      add(labelname);
      //textfield
       JLabel jfname=new JLabel();
      jfname.setBounds(190, 105, 150, 30);
      add(jfname);
      
      //Father name
      JLabel labelfname=new JLabel("Father Name");
      labelfname.setBounds(400, 100, 150, 30);
      labelfname.setFont(new Font("serif",Font.PLAIN,25));
      add(labelfname);
      //textfield
       jffname=new JTextField();
      jffname.setBounds(550, 105, 150, 30);
      add(jffname);
      
      //date of birth
      JLabel labeldob=new JLabel("Date of Birth");
      labeldob.setBounds(50, 200, 150, 30);
      labeldob.setFont(new Font("serif",Font.PLAIN,25));
      add(labeldob);
      //calender
       JLabel jdob=new JLabel();
      jdob.setBounds(190, 200, 150, 30);
      add(jdob);
        
      //sal
      JLabel labelsalary=new JLabel("Salary");
      labelsalary.setBounds(400, 200, 150, 30);
      labelsalary.setFont(new Font("serif",Font.PLAIN,25));
      add(labelsalary);
      //textfield
       jfsalary=new JTextField();
      jfsalary.setBounds(550, 200, 150, 30);
      add(jfsalary);
      
      //address
      JLabel labeladdress=new JLabel("Address");
      labeladdress.setBounds(50, 300, 150, 30);
      labeladdress.setFont(new Font("serif",Font.PLAIN,25));
      add(labeladdress);
      //textfield
       jfaddress=new JTextField();
      jfaddress.setBounds(190, 300, 150, 30);
      add(jfaddress);
      
      //phone
      JLabel labelphone=new JLabel("Phone No");
      labelphone.setBounds(400, 300, 150, 30);
      labelphone.setFont(new Font("serif",Font.PLAIN,25));
      add(labelphone);
      //textfield
       jfphone=new JTextField();
      jfphone.setBounds(550, 300, 150, 30);
      add(jfphone);
      
      //email
      JLabel labelemail=new JLabel("Email Id");
      labelemail.setBounds(50, 400, 150, 30);
      labelemail.setFont(new Font("serif",Font.PLAIN,25));
      add(labelemail);
      //textfield
       jfemail=new JTextField();
      jfemail.setBounds(190, 400, 150, 30);
      add(jfemail);
   
      //Education
      JLabel labeleducation=new JLabel("Qualification");
      labeleducation.setBounds(400, 400, 150, 30);
      labeleducation.setFont(new Font("serif",Font.PLAIN,25));
      add(labeleducation);
      
      //textfield
       tfeducation=new JTextField();
    tfeducation.setBackground(Color.WHITE);
      tfeducation.setBounds(550, 400, 150, 30);
      add(tfeducation);
      
      //Designetion
      JLabel labeldisignation=new JLabel("Disignation");
      labeldisignation.setBounds(50, 500, 150, 30);
      labeldisignation.setFont(new Font("serif",Font.PLAIN,25));
      add(labeldisignation);
      //textfield
       jfdesignation=new JTextField();
      jfdesignation.setBounds(190, 500, 150, 30);
      add(jfdesignation);
      
      //phone
      JLabel labeladdhar=new JLabel("Addhar No");
      labeladdhar.setBounds(400, 500, 150, 30);
      labeladdhar.setFont(new Font("serif",Font.PLAIN,25));
      add(labeladdhar);
      //textfield
       JLabel jfaddhar=new JLabel();
      jfaddhar.setBounds(550, 500, 150, 30);
      add(jfaddhar);
      
      //employee id
      JLabel labeldempid=new JLabel("Employee Id");
      labeldempid.setBounds(50, 600, 150, 30);
      labeldempid.setFont(new Font("serif",Font.PLAIN,25));
      add(labeldempid);
      //textfield
      //here want to genarate id automatically to generate use util package and Random class object
       jempid=new JLabel();//pass only String not number , convert int to string use "" concate
      jempid.setBounds(200, 600, 150, 30);
      jempid.setFont(new Font("serif",Font.BOLD,25));
      add(jempid);
      
      
      try{
          Conn con=new Conn();
          String query="select * from employee where empId= '"+empId+"'";
         ResultSet rs= con.stmt.executeQuery(query);
          while(rs.next()){
              jfname.setText(rs.getString("name"));
              jffname.setText(rs.getString("fname"));
              jdob.setText(rs.getString("dob"));
              jfsalary.setText(rs.getString("salary"));
              jfaddress.setText(rs.getString("address"));
              jfphone.setText(rs.getString("phone"));
              jfemail.setText(rs.getString("email"));
              tfeducation.setText(rs.getString("education"));
              jfdesignation.setText(rs.getString("designation"));
              jfaddhar.setText(rs.getString("addhar"));
              jempid.setText(rs.getString("empId"));
              
              
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      //add details Button
       add=new JButton("update Details");
      add.setBounds(400, 600, 150, 40);
      add.addActionListener(this);
      add.setBackground(Color.black);
      add.setForeground(Color.WHITE);
      add(add);
      
      //add go back button
       back=new JButton("Go Back");
      back.setBounds(600, 600, 150, 40);
      back.addActionListener(this); // for clikebel button
      back.setBackground(Color.black);
      back.setForeground(Color.WHITE);
      add(back);
      

        
           setSize(1000,900);
        setLocation(250,0);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent j){
         if(j.getSource()==add){
            String fname=jffname.getText();
            String salary=jfsalary.getText();
            String address=jfaddress.getText();
            String phone=jfphone.getText();
            String email=jfemail.getText();
            String education=tfeducation.getText(); //get selected item and return in String so typecast
            String designation=jfdesignation.getText();
            
            
            try{
                Conn con=new Conn();
               String query="update employee set fname='"+fname+"',salary= '"+salary+"', address='"+address+"', phone='"+phone+"', email='"+email+"', education='"+education+"', designation='"+designation+"' where empId='"+empId+"'";
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details update Successfully");
                setVisible(false);
                new Home();
                 
            }catch(Exception eaa){
                eaa.printStackTrace();
                
            }
         } else{
             setVisible(false);
             new Home();
         }
     }
    
    public static void main(String[] args) {
        new UpdateEmployee(""); //pass empty string for get id from view
        
    }
    
}
