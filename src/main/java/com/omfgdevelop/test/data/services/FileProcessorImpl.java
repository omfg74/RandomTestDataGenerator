package com.omfgdevelop.test.data.services;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class FileProcessorImpl implements FileProcessor {
    @Override
    public void writeToFile(String preparedString, String generatorName) throws IOException {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString() + "/generatedResult/";
        Path pathLocal = Paths.get(path);
        if (!Files.exists(pathLocal)){
           File f = new File(String.valueOf(pathLocal));
           f.mkdir();
        }

        File file = new File(path + generatorName + "_result_file_name.txt");
        if (file.exists()) {
            file = new File(path + generatorName + "_result_file_name_" + new Date().getTime() + ".txt");
        }
        boolean did = file.createNewFile();


        FileWriter writer;
        try {
            writer = new FileWriter(file);
            System.out.println("Current path " + file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.append(preparedString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFileToString(String filename) throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource(filename);
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(url.toURI());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        String[] arr = stringBuilder.toString().split(",");
        return Arrays.asList(arr.clone());
    }

    @Override
    public List<LocalDate> readFileToDate(String filename) throws IOException, URISyntaxException, ParseException {
        List<LocalDate> dates = new ArrayList<>();
        List<String> stringDates = readFileToString(filename);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        for (int i = 0; i < stringDates.size(); i++) {
            Date date = sdf.parse(stringDates.get(i));
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            dates.add(localDate);
        }
        return dates;
    }


}
