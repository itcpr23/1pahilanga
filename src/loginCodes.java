
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
public class loginCodes {
    public int log_in(String uname, String pass){
        int x = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?", "root","");
            String sql = "select * from register where username=? and password=?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            pstmt.setString(2, pass);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                x=1;
            }else{
                x=0;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginCodes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
}
