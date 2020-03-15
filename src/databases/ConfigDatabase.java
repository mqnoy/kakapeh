/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import applaporan.Library;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class ConfigDatabase {

    static String host;
    static String username;
    static String password;
    static String driver;
    static String database;
    static Integer port;
    static String urldb;
    protected static Connection koneksi;

    ConfigDatabase() {
        setConf();
        connect();
    }

    protected Connection getConn() {
        return koneksi;
    }

    protected static void setConf() {
        Library.loadConfig();

        ConfigDatabase.host = Library.get_config("db_host");
        ConfigDatabase.username = Library.get_config("db_username");
        ConfigDatabase.password = Library.get_config("db_password");
        ConfigDatabase.driver = "mysql";
        ConfigDatabase.database = Library.get_config("db_name");
        ConfigDatabase.port = 3306;
        String rawurldb = "jdbc:" + ConfigDatabase.driver + "://" + ConfigDatabase.host + ":" + ConfigDatabase.port + "/" + ConfigDatabase.database;
        ConfigDatabase.urldb = rawurldb.trim();
    }

    protected static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfigDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "driver not found\n" + ex);
        }

        try {
            koneksi = DriverManager.getConnection(urldb, username, password);
            System.out.println("Berhasil Koneksi Database");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Koneksi Database\n" + ex);
        }
        return koneksi;
    }
}
