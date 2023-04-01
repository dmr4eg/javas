package cz.cvut.fel.pjv.data;

import java.util.Objects;

public class TimeSpan {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public TimeSpan(){
    }
    public TimeSpan(int second){
        minute = second / 60;
        this.second = second % 60;
        hour = minute / 60;
        minute = minute % 60;

    }
    public TimeSpan(int minute, int second){
        this.second = second >= 60 ? 0 : second;
        this.minute = minute % 60;
        hour = minute / 60;
    }
    public TimeSpan(TimeSpan timeSpan){
        setTime(timeSpan.hour, timeSpan.minute, timeSpan.second);
    }
    public TimeSpan(int hour, int minute, int second){
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute >= 60 ? 0 : minute;
        this.second = second >= 60 ? 0 : second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSpan timeSpan = (TimeSpan) o;
        return getTotalSeconds() == timeSpan.getTotalSeconds();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalSeconds());
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    public TimeSpan add(int second){
        this.second += second;
        normalize();
        return this;
    }

    private void normalize(){
        minute += second / 60;
        second = second % 60;
        hour = minute / 60;
        minute = minute % 60;

    }
    public int getTotalSeconds(){
        return hour * 3600 + minute * 60 + second;
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
