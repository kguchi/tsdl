package com.ibm.tsdl.training;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * In this class, the contents of the selected file are read and each line is outputted in reverse order.
 *
 * @param file selected file by selectFile method in fileListOperator class
*/
class TextFileOperator{
//    private File file;

//    TextFileOperator(File file) {
//        this.file = file;
//    }

    /** 
     * This method makes it possible to read all lines for the selected file and put each line in {@code lineList}
     *
     * @param line each line of the selected file
     * @param br valiable of BufferedReader
     * @param lineList list of all lines for the selected file
     * @return {@code lineList} when {@code this.file} is found
     * @throws UnsupportedEncodingException when the encoding of {@code this.file} is not supported in Java
     * @throws FileNotFoundException when {@code this.file} is not found
     * @throws IOException when unknown error occurs
     * @throws Exception when unknown error occurs
    */
    protected List<String> readFile(File file) {
        String line;
        BufferedReader br = null;
        List<String> lineList = new ArrayList<>();

    	try (br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Config.encoding))) {
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("The encoding of the file is not supported.");
        } catch (FileNotFoundException e) {
            System.err.println("The file is not found in the File list.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
/*
            if (br != null) {
                try {
    	            br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
*/
            return lineList;
        }
    }

    /** 
     * This method outputs each line in reverse order 
    */
    protected void reverseAndOutput(List<String> lineList) {
    	for (int i = lineList.size() - 1; i >= 0; i --) {
    	    System.out.println(lineList.get(i));
    	}
        System.out.println();
    }
}
