package finalprojectpbo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListOrder {
    private StringProperty nama_barang;
    private IntegerProperty harga;
    private IntegerProperty jumlah;
    
    public ListOrder(String nama_barang, Integer harga, Integer jumlah){
        this.nama_barang = new SimpleStringProperty(nama_barang);
        this.harga = new SimpleIntegerProperty(harga);
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    public String getNama_item() {
        return nama_barang.get();
    }

    public void setNama_item(String nama_item) {
        this.nama_barang.set(nama_item);
    }

    public int getHarga_item() {
        return harga.get();
    }

    public void setHarga_item(int harga_item) {
        this.harga.set(harga_item);
    }

    public int getJumlah_item() {
        return jumlah.get();
    }

    public void setJumlah_item(int jumlah_item) {
        this.jumlah.set(jumlah_item);
    }
    
    public StringProperty nama_barangProperty(){
        return nama_barang;
    }
    
    public IntegerProperty hargaProperty(){
        return harga;
    }
    
    public IntegerProperty jumlahProperty(){
        return jumlah;
    }
}