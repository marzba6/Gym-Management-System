package ControlDatabase;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
public class DataBase {
    private Statement stat;
    ConDataBase con=new ConDataBase();
    private String admin;
    
    public boolean Login(String username, String pass1) throws IOException, SQLException {
        con.open();
        stat=con.open().createStatement();
        String sc = "select * from usertable where " + "UserName='" + username + "' and " + "Password='" + pass1 + "'";
        ResultSet res = stat.executeQuery(sc);
        if(res.next()) {
            con.close();
            return true;
        }else{
            con.close();
            return false;
        }
    }
    public String getType() throws SQLException{
        con.open();
        stat=con.open().createStatement();
        String sc = "select * from usertable";
        ResultSet res = stat.executeQuery(sc);
        if(res.next()) {
           
            String s = res.getString(5);
            System.out.println(s);
            con.close();
            return s;
        }else{
            con.close();
           return null;
        }
     
    }
    public Integer getAutoNumber(String tableName,String colName){
   
        try {
            String sql="select max("+colName+")+1 as autonumber"+
                    " from "+tableName;
            con.open();
            stat=con.open().createStatement();
            stat.executeQuery(sql);
            Integer num = 0;
            while (stat.getResultSet().next()){
                num=stat.getResultSet().getInt("autonumber");
            
            }
            con.close();
            if(num>0)
            {
                return num;
            }
            else{
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
        }
    }
    public ResultSet fillTable(String tableName) throws SQLException {
        con.open();
        stat=con.open().createStatement();
        String sc = "select * from " + tableName;
        ResultSet res = stat.executeQuery(sc);
        return res;
    }
       public ResultSet fillSomeCTable(String tableName,String tableColumn) throws SQLException {
        con.open();
        stat=con.open().createStatement();
        String sc = "select * from " + tableName+" where "+tableColumn;
        ResultSet res = stat.executeQuery(sc);
        return res;
    }
}
