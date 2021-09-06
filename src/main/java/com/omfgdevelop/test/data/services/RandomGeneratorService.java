package com.omfgdevelop.test.data.services;

import com.omfgdevelop.test.data.model.Result;
import com.omfgdevelop.test.data.simpleGenerators.SimpleEntityGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorService extends BaseGenerator implements SimpleTestDataGenerator {

    private final SimpleEntityGenerator<String> phoneGenerator;

    private final SimpleEntityGenerator<String> dateGenerator;

    private final SimpleEntityGenerator<String> groupGenerator;

    private final SimpleEntityGenerator<String> nameGenerator;

    public RandomGeneratorService(SimpleEntityGenerator<String> phoneGenerator, SimpleEntityGenerator<String> dateGenerator, SimpleEntityGenerator<String> groupGenerator, SimpleEntityGenerator<String> nameGenerator, FileProcessor fileProcessor) {
        this.phoneGenerator = phoneGenerator;
        this.dateGenerator = dateGenerator;
        this.groupGenerator = groupGenerator;
        this.nameGenerator = nameGenerator;
        this.fileProcessor = fileProcessor;
    }


    @Override
    public void generate(int iteration) throws IOException {
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < iteration; i++) {
            String name = nameGenerator.generateRandom();
            String lastName = nameGenerator.generateRandom();
            String patronymic = nameGenerator.generateRandom();

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
