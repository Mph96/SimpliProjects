package phaseend;

import java.io.IOException;

public class FileMain {

    /*Calls from MenuOperations Class to keep this main as minimal as possible. All of the necessary code is handled
     * within the other classes.*/

    public static void main (String[]args) throws IOException {
        MenuOperations.WelcomeScreen();
        MenuOperations.MainMenu();
    }

}
