public class InsertionSorter extends Sorter {

    public InsertionSorter(int[] od) {
        super(od);
    }

    public int[] getData() {
        return data;
    }

    public void sort() {
        for (int i = 1; i < data.length; i++) {
            outerLoopExecutions++;

            int keyValue = data[i];
            int previousIndex = i - 1;

            shiftElementsRight(previousIndex, keyValue);
        }
    }

    private void shiftElementsRight(int previousIndex, int keyValue) {
        while (previousIndex >= 0 && data[previousIndex] > keyValue) {
            innerLoopExecutions++;
            numSwaps++;

            data[previousIndex + 1] = data[previousIndex];
            previousIndex--;
        }

        data[previousIndex + 1] = keyValue;
    }
}
