package Model;

import Entity.User;
import Util.DBHelper;

import java.sql.*;

public class UserHandler {

    DBHelper dbHelper = new DBHelper();
    private Connection conn;

    public UserHandler(){
        conn = dbHelper.getConn();
    }

    //登录验证
    public boolean loginCheck(User user){
        boolean result = false;
        Statement sta = null;
        ResultSet rs = null;

        try {
            sta = conn.createStatement();
            String sql = "select password from user where username='"+user.getUsername()+"'";
            rs = sta.executeQuery(sql);

            if(rs.next()){
                if(rs.getString(1).equals(user.getPassword())){
                    result = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                rs.close();
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

}
