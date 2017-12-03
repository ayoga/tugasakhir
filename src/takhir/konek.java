/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takhir;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class konek {
    private static Connection konek;
    Connection con;
    Statement stm;
    
    public void config (){
        try {
            Class.forName("com.mysqly.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir", "root", "");
            stm = con.createStatement();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }

    public static Connection GetConnection() throws SQLException {
        if (konek == null) {
            Driver driver = new Driver();
            konek = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir? zeroDateTimeBehavior=convertToNull", "root", "");
        }
        return konek;
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

