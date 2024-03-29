package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginBean;
import exception.ConnectionClosedFXException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginBean loginBean;
    
    @Override
    public void init() {
    	
        loginBean = new LoginBean();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        
        
        try {
            if (loginBean.userExist() == 1) {
        		
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("index.jsp");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("HomePageSportman.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
