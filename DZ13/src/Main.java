public class Main {

    public static void main(String[] args) {

// Завдання 1
//######################################################################################

        Dish soup = new Dish("soup", "main course", 80.0f);
        Dish pizza = new Dish("pizza", "fast food", 200.0f);
        Dish ice_cream = new Dish("ice cream", "dessert", 50.5f);

        Restaurant restaurant = new Restaurant();
        restaurant.addDish(soup);
        restaurant.addDish(pizza);
        restaurant.addDish(ice_cream);

        for (Dish dish : Restaurant.allDishes){
            dish.displayInfo();
        }

        System.out.println("TotalDishes: " + Restaurant.getTotalDishes());

// Завдання 2
//######################################################################################

        Car tesla_model_y = new Car("Model Y", 2020, "Tesla");
        Car ford_focus = new Car("Focus", 2015, "Ford");
        Car vaz_2106 = new Car("2106", 1986, "Vaz");

        tesla_model_y.displayInfo();
        ford_focus.displayInfo();
        vaz_2106.displayInfo();

        System.out.println("Total cars produced: " + Car.totalCarsProduced);

    }



}
