package com.samsundot.invoice.utils;

public class WDWUtil {
	 //是否是2003版本的excel  
    public static boolean isExcel2003(String filePath)  {    
         return filePath.matches("^.+\\.(?i)(xls)$");    
     }    
     
    //是否是2007版本的excel   
    public static boolean isExcel2007(String filePath)  {    
         return filePath.matches("^.+\\.(?i)(xlsx)$");    
     }    

}
