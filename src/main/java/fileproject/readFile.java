package fileproject;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class readFile extends fileWriting {

    //This method allows you to read from the existing file
    public void read() throws IOException{

        /*FileReader myReader = new FileReader(textFile);
        BufferedReader bufferedReader = new BufferedReader(myReader);
        String line;
        while ((line = bufferedReader.readLine()) != null)){
        System.out.println(line + " From " + );
        }
        myReader.close();*/


        try (FileReader textReader = new FileReader(textFile); BufferedReader myReader = new BufferedReader(textReader)) {
            String line = myReader.readLine();
            while (line != null){
                System.out.println(line + " From " + textFile);
                line = myReader.readLine();
            }
        }


        /*BufferedReader bufferedReader();
        String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line + " From " + textFile);
            }*/
        }
    }
