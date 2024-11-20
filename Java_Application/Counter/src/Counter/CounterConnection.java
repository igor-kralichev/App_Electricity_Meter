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
public class CounterConnection extends AbstractTableModel {
    
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "№ счётчика","№ sim","Адрес","Показания (кВт*ч)"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel */
    public CounterConnection(ResultSet rs) {
      
      ResultSets=new ArrayList<String[]>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                 rs.getString("id"),rs.getString("sim"),rs.getString("address"),rs.getString("ind")
          
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
