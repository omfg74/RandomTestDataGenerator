package com.omfgdevelop.test.data.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface FileProcessor {

    void writeToFile(String preparedString, String generatorName) throws IOException;

    List<String> readFileToString(String filename) throws IOException, URISyntaxException;

    List<LocalDate> readFileToDate(String filename) throws IOException, URISyntaxException, ParseException;


}
