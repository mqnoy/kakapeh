/*
 * aplikasi ini 
 */

package applaporan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author qnoy
 */
public class Library {
    
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
}
