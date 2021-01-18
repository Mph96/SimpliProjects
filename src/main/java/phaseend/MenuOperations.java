package phaseend;

import java.io.IOException;

import static phaseend.Variables.scanner;



public class MenuOperations {

    public static void WelcomeScreen() throws IOException{

        /*This is the welcome screen of the application. There is no need for user input here so MainMenu & filePaths
        /*is called as soon as the project information is displayed.  */

        System.out.println("------------------");
        System.out.println("Welcome to LockedMe.com!");
        System.out.println("Developed by: Matthew Hernandez");
        System.out.println("Property of: Lockers Pvt. Ltd");
        System.out.println("------------------");
        Variables.filePaths();
        MainMenu();
    }

    public static void MainMenu() throws IOException {

        /*Prints out user options so that they can navigate the application.*/

        System.out.println("-- MAIN MENU --");
        System.out.println("1) Show files in order");
        System.out.println("2) perform file operations");
        System.out.println("3) Close the application");
        System.out.println("------------------");
        collectionMainMenuOption();
    }

    public static void collectionMainMenuOption() throws IOException {

        /*Takes in the user input so that the application knows where to proceed.*/

        System.out.println("Please choose 1, 2 or 3:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                FileOperations ascending = new FileOperations();
                ascending.ascension();
                break;
            case "2":
                showFileOperations();
            case "3":
                System.out.println("Thanks for using my project. Closing application.");
                System.exit(0);
            default:
                System.out.println("Invalid input provided, please choose 1, 2 or 3");
        }
        MainMenu();
    }

    public static void showFileOperations() throws IOException {

        /*The second menu where specific file operations are listed for the user to view.*/

        System.out.println("------------------");
        System.out.println("1) Add a file to the new folder");
        System.out.println("2) Delete a file from the new folder");
        System.out.println("3) Search for a file in the new folder");
        System.out.println("4) Back to the main menu");
        System.out.println("------------------");
        collectFileOperation();
    }

    public static void collectFileOperation() throws IOException {

        /*User input taken to navigate the file operations.*/

        System.out.println("Please choose 1, 2, 3 or 4:");
        String option = scanner.nextLine();
        switch (option){
            case "1":
                FileOperations addingFile = new FileOperations();
                addingFile.add();
                break;
            case "2":
                FileOperations deletingFile = new FileOperations();
                deletingFile.delete();
                break;
            case "3":
                FileOperations searchingFile = new FileOperations();
                searchingFile.search();
                break;
            case "4":
                MainMenu();
                break;
        }
        showFileOperations();
    }





}
