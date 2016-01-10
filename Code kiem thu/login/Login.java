package login;
import Connection.Connect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author monkey
 */
public class Login {
    Connect conn;
    public Login() throws SQLException {
        conn = new Connect();
    }
    public boolean isUsername(String user){
        Statement st ;
        String user1;
        boolean kq = false;
        try {
            st = conn.getConn().createStatement();
            st.executeQuery("Select username from quanlythuvien where username = '"+ user + "'");
            ResultSet rs = st.getResultSet();
            user1 = rs.getString(1);
            if (user1.equals("")) kq=true;
            else kq=false;
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public boolean isPassword(String pass){
        Statement st;
        String pass1;
        boolean kq = false;
        try {
            st = conn.getConn().createStatement();
            st.executeQuery("Select distinct password from quanlythuvien where password = '"+ pass + "'");
            ResultSet rs = st.getResultSet();
            pass1 = rs.getString(1);
            if (pass1.equals("")) kq = true;
            else kq = false;
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    public boolean CheckLog(String user, String pass){
        if (isUsername(user) && isPassword(pass)) return true;
        else return false;
    }
}
