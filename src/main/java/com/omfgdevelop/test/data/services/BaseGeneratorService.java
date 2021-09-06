package com.omfgdevelop.test.data.services;

import com.google.gson.Gson;
import com.omfgdevelop.test.data.model.Result;

import java.io.IOException;
import java.util.List;

/**
 * Базовый класс генератора, ничего не генерирует. Отвечает за постобработку
 */
public abstract class BaseGeneratorService implements SimpleTestDataGeneratorService<Result> {

    protected FileProcessor fileProcessor;

    protected Gson gson = new Gson();


    /**
     * Базовый метод инициирующий генерацию
     * @param iteration количество создаваемых объектов
     * @throws IOException исключение
     */
    public abstract void generate(int iteration) throws IOException;

    /**
     * Метод записывает занные в консоль
     * @param result
     */
    @Override
    public void writeToConsole(Result result) {
        System.out.println(result.toString());
    }

    /**
     * Метод записывает данные в файл как отдельные объекты
     * @param resultList входные параметры
     * @throws IOException исключение
     */
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

    /**
     * Метод записывает данные в файл как список объектов
     * @param resultList входные параметры
     * @throws IOException исключение
     */
    @Override
    public void writeFileAsJsonList(List<Result> resultList) throws IOException {
        fileProcessor.writeToFile(gson.toJson(resultList), getClass().getSimpleName() + "_list");
    }
}
