package cz.cvut.fel.pjv.model;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private static int carCount = 0;
    private final String manufacturer;
    private final String modelName;
    private final int year;
    private final UUID vinCode;
    private final Engine engine;
    private ServiceBook serviceBook;
    
    /**
     * Constructor for Car class.
     * @param manufacturer manufacturer of the car
     * @param modelName model name of the car
     * @param year year of production
     * @param engineType type of engine
     */
    public Car(String manufacturer, String modelName, int year, String engineType) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.year = year;
        vinCode = UUID.randomUUID();
        carCount++;
        engine = new Engine(engineType);
    }

    public static int getCountOfExistingCars(){
        return carCount;
    }

    @Override
    public String toString() {
        return manufacturer + ' ' + modelName + ' ' + year + " VIN: " + vinCode + '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(vinCode, car.vinCode);
    }

    @Override
    public int hashCode() {
        return vinCode != null ? vinCode.hashCode() : 0;
    }

    public static void setCarCount(int carCount) {
        Car.carCount = carCount;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }
}
