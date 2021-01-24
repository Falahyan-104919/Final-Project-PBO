package finalprojectpbo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainClass extends Application{
    
    private Stage Main;
    
    @Override
    public void start(Stage Main) throws IOException {
        this.Main = Main;
        StartApp();
    }
    
    public void StartApp() throws IOException{
        
        Parent form = FXMLLoader.load(getClass().getResource("formCust.fxml"));
        Parent menu =  FXMLLoader.load(getClass().getResource("UIFXML.fxml"));
        Parent invoice = FXMLLoader.load(getClass().getResource("InvOrder.fxml"));
        
        Stage formCust = new Stage();
        formCust.setTitle("Daftar");
        Scene Customer = new Scene(form,768,500);
        formCust.setScene(Customer);
        formCust.showAndWait();
        
        Stage Menu = new Stage();
        Menu.setTitle("HIMAKOM Electronic City");
        Scene MenuOrder = new Scene (menu,1366,758);
        Menu.setScene(MenuOrder);
        Menu.initModality(Modality.APPLICATION_MODAL);
        Menu.initOwner(formCust);
        Menu.showAndWait();
        
        Stage InvoiceOrder = new Stage();
        InvoiceOrder.setTitle("Invoice");
        Scene Invoice = new Scene(invoice,768,489);
        InvoiceOrder.setScene(Invoice);
        InvoiceOrder.initModality(Modality.APPLICATION_MODAL);
        InvoiceOrder.initOwner(Menu);
        InvoiceOrder.showAndWait();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}