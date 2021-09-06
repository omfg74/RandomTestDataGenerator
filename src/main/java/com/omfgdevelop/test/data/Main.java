package com.omfgdevelop.test.data;

import com.omfgdevelop.test.data.services.*;
import com.omfgdevelop.test.data.simpleGenerators.DateGenerator;
import com.omfgdevelop.test.data.simpleGenerators.GroupGenerator;
import com.omfgdevelop.test.data.simpleGenerators.NameGenerator;
import com.omfgdevelop.test.data.simpleGenerators.PhoneGenerator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static int ITERATIONS = 3;

    public static void main(String[] args) throws IOException, URISyntaxException {

        FileProcessor fileProcessor = new FileProcessorImpl();

        List<String> names = fileProcessor.readFileToString("names.txt");
        List<String> lastNames = fileProcessor.readFileToString("lastNames.txt");
        List<String> phones = fileProcessor.readFileToString("phones.txt");
        List<String> patronymics = fileProcessor.readFileToString("patronymics.txt");
        List<String> groups = fileProcessor.readFileToString("groups.txt");
        List<String> birthDates = fileProcessor.readFileToString("birthDates.txt");


        BaseGeneratorService dictionaryDataGenerator = new DictionaryGeneratorServiceService(names, lastNames, patronymics, birthDates, phones, groups, fileProcessor);
        dictionaryDataGenerator.generate(ITERATIONS);

        BaseGeneratorService mixedGenerator = new MixedGeneratorService(names, lastNames, patronymics, fileProcessor, new PhoneGenerator(), new DateGenerator(), new GroupGenerator());
        mixedGenerator.generate(ITERATIONS);

        BaseGeneratorService randomGenerator = new RandomGeneratorServiceService(new PhoneGenerator(), new DateGenerator(), new GroupGenerator(), new NameGenerator(), fileProcessor);
        randomGenerator.generate(ITERATIONS);
    }


}
