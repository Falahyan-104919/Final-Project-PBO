package finalprojectpbo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Falahyan
 */
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
    private TextField noInvoiceOrder;

    @FXML
    private TextField nameCustInvoiceOrder;
    
     @FXML
    private TextField InvoiceTotalPrice;

    @FXML
    private TextField InvoicePay;

    @FXML
    private Button InvoiceButtonPay;

    @FXML
    private TextField InvoiceChange;

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
    private Label hallo;

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
    void handleButtonGoMenu(ActionEvent event) {
        try {
            dm.tambahInvoice(new Invoice(dm.nextInvoiceID(), "NULL", namaCust.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    @FXML
    void handleButtonMakeOrder(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    } 

    @FXML
    void handleButtonResetList(ActionEvent event) {
    }

    @FXML
    void handleReloadButtonList(ActionEvent event) {
        
    }
    
    @FXML
    void handleButtonInvoiceExit(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void handleButtonInvoicePay(ActionEvent event) {

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
        menuOrderListColPrice.setCellValueFactory(new PropertyValueFactory<>("harga"));
        menuOrderList.setItems(null);
        menuOrderList.setItems(list_order);
    }
}
