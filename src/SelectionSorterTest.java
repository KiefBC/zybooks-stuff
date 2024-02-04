import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class SelectionSorterTest {

    @Test
    public void testSortAscendingOrder() {
        int[] data = {5, 2, 8, 1, 9};

        System.out.println("Unordered: " + Arrays.toString(data));

        SelectionSorter selectionSorter = new SelectionSorter(data);
        selectionSorter.sort();

        int[] expected = {1, 2, 5, 8, 9};

        System.out.println("Ordered: " + Arrays.toString(selectionSorter.getData()));

        assertArrayEquals(expected, selectionSorter.getData());
    }

    @Test
    public void testSortNegativeValues() {
        int[] data = {-5, -2, -8, -1, -9};

        System.out.println("Unordered: " + Arrays.toString(data));

        SelectionSorter selectionSorter = new SelectionSorter(data);
        selectionSorter.sort();

        int[] expected = {-9, -8, -5, -2, -1};

        System.out.println("Ordered: " + Arrays.toString(selectionSorter.getData()));

        assertArrayEquals(expected, selectionSorter.getData());
    }

    @Test
    public void testSortDuplicateValues() {
        int[] data = {5, 2, 8, 1, 9, 2};

        System.out.println("Unordered: " + Arrays.toString(data));

        SelectionSorter selectionSorter = new SelectionSorter(data);
        selectionSorter.sort();

        int[] expected = {1, 2, 2, 5, 8, 9};

        System.out.println("Ordered: " + Arrays.toString(selectionSorter.getData()));

        assertArrayEquals(expected, selectionSorter.getData());
    }
}