package servlets;

import entities.Food;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.order.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet("/formOrder")
public class FormOrder extends HttpServlet {

    OrderService orderService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService=new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> basketFood=Listener.getBusket().get(req.getSession().getId());
        orderService.signFood(basketFood);
        req.getRequestDispatcher("/").forward(req,resp);
//        req.getRequestDispatcher("/").forward(req,resp);
    }
}
