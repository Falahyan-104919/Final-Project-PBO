package finalprojectpbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class  Barang {
    private IntegerProperty id;
    private StringProperty nama_barang;
    private StringProperty brand;
    private IntegerProperty harga;
    

    public Barang(int id, String nama_barang, String brand, int harga) {
        this.id = new SimpleIntegerProperty(id);
        this.nama_barang = new SimpleStringProperty(nama_barang);
        this.brand = new SimpleStringProperty(brand);
        this.harga = new SimpleIntegerProperty(harga);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNama_barang() {
        return nama_barang.get();
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang.set(nama_barang);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int harga) {
        this.harga.get();
    }
    
    public IntegerProperty IDProperty() {
        return id;
    }

    public StringProperty NamaProperty() {
        return nama_barang;
    }

    public StringProperty BrandProperty() {
        return brand;
    }
    
    public IntegerProperty HargaProperty() {    
        return harga;
    }

    abstract String shortSpec();
}
