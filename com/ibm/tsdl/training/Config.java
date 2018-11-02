package com.ibm.tsdl.training;

/**
 * This class is to define configuration for this program.
 *
 * @param filePath relative path where the files are stored
 * @param maximumFileNumber maximum number of files in the file list
 * @param maximumFileSize maximum size of a file
 * @param fileExtensions supported extensions of files
 * @param encoding supported encoding of the files
*/
public final class Config {
    protected static final String filePath = "./file/";
    protected static final int maximumFileNumber = 100;
    protected static final int maximumFileSize = 50 * 1024 * 1024;
    protected static final String[] fileExtensions = {"csv", "txt", "log"};
    protected static final String encoding = "UTF-8";
}
