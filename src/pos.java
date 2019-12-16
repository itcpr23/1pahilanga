
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author for sale
 */
public class pos {
    public void getProd(String id,JTable table){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ted?","root","");
            String sql = "select * from product where prod_id =?;";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

            pstmt.setString(1,id);
            
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            while (rs.next()) {
                int qty = 1;
                float subTotal = qty * rs.getFloat("price");
                model.addRow(new Object[]{rs.getString("prod_id"),  qty, rs.getString("prodname"), rs.getString("price"), subTotal});
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
