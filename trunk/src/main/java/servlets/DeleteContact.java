package servlets;

import dao.UserContactDao;
import data.UserContact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 18.11.13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class DeleteContact extends HttpServlet {

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
        try{
            Integer contactId = Integer.valueOf(request.getParameter("contactId"));

            UserContact userContact = new UserContact();
            userContact.setId(contactId);

            UserContactDao userContactDao = new UserContactDao();
            Boolean isUserContactDeleted = userContactDao.deleteUserContact(userContact);

            if(isUserContactDeleted){
                response.sendRedirect("/contacts");
            }
        }
        catch (Exception e){
            throw new ServletException("Server error with loading page", e);
        }
    }
}
