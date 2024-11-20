import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            
            while ((line = br.readLine()) != null) {

                String word = line.trim().toLowerCase();
                

                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    bw.write(entry.getKey() + " " + entry.getValue());
                    bw.newLine();
                }
            }
            
            System.out.println("Word count written to " + outputFile);
            
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
