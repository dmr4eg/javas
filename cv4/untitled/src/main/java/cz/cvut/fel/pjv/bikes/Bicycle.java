package cz.cvut.fel.pjv.bikes;

public class Bicycle {
    protected int cadence;
    protected int speed;
    protected int gear;

    public Bicycle(int cadence, int speed, int gear) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }

    public Bicycle() {

    }

    public void printDescription(){
        System.out.printf("Bike is in gear %d with a cadence of %d and travelling at a speed of %d. ", gear, cadence, speed );
    }
}
