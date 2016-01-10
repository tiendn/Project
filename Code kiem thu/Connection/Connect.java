/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 
 */
public class Connect {
    Connection conn;
    public Connect(){
        connectMySql();
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    private void connectMySql(){
       conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quanlythuvien", "root", "123winers");
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            System.out.println("kết nối không thành công");
            System.exit(0);
        }
    }
}
