package FixingBugs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProjectCode {

/*
    The array is called outside of the methods so that it is not populated with the predefined array each time
    it is called
*/
    static ArrayList<Integer> expenses = new ArrayList<>();

    private static void optionsSelection() {
        String[] theOptions = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        for(String option : theOptions){
            System.out.println(option);
            // display all the Strings mentioned in the String array
        }

        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Here is your updated expense values\n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                            expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        System.out.println("What is the value you are looking for?");
                        int searchValue = sc.nextInt();
                        searchExpenses(expenses, searchValue);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp(); //Use of "closeApp" allows application to close
                        break;
                    default:
                        System.out.println("\n I am unable to recognize the choice you made, please try again. \n");
                        optionsSelection();
                        break;
                        /*I added a call to "optionsSelection so that the user has the opportunity to try calling again,
                        * rather than the app closing and user having to run again */
                }
    }

    private static void closeApp() {
        System.out.println("Closing your application now \n Thank you, and have a nice day!");
        System.exit(0);
        /* the "0" in parenthesis indicates a successful termination of the program */
    }

    private static void searchExpenses(ArrayList<Integer> arrayList, Integer value) {
        boolean foundResult = false;
        //Complete the method
        for (int expense : arrayList){
            // if the value put in by the user matches an element in the array
            if (expense == value) {
                foundResult = true;
                break;
            }
        }
        if (foundResult){
            System.out.println(" \n Hooray! I have the expense listed as: " + value + "\n");
        } else {
            System.out.println(" \n Awww man, I am sorry. I am unable to find the expense listed as: " + value + "\n");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        //Complete the method. The expenses should be sorted in ascending order.
        Collections.sort(arrayList);
        // Use of the Collections library allows the arrayList to be automatically sorted based on the elements found
        // unnecessary to write an entire sorting algorithm by hand in this situation
        System.out.println("Here are your expenses listed in order: \n");
        System.out.println(arrayList+"\n");
    }

    public static void main(String[] args) {
        // Default values of the array
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
}

