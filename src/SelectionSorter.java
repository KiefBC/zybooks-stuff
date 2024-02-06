public class SelectionSorter extends Sorter {

    public SelectionSorter(int[] od) {
        super(od);
    }

    public int[] getData() {
        return data;
    }

    public void sort() {
        for (int i = 0; i < data.length - 1; i++) {
            outerLoopExecutions++;

            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                innerLoopExecutions++;

                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            numSwaps++;
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }
}