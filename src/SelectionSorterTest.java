import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class SelectionSorterTest {

    private int[] readNumbersFromFile(String filePath) throws IOException {
        String separator = System.lineSeparator();

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        String[] stringArray = content.split(separator);

        return Arrays.stream(stringArray)
                .filter(s -> !s.isEmpty() && s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void writeNumbersToFile(int[] numbers, String filePath) throws IOException {
        String separator = System.lineSeparator();

        String content = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(separator));

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        Files.write(path, content.getBytes());
    }

    @Test
    public void testSortFiles() throws IOException {
        String[] fileNames = {"data_medium", "data_small", "data_reverse_sorted", "data_sorted"};

        for (String fileName : fileNames) {
            String inputFilePath = "static/" + fileName + ".txt";
            String outputFilePath = "static/" + fileName + "_sorted.txt";

            int[] unsortedArray = readNumbersFromFile(inputFilePath);

            long startTime = System.currentTimeMillis();

            InsertionSorter insertionSorter = new InsertionSorter(unsortedArray);
            insertionSorter.sort();

            long finishTime = System.currentTimeMillis();
            long elapsedTime = finishTime - startTime;

            int[] sortedArray = insertionSorter.getData();
            writeNumbersToFile(sortedArray, outputFilePath);

            System.out.println(fileName + " - Start: " + startTime + ", Finish: " + finishTime + ", Elapsed: " + elapsedTime + " ms");
        }
    }


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