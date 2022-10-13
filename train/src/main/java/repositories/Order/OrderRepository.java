package repositories.Order;

import entities.Food;
import entities.Order;
import repositories.ConnectionProvider;
import servlets.Listener;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository {
    Connection connection= ConnectionProvider.getConnection();

    private static final String newOrder="INSERT INTO order1 (date,isReady) VALUES(now(),false) RETURNING id";

    private static final String newFood="INSERT INTO order_and_food (id_of_oder,id_of_food) VALUES (?,?);";

    public void signBasketFood(List<Food> allFood){
        try {
            PreparedStatement statement1=connection.prepareStatement(newOrder);
            ResultSet resultSet1=statement1.executeQuery();
            resultSet1.next();
            int id=resultSet1.getInt("id");
            Listener.getOrderList().add(id);
            for(Food food: allFood){
                PreparedStatement statement=connection.prepareStatement(newFood);
                statement.setInt(1,id);
                statement.setInt(2,food.getId());
                statement.execute();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    private static final String order="SELECT * FROM order1 WHERE id=?";

    public Order getOrder(int id){
        Order order1=null;
        try {
            PreparedStatement statement=connection.prepareStatement(order);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                order1=Order.builder()
                        .id(resultSet.getInt("id"))
                        .status(resultSet.getBoolean("isReady"))
                        .build();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return order1;
    }


    private static final String orderUpdate="UPDATE order1 SET isReady=true WHERE id=?";

    public void UpdateOrder(int id){
        try {
            PreparedStatement statement=connection.prepareStatement(orderUpdate);
            statement.setInt(1,id);
            statement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
