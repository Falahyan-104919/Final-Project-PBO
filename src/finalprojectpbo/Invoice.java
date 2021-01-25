package finalprojectpbo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Invoice {
    private IntegerProperty id;
    private StringProperty customer, waktu;
    
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

}
