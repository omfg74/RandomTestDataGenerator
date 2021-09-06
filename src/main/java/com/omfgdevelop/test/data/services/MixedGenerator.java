package com.omfgdevelop.test.data.services;

import com.google.gson.Gson;
import com.omfgdevelop.test.data.model.Result;
import com.omfgdevelop.test.data.simpleGenerators.SimpleDictionaryStringGenerator;
import com.omfgdevelop.test.data.simpleGenerators.SimpleEntityGenerator;
import com.omfgdevelop.test.data.simpleGenerators.UniversalDictionaryStringGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MixedGenerator extends BaseGenerator implements SimpleTestDataGenerator {

    private final List<String> names;

    private final List<String> lastNames;

    private final List<String> patronymics;

    private final Gson gson = new Gson();


    private final SimpleDictionaryStringGenerator<String> dictionaryStringGenerator = new UniversalDictionaryStringGenerator();

    private final SimpleEntityGenerator<String> phoneGenerator;

    private final SimpleEntityGenerator<String> dateGenerator;

    private final SimpleEntityGenerator<String> groupGenerator;

    public MixedGenerator(List<String> names, List<String> lastNames, List<String> patronymics, FileProcessor fileProcessor, SimpleEntityGenerator<String> phoneGenerator, SimpleEntityGenerator<String> dateGenerator, SimpleEntityGenerator<String> groupGenerator) {
        this.names = names;
        this.lastNames = lastNames;
        this.patronymics = patronymics;
        this.fileProcessor = fileProcessor;
        this.phoneGenerator = phoneGenerator;
        this.dateGenerator = dateGenerator;
        this.groupGenerator = groupGenerator;
    }

    @Override
    public void generate(int iteration) throws IOException {
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < iteration; i++) {
            String name = dictionaryStringGenerator.generateFromDictionary(names);
            String lastName = dictionaryStringGenerator.generateFromDictionary(lastNames);
            String patronymic = dictionaryStringGenerator.generateFromDictionary(patronymics);

            String phone = phoneGenerator.generateRandom();

            String birthday = dateGenerator.generateRandom();

            String group = groupGenerator.generateRandom();

            Result result = new Result();
            result.setName(name);
            result.setLastName(lastName);
            result.setPatronymic(patronymic);
            result.setBirthDay(birthday);
            result.setGroupName(group);
            result.setPhoneNumber(phone);
            writeToConsole(result);
            results.add(result);
        }

        writeToFileSeparate(results);
        writeFileAsJsonList(results);
    }


}
