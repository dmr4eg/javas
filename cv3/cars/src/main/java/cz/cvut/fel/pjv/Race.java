package cz.cvut.fel.pjv;

import cz.cvut.fel.pjv.data.CarLinkedLIst;
import cz.cvut.fel.pjv.data.RaceResult;
import cz.cvut.fel.pjv.data.TimeSpan;
import cz.cvut.fel.pjv.model.Car;
import cz.cvut.fel.pjv.utils.ArrayUtil;

import java.util.Arrays;

public class Race {
    private final int length;

    private final CarLinkedLIst racingCars;
    private boolean alreadyExists = false;
    private RaceResult[] results;
    public Race(int length){
        this.length = length;
        racingCars = new CarLinkedLIst();
    }

    public boolean addRacingCars(Car car){
        if (!alreadyExists){
            racingCars.addcar(car);
            return true;
        } else {
            return false;
        }
    }
    private RaceResult[] getRaceResult(){
        if (!alreadyExists) {
            alreadyExists = true;
            Car[] racingCarsArray = racingCars.toArray();
            results = new RaceResult[racingCarsArray.length];
            int i = 0;
            for (Car car : racingCarsArray) {
                results[i] = new RaceResult(car, new TimeSpan(length / car.getSpeed()));
                i++;
            }
            ArrayUtil.sort(results);
        }
        return results;
    }
    public Car getWinner(){
        getRaceResult();
        return results[0].getCar();
    }

    public TimeSpan getWinningTime(){
        getRaceResult();
        return results[0].getTimeSpan();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!alreadyExists){
            for (Car car : racingCars.toArray()){
                sb.append(car.toString()).append(System.lineSeparator());
            }
        } else {
            for (RaceResult rr : results){
                sb.append(rr.getCar().toString().append(System.lineSeparator());
            }
        }
    }
}
