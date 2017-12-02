/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takhir;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anjas
 */
public class FXMLChooseOpsiController implements Initializable {

    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton Update;
    private ObservableList<tabelanggota> data;
     Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    @FXML
    private TableView<tabelanggota> ListUser;
    @FXML
    private JFXButton Exit;
    @FXML
    private TableColumn<tabelanggota, String> namapengguna;
    @FXML
    private TableColumn<tabelanggota, String> Password;
    @FXML
    private TableColumn<tabelanggota, String> nokend;
    @FXML
    private TableColumn<tabelanggota, String> telp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void update(ActionEvent event) throws SQLException { {
        
         try {
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = stat.executeQuery("SELECT * FROM daftar");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new tabelanggota(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        namapengguna.setCellValueFactory(new PropertyValueFactory<>("username"));
        Password.setCellValueFactory(new PropertyValueFactory<>("password"));
        nokend.setCellValueFactory(new PropertyValueFactory<>("No_kendrn"));
        telp.setCellValueFactory(new PropertyValueFactory<>("telp"));
        
        
        ListUser.setItems(data);
        
    }
    }

    @FXML
    private void Keluar(ActionEvent event) throws IOException {
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

    @FXML
    private void hapus(ActionEvent event) {
    }

    @FXML
    private void Update(ActionEvent event) {
    }

    
}

