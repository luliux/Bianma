package Controller;

import Entity.User;
import Service.ServiceImpl.UserServiceImpl;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistController",value = "/RegistController")
public class RegistController extends HttpServlet {
    private UserService userService;//Service对象

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

        //System.out.println(gender);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setGender(gender);
        user.setEmail(email);

        userService = new UserServiceImpl();
        boolean result = userService.registUser(user);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //控制器进行视图切换
        if(result){
            out.print("<script language='javascript'>"+"alert('Regist success!');"
                    +"window.location.href='登录界面.html';</script>')");
        }else {
            out.print("<script language='javascript'>"+"alert('Regist fail!');"
                    +"window.location.href='登录界面.html';</script>')");
        }
    }
}
