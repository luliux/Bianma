package Controller;

import Entity.Customer;
import Service.CustomerService;
import Service.ServiceImpl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomersController",value = "/index")
public class CustomersController extends HttpServlet {
    private static final long serialVwesionUID = 1L;
    private CustomerService customerService;
    /*
    @see HttpServlet#HttpServlet()
     */
    public CustomersController(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        customerService = new CustomerServiceImpl();
        List<Customer> cusList =  new ArrayList<Customer>();
        cusList = customerService.getAllCustomers();

        request.getSession().setAttribute("cusList",cusList);
        response.sendRedirect("index.jsp");
    }
}
