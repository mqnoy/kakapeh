/*
 * aplikasi ini 
 */

package applaporan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *
 * @author qnoy
 */
public class Library {
     //untuk file aplikasi-config.ini
    private static PropertiesConfiguration configuration = new PropertiesConfiguration();
    private static Properties properti = new Properties();
    private static FileInputStream file_inputStream;
    
//        
    
    public static String strTo_MD5(String var_text) {
        return DigestUtils.md5Hex(var_text);
    }
    /**
    *  method untuk parsing jdatechoser  untuk date di sql
     * @param raw_date
     * @param raw_format
     * @return 
    */
    public static String parsing_Jdate(Date raw_date,String raw_format){
        DateFormat sdf = new SimpleDateFormat(raw_format);
        return sdf.format(raw_date);
    }
    /**/
    /*
    * fungsi untuk generate kode untuk barang keluar masuk 
    * @param type (ODR,DTL) 1,2
    * @param tanggal 
    * @param outletId  = outlet id
    */
    public String generateCodeOrder(int type, int outletId, String tgl){
        String _Prefix = "" ;
        StringBuilder buffer = new StringBuilder();

        if (type == 1) {
            _Prefix = "ODR";//untuk barang masuk outlet ,atau outlet merequest barang ke pusat
        } else if (type == 2) {
            _Prefix = "DTL";//kode detail unntuk apa saja yang di request oleh outlet
        }
        //2019-04-15
        String[] arrOfStr = tgl.split(" ", -2);
        String final_date = arrOfStr[0].replace("-", "");

        buffer.append(_Prefix);
        buffer.append(outletId);
        buffer.append(final_date);       

        
        String codeOrder = buffer.toString();
        System.out.println(codeOrder);
        return codeOrder;
    }
    
    public static void main(String []args){
        Library lib = new Library();
        lib.generateCodeOrder(1,1,"2020-02-28");
    }
    
    
    //get full path 
    public static String get_fullPath(String raw_location){
        // works on *nix
        // works on Windows
        String fullPath = "";
        String dir_report = Paths.get(raw_location).toAbsolutePath().toString();

        boolean directoryExists = new java.io.File(dir_report).exists();
        System.out.println(directoryExists);

        if(directoryExists){
            fullPath = dir_report;
        }else{
            JOptionPane.showMessageDialog(null, "directory is not exists\n" +dir_report);
        }
        return fullPath;
    }
    /*end */
       
    /**
    * mengambil value dari parameter
    * @param getParams
    * @return String
     */
    public static String get_config(String getParams){
        return configuration.getString(getParams); 
    }
    /**
     * load file aplikasi_config.ini
     * mengambil value dari parameter yang ada di dalam file *.ini
     *
     */
    public static void loadConfig() {
        try {
            String dir_iniFile = get_fullPath("config/aplikasi_config.ini");
            //boolean directoryExists = new java.io.File(dir_iniFile).exists();
                FileInputStream file = new FileInputStream(dir_iniFile);
                configuration.load(file);
        } catch (ConfigurationException  | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Tidak ada file .ini !\n"+ex);
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
