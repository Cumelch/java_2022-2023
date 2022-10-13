package service.Food;

import entities.Food;
import repositories.Food.FoodRepository;

import java.util.List;

public class FoodService {
    FoodRepository foodRepository=new FoodRepository();

    public List<Food> getAllFood(){
        return foodRepository.getFood();
    }

    public Food getFoodById(int id){return foodRepository.getFoodById(id);}
}
