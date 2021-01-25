package finalprojectpbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModel {
    public  Connection conn;

    public DataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    public void tambahBarang(Laptop barang) throws SQLException{
        String insertBarang = "INSERT INTO barang (id, nama_barang, brand, harga) VALUES (?, ?, ?, ?)";
        String insertLaptop = "INSERT INTO laptop (id, cpu, gpu, ram, storage) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmtBarang = conn.prepareStatement(insertBarang);
        stmtBarang.setInt(1, barang.getId());
        stmtBarang.setString(2, barang.getNama_barang());
        stmtBarang.setString(3, barang.getBrand());
        stmtBarang.setInt(4, barang.getHarga());
        stmtBarang.execute();
        
        PreparedStatement stmtLaptop = conn.prepareStatement(insertLaptop);
        stmtLaptop.setInt(1, barang.getId());
        stmtLaptop.setString(2, barang.getCpu());
        stmtLaptop.setString(3, barang.getGpu());
        stmtLaptop.setInt(4, barang.getRam());
        stmtLaptop.setInt(5, barang.getStorage());
        stmtLaptop.execute();
    }
    public void tambahBarang(Monitor barang) throws SQLException{
        String insertBarang = "INSERT INTO barang (id, nama_barang, brand, harga) VALUES (?, ?, ?, ?)";
        String insertMonitor = "INSERT INTO monitor (id, tipe_panel, resolusi, ukuran_layar, refresh_rate) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmtBarang = conn.prepareStatement(insertBarang);
        stmtBarang.setInt(1, barang.getId());
        stmtBarang.setString(2, barang.getNama_barang());
        stmtBarang.setString(3, barang.getBrand());
        stmtBarang.setInt(4, barang.getHarga());
        stmtBarang.execute();
        
        PreparedStatement stmtMonitor = conn.prepareStatement(insertMonitor);
        stmtMonitor.setInt(1, barang.getId());
        stmtMonitor.setString(2, barang.getTipe_panel());
        stmtMonitor.setString(3, barang.getResolusi());
        stmtMonitor.setInt(4, barang.getUkuran_layar());
        stmtMonitor.setInt(5, barang.getRefresh_rate());
        stmtMonitor.execute();
    }
    public void tambahBarang(Printer barang) throws SQLException{
        String insertBarang = "INSERT INTO barang (id, nama_barang, brand, harga) VALUES (?, ?, ?, ?)";
        String insertPrinter = "INSERT INTO printer (id, jenis_printer, print_rate, scan) VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmtBarang = conn.prepareStatement(insertBarang);
        stmtBarang.setInt(1, barang.getId());
        stmtBarang.setString(2, barang.getNama_barang());
        stmtBarang.setString(3, barang.getBrand());
        stmtBarang.setInt(4, barang.getHarga());
        stmtBarang.execute();
        
        PreparedStatement stmtPrinter = conn.prepareStatement(insertPrinter);
        stmtPrinter.setInt(1, barang.getId());
        stmtPrinter.setString(2, barang.getJenis_printer());
        stmtPrinter.setInt(3, barang.getPrint_rate());
        stmtPrinter.setBoolean(4, barang.getScan());
        stmtPrinter.execute();
    }
    public void tambahInvoice(Invoice invoice) throws SQLException{
        String insertInvoice = "INSERT INTO invoice (id, customer, waktu) VALUES (?, ?, ?)";
        
        PreparedStatement stmtInvoice = conn.prepareStatement(insertInvoice);
        stmtInvoice.setInt(1, invoice.getId());
        stmtInvoice.setString(2, invoice.getCustomer());
        stmtInvoice.setString(3, invoice.getWaktu());
        stmtInvoice.execute();
        
    }
    public void tambahItem(int id_invoice, int id_barang, int jumlah) throws SQLException{
        String insertItem = "INSERT INTO items (id_invoice, id_barang, jumlah) VALUES (?, ?, ?)";
        
        PreparedStatement stmtItem = conn.prepareStatement(insertItem);
        stmtItem.setInt(1, id_invoice);
        stmtItem.setInt(2, id_barang);
        stmtItem.setInt(3, jumlah);
        stmtItem.execute();
        
    }
    
    public ObservableList<ListOrder> getListOrder(int id_invoice) throws SQLException{
        ObservableList<ListOrder> data = FXCollections.observableArrayList();
        String sql1="SELECT id_barang, jumlah FROM items WHERE id_invoice="+id_invoice;
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        while (rs1.next()){
            String sql2 = "SELECT nama_barang, harga FROM barang WHERE id="+rs1.getInt(1);
            ResultSet rs2 = conn.createStatement().executeQuery(sql2);
            while(rs2.next()){
                data.add(new ListOrder(rs2.getString(1), rs2.getInt(2), rs1.getInt(2)));
            }
        }
        return data;
    }
    public StringProperty getNamaBarang(int id_barang) throws SQLException{
        String sql="SELECT nama_barang FROM `barang` WHERE id="+id_barang;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        StringProperty nama = new SimpleStringProperty(rs.getString(1));
        return nama;
    }
    public IntegerProperty getHargaBarang(int id_barang) throws SQLException{
        String sql="SELECT harga FROM `barang` WHERE id="+id_barang;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        IntegerProperty harga = new SimpleIntegerProperty(rs.getInt(1));
        return harga;
    }
    public int getTotalOrder(int id_invoice) throws SQLException{
        int total = 0;
        String sql1="SELECT id_barang, jumlah FROM items WHERE id_invoice="+id_invoice;
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        while (rs1.next()){
            String sql2 = "SELECT harga FROM barang WHERE id="+rs1.getInt(1);
            ResultSet rs2 = conn.createStatement().executeQuery(sql2);
            while(rs2.next()){
                total += rs1.getInt(2) * rs2.getInt(1);
            }
        }
        return total;
    }
    public String getNamaInvoice(int id_invoice) throws SQLException{
        String nama = ""; 
        String sql1="SELECT customer FROM invoice WHERE id="+id_invoice;
        ResultSet rs = conn.createStatement().executeQuery(sql1);
        while (rs.next()){
            nama = rs.getString(1);
        }
        return nama;
    }
    
    public void setWaktu(int id_invoice, String waktu) throws SQLException{
        String sql="UPDATE invoice SET waktu = \'"+waktu+"\' WHERE id="+id_invoice;
        conn.createStatement().executeUpdate(sql);
    }
 
    public void resetItems(int id_invoice) throws SQLException{
        String sql="DELETE FROM items WHERE id_invoice="+id_invoice;
        conn.createStatement().executeUpdate(sql);
    }

    public int nextLaptopID() throws SQLException{
        String sql="SELECT MAX(id) from laptop";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1) == 0 ? 1211000:rs.getInt(1)+1;
            }
        return 1211000;
    }
    public int nextMonitorID() throws SQLException{
        String sql="SELECT MAX(id) from monitor";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1) == 0 ? 1212000:rs.getInt(1)+1;
            }
        return 1212000;
    }
    public int nextPrinterID() throws SQLException{
        String sql="SELECT MAX(id) from printer";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1) == 0 ? 1213000:rs.getInt(1)+1;
            }
        return 1213000;
    }
    public int nextInvoiceID() throws SQLException{
        String sql="SELECT MAX(id) from invoice";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            return rs.getInt(1) == 0 ? 2210000:rs.getInt(1)+1;
        }
        return 2210000;
    }
}