package servlets;

import entities.Order;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.order.OrderService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("")
public class mainPage extends HttpServlet {
    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService=new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> p= Listener.getOrderList();
        List<Order> p1= new LinkedList<>();
        for(int i=0;i<p.size();i++){
            p1.add(orderService.getOrder(p.get(i)));
        }
        req.setAttribute("list",p1);
        req.getRequestDispatcher("WEB-INF/views/mainPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
