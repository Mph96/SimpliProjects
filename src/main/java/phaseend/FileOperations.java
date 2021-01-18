package phaseend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static phaseend.Variables.*;
import static phaseend.MenuOperations.*;

/*Case sensitivity is not implemented at this time throughout my file operations.
 * Reason being that file explorer automatically detects files of the same name(regardless of case).
 * My program already adds a way to differentiate files of the same name in order to avoid this issue
 * Every file operation has the ability to return back to the menu. */

public class FileOperations {

    /* From SimpliLearn
    -Add a file to the existing directory list
    -You can ignore the case sensitivity of the file names
    Files are able to be added to the existing directory list.*/

    public void add() throws IOException {

        System.out.println("------------------");
        System.out.println("Please provide the name of the file you would like to add to the new directory: " +
                "\nExample: test.txt, picture.png, cat.jpg");

        /* Only the file name is needed because the directory path is provided by the user at the beginning of the application
        * That path is saved so that the user only has to enter it once throughout their use until the application is
        * ended */

        String filePath = scanner.nextLine();
        Path path = Paths.get(filePath);

        /*Checks the entire file path for if the user input exists or not.
        * Provides option to go back to the options menu or to try entering a file again*/

        if (!Files.exists(Paths.get(FOLDER + "/" + filePath))) {
            System.out.println("\nThis file does not exist. Would you like to try again? \n\nType yes or no:");
            String option = scanner.nextLine();
            switch (option) {
                case "yes":
                    add();
                    break;
                case "no":
                    System.out.println("------------------");
                    showFileOperations();
                    break;
            }
            System.out.println("------------------");
            return;
        }

        /*This section will check if the file being added has already been input.
        * If it has, it will provide a numerical means of differentiating from the others.*/

        String newFilePath = NEWFOLDER + "/" + path.getFileName();
        String newPath;
        int inc = 0;
        while (Files.exists(Paths.get(newFilePath))) {
            inc++;
            newPath = NEWFOLDER + "/" + "(" + inc + ")" + path.getFileName();
            newFilePath = newPath;
        }

        /*Will either add the file to the new folder or return the error message.
        * Error message prompts user if they want to try again or return to options menu*/

        try {
            Files.copy(Paths.get(FOLDER + "/" + filePath), Paths.get(newFilePath));
            System.out.println("\n This file has been added \n");
            System.out.println("------------------");
            showFileOperations();
        } catch (IOException e) {
            System.out.println("\nUnable to add this file. Would you like to try again? \nType yes or no:");
            String option = scanner.nextLine();
            switch (option) {
                case "yes":
                    System.out.println("------------------");
                    add();
                    break;
                case "no":
                    System.out.println("------------------");
                    showFileOperations();
                    break;
            }
        }
    }

    /* From SimpliLearn
    * - Return a message if FNF (File not found)
    * Message is returned when a file is not found or if unable to be deleted.
    * A list of files from the new directory list are shown ao users know what can be deleted*/

    public void delete() throws IOException {

        /*This code is the same concept as what is used in the ascension method.
        * It looks into the new folder and pulls all of the files into an array.
        * That array is then printed out in a sorted order for the user to see what they can delete.
        * This will hopefully reduce user input error.*/

        System.out.println("------------------");
        File[] files = new File(NEWFOLDER).listFiles();

        ArrayList<String> sorted = new ArrayList<>();

        assert files != null;
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            sorted.add(file.getName());
        }
        Collections.sort(sorted);
        System.out.println("Here is a list of files in this folder: \n");
        System.out.println(sorted + "\n");
        System.out.println("------------------");

        /*Only file name is needed since folder path is already provided.*/

        System.out.println("Please provide the name of the file you would like to delete:" +
                "\nExample: test.txt, picture.png, cat.jpg");
        String deletePath = scanner.nextLine();
        System.out.println("------------------");

        /*Checks to see if the file exists in the new directory. If not, user will be asked if they would like to try
        * again or to return to file operations.*/

        if (!Files.exists(Paths.get(NEWFOLDER + "/" + deletePath))) {
            System.out.println("File does not exist. Would you like to try again? \n\nType yes or no:");
            String option = scanner.nextLine();
            switch (option) {
                case "yes":
                    delete();
                    break;
                case "no":
                    System.out.println("------------------");
                    showFileOperations();
                    break;
            }
            System.out.println("------------------");
            return;
        }

        /*Will display if the file has been successfully deleted from the folder. An error message is displayed otherwise.
        * Option is given to try again or return to file operations.*/
        try {
            Files.deleteIfExists(Paths.get(NEWFOLDER + "/" + deletePath));
            System.out.println("\n This file has been deleted \n");
            System.out.println("------------------");
            showFileOperations();
        } catch (IOException e) {
            System.out.println("Unable to delete this file. Would you like to try again? \n Type yes or no:");
            String option = scanner.nextLine();
            switch (option) {
                case "yes":
                    delete();
                    break;
                case "no":
                    System.out.println("------------------");
                    showFileOperations();
                    break;
            }
            System.out.println("------------------");
        }
    }

    /* From SimpliLearn
    * - Display the result upon successful operation
    * - Display the result upon unsuccessful operation
    * Both of these are accomplished*/

    public void search() throws IOException {

        /*Only file name is required as the folder path is already provided for the user*/

        System.out.println("------------------");
        System.out.println("Enter a file name to search for: " +
                "\nExample: test.txt, picture.png, cat.jpg");
        String filename = scanner.nextLine();

        /*Checks to see if the file exists in the folder. If it does not exist then the message is displayed
        * to notify user to try again or return to file operations menu*/

        if (Files.exists(Paths.get(NEWFOLDER + "/" + filename))) {
            System.out.println("\nFile " + filename + " was found\n");
            System.out.println("------------------");
            showFileOperations();
        } else {
            System.out.println("\nfile " + filename + " could not be found");
            System.out.println("Would you like to try again? \n Type yes or no:");
            String option = scanner.nextLine();
            switch (option) {
                case "yes":
                    search();
                    break;
                case "no":
                    System.out.println("------------------");
                    showFileOperations();
                    break;
            }
            System.out.println("------------------");
        }
    }

    /*User can choose to show the files in ascending or descending order.*/

    public void ascension() throws IOException {

        /*Searches and pulls all of the files from the original folder path into an array.
        * That array is then sorted in both ascending and descending order for the user to view.
        * Collections is used as it as a built in sort algorithm.*/

        System.out.println("------------------");

        File[] files = new File(FOLDER).listFiles();

        ArrayList<String> sorted = new ArrayList<>();

        assert files != null;
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            sorted.add(file.getName());
        }

        System.out.println("Would you like to display the files in ascending or descending order? " +
                "\nEnter 'ascending' or 'descending' please:");
        String option = scanner.nextLine();
        switch (option) {
            case "ascending":
                Collections.sort(sorted);
                System.out.println("\nHere is the list of files in ascending order:");
                System.out.println(sorted + "\n");
                System.out.println("------------------");
                MainMenu();
                break;
            case "descending":
                sorted.sort(Collections.reverseOrder());
                System.out.println("\nHere is the list of files in descending order:");
                System.out.println(sorted + "\n");
                System.out.println("------------------");
                MainMenu();
                break;
        }
        System.out.println("------------------");

    }
}


