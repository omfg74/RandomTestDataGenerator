package com.omfgdevelop.test.data.simpleGenerators;

import java.util.Random;

/**
 * Генератор случайных названий групп
 */
public class GroupGenerator implements SimpleEntityGenerator<String>{
    @Override
    public String generateRandom() {
        return "Group "+new Random().nextInt(9);
    }
}
