import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class InsertionSorterTest {

    @Test
    public void testSortAscending() {
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Unordered: " + Arrays.toString(arr));
        InsertionSorter sorter = new InsertionSorter(arr);
        sorter.sort();
        int[] expected = {1, 2, 5, 8, 9};
        System.out.println("Ordered: " + Arrays.toString(sorter.getData()));
        assertArrayEquals(expected, sorter.getData());
    }

    @Test
    public void testSortDuplicateElements() {
        int[] arr = {5, 2, 8, 1, 9, 2, 5};
        System.out.println("Unordered: " + Arrays.toString(arr));
        InsertionSorter sorter = new InsertionSorter(arr);
        sorter.sort();
        int[] expected = {1, 2, 2, 5, 5, 8, 9};
        System.out.println("Ordered: " + Arrays.toString(sorter.getData()));
        assertArrayEquals(expected, sorter.getData());
    }

    @Test
    public void testSortNegativeValues() {
        int[] arr = {-5, -2, -8, -1, -9};
        System.out.println("Unordered: " + Arrays.toString(arr));
        InsertionSorter sorter = new InsertionSorter(arr);
        sorter.sort();
        int[] expected = {-9, -8, -5, -2, -1};
        System.out.println("Ordered: " + Arrays.toString(sorter.getData()));
        assertArrayEquals(expected, sorter.getData());
    }
}