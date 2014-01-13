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

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 18.11.13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class AddContact extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            UserContactDao uad = new UserContactDao();
            HttpSession session = request.getSession(true);

            Integer userId = (Integer)session.getAttribute("userId");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            UserContact contact = new UserContact(userId, name, phone);
            Boolean isContactAdded =  uad.addContact(contact);
            if(isContactAdded) {
                response.sendRedirect("/contacts");
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("//addContact.jsp");
                dispatcher.forward(request, response);
            }
        }
        catch (Exception e){
            throw new ServletException("Server error with adding a contact", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("//addContact.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            throw new ServletException("Server error with loading page", e);
        }
    }
}
