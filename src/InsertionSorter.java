public class InsertionSorter extends Sorter {

    // Constructor just uses superclass constructor.
    public InsertionSorter(int[] od) {
        super(od);
    }

    public int[] getData() {
        return data;
    }

    // Method to sort the array, using Insertion Sort.
    public void sort() {
        // TO-DO: implement the insertion sort algorithm to
        //        sort the data array.

        for (int i = 1; i < data.length; i++) {
            int keyValue = data[i];
            int previousIndex = i - 1;

            shiftElementsRight(previousIndex, keyValue);
        }
    }

    private void shiftElementsRight(int previousIndex, int keyValue) {

        while (previousIndex >= 0 && data[previousIndex] > keyValue) {
            data[previousIndex + 1] = data[previousIndex];
            previousIndex--;
        }

        data[previousIndex + 1] = keyValue;
    }
}
