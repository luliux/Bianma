package DAO.Impl;

import DAO.CustomerDao;
import Entity.Customer;
import Util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao {

    @Override
    public List<Customer> selectAll() {
        List<Customer> list = new ArrayList<Customer>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConn();
            ps = con.prepareStatement("select * from customer");
            rs = ps.executeQuery();
            //遍历
            while (rs.next()){
                Customer cus = new Customer();
                cus.setCustId(rs.getLong(1));
                cus.setCustName(rs.getString(2));
                cus.setCustSource(rs.getString(3));
                cus.setCustIndustry(rs.getString(4));
                cus.setCustLevel(rs.getString(5));
                cus.setCustAddress(rs.getString(6));
                cus.setCustPhone(rs.getString(7));
                list.add(cus);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getClose(con,ps,rs);
        }
        return list;
    }
}
