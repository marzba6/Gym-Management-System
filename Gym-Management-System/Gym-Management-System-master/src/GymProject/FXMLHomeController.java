package GymProject;

import ControlDatabase.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FXMLHomeController implements Initializable {
   Pane veiw;
   @FXML
   Pane viewPane;  
   @FXML
   Label setting;
   @FXML
   Label LCoaches;
   public void addPane1(){
   viewPane.getChildren().add(getPane("FXMLCoatches.fxml"));
   }
      public void addPane2(){
   viewPane.getChildren().add(getPane("FXMLRegister.fxml"));
   }
      public void addPane3(){
   viewPane.getChildren().add(getPane("FXMLTrainerData.fxml"));
   }
      public void addPane4(){
   viewPane.getChildren().add(getPane("FXMLUsers.fxml"));
   }
      public Pane getPane(String FXMLname){
       try {
           veiw = FXMLLoader.load(getClass().getResource(FXMLname));
       } catch (IOException ex) {
           Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
       }
    return veiw;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
           if(!(new DataBase().getType().equals("admin")));
           {
             LCoaches.setDisable(true);
             setting.setDisable(true);
           }
       } catch (SQLException ex) {
           Logger.getLogger(FXMLHomeController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }    
    
}