/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anjas
 */
public class FXMLdaftarController implements Initializable {

    @FXML
    private JFXButton btnMasuk;
    @FXML
    private JFXButton btnDaftar;
    @FXML
    private JFXPasswordField InPass;
    @FXML
    private JFXTextField InUser;
    @FXML
    private JFXTextField nokend;
    @FXML
    private Label cek;
    @FXML
    private JFXButton Back;
    @FXML
    private JFXTextField telp;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    void kelogin(ActionEvent event) {
        
                try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLlogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Penghitungan Parkiran");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
            
    }

    @FXML
    void submit(ActionEvent event) {
 Connection connection = null;
        PreparedStatement ps;
        try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull", "root","");
           String sql = "INSERT INTO daftar(username,password,No_kendrn,telp) VALUES(?,?,?,?)";
           ps=connection.prepareStatement(sql);
           ps.setString(1,InUser.getText());
           ps.setString(2,InPass.getText());
           ps.setString(3,nokend.getText());
           ps.setString(4,telp.getText());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Data success");
           try{
               ((Node) (event.getSource())).getScene().getWindow().hide();
               
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("FXMLlogin.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.setTitle("TNBTS");
               stage.show();
           
        }catch(Exception e){
           System.out.println ("Failed to create new data" + e);
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
         // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLwelcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Penghitungan Parkiran");
            stage.show();
    }
    
}


