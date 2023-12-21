package com.bridgeLabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class GsonExample {
    private static final String SAMPLE_CSV_FILE_PATH="src/main/java/com/bridgeLabz/user.csv";
    private static final String SAMPLE_JSON_FILE_PATH="src/main/java/com/bridgeLabz/users.json";
    // reading from user.csv and write  in users.json
    public static void main(String[] args) throws IOException, CsvException {
     Reader reader= Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBeanBuilder<CSVUser> csvToBeanBuilder= new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(CSVUser.class);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<CSVUser> csvToBean= csvToBeanBuilder.build();
        List<CSVUser> csvUsers= csvToBean.parse();
        Gson gson = new Gson();
        String json= gson.toJson(csvUsers);
        FileWriter writer= new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
        BufferedReader br= new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
        CSVUser[] usrObj= gson.fromJson(br,CSVUser[].class);
        List<CSVUser> csvUserList= Arrays.asList(usrObj);
    }
}
