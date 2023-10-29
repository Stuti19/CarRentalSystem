import java.io.*;
import java.nio.file.*;
import java.util.*;

public class fileHandling {
    public static void main(String[] args) {
        String filePath = "carInput.txt";
        List<Integer> linesToDelete = Arrays.asList(2, 4, 6);

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> updatedLines = new ArrayList<>();

            for (int i = 0; i < lines.size(); i++) {
                if (!linesToDelete.contains(i + 1)) { // Line numbers start from 1
                    updatedLines.add(lines.get(i));
                }
            }

            Files.write(Paths.get(filePath), updatedLines);
            System.out.println("Lines deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
