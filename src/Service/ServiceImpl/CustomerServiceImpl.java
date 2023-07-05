package Service.ServiceImpl;

import DAO.CustomerDao;
import DAO.Impl.CustomerDaoImp;
import Entity.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public List<Customer> getAllCustomers() {
        customerDao = new CustomerDaoImp();
        return customerDao.selectAll();
    }
}
