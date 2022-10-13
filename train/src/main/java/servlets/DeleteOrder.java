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

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {
    OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService=new OrderService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("deleteId"));
        System.out.println(Listener.getOrderList().toString());
        List<Integer> o=Listener.getOrderList();
        for(int i=0;i<o.size();i++){
            if(o.get(i)==id){
                o.remove(o.get(i));
            }
        }
        resp.sendRedirect("/adminPage");
    }
}
