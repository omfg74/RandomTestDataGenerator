package com.omfgdevelop.test.data.simpleGenerators;

import java.util.Random;

public class NameGenerator implements SimpleEntityGenerator<String> {


    @Override
    public String generateRandom() {

        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        String chars = "абвгдежзиклмнопрстуфхцчшщэюя";
        int randomDigit = r.nextInt(12)+3;
        for (int i = 0; i < randomDigit; i++) {
            char randomChar = (char) (chars.charAt(new Random().nextInt(chars.length())));
            sb.append(randomChar);
        }
        String name =sb.toString();
        String cap= name.substring(0,1).toUpperCase()+name.substring(1);
        return cap;
    }
}
