package servlets;

import dao.UserContactDao;
import data.UserContact;

import javax.servlet.RequestDispatcher;
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
public class EditContact extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer contactId = Integer.valueOf(request.getParameter("id"));
        String contactName = request.getParameter("name");
        String contactPhone = request.getParameter("phone");

        UserContact userContact = new UserContact();
        userContact.setId(contactId);
        userContact.setName(contactName);
        userContact.setPhone(contactPhone);

        UserContactDao userContactDao = new UserContactDao();
        Boolean isUserContactSaved = userContactDao.saveUserContact(userContact);

        if(isUserContactSaved){
            response.sendRedirect("/contacts");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contactId = request.getParameter("contactId");
        UserContactDao userContactDao = new UserContactDao();
        UserContact userContact =  userContactDao.getUserContactById(Integer.valueOf(contactId));
        request.setAttribute("contact", userContact);

        RequestDispatcher dispatcher = request.getRequestDispatcher("//editContact.jsp");
        dispatcher.forward(request, response);
    }
}
