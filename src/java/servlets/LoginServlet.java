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
        if (logout == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
            return;
        } else {
            session.invalidate(); 
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
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
                response.sendRedirect("home.jsp"); 
                return; 
            } else {
                response.sendRedirect("login.jsp");
                return;
            }
        } 
    }
}
