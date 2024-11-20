/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counter;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author PC_Home
 */
public class UserConnection extends AbstractTableModel {
    
    private int colnum=3;
    private int rownum;
    private String[] colNames={
        "Номер пользователя","Логин","Роль"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public UserConnection(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                 rs.getString("iduser"),rs.getString("login"),rs.getString("role")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in userConnection ");
            }
        
    }
   
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {

       return colNames[param];
    }
    
}
