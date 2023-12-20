/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Akash
 */
import java.sql.*;


public class Conn {                      
   
    
    Connection con=null; //interface
    Statement stmt=null;
    
    public Conn(){
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","sql@123");
        stmt=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
