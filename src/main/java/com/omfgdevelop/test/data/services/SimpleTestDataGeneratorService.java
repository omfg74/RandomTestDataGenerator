package com.omfgdevelop.test.data.services;

import com.omfgdevelop.test.data.model.Result;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс предоставляющий доступ к различным реализациям сервисов генерации
 */
public interface SimpleTestDataGeneratorService<T> {


    /**
     * Метод записывает занные в консоль
     * @param result
     */
    void writeToConsole(T result);

    /**
     * Метод записывает данные в файл как отдельные объекты
     * @param resultList входные параметры
     * @throws IOException исключение
     */
    void writeToFileSeparate(List<T> resultList) throws IOException;

    /**
     * Метод записывает данные в файл как список объектов
     * @param resultList входные параметры
     * @throws IOException исключение
     */
    void writeFileAsJsonList(List<T> resultList) throws IOException;
}
