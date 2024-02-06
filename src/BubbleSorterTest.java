import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class BubbleSorterTest {

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

            BubbleSorter bubbleSorter = new BubbleSorter(unsortedArray);
            bubbleSorter.sort();

            long finishTime = System.currentTimeMillis();
            long elapsedTime = finishTime - startTime;

            int[] sortedArray = bubbleSorter.getData();
            writeNumbersToFile(sortedArray, outputFilePath);
        }
    }

    @Test
    public void testSortAscending() {
        int[] unsortedArray = {5, 3, 1, 2, 4};
        int[] expectedArray = {1, 2, 3, 4, 5};

        BubbleSorter bubbleSorter = new BubbleSorter(unsortedArray);
        bubbleSorter.sort();

        int[] sortedArray = bubbleSorter.getData();
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public void testSortDuplicateValues() {
        int[] unsortedArray = {5, 3, 1, 2, 4, 3};
        int[] expectedArray = {1, 2, 3, 3, 4, 5};

        BubbleSorter bubbleSorter = new BubbleSorter(unsortedArray);
        bubbleSorter.sort();

        int[] sortedArray = bubbleSorter.getData();
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public void testSortNegativeValues() {
        int[] unsortedArray = {-5, -3, -1, -2, -4};
        int[] expectedArray = {-5, -4, -3, -2, -1};

        BubbleSorter bubbleSorter = new BubbleSorter(unsortedArray);
        bubbleSorter.sort();

        int[] sortedArray = bubbleSorter.getData();
        assertArrayEquals(expectedArray, sortedArray);
    }


}
