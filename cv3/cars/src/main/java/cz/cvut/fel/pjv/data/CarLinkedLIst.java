package cz.cvut.fel.pjv.data;

import cz.cvut.fel.pjv.model.Car;

import java.util.LinkedList;


public class CarLinkedLIst {
    private final LinkedList<Car> cars = new LinkedList<Car>();

    public void addcar(Car car){
        cars.add(car);
    }

    public Car[] toArray(){
        return cars.toArray(new Car[cars.size()]);
    }

}
