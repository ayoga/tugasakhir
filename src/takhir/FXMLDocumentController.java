/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takhir;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Anjas
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField inAn1;
    @FXML
    private JFXRadioButton radio1;
    @FXML
    private JFXRadioButton radio2;
    @FXML
    private JFXRadioButton radio3;
    @FXML
    private JFXButton btnHapus;
    @FXML
    private JFXButton btnCetak;
    @FXML
    private JFXTextField inAn2;
    @FXML
    private JFXCheckBox kat1;
    @FXML
    private JFXCheckBox kat2;
    @FXML
    private JFXCheckBox kat3;
    @FXML
    private Label harga1;
    @FXML
    private Label harga2;
    @FXML
    private Label harga3;
    @FXML
    private JFXTextField jumlah1;
    @FXML
    private JFXTextField jumlah2;
    @FXML
    private JFXTextField jumlah3;
    @FXML
    private JFXTextField HasTotal;
    @FXML
    private JFXButton btnTotal;
    
    int jumlahkategori;
    int hargatotal1,hargatotal2,hargatotal3;
    String menu1, menu2, menu3;
    String menu="";
    String atasnama, tampilTotalBayar, ket;
    int harga, kembalian;
    int totalbayar, jmlUangBayar;
    @FXML
    private JFXTextArea HasilPesanan;
    @FXML
    private JFXButton Show;

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
    private void hapus(ActionEvent event) {
        jumlah1.setText("");
        jumlah2.setText("");
        jumlah3.setText("");
        HasilPesanan.setText("");
        inAn2.setText("");
        inAn1.setText("");
        kat1.setSelected(false);
        kat2.setSelected(false);
        kat3.setSelected(false);
        HasilPesanan.setText("");
        radio1.setSelected(false);
        radio2.setSelected(false);
        radio3.setSelected(false);
        HasTotal.setText("");
    }

    @FXML
    private void cetak(ActionEvent event) {
         if (radio1.isSelected()) {
            ket = "Lama Waktu";
        } else if (radio2.isSelected()) {
            ket = "Kapasitas Barang";
        } else if (radio3.isSelected()) {
            ket = "Jumlah Kendaraan";
        }else {
            ket = "";
        }
        atasnama = inAn1.getText();
        jmlUangBayar = Integer.parseInt(inAn2.getText());
        kembalian = jmlUangBayar - totalbayar;
        
        HasilPesanan.setText("Nama Pemesanan: " + atasnama + "\n" + "Kategori yang dipilih : "  + menu +"\n" + "Total Pembayaran : Rp. " + totalbayar + "\n" + "Jumlah Uang yang Dibayar : Rp. "
                + jmlUangBayar + "\n" + "Uang Kembali : Rp. " + kembalian);
    }

    @FXML
    private void waktu(ActionEvent event) {
    }

    @FXML
    private void banyak(ActionEvent event) {
    }

    @FXML
    private void kendaraan(ActionEvent event) {
    }

    @FXML
    private void Total(ActionEvent event) {
        if(kat1.isSelected()){     
            harga = 500;
            menu += kat1.getText()+", ";
            jumlahkategori=Integer.parseInt(jumlah1.getText());
            hargatotal1=harga*jumlahkategori;
            System.out.println(hargatotal1);
        }
        if(kat2.isSelected()){     
            harga = 300;
            menu += kat2.getText()+", ";
            jumlahkategori=Integer.parseInt(jumlah2.getText());
            hargatotal2=harga*jumlahkategori;
            System.out.println(hargatotal2);
        }
        if(kat3.isSelected()){     
            harga = 2000;
            menu += kat3.getText()+", ";
            jumlahkategori=Integer.parseInt(jumlah3.getText());
            hargatotal3=harga*jumlahkategori;
            System.out.println(hargatotal3);
        }
        totalbayar = hargatotal1+hargatotal2+hargatotal3;
        tampilTotalBayar=String.valueOf(totalbayar);
        HasTotal.setText(tampilTotalBayar);
    }

    @FXML
    private void HasilPesanan(MouseEvent event) {
    }

    @FXML
    private void tampil(ActionEvent event) throws IOException {
        // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLlogAdmin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Penghitungan Parkiran");
            stage.show(); 

      
    }
}
