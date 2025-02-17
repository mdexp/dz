package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Додати автомобіль до бази
        postgresDB.addCar("Toyota Camry", 5);
        postgresDB.addCar("Lada 08", 15);
        postgresDB.addCar("Wolga", 11);


        System.out.println("Автомобілі у наяві:");
        ArrayList<Car> cars = postgresDB.readCars();

        //Оновити машину
        int carIdToUpdate = cars.get(1).id;
        postgresDB.updateCar(carIdToUpdate, "Honda Accord", 7);

        //видалити машину
        int carIdToDelete = cars.get(0).id;
        postgresDB.deleteCar(carIdToDelete);


        System.out.println("Чтение после изменений:");
        postgresDB.readCars();
    }
}
