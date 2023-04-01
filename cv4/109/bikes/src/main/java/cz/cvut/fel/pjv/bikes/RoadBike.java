package cz.cvut.fel.pjv.bikes;

public class RoadBike extends Bicycle {
    private int tireWidth;

    public RoadBike(int cadence, int speed, int gear, Color color, int tireWidth) {
        super(cadence, speed, gear, color);
        this.tireWidth = tireWidth;
    }

    @Override
    public void visit(BasicService service){
        service.accept(this);
    }

    @Override
    public void printDescription(){
        System.out.printf("Bike is in gear %d with a cadence of %d and travelling at a speed of %d with suspension: %d.\n", gear, cadence, speed, tireWidth);
    };
}
