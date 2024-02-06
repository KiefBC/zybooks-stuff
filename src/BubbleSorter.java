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

    /*
    This will be for showing Lynda, it also works, but the increments are different

        public void sort() {

        for (int i = 0; i < data.length - 1; i++) {
            outerLoopExecutions++;

            for (int j = 0; j < data.length - i - 1; j++) {
                innerLoopExecutions++;

                if (data[j] > data[j + 1]) {
                    numSwaps++;

                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

     */

}
