package com.omfgdevelop.test.data.services;

import com.omfgdevelop.test.data.model.Result;
import com.omfgdevelop.test.data.simpleGenerators.SimpleDictionaryStringGenerator;
import com.omfgdevelop.test.data.simpleGenerators.UniversalDictionaryStringGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация псевдослучайного сервиса-генератора по словарям. Просто выбирает случайное значение из словарей
 */
public class DictionaryGeneratorService extends BaseGeneratorService {

    private final List<String> names;

    private final List<String> lastNames;

    private final List<String> patronymics;

    private final List<String> birthDates;

    private final List<String> phones;

    private final List<String> groupNames;


    private final SimpleDictionaryStringGenerator<String> dictionaryStringGenerator = new UniversalDictionaryStringGenerator();


    public DictionaryGeneratorService(List<String> names, List<String> lastNames, List<String> patronymics, List<String> birthDates, List<String> phones, List<String> groupName, FileProcessor fileProcessor) {
        this.names = names;
        this.lastNames = lastNames;
        this.patronymics = patronymics;
        this.birthDates = birthDates;
        this.phones = phones;
        this.groupNames = groupName;
        this.fileProcessor = fileProcessor;
    }


    /**
     * Метод инициирующий генерацию
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
            String phoneNumber = dictionaryStringGenerator.generateFromDictionary(phones);
            String birthDay = dictionaryStringGenerator.generateFromDictionary(birthDates);
            String groupName = dictionaryStringGenerator.generateFromDictionary(groupNames);

            Result result = new Result();
            result.setName(name);
            result.setLastName(lastName);
            result.setPatronymic(patronymic);
            result.setBirthDay(birthDay);
            result.setGroupName(groupName);
            result.setPhoneNumber(phoneNumber);
            writeToConsole(result);
            results.add(result);
        }

        //Запись в файл разных объектов
        writeToFileSeparate(results);
        //Запись в файл как список объектов
        writeFileAsJsonList(results);
    }


}
