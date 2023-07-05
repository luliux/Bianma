package Util;

import java.sql.*;

public class DBHelper {
    private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/dbdemo?useSSL=false&serverTimezone=UTC";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "llx20020611";

    static {
        try {
            Class.forName(DBDRIVER);//加载驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void getClose(Connection con, PreparedStatement ps, ResultSet rs) {

        if(con != null){
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            con = null;
        }
        if(ps != null){
            try{
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ps = null;
        }
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            rs = null;
        }
    }

}
