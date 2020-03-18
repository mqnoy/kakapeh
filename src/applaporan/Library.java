/*
 * aplikasi ini 
 */
package applaporan;

import static databases.CrudModel.conn;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
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
     * method untuk parsing jdatechoser untuk date di sql
     *
     * @param raw_date
     * @param raw_format
     * @return
     */
    public static String parsing_Jdate(Date raw_date, String raw_format) {
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

    public String generateCodeOrder(int type, int outletId, String tgl) {
        String _Prefix = "";
        StringBuilder buffer = new StringBuilder();

        if (type == 1) {
            _Prefix = "ODR";//untuk barang masuk outlet ,atau outlet merequest barang ke pusat
        } else if (type == 2) {
            _Prefix = "DTL";//kode detail unntuk apa saja yang di request oleh outlet
        } else if (type == 3) {//detail pengeluaran
            _Prefix = "EXT";
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

    public static void main(String[] args) {
        Library lib = new Library();
//        lib.generateCodeOrder(1,1,"2020-02-28");
        lib.getReport("2020-03-18","2020-03-18","omsetkotor");
    }

    //get full path 
    public static String get_fullPath(String raw_location) {
        // works on *nix
        // works on Windows
        String fullPath = "";
        String dir_report = Paths.get(raw_location).toAbsolutePath().toString();

        boolean directoryExists = new java.io.File(dir_report).exists();
        System.out.println(directoryExists);

        if (directoryExists) {
            fullPath = dir_report;
        } else {
            JOptionPane.showMessageDialog(null, "tidak ditemukan\n" + dir_report,"get_fullPath",2);
        }
        return fullPath;
    }
    /*end */

    /**
     * mengambil value dari parameter
     *
     * @param getParams
     * @return String
     */
    public static String get_config(String getParams) {
        return configuration.getString(getParams);
    }

    /**
     * load file aplikasi_config.ini mengambil value dari parameter yang ada di
     * dalam file *.ini
     *
     */
    public static void loadConfig() {
        try {
            String dir_iniFile = get_fullPath("config/aplikasi_config.ini");
            //boolean directoryExists = new java.io.File(dir_iniFile).exists();
            FileInputStream file = new FileInputStream(dir_iniFile);
            configuration.load(file);
        } catch (ConfigurationException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Tidak ada file .ini !\n" + ex);
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     *
     * untuk reporting
     
     */

    public static void getReport(String tglawal,String tglakhir,String report) {
        String templateReport = null;

        switch (report) {
            case "omsetkotor":
                templateReport = "report_omset_kotor";
                break;
            case "omsetbersih":
                templateReport = "report_omset_bersih";
                break;
            case "uangstoran":
                templateReport = "report_uang_setoran";
                break;
        }
        Map JasperParams = new HashMap();

//        Date tanggalAwal_rpt = rpt_tanggal_awal.getDate();
//            Date tanggalAkhir_rpt = rpt_tanggal_akhir.getDate();
//            String final_tanggalAwal_rpt = Library.parsing_Jdate(tanggalAwal_rpt, "dd-MM-yyyy");
//            String final_tanggalAkhir_rpt = Library.parsing_Jdate(tanggalAkhir_rpt, "dd-MM-yyyy");
        String final_tanggalAwal_rpt = "2020-03-18";
        String final_tanggalAkhir_rpt = "2020-03-18";
        JasperParams.put("PARAM_NM_OUTLET", "NAMA OUTLET");
        JasperParams.put("PARAM_OUTLET_INFO", "jl.yang tidak rusak");
        JasperParams.put("PARAM_PERIOD_BEGIN", tglawal);
        JasperParams.put("PARAM_PERIOD_END", tglakhir);
        String reportPath = Library.get_fullPath("src/reporting/" + templateReport + ".jrxml");
        try {
            JasperDesign jd = JRXmlLoader.load(reportPath);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, JasperParams, conn);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex, "getReport", 2);
        }
    }
}
