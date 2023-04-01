package cz.cvut.fel.pjv.data;

import cz.cvut.fel.pjv.model.Car;

public class RaceResult implements Comparable<RaceResult> {
    private final Car car;
    private final TimeSpan timeSpan;
    public RaceResult(Car car, TimeSpan timeSpan) {
        this.car = car;
        this.timeSpan = timeSpan;
    }

    @Override
    public int compareTo(RaceResult o) {
        return timeSpan.getTotalSeconds() - o.timeSpan.getTotalSeconds();
    }

    public Car getCar() {
        return car;
    }

    public TimeSpan getTimeSpan() {
        return timeSpan;
    }
}
