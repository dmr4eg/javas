/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @assyldam
 */

package cz.cvut.fel.pjv;

import java.util.Objects;
import java.util.Scanner;

import java.util.Objects;
import java.util.Scanner;

public class Lab02 {
    private final Scanner sc = new Scanner(System.in);

    public void start(String[] args) {
        homework();
    }

    public void homework() {
        String[] arr = new String[10];
        int counter = 0;
        int liner = 0;

        TextIO bla = new TextIO();
        String input;
        while (!Objects.equals(input = bla.getLine(), "")) {
            liner++;
            if (TextIO.isDouble(input)) {
                arr[counter] = String.valueOf(Double.parseDouble(input));
                counter++;
                if (counter == 10) {
                    arr = printer(arr, counter);
                    counter = 0;
                }
            } else {
                System.err.println("A number has not been parsed from line " + liner);
            }
        }
        System.err.println("End of input detected!");
        if (counter > 1) {
            arr = printer(arr, counter);
            for (String i : arr) {
                if (i != null) {
                System.out.println(i);
                }
            }
        }
    }

    private String[] printer(String[] arr, int counter) {
        double prumer = Double.parseDouble(String.valueOf(prumer(arr, counter)));
        double odchylka = odchylka(arr, counter);
        System.out.printf("%2d" + " " + "%.3f" + " " + "%.3f" + "\n", counter, prumer, odchylka);
        return new String[10];
    }

    public double prumer(String[] pru, int counter) {
        double soucet = 0;
        double result;
        for (int i = 0; i < counter; i++) {
            soucet += Double.parseDouble(pru[i]);
        }
        result = soucet / counter;
        return result;
    }

    public double odchylka(String[] pru, int counter) {
        double result = prumer(pru, counter);
        double od = 0;
        for (int i = 0; i < counter; i++) {
            double res = Math.pow(Double.parseDouble(pru[i]) - result, 2);
            od += res;
        }
        return Math.sqrt(od / counter);
    }
}


