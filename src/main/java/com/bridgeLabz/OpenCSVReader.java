package com.bridgeLabz;
import  java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.Reader;
import  java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH="src/main/java/com/bridgeLabz/users.csv";

    public static void main(String[] args) throws IOException , CsvException {
        Reader reader= Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVReader csvreader= new CSVReader(reader);
        //Reading records one by one in a String array
        String[] nextRecord;
        while((nextRecord= csvreader.readNext())!=null){
            System.out.println("Name: "+ nextRecord[0]);
            System.out.println("Email: "+ nextRecord[1]);
            System.out.println("Phone : "+ nextRecord[2]);
            System.out.println("Country: "+ nextRecord[3]);
            System.out.println("************");
        }

    }
}
