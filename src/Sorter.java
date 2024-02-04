import java.util.Scanner;
import java.util.Arrays;

/**
 * An abstract class to sort integer arrays.
 * There is an abstract method called sort() that must be
 * implemented by subclasses in order to be instantiable.
 *
 * The provided program (main method) will test InsertionSorter
 * and SelectionSorter, comparing times and correctness.
 */
public abstract class Sorter {

    // The integer array.
    protected int[] data;

    // Constructor creates a copy of the parameter array.
    protected Sorter(int[] od) {
        data = Arrays.copyOf(od, od.length);
    }

    // Abstract method - must be implemented by subclasses. Sorts
    // the "data" array in-place.
    public abstract void sort();


    // Method to determine if "data" is sorted. Returns true if
    // the items are in sorted order, false otherwise.
    public boolean validate() {
        // TO-DO: check the array to see if it is in order or not!

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // Returns a String representation of the "data" array.
    public String toString() {
        return Arrays.toString(data);
    }

    // Main program to test InsertionSorter and SelectionSorter.
    public static void main(String[] args) {

        // Read in the original data array from System.in. First number is
        // n, following by n integers.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }


        // Sort using Selection Sort, and time how long it takes.
        SelectionSorter selectionSorter = new SelectionSorter(data);
        long start = System.currentTimeMillis();
        selectionSorter.sort();
        long stop = System.currentTimeMillis();

        // Output timing and correctness of Selection Sort.
        boolean sorted = selectionSorter.validate();
        System.out.print("SELECTION SORT: ");
        if (sorted) System.out.print("sorted");
        else System.out.print("unsorted");
        System.out.println(", " + (stop - start) + " ms.");


        // Sort using InsertionSort, and time how long it takes.
        InsertionSorter insertionSorter = new InsertionSorter(data);
        start = System.currentTimeMillis();
        insertionSorter.sort();
        stop = System.currentTimeMillis();

        // Output timing and correctness of Insertion Sort.
        sorted = insertionSorter.validate();
        System.out.print("INSERTION SORT: ");
        if (sorted) System.out.print("sorted");
        else System.out.print("unsorted");
        System.out.println(", " + (stop - start) + " ms.");
    }

}
