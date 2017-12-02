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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXPasswordField;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Anjas
 */
public class FXMLlogAdminController implements Initializable {

    @FXML
    private JFXButton btnMasuk;
     @FXML
    private JFXPasswordField Pass;
    private Label tampilPass;
    private Label tampilUser;
    String username, password;
    @FXML
    private JFXTextField InUser;
    @FXML
    private Label label;
    @FXML
    private JFXButton Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Masuk(ActionEvent event) {
         Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `admin` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, InUser.getText());
            ps.setString(2, Pass.getText());
            ResultSet result = ps.executeQuery();
              if (result.next()) {
                try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLChooseOpsi.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 830, 450);
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("anjas");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
            } else {
                label.setText("Gagal Masuk !");
                Pass.setText("");
                InUser.requestFocus();
            }
        } catch (SQLException ex) {
            label.setText("Gagal !");
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

