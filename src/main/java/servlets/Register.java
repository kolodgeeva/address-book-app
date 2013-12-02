package servlets;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 04.11.13
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 */

import dao.UserDao;
import data.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        String valid =  UserDao.isUserRegisterValid(login, password, cpassword);

        if(valid == null){
            //register user

            User user = new User(login, password);
            Integer id = UserDao.registerUser(user);

            if(id != 0){
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", id);

                response.sendRedirect("/contacts");
            }
            else{
                valid = "Some error with register";
                request.setAttribute("msg", valid);

                RequestDispatcher dispatcher = request.getRequestDispatcher("//register.jsp");
                dispatcher.forward(request, response);
            }

        }
        else{

            request.setAttribute("msg", valid);

            RequestDispatcher dispatcher = request.getRequestDispatcher("//register.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("//register.jsp");
        dispatcher.forward(request, response);
    }

}
