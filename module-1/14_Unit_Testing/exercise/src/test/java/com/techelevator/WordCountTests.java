package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {

    @Test
    public void givenString_shouldReturnNumOfTimesWordOccurs() {
        WordCount normalSituation = new WordCount();
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 2);
        Map<String, Integer> result = normalSituation.getCount(new String[]{"a", "b", "c", "a", "b", "c"});
        Assert.assertEquals(expected, result);
    }

//    @Test
//    public void givenNull_shouldReturnEmptyMap() {
//        WordCount nullArray = new WordCount();
//        Map<String, Integer> expected = new HashMap<>();
//        Map<String, Integer> result = nullArray.getCount(new String[]{""});
//        Assert.assertEquals(expected, result);
//    }
}
