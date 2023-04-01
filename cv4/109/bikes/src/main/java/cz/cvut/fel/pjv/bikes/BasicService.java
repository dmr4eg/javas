package cz.cvut.fel.pjv.bikes;

public class BasicService {
    public void accept(Bicycle bike){
        System.out.println("fixing Bicycle");
    }
    public void accept(MountainBike bike){
        System.out.println("cant fix MountainBike");
    }
    public void accept(RoadBike bike){
        System.out.println("cant fix RoadBike");
    }
}
