package org.ntmast.commons.excel;

import java.sql.SQLException;
import java.util.List;
  
public class XxlsPrint extends XxlsAbstract {   
  
    @Override  
    public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException {   
//        System.out.println("curRow....="+curRow);
    	for (int i = 0; i < rowlist.size(); i++) { 
    		if(curRow==0){
    		//Excle的列头顺序
            System.out.print("'" + rowlist.get(i) + "',");
    		}else{
    			 System.out.print("'" + rowlist.get(i) + "',");
    		}
            
        }   
       System.out.println();   
    }   
  
    public static void main(String[] args) throws Exception {   
        XxlsPrint howto = new XxlsPrint(); 
        String paths = "G:\\201307.xlsx";
        howto.processOneSheet(paths,1);   
//      howto.processAllSheets("F:/new.xlsx");   
    }   
}  
