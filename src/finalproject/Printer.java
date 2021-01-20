package finalproject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Printer extends Barang {
    private StringProperty jenis_printer;
    private BooleanProperty scan;
    private IntegerProperty print_rate;

    public Printer(int id, String nama_barang, String brand, int harga, String jenis_printer, int print_rate, boolean scan) {
        super(id, nama_barang, brand, harga);
        this.jenis_printer = new SimpleStringProperty(jenis_printer);
        this.print_rate = new SimpleIntegerProperty(print_rate);
        this.scan = new SimpleBooleanProperty(scan);
    }

    public String getJenis_printer() {
        return jenis_printer.get();
    }

    public void setJenis_printer(String jenis_printer) {
        this.jenis_printer.set(jenis_printer);
    }

    public int getPrint_rate() {
        return print_rate.get();
    }

    public void setPrint_rate(int print_rate) {
        this.print_rate.set(print_rate);
    }
    
    public boolean getScan() {
        return scan.get();
    }

    public void setScan(boolean scan) {
        this.scan.set(scan);
    }
    
    public String shortSpec(){
        String spec = "";
        spec += getJenis_printer() + ", ";
        spec += getPrint_rate() + " PPM";
        if(getScan()){spec += ", Scanner";}
        return spec;
    }
}
