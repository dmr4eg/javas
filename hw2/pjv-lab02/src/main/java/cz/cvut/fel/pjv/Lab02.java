/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @assyldam
 */

package cz.cvut.fel.pjv;

import java.util.Objects;
import java.util.Scanner;

public class Lab02 {
   private final Scanner sc = new Scanner(System.in);
   public void start(String[] args) {
    homework();
   }

   public void homework(){
//       String[] arr = new String[10];
       double[] arr = new double[10];
       int counter = 0;
       int liner = 0;

       TextIO bla = new TextIO();
       String input;
       while (!Objects.equals(input = bla.getLine(), "")){
          liner++;
          if (TextIO.isDouble(input)){
              arr[counter] = Double.parseDouble(input);
              counter++;
              if (counter == 10) {
                  printer(arr, counter);
                  counter = 0;
                  for (int i = 0; i < counter; i++){
                      arr[i] = 0.25;
                  }
              }
          } else {
              System.err.println("A number has not been parsed from line " + liner);
          }
       }
       System.err.println("End of input detected!");
       if (counter > 1){
           printer(arr, counter );
       }
   }

   private void printer(double[] arr, int counter){
       double prumer = prumer(arr, counter);
       double odchylka = odchylka(arr, prumer, counter);
       System.out.printf("%2d" + " " + "%.3f" + " " + "%.3f" + "\n", counter, prumer, odchylka);
       arr = new double[10];
   }
   public double prumer(double[] pru, int counter){
        double soucet = 0;
        double result;
        for (double i : pru){
            soucet += i;
        }
        result = soucet / counter;
        return result;
   }
   public double odchylka(double[] pru, double prumer, int counter){
       double od = 0;
       for (double i : pru){
           if (i == 0.25){
               break;
           }
           double result = Math.pow((i - prumer), 2);
           if (result == 0){
               break;
           }
           od += result;
       }
       return Math.sqrt(od / counter);
   }
}
