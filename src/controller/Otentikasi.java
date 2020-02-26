/*
 * aplikasi ini 
 */

package controller;

import databases.CrudModel;
import java.util.HashMap;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author qnoy
 */
public class Otentikasi  {
    FrameController frame = new FrameController();
    CrudModel model = new CrudModel();
    
    private String o_nik;
    private String o_pass;
    public String hakakses = null;// staff dan manager
    public static boolean grant = false;
    
    public static String strTo_MD5(String var_text) {
        return DigestUtils.md5Hex(var_text);
    }
    
    public void logout(){
        grant = false;
        this.hakakses  = null;
        frame.showLoginApp();
    }
    public void login(){
        //untuk otentikasi ke database
        HashMap dataLogin = model.loginModel(this.o_nik, this.o_pass);
        if(!dataLogin.isEmpty()){
            
            if (dataLogin.get("jabatan").equals("staff")) {
                this.hakakses = "staff";
            }else if(dataLogin.get("jabatan").equals("manager")){
                this.hakakses = "manager";
            }
            
            this.setGrant(true);
            System.out.println("Otentikasi =>"+ dataLogin);

        }else{
            this.setGrant(false);
            System.out.println("Otentikasi =>"+ this.grant);
        }
    }
    public void setNik(String nik){
        this.o_nik = nik;
    }
    public void setPass(String pass){
        String md5pass = this.strTo_MD5(pass);
        this.o_pass = md5pass;
    }
    
    // hakakses = jabatan
    public String getHakakses(){
        return this.hakakses;
    }
    public void setGrant(boolean val){
        this.grant = val;
    }
    public static boolean getGrant(){
        return grant;
    }
    
    
    
    
    
}
