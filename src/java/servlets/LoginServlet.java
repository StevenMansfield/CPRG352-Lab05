package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String logout = request.getParameter("logout");
        
        if (logout != null) {
            session.invalidate(); 
            request.setAttribute("loggedOut", true);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        if (session.getAttribute("sessionUsername") != null) {
            response.sendRedirect("home"); 
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        HttpSession session = request.getSession(); 
        AccountService accountUser;
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        if (username != null && password != null) {
            accountUser = new AccountService(); 
            User user = accountUser.login(username, password); 
            if(user != null) {
                session.setAttribute("sessionUsername", user.getUsername());
                response.sendRedirect("home"); 
                return; 
            } else {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("invalid", true);
                response.sendRedirect("login"); 
                return;
            }
        } 
    }
}
