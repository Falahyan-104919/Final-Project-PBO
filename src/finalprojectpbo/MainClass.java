package finalprojectpbo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Stage formCust = new Stage();
        formCust.setTitle("Daftar");
        Scene Customer = new Scene(form,768,500);
        formCust.setScene(Customer);
        formCust.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}