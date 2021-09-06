package com.omfgdevelop.test.data.simpleGenerators;

import com.omfgdevelop.test.data.services.FileProcessor;

import java.util.List;
import java.util.Random;

public class UniversalDictionaryStringGenerator implements SimpleDictionaryStringGenerator<String> {

    private Random rn = new Random();

    @Override
    public String generateFromDictionary(List<String> list) {

        int nameIterator = rn.nextInt(list.size());
        return list.get(nameIterator);
    }
}
