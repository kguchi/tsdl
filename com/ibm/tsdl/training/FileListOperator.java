package com.ibm.tsdl.training;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class processes file directory.
 * The files meeting the configuration are listed and one of them can be selected.
*/
class FileListOperator {
    /** 
     * In this method, the names of the files in {@code Config.filePath} are read and listed. 
     * The extension, size and count of the listed file are configured in Config class.
     *
     * @param i index for the file
     * @param fileDir directory where files are stored
     * @param fileList list containing all files
     * @param files all files in {@code fileList}
     * @param file each file in {@code fileList}
     * @return {@code fileList} 
    */
    protected List<String> listFileName() {
        int i = 1;
        File fileDir = new File(Config.filePath);
        List<String> fileList = new ArrayList<String>();
        File[] files = fileDir.listFiles();
        System.out.println("[File list]");
        for (File file: files) { 
            if (!(isFileExtensionSupported(file.getName()))) { 
                continue;
            }

            if (!(isFileSizeSupported(file))) {
                continue;
            }

            if (!(isCountOfFileSupported(fileList))) {
                break;
            }

    	    System.out.println(i + ". " + file.getName());
            fileList.add(file.getName());
            i ++;
    	}
        System.out.println();
        return fileList;
    }

    /** 
     * This is a method for checking the extension of the file.
     *
     * @return {@code true} if the extension of the file is supported.
    */
    private boolean isFileExtensionSupported(String fileName) {
        int point = fileName.lastIndexOf(".");
        String fileExtension = null;

        if (point != -1) {
            fileExtension = fileName.substring(point + 1);
        }
        return Arrays.asList(Config.fileExtensions).contains(fileExtension);
    }

    /** 
     * This is a method for checking the file size.
     *
     * @return {@code true} if the file size is less than the supported size.
    */
    private boolean isFileSizeSupported(File file) {
        return file.length() <= Config.maximumFileSize;
    }

    /** 
     * This is a method for checking the count of files in {@code fileList}.
     *
     * @return {@code true} if the count of files is less than the supported number.
    */
    private boolean isCountOfFileSupported(List fileList) {
        return fileList.size() < Config.maximumFileNumber;
    }

    /**
     * You can select a file from {@code fileList} by inputting the attached number.
     *
     * @param fileNumber number attached to the file in {@code fileList}
     * @param fileName name of the selected file
     * @return {@code file}
     * @throws IndexOutOfBoundsException when {@code fileNumber <= 0 || fileNumber > fileList.size()}
     * @throws InputMismatchException when {@code fileNumber instanceof String}
     * @throws Exception when unknown error occurs
    */
    protected File selectFile(List<String> fileList) {
        Scanner scanner = new Scanner(System.in);
        int fileNumber;
        String fileName;
        System.out.print("select a file number: ");

        while (true) {
            try {
                fileNumber = scanner.nextInt();
                fileName = fileList.get(fileNumber - 1);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("ERROR: the file which is specified by the inputted number does not exist.");
            } catch (InputMismatchException e) {
                System.err.println("ERROR: the format of the inputted string is incorrect.");
                scanner = new Scanner(System.in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("select a correct file number again: ");
        }
        File file = new File(Config.filePath + fileName);
        return file;
    }
}
