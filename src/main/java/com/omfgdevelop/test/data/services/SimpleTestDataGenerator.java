package com.omfgdevelop.test.data.services;

import com.omfgdevelop.test.data.model.Result;

import java.io.IOException;
import java.util.List;

public interface SimpleTestDataGenerator {

    void generate(int iteration) throws IOException;

    void writeToConsole(Result result);

    void writeToFileSeparate(List<Result> resultList) throws IOException;

    void writeFileAsJsonList(List<Result> resultList) throws IOException;
}
