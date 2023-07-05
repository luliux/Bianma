package DAO.Impl;

import DAO.UserDao;
import Entity.User;
import Util.DBHelper;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    public User selbyUsername(User user) {
        User returnUser = null;
        Connection con = null;
        //定义执行对象为null
        PreparedStatement ps = null;
        //定义结果集为null
        ResultSet rs = null;
        try {
            //执行连接
            con = DBHelper.getConn();
            //执行sql语句
            ps = con.prepareStatement("select * from user where username='"+user.getUsername()+"'");
            //执行结果集
            rs = ps.executeQuery();
            //遍历
            if(rs.next()){
                returnUser = new User();
                returnUser.setId(user.getId());
                returnUser.setUsername(rs.getString(2));
                returnUser.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            DBHelper.getClose(con,ps,rs);
        }
        return returnUser;
    }

   @Override
    public int insertUser(User user) {
        int result = 0;
        Connection con = null;
        //定义执行对象为null
       PreparedStatement ps = null;
       try {
           con = DBHelper.getConn();
           String sql = "insert into user(username,password,age,gender,email)"
                   + "values('"+ user.getUsername()+"','"
                   +user.getPassword()+"',"
                   +user.getAge()+",'"
                   +user.getGender()+"','"
                   +user.getEmail()+"')";
           ps = con.prepareStatement(sql);
           result = ps.executeUpdate();

       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           DBHelper.getClose(con,ps,null);
       }
       return result;
    }

}
