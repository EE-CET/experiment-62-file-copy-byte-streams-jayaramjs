import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {
    public static void main(String[] args) {
        // Use relative paths as per requirements
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        // Part 1: Copying the File
        // Try-with-resources handles multiple streams separated by a semicolon
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            int byteData;
            
            // read() returns -1 when the end of the file (EOF) is reached
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("File Copied");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return; // Stop execution if the copy fails
        }

        // Part 2: Displaying the Destination Content
        try (FileInputStream fis = new FileInputStream(destFile)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                // Cast the integer byte to char to display as text
                System.out.print((char) byteData);
            }
            System.out.println(); // New line after content
        } catch (IOException e) {
            System.out.println("Error reading destination: " + e.getMessage());
        }
    }
}
