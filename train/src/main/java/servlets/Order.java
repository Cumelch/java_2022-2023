package servlets;

import entities.Food;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Food.FoodService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/addOrder")
public class Order extends HttpServlet {

    FoodService foodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        foodService=new FoodService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));

        if(!Listener.getBusket().containsKey(req.getSession().getId())){
            System.out.println("1");
            List<Food> t=new LinkedList<>();
            Listener.getBusket().put(req.getSession().getId(),t);
            System.out.println(Listener.getBusket().get(req.getSession().getId()));
        }
        List<Food> r=Listener.getBusket().get(req.getSession().getId());
        r.add(foodService.getFoodById(id));
        System.out.println(Listener.busket.toString());
        resp.sendRedirect("/addOrder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> allFood=foodService.getAllFood();
        List<Food> basketFood=Listener.getBusket().get(req.getSession());
        req.setAttribute("basketFood",basketFood);
        req.setAttribute("ListOfFood",allFood);
        req.getRequestDispatcher("/WEB-INF/views/Order.jsp").forward(req,resp);
    }
}
