import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Use relative paths as required by the assignment
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        // Task 1: Copy from source to destination
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            // Required Output line 1
            System.out.println("File Copied");

        } catch (IOException e) {
            // If the file is missing or inaccessible
            return;
        }

        // Task 2: Display the content of the destination file
        try (FileInputStream fis = new FileInputStream(destFile)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                // Cast byte to char to display as text
                System.out.print((char) byteData);
            }
            // Add a newline at the end of the file content
            System.out.println();
        } catch (IOException e) {
            // Handle secondary read error
        }
    }
}
