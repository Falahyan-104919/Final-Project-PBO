package finalprojectpbo;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Invoice {
    private IntegerProperty id;
    private StringProperty customer, waktu;
    private ArrayList <Barang> items = new ArrayList<>();
    private ArrayList <Integer> jumlah = new ArrayList<>();
    
    public Invoice(int id, String waktu, String customer, ArrayList <Barang> items, ArrayList <Integer> jumlah) {
        this.id = new SimpleIntegerProperty(id);
        this.waktu = new SimpleStringProperty(waktu);
        this.customer = new SimpleStringProperty(customer);
        this.items = items;
        this.jumlah = jumlah;
    }
    
    public Invoice(int id, String waktu, String customer){
        this.id = new SimpleIntegerProperty(id);
        this.waktu = new SimpleStringProperty(waktu);
        this.customer = new SimpleStringProperty(customer);
    }
    
    public Invoice(int id, String customer){
        this.id = new SimpleIntegerProperty(id);
        this.customer = new SimpleStringProperty(customer);
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getCustomer() {
        return customer.get();
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public String getWaktu() {
        return waktu.get();
    }

    public void setWaktu(String waktu) {
        this.waktu.set(waktu);
    }

    public ArrayList <Barang> getItems() {
        return items;
    }

    public void setItems(ArrayList <Barang> items) {
        this.items = items;
    }

    public ArrayList <Integer> getJumlah() {
        return jumlah;
    }

    public void setJumlah(ArrayList <Integer> jumlah) {
        this.jumlah = jumlah;
    }
    
    public int Jumlah_item() {
        return items.size();
    }
    
    public int Total_beli() {
        int total_beli = 0;
        for(int i = 0; i < Jumlah_item(); i++){
            total_beli += items.get(i).getHarga() * jumlah.get(i);
        }
        return total_beli;
    }

}
