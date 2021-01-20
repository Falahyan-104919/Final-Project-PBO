package finalproject;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TextField menuQtyPrinter1;

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
    private Button menuAddPrinter5;

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
    private TableView<?> menuOrderList;

    @FXML
    private TableColumn<?, ?> menuOrderListColItem;

    @FXML
    private TableColumn<?, ?> menuOrderListColPrice;

    @FXML
    private TableColumn<?, ?> menuOrderListColQty;

    @FXML
    private Button menuMakeOrder;

    @FXML
    private Button menuResetList;

    @FXML
    private TextField noInvoiceOrder;

    @FXML
    private TextField nameCustInvoiceOrder;

    @FXML
    private TableView<?> InvoiceTableOrder;

    @FXML
    private TableColumn<?, ?> InvoiceTableOrderColItem;

    @FXML
    private TableColumn<?, ?> InvoiceTableOrderColPrice;

    @FXML
    private TableColumn<?, ?> InvoiceTableOrderColQty;

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
    
    private DataModel dm;
    
    @FXML
    void handleButtonGoMenu(ActionEvent event) {
//        try {
//            dm.addAccountHolder(holder);
//            lblSaveStatus.setText("Account berhasil dibuat");
//        } catch (SQLException ex) {
//            lblSaveStatus.setText("Account gagal dibuat");
//            Logger.getLogger(AccountHolderFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Invoice()
    }
    
    @FXML
    void handleButtonAddL1(ActionEvent event) {

    }

    @FXML
    void handleButtonAddL2(ActionEvent event) {

    }

    @FXML
    void handleButtonAddL3(ActionEvent event) {

    }

    @FXML
    void handleButtonAddL4(ActionEvent event) {

    }

    @FXML
    void handleButtonAddL5(ActionEvent event) {

    }

    @FXML
    void handleButtonAddM1(ActionEvent event) {

    }

    @FXML
    void handleButtonAddM2(ActionEvent event) {

    }

    @FXML
    void handleButtonAddM3(ActionEvent event) {

    }

    @FXML
    void handleButtonAddM4(ActionEvent event) {

    }

    @FXML
    void handleButtonAddM5(ActionEvent event) {

    }

    @FXML
    void handleButtonAddP1(ActionEvent event) {

    }

    @FXML
    void handleButtonAddP3(ActionEvent event) {

    }

    @FXML
    void handleButtonAddP4(ActionEvent event) {

    }

    @FXML
    void handleButtonAddP5(ActionEvent event) {

    }

    @FXML
    void handleButtonMakeOrder(ActionEvent event) {

    }

    @FXML
    void handleButtonP2(ActionEvent event) {

    }

    @FXML
    void handleButtonResetList(ActionEvent event) {

    }
    
    @FXML
    void handleButtonInvoiceExit(ActionEvent event) {

    }

    @FXML
    void handleButtonInvoicePay(ActionEvent event) {

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
