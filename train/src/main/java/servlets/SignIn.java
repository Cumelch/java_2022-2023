package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.admin.AdminService;

import java.io.IOException;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {
    AdminService adminService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        adminService=new AdminService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/SignIn.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        if(adminService.signIn(email,password)){
            resp.sendRedirect("/adminPage");
        }else{
            resp.sendRedirect("/signIn");
        }
    }
}
