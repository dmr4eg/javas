package cz.cvut.fel.pjv.bikes;

public class Bicycle {
    protected int cadence;
    protected int speed;
    protected int gear;
    protected Color color;
    public Bicycle(int cadence, int speed, int gear, Color color) {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
        this.color = color;
    }

    public void visit(BasicService service){
        service.accept(this);
    }
    public void printDescription(){
        System.out.printf("Bike is in gear %d with a cadence of %d and travelling at a speed of %d of color %s.\n", gear, cadence, speed, color.getDescription());
    };
}
