package cz.cvut.fel.pjv.data;

public class TimeSpan {
    private int hour;
    private int minute;
    private int second;

    public TimeSpan(){
    }
    public TimeSpan(int second){
        minute = second / 60;
        this.second = second % 60;
        hour = minute / 60;
        minute = minute % 60;
    }
    public TimeSpan(int minute, int second){
        setTime(0, minute, second);

    }
    public TimeSpan(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }


    public static void main(String[] args) {
        TimeSpan t1 = new TimeSpan(0, 0, 130);
        System.out.println("T1: " + t1);
        t1 = new TimeSpan(130);
        System.out.println("T1: " + t1);
        TimeSpan t2 = new TimeSpan(t1).add(70);
        System.out.println("T1: " + t1);
        System.out.println("T2: " + t2);
        System.out.printf("Časy se %s.\n", t1.equals(t2) ? "rovnají" : "nerovnají");
        t1 = t1.add(70);
        System.out.println("T1: " + t1);
        System.out.println("T2: " + t2);
        System.out.printf("Časy se %s.\n", t1.equals(t2) ? "rovnají" : "nerovnají");
    }
}
