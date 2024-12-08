import java.util.ArrayList;

public class Restaurant {

    static ArrayList<Dish> allDishes = new ArrayList<Dish>();

    public void addDish(Dish dish){
        allDishes.add(dish);
    }

    public static int getTotalDishes(){
        return allDishes.size();
    }
}
