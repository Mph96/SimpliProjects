package phaseend;

import java.util.Scanner;

public class Variables {

    /*Declaration of variables that will be used throughout the rest of the program.*/

    static Scanner scanner = new Scanner(System.in);

    static String FOLDER = null;

    static String NEWFOLDER = null;

    /*This method takes in the user inputs for the full paths to both the original file folder and
    * the new file folder.*/

    public static void filePaths(){

        System.out.println("------------------");
        System.out.println("Enter the path to the folder you would like to add from: \n" +
                "Example: 'C:\\Users\\matth\\Documents\\testfiles' ");
        FOLDER = scanner.nextLine();
        System.out.println("------------------");
        System.out.println("Please enter the path to the folder that you would files to be added to: \n" +
                "Example: 'C:\\Users\\matth\\Documents\\testfiles' ");
        NEWFOLDER = scanner.nextLine();
        System.out.println("------------------");

    }






}
