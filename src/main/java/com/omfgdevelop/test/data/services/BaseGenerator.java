package com.omfgdevelop.test.data.services;

import com.google.gson.Gson;
import com.omfgdevelop.test.data.model.Result;

import java.io.IOException;
import java.util.List;

public abstract class BaseGenerator implements SimpleTestDataGenerator{

    protected FileProcessor fileProcessor;

    protected Gson gson = new Gson();

    @Override
    public void generate(int iteration) throws IOException {

    }

    @Override
    public void writeToConsole(Result result) {
        System.out.println(result.toString());
    }

    @Override
    public void writeToFileSeparate(List<Result> resultList) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            String resultString = gson.toJson(resultList.get(i));
            sb.append(resultString);
            sb.append("\n");
        }
        fileProcessor.writeToFile(sb.toString(), getClass().getSimpleName());
    }

    @Override
    public void writeFileAsJsonList(List<Result> resultList) throws IOException {
        fileProcessor.writeToFile(gson.toJson(resultList),getClass().getSimpleName()+"_list");
    }
}
