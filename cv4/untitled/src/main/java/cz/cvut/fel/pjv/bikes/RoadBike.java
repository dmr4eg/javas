package cz.cvut.fel.pjv.bikes;

public class RoadBike extends Bicycle{
    private String tireWidth;

    public RoadBike(int cadence, int speed, int gear, String suspension) {
        super(cadence, speed, gear);
        this.tireWidth = tireWidth;
    }

    @Override
    public void printDescription(){
        super.printDescription();
        System.out.println("The " + "RoadBike " + "has a" + tireWidth + "Tire.");
    }
}
