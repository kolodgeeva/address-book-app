package servlets;

import dao.UserContactDao;
import data.UserContact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class UserContacts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            super.doPost(request, response);
        }
        catch (Exception e){
            throw new ServletException("Server error with loading page", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(true);
            UserContactDao uad = new UserContactDao();
            String userId = session.getAttribute("userId").toString();

            ArrayList<UserContact> contacts = uad.GetUserContacts(Integer.valueOf(userId));
            request.setAttribute("contacts", contacts);

            RequestDispatcher dispatcher = request.getRequestDispatcher("//contacts.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            throw new ServletException("Server error with loading page", e);
        }
    }
}
