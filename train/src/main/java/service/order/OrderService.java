package service.order;

import entities.Food;
import entities.Order;
import repositories.Order.OrderRepository;

import java.util.List;

public class OrderService {

    OrderRepository orderRepositor=new OrderRepository();

    public void signFood(List<Food> basketFood){
        orderRepositor.signBasketFood(basketFood);
    }

    public Order getOrder(int id){
        return orderRepositor.getOrder(id);
    }

    public void update(int id){
        orderRepositor.UpdateOrder(id);
    }
}
