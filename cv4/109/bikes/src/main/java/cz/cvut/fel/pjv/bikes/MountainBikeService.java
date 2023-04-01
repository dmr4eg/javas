package cz.cvut.fel.pjv.bikes;

public class MountainBikeService extends BasicService{

    @Override
    public void accept(MountainBike bike) {
        System.out.println("fixing MountainBike");
    }
}
