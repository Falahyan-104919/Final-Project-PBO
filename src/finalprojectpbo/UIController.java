package finalprojectpbo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UIController implements Initializable {
    
    @FXML
    private TextField namaCust;

    @FXML
    private Button goMenu;
    
    @FXML
    private TextField menuQtyM1;

    @FXML
    private Button menuAddM1;

    @FXML
    private TextField menuQtyM2;

    @FXML
    private Button menuAddM2;

    @FXML
    private TextField menuQtyM3;

    @FXML
    private Button menuAddM3;

    @FXML
    private TextField menuQtyM4;

    @FXML
    private Button menuAddM4;

    @FXML
    private TextField menuQtyM5;

    @FXML
    private Button menuAddM5;

    @FXML
    private TextField menuQtyP1;

    @FXML
    private Button menuAddP1;

    @FXML
    private TextField menuQtyP2;

    @FXML
    private Button menuAddP2;

    @FXML
    private TextField menuQtyP3;

    @FXML
    private Button menuAddP3;

    @FXML
    private TextField menuQtyP4;

    @FXML
    private Button menuAddP4;

    @FXML
    private TextField menuQtyP5;

    @FXML
    private Button menuAddP5;

    @FXML
    private TextField menuQtyL1;

    @FXML
    private Button menuAddL1;

    @FXML
    private TextField menuQtyL2;

    @FXML
    private Button menuAddL2;

    @FXML
    private TextField menuQtyL3;

    @FXML
    private Button menutAddL3;

    @FXML
    private TextField menuQtyL4;

    @FXML
    private Button menuAddL4;

    @FXML
    private TextField menuQtyL5;

    @FXML
    private Button menuAddL5;
    
    @FXML
    private Label noInvoiceOrder;

    @FXML
    private Label nameCustInvoiceOrder;
    
     @FXML
    private Label InvoiceTotalPrice;

    @FXML
    private TextField InvoicePay;

    @FXML
    private Button InvoiceButtonPay;

    @FXML
    private Label InvoiceChange;

    @FXML
    private Button InvoiceButtonExit;

    @FXML
    private TableView<ListOrder> menuOrderList;

    @FXML
    private TableColumn<ListOrder, String> menuOrderListColItem;

    @FXML
    private TableColumn<ListOrder, Integer> menuOrderListColPrice;

    @FXML
    private TableColumn<ListOrder, Integer> menuOrderListColQty;
    
    @FXML
    private TableView<ListOrder> InvoiceTableOrder;

    @FXML
    private TableColumn<ListOrder, String> InvoiceTableOrderColItem;

    @FXML
    private TableColumn<ListOrder, Integer> InvoiceTableOrderColPrice;

    @FXML
    private TableColumn<ListOrder, Integer> InvoiceTableOrderColQty;

    @FXML
    private Button menuMakeOrder;

    @FXML
    private Button menuResetList;

    @FXML
    private Button menuReloadButtonList;
    
    @FXML
    private Label hello;
    
    @FXML
    private Label displayWaktu;
    
    @FXML
    private TextField totalOrder;

    private DataModel dm;
    private Invoice inv;
    
    @FXML
    void handleButtonAddL1(ActionEvent event) throws SQLException {
        int qty = Integer.parseInt(menuQtyL1.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1211000, qty);
            update();
            menuQtyL1.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL2(ActionEvent event) throws SQLException {
        int qty = Integer.parseInt(menuQtyL2.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1211001, qty);
            update();
            menuQtyL2.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL3(ActionEvent event) {
         int qty = Integer.parseInt(menuQtyL3.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1211002, qty);
            update();
            menuQtyL3.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL4(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyL4.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1211003, qty);
            update();
            menuQtyL4.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL5(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyL5.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1211004, qty);
            update();
            menuQtyL5.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM1(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyM1.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1212000, qty);
            update();
            menuQtyM1.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM2(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyM2.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1212001, qty);
            update();
            menuQtyM2.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM3(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyM3.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1212002, qty);
            update();
            menuQtyM3.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM4(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyM4.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1212003, qty);
            update();
            menuQtyM4.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM5(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyM5.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1212004, qty);
            update();
            menuQtyM5.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP1(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyP1.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1213000, qty);
            update();
            menuQtyP1.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void handleButtonP2(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyP2.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1213001, qty);
            update();
            menuQtyP2.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void handleButtonAddP3(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyP3.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1213002, qty);
            update();
            menuQtyP3.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP4(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyP4.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1213003, qty);
            update();
            menuQtyP4.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP5(ActionEvent event) {
        int qty = Integer.parseInt(menuQtyP5.getText());
        try {
            dm.tambahItem(dm.nextInvoiceID()-1, 1213004, qty);
            update();
            menuQtyP5.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonGoMenu(ActionEvent event) throws IOException {
        try {
            dm.tambahInvoice(new Invoice(dm.nextInvoiceID(), "NULL", namaCust.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuOrder.fxml"));
        Parent root =  loader.load();
        Scene menu = new Scene(root,1366,768);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setMaximized(true);
        window.setTitle("HIMAKOM Electronic City");
        window.setScene(menu);
        window.show();
        UIController scene_controller = loader.getController();
        scene_controller.sayHello(namaCust.getText());
    }
    
    @FXML
    void handleButtonMakeOrder(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvOrder.fxml"));
        Parent invoice = loader.load();
        Scene Invoice = new Scene(invoice,768,489);
        Stage InvoiceOrder = (Stage)((Node)event.getSource()).getScene().getWindow();
        InvoiceOrder.setTitle("Invoice");
        InvoiceOrder.setScene(Invoice);
        InvoiceOrder.show();
        UIController scene_controller = loader.getController();
        scene_controller.showInvoice();
    } 

    @FXML
    void handleButtonResetList(ActionEvent event) throws SQLException {
        dm.resetItems(dm.nextInvoiceID()-1);
        update();
    }
    
    @FXML
    void handleButtonInvoiceExit(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void handleButtonInvoicePay(ActionEvent event) throws IOException, SQLException {
        InvoiceChange.setText(Integer.toString(Integer.parseInt(InvoicePay.getText())-(dm.getTotalOrder(dm.nextInvoiceID()-1))));
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dm = new DataModel("MYSQL");
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update() throws SQLException{
        ObservableList<ListOrder> list_order = dm.getListOrder(dm.nextInvoiceID()-1);
        menuOrderListColItem.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        menuOrderListColQty.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        menuOrderListColPrice.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        menuOrderList.setItems(null);
        menuOrderList.setItems(list_order);
        totalOrder.setText(Integer.toString(dm.getTotalOrder(dm.nextInvoiceID()-1)));
    }
    
    void sayHello(String nama){
        hello.setText("Halo, " + nama + ".");
    }
    
    void showInvoice() throws SQLException{
        displayWaktu.setText(waktu());
        noInvoiceOrder.setText(Integer.toString(dm.nextInvoiceID()-1));
        nameCustInvoiceOrder.setText(dm.getNamaInvoice(dm.nextInvoiceID()-1));
        ObservableList<ListOrder> list_order = dm.getListOrder(dm.nextInvoiceID()-1);
        InvoiceTableOrderColItem.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
        InvoiceTableOrderColQty.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        InvoiceTableOrderColPrice.setCellValueFactory(new PropertyValueFactory<>("total_harga"));
        InvoiceTableOrder.setItems(null);
        InvoiceTableOrder.setItems(list_order);
        InvoiceTotalPrice.setText(Integer.toString(dm.getTotalOrder(dm.nextInvoiceID()-1)));
    }
    
    static String waktu(){
        LocalDateTime waktu = LocalDateTime.now();
        String waktu_terformat = waktu.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
        return waktu_terformat;
    }
}

