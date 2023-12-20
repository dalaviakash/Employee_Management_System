/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Akash
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempid;
    JButton delete, back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel jremove=new JLabel("Remove Employee");
        jremove.setBounds(500, 5, 250, 40);
        jremove.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(jremove);
        
        JLabel lempid=new JLabel("Employee ID");
        lempid.setBounds(50, 40, 150, 40);
        add(lempid);
        
         cempid=new Choice();
         cempid.setBounds(200, 50, 150, 40);
         add(cempid);
         
         try{
             Conn con=new Conn();
             String query="select * from employee";
             ResultSet rs=con.stmt.executeQuery(query);
             while(rs.next()){
                 cempid.add(rs.getString("empId"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         //for display
         JLabel Jlname=new JLabel("Name");
        Jlname.setBounds(50, 90, 150, 40);
        add(Jlname);
        
        JLabel lname=new JLabel();
        lname.setBounds(200, 90, 150, 40);
        add(lname);
        
         JLabel Jphone=new JLabel("Phone");
        Jphone.setBounds(50, 130, 150, 40);
        add(Jphone);
        
        JLabel lphone=new JLabel();
        lphone.setBounds(200, 130, 150, 40);
        add(lphone);
        
         JLabel Jemail=new JLabel("EmaIl Id");
        Jemail.setBounds(50, 180, 150, 40);
        add(Jemail);
        
        JLabel lemail=new JLabel();
        lemail.setBounds(200, 180, 150, 40);
        add(lemail);
        
//        //data pass to set
        try{
             Conn con=new Conn();
             String query="select * from employee where empId='"+cempid.getSelectedItem()+"'";
             ResultSet rs=con.stmt.executeQuery(query);
             while(rs.next()){
                 lname.setText(rs.getString("name"));
                 lphone.setText(rs.getString("phone"));
                 lemail.setText(rs.getString("email"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        
        // add event when dropdown id change that time value change
        
        cempid.addItemListener(new ItemListener() {   //this is use for tos see current data changed or not
           //unimplemented method override
            @Override
            public void itemStateChanged(ItemEvent ie) {
                
                 try{
             Conn con=new Conn();
             String query="select * from employee where empId='"+cempid.getSelectedItem()+"'";
             ResultSet rs=con.stmt.executeQuery(query);
             while(rs.next()){
                 lname.setText(rs.getString("name"));
                 lphone.setText(rs.getString("phone"));
                 lemail.setText(rs.getString("email"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
                
            }
        });
        
        
        delete=new JButton("Delete");
        delete.setBounds(100, 250, 100, 40);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(250, 250, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400, 0, 600, 500);
        add(image);
        
        setSize(1100,500);
        setLocation(200,40);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ei){
        if(ei.getSource()==delete){
            //delete the data
            try{
                Conn con=new Conn();
                String query="delete from employee where empId='"+cempid.getSelectedItem()+"'";
                con.stmt.executeUpdate(query);
                //messege display
                JOptionPane.showConfirmDialog(null, "Employee information Deleted Successfully");
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
    public static void main(String[] args) {
        new RemoveEmployee();
    }
    
}
