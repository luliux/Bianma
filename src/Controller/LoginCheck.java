package Controller;

import Entity.User;
import Service.ServiceImpl.UserServiceImpl;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginCheck",value = "/LoginCheck")
public class LoginCheck extends HttpServlet {

    private static final long serialVwesionUID = 1L;
    private UserService userService;//Service对象

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();//模型层组件
        user.setUsername(username);
        user.setPassword(password);

        userService = new UserServiceImpl();
        boolean result = userService.loginCheck(user);//执行登录检查。判断user是否是一个合法登录用户

        //控制器进行视图从切换
        if(result){//登录成功
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            //response.sendRedirect("ok.jsp");//客户端跳转，相当于发起新的请求，URL改变
            //服务器端跳转，
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index");
            dispatcher.forward(request,response);
        }else {
            //response.sendRedirect("error.html");
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/error.html");
            dispatcher.forward(request,response);
        }

    }
}
