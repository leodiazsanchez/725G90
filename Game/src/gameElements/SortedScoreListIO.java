package gameElements;

import java.io.*;
import java.util.Scanner;

/**

 The SortedScoreListIO class provides methods to save and load SortedScoreList objects from files.
 */
public class SortedScoreListIO {

    /**

     Saves a SortedScoreList object to a file with the specified filename.
     @param scores the SortedScoreList object to save
     @param filename the filename to save the SortedScoreList object to
     */
    public static void saveToFile(SortedScoreList scores, String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + filename);
                } else {
                    System.out.println("File already exists: " + filename);
                }
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (int i = 0; i < scores.size(); i++) {
                    writer.println(scores.get(i));
                }
                System.out.println("Scores saved to: " + filename);
            }

        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
    /**

     Loads a SortedScoreList object from a file with the specified filename.
     @param filename the filename to load the SortedScoreList object from
     @return the SortedScoreList object loaded from the file
     */

    public static SortedScoreList readFromFile(String filename) {
        SortedScoreList scores = new SortedScoreList();

        try {
            // Use absolute path for simplicity
            File file = new File(filename);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + filename);
                } else {
                    System.out.println("File already exists: " + filename);
                }
            }

            // Read from file
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    try {
                        Integer score = Integer.parseInt(scanner.nextLine().trim());
                        scores.add(score);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid score format: " + e.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return scores;
    }


}