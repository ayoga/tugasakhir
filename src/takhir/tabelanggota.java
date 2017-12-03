/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takhir;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tabelanggota {
    private final StringProperty namapengguna;
    private final StringProperty Password;
    private final StringProperty nokend;
    private final StringProperty telp;
    
    public tabelanggota(String namapengguna, String Password, String nokend, String telp) {
        this.namapengguna = new SimpleStringProperty(namapengguna);
        this.Password = new SimpleStringProperty(Password);
        this.nokend = new SimpleStringProperty(nokend);
        this.telp = new SimpleStringProperty(telp);
    }
    
    //getter
    public String getnamapengguna() {
        return namapengguna.get();
    }
    public String getPassword() {
        return Password.get();
    }
    public String getnokend() {
        return nokend.get();
    }
    public String gettelp() {
        return telp.get();
    }
   
    
    //setter
    public void setnamapengguna(String value) {
        namapengguna.set(value);
    }
    public void setPassword(String value) {
        Password.set(value);
    }
    public void setnokend(String value) {
        nokend.set(value);
    }
    public void settelp(String value) {
        telp.set(value);
    }
   
    
    //Property values
    public StringProperty namapenggunaProperty() {
        return namapengguna;
    }
    public StringProperty PasswordProperty() {
        return Password;
    }
    public StringProperty nokendProperty() {
        return nokend;
    }
    public StringProperty telpProperty() {
        return telp;
    }
}
