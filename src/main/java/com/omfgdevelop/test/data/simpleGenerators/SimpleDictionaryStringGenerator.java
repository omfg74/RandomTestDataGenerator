package com.omfgdevelop.test.data.simpleGenerators;

import com.omfgdevelop.test.data.services.FileProcessor;

import java.util.List;

public interface SimpleDictionaryStringGenerator<T> {
    T generateFromDictionary(List<String> list);
}
