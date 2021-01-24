package finalprojectpbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListOrder {
    private final StringProperty nama_barang;
    private final IntegerProperty jumlah;
    private final IntegerProperty total_harga;
    
    public ListOrder(String nama_barang, Integer harga, Integer jumlah){
        this.nama_barang = new SimpleStringProperty(nama_barang);
        this.jumlah = new SimpleIntegerProperty(jumlah);
        this.total_harga = new SimpleIntegerProperty(harga*jumlah);
    }
    
    public StringProperty nama_barangProperty() {
        return nama_barang;
    }

    public IntegerProperty jumlahProperty() {
        return jumlah;
    }

    public IntegerProperty total_hargaProperty() {
        return total_harga;
    }
}