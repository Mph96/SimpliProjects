package fileproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileWriting {
    File textFile = new File("projectFile.txt");

    //This method writes to the file
    public void write() throws IOException{
        try(FileWriter textWriter = new FileWriter(textFile)){
            textWriter.write("Welcome to my file");
        }
    }

    //This method allows you to append to the existing file
    public void append() throws IOException{
        try(BufferedWriter appendWriter = new BufferedWriter(new FileWriter(textFile, true))) {
            appendWriter.newLine();
            appendWriter.write("This is how we start.");
            appendWriter.newLine();
            appendWriter.write("This will be the middle.");
            appendWriter.newLine();
            appendWriter.write("This is how the story ends.");appendWriter.newLine();
            appendWriter.write("This is an appended line.");
        }
    }
}
