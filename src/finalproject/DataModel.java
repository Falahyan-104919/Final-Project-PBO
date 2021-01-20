package finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModel {
    public final Connection conn;

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
    public void tambahItem(Invoice invoice, Barang barang, int jumlah) throws SQLException{
        String insertItem = "INSERT INTO items (id_invoice, id_barang, jumlah) VALUES (?, ?, ?)";
        
        PreparedStatement stmtItem = conn.prepareStatement(insertItem);
        stmtItem.setInt(1, invoice.getId());
        stmtItem.setInt(2, barang.getId());
        stmtItem.setInt(3, jumlah);
        stmtItem.execute();
        
    }
    
    public ObservableList<Integer> getListIDBarang(int id_invoice)throws SQLException{
        ObservableList<Integer> data = FXCollections.observableArrayList();
        String sql="SELECT id_barang FROM items WHERE id_invoice="+id_invoice;
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            data.add(rs.getInt(1));
        }
        return data;
    }
    public ObservableList<Integer> getListJmlBarang(int id_invoice)throws SQLException{
        ObservableList<Integer> data = FXCollections.observableArrayList();
        String sql="SELECT jumlah FROM items WHERE id_invoice="+id_invoice;
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
            data.add(rs.getInt(1));
        }
        return data;
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
//    public int nextAccountNumber(int holderID) throws SQLException{
//        String sql="SELECT MAX(acc_number) FROM account WHERE holder_id="+holderID;
//        ResultSet rs = conn.createStatement().executeQuery(sql);
//        while (rs.next()){
//                return rs.getInt(1)+1;
//            }
//        return 0;
//    }
//    
//    public void addAccount(int holderID, Account acc) throws SQLException{
//        String insertHolder = "INSERT INTO account (holder_id, acc_number, balance)"
//                + " VALUES (?,?,?)";
//  
//        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
//        stmtHolder.setInt(1, holderID);
//        stmtHolder.setInt(2, acc.getAccNumber());
//        stmtHolder.setDouble(3, acc.getBalance());
//        stmtHolder.execute();
//        
//    }
}
