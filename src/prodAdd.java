
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * @author for sale
 */
public class prodAdd {
    
    public int add(String pname, int quantity, Object price){
        int a = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?","root", "");
            String sql = "insert into product values(null,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, pname);
            pstmt.setInt(2, quantity);
            pstmt.setObject(3, price);
            
            a = pstmt.executeUpdate();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(prodAdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(prodAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return a;
    }
}
