public class BubbleSorter extends Sorter {

    public BubbleSorter(int[] od) {
        super(od);
    }

    public int[] getData() {
        return data;
    }

    public void sort() {
        boolean isSorted = false;
        int lastUnsorted = data.length - 1;

        while (!isSorted) {
            isSorted = true;
            outerLoopExecutions++;

            for (int j = 0; j < lastUnsorted; j++) {
                innerLoopExecutions++;

                if (data[j] > data[j + 1]) {
                    numSwaps++;

                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    isSorted = false;
                }
            }

            lastUnsorted--;
        }
    }

}
