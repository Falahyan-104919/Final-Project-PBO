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
    private TableView<Invoice> menuOrderList;

    @FXML
    private TableColumn<Invoice, String> menuOrderListColItem;

    @FXML
    private TableColumn<Invoice, Integer> menuOrderListColPrice;

    @FXML
    private TableColumn<Invoice, Integer> menuOrderListColQty;
    
    @FXML
    private TableView<Invoice> InvoiceTableOrder;

    @FXML
    private TableColumn<Invoice, String> InvoiceTableOrderColItem;

    @FXML
    private TableColumn<Invoice, Integer> InvoiceTableOrderColPrice;

    @FXML
    private TableColumn<Invoice, Integer> InvoiceTableOrderColQty;


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
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL2(ActionEvent event) throws SQLException {
         menuQtyL2.getText();
         Laptop L2 = new Laptop(dm.nextLaptopID(),
                "MSI WP565 ",
                "MSI",
                Integer.parseInt("Rp. 73.999.000"),
                "Intel Core i9-8950HK",
                "NVIDIA® RTX2080 8GB GDDR6",
                Integer.parseInt("64GB"),
                Integer.parseInt("2TB"));
        try {
            dm.tambahBarang(L2);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL3(ActionEvent event) {
         menuQtyL3.getText();
         Laptop L3 = new Laptop(10003,
                "Asus ROG Chimera G703GI",
                "Asus",
                Integer.parseInt("Rp. 69.999.000"),
                "Intel Core i9-8950HK",
                "NVIDIA® RTX2080 8GB GDDR6",
                Integer.parseInt("64GB"),
                Integer.parseInt("2TB"));
        try {
            dm.tambahBarang(L3);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL4(ActionEvent event) {
        menuQtyL4.getText(); 
        Laptop L4 = new Laptop(10004,
                "Acer Predator Helios PH717",
                "Acer",
                Integer.parseInt("Rp. 67.999.000"),
                "Intel Core i9-8950HK",
                "NVIDIA® RTX2080 8GB GDDR6",
                Integer.parseInt("64GB"),
                Integer.parseInt("2TB"));
        try {
            dm.tambahBarang(L4);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddL5(ActionEvent event) {
        menuQtyL5.getText(); 
        Laptop L5 = new Laptop(10005,
                "Alienware 17-R4",
                "Asus",
                Integer.parseInt("Rp. 34.999.000"),
                "Intel Core i9-8950HK",
                "NVIDIA® RTX2080 8GB GDDR6",
                Integer.parseInt("64GB"),
                Integer.parseInt("2TB"));
        try {
            dm.tambahBarang(L5);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM1(ActionEvent event) {
        menuQtyM1.getText(); 
        Monitor M1 = new Monitor(
                20001,
                "Benq Zowie XL2740",
                "Benq",
                Integer.parseInt("Rp. 9.385.000"),
                Integer.parseInt("27 inch" ),
                "Full HD (1920x1080)",
                Integer.parseInt("240Hz"),
                "TN");
        try {
            dm.tambahBarang(M1);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM2(ActionEvent event) {
        menuQtyM2.getText(); 
        Monitor M2 = new Monitor(
                20002,
                "AOC AGON AG271QX",
                "AOC",
                Integer.parseInt("Rp. 7.599.000"),
                Integer.parseInt("27 inch" ),
                "Full HD (2560x1440)",
                Integer.parseInt("144Hz"),
                "TN");
        try {
            dm.tambahBarang(M2);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM3(ActionEvent event) {
        menuQtyM3.getText(); 
        Monitor M3 = new Monitor(
                20003,
                "Acer Predator XB241H",
                "Acer",
                Integer.parseInt("Rp. 7.370.000"),
                Integer.parseInt("27 inch" ),
                "Full HD (1920x1080)",
                Integer.parseInt("144Hz"),
                "TN Film");
        try {
            dm.tambahBarang(M3);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM4(ActionEvent event) {
        menuQtyM4.getText(); 
        Monitor M4 = new Monitor(
                20004,
                "Dell S2417DG",
                "Benq",
                Integer.parseInt("Rp. 7.000.000"),
                Integer.parseInt("24 inch" ),
                "Full HD (2560x1440)",
                Integer.parseInt("160Hz"),
                "TN");
        try {
            dm.tambahBarang(M4);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddM5(ActionEvent event) {
        menuQtyM5.getText(); 
        Monitor M5 = new Monitor(
                20005,
                "MSI Optix MAG24C",
                "Benq",
                Integer.parseInt("Rp. 4.850.000"),
                Integer.parseInt("23.6 inch" ),
                "Full HD (1920 x 1080)",
                Integer.parseInt("144Hz"),
                "VA");
        try {
            dm.tambahBarang(M5);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP1(ActionEvent event) {
        menuQtyP1.getText(); 
        Printer P1 = new Printer(30001,
                    "Epson L310",
                    "Epson",
                     Integer.parseInt("Rp. 1.730.000"),
                    "Printer Inkjet",
                    Integer.parseInt("Black/White 33 ppm & Color 15 ppm"),
                    Boolean.FALSE);
        try {
            dm.tambahBarang(P1);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void handleButtonP2(ActionEvent event) {
        menuQtyP2.getText(); 
        Printer P2 = new Printer(30002,
                    "Canon Pixma MG2570",
                    "Canon",
                     Integer.parseInt("Rp. 675.000"),
                    "Printer Inkjet",
                    Integer.parseInt("Black/White 8.0 ipm & Color 4.0 ipm"),
                    Boolean.TRUE);
        try {
            dm.tambahBarang(P2);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void handleButtonAddP3(ActionEvent event) {
        menuQtyP3.getText(); 
        Printer P3 = new Printer(30003,
                    "HP DeskJet 1010",
                    "HP",
                     Integer.parseInt("Rp. 415.000"),
                    "Printer Inkjet",
                    Integer.parseInt("Black/White 7 ppm & Color 4 ppm"),
                    Boolean.TRUE);
        try {
            dm.tambahBarang(P3);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP4(ActionEvent event) {
        menuQtyP4.getText(); 
        Printer P4 = new Printer(30004,
                    "HP LaserJet Pro M15A",
                    "HP",
                     Integer.parseInt("Rp. 1.245.000"),
                    "Laser Monochrome Printer",
                    Integer.parseInt("Black/White & Color 20ppm"),
                    Boolean.FALSE);
        try {
            dm.tambahBarang(P4);
        } catch (SQLException ex) {
            Logger.getLogger(UIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonAddP5(ActionEvent event) {
        menuQtyP5.getText(); 
        Printer P5 = new Printer(30005,
                    "Canon imageClass LBP6030w",
                    "Canon",
                     Integer.parseInt("Rp. 1.479.000"),
                    "Laser Monochrome Printer",
                    Integer.parseInt("Black/White 19 ppm & Color 18 ppm"),
                    Boolean.FALSE);
        try {
            dm.tambahBarang(P5);
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
        ArrayList<Integer> list_id =  dm.getListIDBarang(dm.nextInvoiceID()-1);
        ObservableList<IntegerProperty> list_jumlah =  dm.getListJmlBarang(dm.nextInvoiceID()-1);
        
//        ObservableList<Barang> list_barnag = dm.getIndividualHolders();
//        colHolderID.setCellValueFactory(new PropertyValueFactory<>("holderID"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        colBirthdate.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
//        colNumAccounts.setCellValueFactory(new PropertyValueFactory<>("numAccounts"));
//        tblAccHolder.setItems(null);
//        tblAccHolder.setItems(data);
//        btnAddAccount.setDisable(true);
    }
}