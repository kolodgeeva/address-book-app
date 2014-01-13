package servlets;

import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html;charset=UTF-8");

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            //validate
            Integer userId = UserDao.isUserValid(login, password);

            if (userId != 0) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);

                response.sendRedirect("/contacts");
            } else {
                response.setStatus(401);
                response.sendRedirect("/login");
            }
        } catch (Exception e) {
            throw new ServletException("Server error with authorization", e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            if (request.getParameter("action") != null) {
                HttpSession session = request.getSession(true);
                session.removeAttribute("userId");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("//login.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Server error with loading a login page", e);
        }
    }

}
