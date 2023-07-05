package DAO;

import Entity.Customer;
import java.util.List;

import java.util.List;

public interface CustomerDao {
    /*
    该方法语义为从 customer 表中搜索所有记录，并返回成一个 List 对象
     */
    public List<Customer> selectAll();
}
