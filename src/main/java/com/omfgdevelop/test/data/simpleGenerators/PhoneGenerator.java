package com.omfgdevelop.test.data.simpleGenerators;


import java.util.Random;

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

    private String generatePrefix() {
        String[] str = new String[]{"900", "905", "906", "999", "912", "918"};
        return str[random.nextInt(str.length - 1)];
    }
}
