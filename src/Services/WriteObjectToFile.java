package Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteObjectToFile {
    private static final String directory = "Files/";

    public static void createFile(Object object) {
        try {
            final Object fObject = object;
            final FileOutputStream fos = new FileOutputStream(directory + fObject.getClass().getSimpleName() + ".ser");
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(fObject);
        } catch (
                FileNotFoundException ex) {
            Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (
                IOException ex) {
            Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}