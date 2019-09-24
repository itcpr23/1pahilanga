
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class registerCodes {
    public int registerAcc(String fname, String lname, String username, String pass){
        int x=0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?","root","");
            String sql = "insert into register values(?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                    pstmt.setString(3, username);
                        pstmt.setString(4, pass);
                        
               x = pstmt.executeUpdate();
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerCodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(registerCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return x;
    }
    public int confirmPass(String pass, String cpass){
        int x;
         if(pass.equals(cpass)){
             x=1;
         } else{
             x=0;
         }  
        
        return x;
    }
    public int checkUser(String uname){
        int x=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?","root","");
            String sql = "select * from register where username=?;";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x=1;
            }else{
                x=0;
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registerCodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(registerCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return x;
        
    }
}
