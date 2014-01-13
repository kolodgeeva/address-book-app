package servlets;

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

        try {
            response.setContentType("text/html;charset=UTF-8");

            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String cpassword = request.getParameter("cpassword");

            String valid =  UserDao.isUserRegisterValid(login, password, cpassword);

            if(valid == null){

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
        catch (Exception e){
            throw new ServletException("Server error with registration", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("//register.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            throw new ServletException("Server error with loading registration page", e);
        }
    }

}
