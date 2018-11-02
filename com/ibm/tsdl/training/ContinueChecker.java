package com.ibm.tsdl.training;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class handles whether to continue or terminate this program.
*/
class ContinueChecker {
    private static final String DOTTEDLINE = "----------------------------------------";

    /**
     * This method askes whether to continue or terminate this program.
     *
     * @param reply inputted reply "Y" or "N"
     * @param state state of this program to be continued or terminated
     * @return {@code state} which is continue or terminate
    */
    protected String continueOrExit() {
        String reply;
        int state;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to continue? (Y/N) : ");
        while (true) {
            reply = scanner.next();
            if (reply.equalsIgnoreCase("Y")) {
                return 1;
            } else if (reply.equalsIgnoreCase("N")) {
                return 2;
            } else {
                System.err.println("ERROR: the inputted string is incorrect.");
                System.out.print("Input Y or N again: ");
            }
        }
    }

    /**
     * This method outputs the comments according to the state of this program
    */
    protected void outputLastMessage(int state) {
        switch (state) {
            case 1:
                System.out.println(dottedLine);
                break;
            case 2:
                lastMessage("This program was completed successfully.");
//                System.out.println(dottedLine);
//                System.out.println("This program was completed successfully.");
//                System.out.println(dottedLine);
                break;
            case 3:
                lastMessage("This program was terminated abnormally.");
//                System.out.println(dottedLine);
//                System.out.println("This program was terminated abnormally.");
//                System.out.println(dottedLine);
                break;
            default:
                lastMessage("This is an unsupported state.");
//                System.out.println(dottedLine);
//                System.out.println("This is an unsupported state.");
//                System.out.println(dottedLine);
        }
    }

    protected void lastMessage(String message) {
        System.out.println(dottedLine);
        System.out.println(message);
        System.out.println(dottedLine);
    }
}
