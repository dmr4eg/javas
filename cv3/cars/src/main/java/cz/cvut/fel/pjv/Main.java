package cz.cvut.fel.pjv;

import cz.cvut.fel.pjv.data.TimeSpan;
import cz.cvut.fel.pjv.model.Car;
import cz.cvut.fel.pjv.model.ServiceBook;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Volkswagen", "Polo", 2010, "AKK", 40);
        Car car2 = new Car("Chevrolet", "Corvette", 1980, "LS7", 45);

        Car car3 = new Car("Trabant", "P601", 1990, "Air cooled, 0.6-liter 2-stroke", 20);
        Car car4 = new Car("BMW", "3", 2006, "318d", 42);
        Car car5 = new Car("McLaren", "F1", 2014, "V12", 107);
        Race race = new Race(1000);
        race.addRacingCars(car1);
        race.addRacingCars(car2);
        race.addRacingCars(car3);
        race.addRacingCars(car4);
        race.addRacingCars(car5);
        System.out.println("Závodníci:");
        System.out.println(race);
        System.out.printf("Výhercem se stává %s s časem %s.\n", race.getWinner(), race.getWinningTime());
        System.out.printf("Pořadí v cíli:\n%s\n", race);
    }
}