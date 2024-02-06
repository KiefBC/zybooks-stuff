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

    protected long numSwaps;
    protected long outerLoopExecutions;
    protected long innerLoopExecutions;

    // Constructor creates a copy of the parameter array.
    protected Sorter(int[] od) {
        data = Arrays.copyOf(od, od.length);

        numSwaps = 0;
        outerLoopExecutions = 0;
        innerLoopExecutions = 0;
    }

    // Abstract method - must be implemented by subclasses.
    // Sorts the "data" array in-place.
    protected abstract void sort();

    // Method to determine if "data" is sorted. Returns true if
    // the items are in sorted order, false otherwise.
    protected boolean validate() {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i-1]) return false;
        }
        return true;
    }

    // Returns a String representation of the "data" array.
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    protected void checkSwaps(long expected) {
        if (numSwaps-expected==0)
            System.out.println("\tNumber of swaps is correct.");
        else
            System.out.println("\tNumber of swaps is incorrect.");
    }

    protected void checkOuterLoopExecutions(long expected) {
        if (outerLoopExecutions-expected==0)
            System.out.println("\tNumber of outer loop executions is correct.");
        else
            System.out.println("\tNumber of outer loop executions is incorrect.");
    }

    protected void checkInnerLoopExecutions(long expected) {
        if (innerLoopExecutions-expected==0)
            System.out.println("\tNumber of inner loop executions is correct.");
        else
            System.out.println("\tNumber of inner loop executions is incorrect.");
    }

    // Outputs the sort statistics to the screen.
    protected void outputResults() {
        if (this instanceof SelectionSorter) {
            checkSwaps(4999);
            checkOuterLoopExecutions(4999);
            checkInnerLoopExecutions(12497500);
        }
        else if (this instanceof InsertionSorter) {
            checkSwaps(6129299);
            checkOuterLoopExecutions(4999);
            checkInnerLoopExecutions(6129299);
        }
        else if (this instanceof BubbleSorter) {
            checkSwaps(6129299);
            checkOuterLoopExecutions(4882);
            checkInnerLoopExecutions(12490597);
        }

        boolean sorted = this.validate();
        if (sorted) System.out.print("Sort is effective.");
        else System.out.print("Data NOT sorted.");
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

        // 1. Sort using Selection Sort, and time how long it takes.
        SelectionSorter selectionSorter = new SelectionSorter(data);
        System.out.println("SELECTION SORT: ");
        selectionSorter.sort();
        selectionSorter.outputResults();

        // 2. Sort using InsertionSort - SlowSwap, and time how long it takes.
        InsertionSorter insertionSorter = new InsertionSorter(data);
        System.out.println("\n\nINSERTION SORT: ");
        insertionSorter.sort();
        insertionSorter.outputResults();

        // 3. Sort using BubbleSort
        BubbleSorter bubbleSorter = new BubbleSorter(data);
        System.out.println("\n\nBUBBLE SORT: ");
        bubbleSorter.sort();
        bubbleSorter.outputResults();
    }
}