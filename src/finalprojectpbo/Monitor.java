package finalprojectpbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Monitor extends Barang{
    private StringProperty tipe_panel, resolusi;
    private IntegerProperty ukuran_layar, refresh_rate;

    public Monitor(int id, String nama_barang, String brand, int harga, int ukuran_layar, String resolusi, int refresh_rate, String tipe_panel) {
        super(id, nama_barang, brand, harga);
        this.ukuran_layar = new SimpleIntegerProperty(ukuran_layar);
        this.resolusi = new SimpleStringProperty(resolusi);
        this.refresh_rate = new SimpleIntegerProperty(refresh_rate);
        this.tipe_panel = new SimpleStringProperty(tipe_panel);
    }

    public String getTipe_panel() {
        return tipe_panel.get();
    }

    public void setTipe_panel(String tipe_panel) {
        this.tipe_panel.set(tipe_panel);
    }

    public String getResolusi() {
        return resolusi.get();
    }

    public void setResolusi(String resolusi) {
        this.resolusi.set(resolusi);
    }

    public int getUkuran_layar() {
        return ukuran_layar.get();
    }

    public void setUkuran_layar(int ukuran_layar) {
        this.ukuran_layar.set(ukuran_layar);
    }

    public int getRefresh_rate() {
        return refresh_rate.get();
    }

    public void setRefresh_rate(int refresh_rate) {
        this.refresh_rate.set(refresh_rate);
    }
    
    public String shortSpec(){
        String spec = "";
        spec += getUkuran_layar() + "\" ";
        spec += getTipe_panel() + ", ";
        spec += getResolusi() + ", ";
        spec += getRefresh_rate() + " Hz";
        return spec;
    }
}