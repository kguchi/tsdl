package com.ibm.tsdl.training;

import java.util.List;
import java.io.File;

/**
 * This is the main class of our program.
 * In this program, a file is read and each line is outputted in reverse order on terminal.
 * The target file can be selected from the file directory and you can also add files in that.
 *
 * <p> FileListOperator class processes the file directory and lists the files meeting the configuration.
 * TextFileOperator class handles a selected file.
 * Reading the file and outputting each line is done with TextFileOperator class.
 * ContinueChecker class handles whether to continue or terminate this program.
 * Config class is to define configuration for this program.
*/
public class ReverseFileApplication {
    public static void main(String[] args) {
        FileListOperator fileListOperator = new FileListOperator();
        ContinueChecker continueChecker = new ContinueChecker();

        // state of whether this program is continued or terminated
        int state = 1;

        while (state == 1) {
            // list the names of the files in {@code Config.filePath}
            List<String> fileList = fileListOperator.listFileName();

            // select a file from the {@code fileList}
            File file = fileListOperator.selectFile(fileList);

            TextFileOperator textFileOperator = new TextFileOperator(file);

            // read all the lines in the selected file and put each line in {@code lineList}
            List<String> lineList = textFileOperator.readFile(file);

//            if (lineList != null) {
            if (lineList.size() != 0) {
                // output each line in reverse order
                textFileOperator.reverseAndOutput(lineList);
            } else {
                state = 3;
                continueChecker.outputLastMessage(state);
                break;
            }

            // handle the continuation or termination of this program depending on your reply
            state = continueChecker.continueOrExit();
            continueChecker.outputLastMessage(state);
        }
    }
}
