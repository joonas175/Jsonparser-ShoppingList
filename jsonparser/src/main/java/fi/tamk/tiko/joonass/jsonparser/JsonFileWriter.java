package fi.tamk.tiko.joonass.jsonparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for writing Json objects in to a file
 *
 * Applies correct formatting to JsonObjects by using JsonStringBuilder
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonFileWriter {
    /**
     * File to be written as
     */
    File file;

    /**
     * Constructor for creating a new file out of given path string.
     * @param fileName File to be written as.
     */
    public JsonFileWriter(String fileName){
        file = new File(fileName);
    }

    /**
     * Constructor for using a pre-existing File
     * @param file File to be saved as
     */
    public JsonFileWriter(File file){
        this.file = file;
    }

    /**
     * Writes given JsonObject into a file.
     *
     * Calls JsonStringBuilder to make the given object into a more readable format. (indents etc.)
     *
     * @param obj Object to be written.
     * @param append If the file should be overwritten or not
     */
    public void write(JsonObject obj, boolean append) {
        //BufferedWriter writer1 = new BufferedWriter(new FileWriter("asd", true));
        try {
            FileWriter writer = new FileWriter(file, append);
            writer.write(JsonStringBuilder.build(obj));
            writer.close();
        } catch (IOException e){
            System.out.println("Could not write to file:");
            e.printStackTrace();
        }
    }
}
