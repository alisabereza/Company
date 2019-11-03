package Services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectFromFile {
    private static final String filepath = "Files/";

    public static Object readFile(String filename) {
        Object object = new Object();
        try (FileInputStream fin = new FileInputStream(filepath + filename)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = ois.readObject();
            System.out.println(object.getClass().getSimpleName());

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Class not found or was recently changed");
        }
        return object;
    }

}
