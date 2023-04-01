package cz.cvut.fel.pjv.bikes;

public class MountainBike extends Bicycle{
    private String suspension;

    public MountainBike(int cadence, int speed, int gear, String suspension) {
        super(cadence, speed, gear);
        this.suspension = suspension;
    }

    @Override
    public void printDescription(){
        super.printDescription();
        System.out.println("The " + "RoadBike " + "has a" + suspension + " suspension.");
    }
}
