package com.omfgdevelop.test.data.simpleGenerators;


import java.util.Random;

/**
 * Генератор случайных телефонов. Можно ввести дополнительные правила и ограничения для генерации.
 */
public class PhoneGenerator implements SimpleEntityGenerator<String> {
    private final Random random = new Random();

    @Override
    public String generateRandom() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            sb.append(String.valueOf(random.nextInt(9)));
        }
        return "+7" + generatePrefix() + sb.toString();
    }

    /**
     * Генерирует префиксы 9ХХ. Тут нужен как пример некоторого правил случайной генерации.
     * И чтобы результат не выглядел совсем абсурдным
     * @return префикс
     */
    private String generatePrefix() {
        String[] str = new String[]{"900", "905", "906", "999", "912", "918"};
        return str[random.nextInt(str.length - 1)];
    }
}
