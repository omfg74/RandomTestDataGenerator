package com.omfgdevelop.test.data.simpleGenerators;

import java.util.List;

/**
 * Базовый интерфейс предоставляющий доступ к генераторам по словарям.
 * @param <T>
 */
public interface SimpleDictionaryStringGenerator<T> {

    /**
     * Простой пример метода для вызова процесса генерации
     */
    T generateFromDictionary(List<String> list);
}
