package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.order.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminPage")
public class AdminPage extends HttpServlet {
    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService =new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> idOfOrders=Listener.getOrderList();
        System.out.println(idOfOrders);
        req.setAttribute("listOfIdOfOrders", idOfOrders);
        req.getRequestDispatcher("WEB-INF/views/AdminPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("orderId"));
        System.out.println(id);
        orderService.update(id);
        resp.sendRedirect("/adminPage");
    }
}
