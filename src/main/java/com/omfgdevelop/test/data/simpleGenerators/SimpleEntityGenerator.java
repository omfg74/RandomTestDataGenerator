package com.omfgdevelop.test.data.simpleGenerators;

/**
 * Базовый интерфейс предоставляющий доступ к случайным генераторам
 * @param <T>
 */
public interface SimpleEntityGenerator<T> {
    /**
     * Простой пример метода для вызова процесса случайной генерации
     */
    T generateRandom();

}
