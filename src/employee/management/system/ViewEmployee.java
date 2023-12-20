/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import net.proteanit.sql.DbUtils; //for data in table format
import java.awt.event.ActionListener;


public class ViewEmployee extends JFrame implements ActionListener {
    
    JTable table; //data display in table format to use displa table
    Choice employeeId; // for dropdown
    JButton  print,update,back, search; 
    
    ViewEmployee(){
        getContentPane().setBackground(Color.white);
       
       setLayout(null);
       
        
        //search data using serch box
        JLabel jsearch=new JLabel("Search Employee By Id");
        jsearch.setFont(new Font("serif",Font.PLAIN,15));
        jsearch.setBounds(30, 20, 150, 40);
        add( jsearch);
        
        //dropdown
        employeeId=new Choice();
        employeeId.setBounds(180, 30, 150, 20);
        add(employeeId);
        //for display using emp id
        try{
            Conn con=new Conn();
            ResultSet rs=con.stmt.executeQuery("select * from employee");
             while(rs.next()){
                employeeId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
        
        //create table object
        table=new JTable();
        
        //we get data from databse so that handle first exception take try catch
        //whenever databse is taken that time take try catch block
        try{
            // wehenever we work on databse then create Connection object
            Conn con=new Conn();
            //result set execute query and store in rs
            ResultSet rs=con.stmt.executeQuery("select * from employee"); // import sql package
           
            
            //next data stored in rs if you want to get then there is two mwthod use loop and X row and Y colunm
            //otherwise use library rs2xml i this one class present that is DbUtils
            //import them use net.proteanit
            
            table.setModel(DbUtils.resultSetToTableModel(rs));// use add rs data in table
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // when data is more that time it out of frame we take here ScollPane
        //JscrollPane Object
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100, 1200, 700);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
         print=new JButton("Print");
        print.setBounds(110, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
         update=new JButton("Update");
        update.setBounds(200, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(300, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
       
        
        
        
        setSize(1200 ,700);
        setLocation(50,30);
        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent af){
        if(af.getSource()==search){
            //for search getSelectedItem
            String query="select * from employee where empId='"+employeeId.getSelectedItem()+"'";
            try{
                Conn con=new Conn();
                ResultSet rs=con.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(af.getSource()==print){
            //oly call print function for printer
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(af.getSource()==update){
            setVisible(false);
            new UpdateEmployee(employeeId.getSelectedItem());// pass id to that class
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }
    
    
}
