package fileproject;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        readFile RF = new readFile();
        RF.write();
        RF.append();
        RF.read();

    }
}
