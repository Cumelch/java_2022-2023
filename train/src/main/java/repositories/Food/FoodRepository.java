package repositories.Food;

import entities.Admin;
import entities.Food;
import repositories.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FoodRepository {

    Connection connection= ConnectionProvider.getConnection();

    private static final String FindUserByEmail="SELECT * FROM food;";

    public List<Food> getFood(){
        List<Food> allFood=new LinkedList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(FindUserByEmail);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Food food= Food.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .cost(resultSet.getInt("cost"))
                        .build();
                allFood.add(food);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return allFood;
    }


    private static final String FindUserByEmail1="SELECT * FROM food WHERE id=?;";

    public Food getFoodById(int id){
        Food food=null;
        try {
            PreparedStatement statement=connection.prepareStatement(FindUserByEmail1);
            statement.setLong(1,id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                food= Food.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .cost(resultSet.getInt("cost"))
                        .build();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return food;
    }
}
