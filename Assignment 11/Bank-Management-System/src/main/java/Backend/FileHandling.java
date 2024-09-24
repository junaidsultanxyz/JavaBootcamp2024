
package Backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Junaid Sultan
 */

public class FileHandling {
    public static <T extends Serializable> void WriteData(ArrayList<T> list, String filename) {
//        clearFile(filename);
        
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(list);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static <T extends Serializable> ArrayList<T> ReadDate(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // Read the list from the file and cast it to the correct type
            return (ArrayList<T>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void clearFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
