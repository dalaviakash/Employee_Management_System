
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; //for calender display
import java.util.*; //for random class generate random number
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran=new Random();  // random class 
    int number=ran.nextInt(999999); //gereate digits number  how many digit you want
    
    //locally button access globly in method addActionlistner
    JButton add,back;  
    JTextField  jfname,jffname,jfsalary,jfaddress,jfemail,jfphone,jfdesignation,jfaddhar;
    JDateChooser jdob;
    JComboBox jfeducation;
     JLabel jempid;
    
    AddEmployee(){
        //frame color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //frame heading
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(330, 20, 500, 40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //all information
        
      JLabel labelname=new JLabel("Name");
      labelname.setBounds(50, 100, 100, 30);
      labelname.setFont(new Font("serif",Font.PLAIN,25));
      add(labelname);
      //textfield
       jfname=new JTextField();
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
       jdob=new JDateChooser();
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
      String course[]={"select","BE","BTech","BSC","BBA","BCA","BCOM","BA","MBA","MCA","MSC"}; //for dropdown taken array formate
       jfeducation=new JComboBox(course); // fro dropdown another is choice
      jfeducation.setBounds(550, 400, 150, 30);
      add(jfeducation);
      
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
       jfaddhar=new JTextField();
      jfaddhar.setBounds(550, 500, 150, 30);
      add(jfaddhar);
      
      //employee id
      JLabel labeldempid=new JLabel("Employee Id");
      labeldempid.setBounds(50, 600, 150, 30);
      labeldempid.setFont(new Font("serif",Font.PLAIN,25));
      add(labeldempid);
      //textfield
      //here want to genarate id automatically to generate use util package and Random class object
       jempid=new JLabel("" + number);//pass only String not number , convert int to string use "" concate
      jempid.setBounds(200, 600, 150, 30);
      jempid.setFont(new Font("serif",Font.BOLD,25));
      add(jempid);
      
      //add details Button
       add=new JButton("Add Details");
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
    
    public void actionPerformed(ActionEvent ea){
        
        if(ea.getSource()==add){
           //get all values here
            String name=jfname.getText();
            String fname=jffname.getText();
            String dob=((JTextField)jdob.getDateEditor().getUiComponent()).getText();//because getText works on only textField so typecast to JTextField
            String salary=jfsalary.getText();
            String address=jfaddress.getText();
            String phone=jfphone.getText();
            String email=jfemail.getText();
            String education=(String)jfeducation.getSelectedItem(); //get selected item and return in String so typecast
            String designation=jfdesignation.getText();
            String addhar=jfaddhar.getText();
            String empId=jempid.getText();
            
            //to store date in database 
            //databse is a external entity so handle exception
            
            try{
                //ojbect of conn class for databse store
               
               Conn con=new Conn();
               String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empId+"')";
               con.stmt.executeUpdate(query);
               JOptionPane.showConfirmDialog(null,"Details added successfully");
               setVisible(false);
               new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
       
   
}
