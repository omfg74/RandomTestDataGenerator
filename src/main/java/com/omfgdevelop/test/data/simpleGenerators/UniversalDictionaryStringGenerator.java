package com.omfgdevelop.test.data.simpleGenerators;

import java.util.List;
import java.util.Random;

/**
 * Реализация логики генерации срок из словарей
 */
public class UniversalDictionaryStringGenerator implements SimpleDictionaryStringGenerator<String> {

    private Random rn = new Random();

    /**
     * Простой пример метода для вызова процесса генерации по словарю
     */
    @Override
    public String generateFromDictionary(List<String> list) {
        int nameIterator = rn.nextInt(list.size());
        return list.get(nameIterator);
    }
}
