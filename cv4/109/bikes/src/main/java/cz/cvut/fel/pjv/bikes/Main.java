package cz.cvut.fel.pjv.bikes;

public class Main {
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1, Color.RED);
        bike02 = new MountainBike(20, 10, 5, Color.BLUE, "Dual");
        bike03 = new RoadBike(40, 20, 8, Color.GREEN, 23 );

        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();

        BasicService service01 = new BasicService();
        MountainBikeService service02 = new MountainBikeService();
        RoadBikeService service03 = new RoadBikeService();

        System.out.println("-----------");

        bike01.visit(service01);
        bike02.visit(service01);
        bike03.visit(service01);

        bike01.visit(service02);
        bike02.visit(service02);
        bike03.visit(service02);

        bike01.visit(service03);
        bike02.visit(service03);
        bike03.visit(service03);
    }
}