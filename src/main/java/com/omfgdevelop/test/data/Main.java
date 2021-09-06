package com.omfgdevelop.test.data;

import com.omfgdevelop.test.data.services.*;
import com.omfgdevelop.test.data.simpleGenerators.DateGenerator;
import com.omfgdevelop.test.data.simpleGenerators.GroupGenerator;
import com.omfgdevelop.test.data.simpleGenerators.NameGenerator;
import com.omfgdevelop.test.data.simpleGenerators.PhoneGenerator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

public class Main {

    public static int ITERATIONS = 3;

    public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
        FileProcessor fileProcessor = new FileProcessorImpl();
        List<String> names = fileProcessor.readFileToString("names.txt");
        List<String> lastNames = fileProcessor.readFileToString("lastNames.txt");
        List<String> phones = fileProcessor.readFileToString("phones.txt");
        List<String> patronymics = fileProcessor.readFileToString("patronymics.txt");
        List<String> groups = fileProcessor.readFileToString("groups.txt");
        List<String> birthDates = fileProcessor.readFileToString("birthDates.txt");


        SimpleTestDataGenerator dictionaryDataGenerator = new DictionaryGeneratorService(names, lastNames, patronymics, birthDates, phones, groups, fileProcessor);
        dictionaryDataGenerator.generate(ITERATIONS);

        SimpleTestDataGenerator mixedGenerator = new MixedGenerator(names, lastNames, patronymics, fileProcessor, new PhoneGenerator(), new DateGenerator(), new GroupGenerator());
        mixedGenerator.generate(ITERATIONS);

        SimpleTestDataGenerator randomGenerator = new RandomGeneratorService(new PhoneGenerator(), new DateGenerator(), new GroupGenerator(), new NameGenerator(), fileProcessor);
        randomGenerator.generate(ITERATIONS);
    }


}
