package Service;

import Entity.Customer;

import java.util.List;

public interface CustomerService {
    /*
    该方法返回一个包含所有客户信息的List对象
     */
    public List<Customer> getAllCustomers();
}
