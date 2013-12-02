package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 01.12.13
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse responce = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(true);
        //String userId = session.getAttribute("userId").toString();

        if (session.getAttribute("userId") == null) {
            responce.sendRedirect("/notLogin.jsp");    //redirect to LoginServlet
        } else {
            filterChain.doFilter(request, responce);
        }
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
