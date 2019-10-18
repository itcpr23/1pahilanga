
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author for sale
 */
public class editProd {
    public int editProduct(int id , String product, Object price){
        int a = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?","root","");
            String sql = "UPDATE product SET prodname =?,price =? WHERE prod_id =?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.setString(1, product);
            pstmt.setObject(2, price);
            pstmt.setInt(3, id);
            
            
            int z = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO UPDATE?!","C O N F I R M A T I O N",JOptionPane.YES_NO_OPTION);
            if(z==JOptionPane.YES_OPTION){
                a = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "PRODUCT UPDATED!");
                 main m = new main();
                 m.setVisible(true);
            }else{
                
            }
           
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editProd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return 0;
    }
    public int search(String name){
        int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return x;
    }
}
  
