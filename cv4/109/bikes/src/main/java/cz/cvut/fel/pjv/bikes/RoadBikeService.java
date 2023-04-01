package cz.cvut.fel.pjv.bikes;

public class RoadBikeService extends BasicService{
    @Override
    public void accept(RoadBike bike) {
        System.out.println("fixing RoadBike");
    }
}
