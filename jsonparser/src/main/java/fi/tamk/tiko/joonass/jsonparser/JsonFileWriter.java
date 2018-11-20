package fi.tamk.tiko.joonass.jsonparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {
    File file;

    public JsonFileWriter(String fileName){
        file = new File(fileName);
    }
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
