/*
 * aplikasi ini 
 */

package controller;

import applaporan.Dashboard;
import applaporan.Form_login_aplikasi;

/**
 *
 * @author qnoy
 */
public class FrameController {
    
    
    //frame form login
    public void showLoginApp(){
        Form_login_aplikasi form_login = new Form_login_aplikasi();
        form_login.setVisible(true);
    }
    
    //frame dashboard
    public void showDashboard(){
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }
}
