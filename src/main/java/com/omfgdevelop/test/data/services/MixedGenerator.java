package com.omfgdevelop.test.data.services;

import com.google.gson.Gson;
import com.omfgdevelop.test.data.model.Result;
import com.omfgdevelop.test.data.simpleGenerators.SimpleDictionaryStringGenerator;
import com.omfgdevelop.test.data.simpleGenerators.SimpleEntityGenerator;
import com.omfgdevelop.test.data.simpleGenerators.UniversalDictionaryStringGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация смешанного генератора. Часть значений достается из словаря, часть генерируется случайно
 */
public class MixedGenerator extends BaseGenerator {

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

    /**
     * метод инициирующий генерацию
     * @param iteration количество создаваемых объектов
     * @throws IOException исключение
     */
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

        //Запись в файл разных объектов
        writeToFileSeparate(results);
        //Запись в файл как список объектов
        writeFileAsJsonList(results);
    }


}
