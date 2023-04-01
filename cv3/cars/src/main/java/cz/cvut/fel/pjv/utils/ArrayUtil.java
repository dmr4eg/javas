package cz.cvut.fel.pjv.utils;

public class ArrayUtil {
    private ArrayUtil() {
    }
    public static void sort(Comparable[] comparables){
        for (int i = 0; i < comparables.length; i++) {
            for (int j = 0; j < comparables.length - 1; j++){
                if (comparables[j].compareTo(comparables[j + 1]) > 0){
                    Comparable temp = comparables[j];
                    comparables[j] = comparables[j + 1];
                    comparables[j + 1] = temp;

                }
            }
        }
    }
}
