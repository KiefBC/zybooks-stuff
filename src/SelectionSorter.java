public class SelectionSorter extends Sorter {

    // Constructor just uses superclass constructor.
    public SelectionSorter(int[] od) {
        super(od);
    }

    public int[] getData() {
        return data;
    }

    // Method to sort the array using Selection Sort.
    public void sort() {
        // TO-DO: implement the selection sort algorithm to
        //        sort the data array.

        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }
}