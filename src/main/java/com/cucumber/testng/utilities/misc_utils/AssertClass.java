package com.cucumber.testng.utilities.misc_utils;

import org.testng.Assert;

public class AssertClass {

    public static void assertEquals (String actual, String expected) {
        Assert.assertEquals(actual,expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    public static void assertFail(String expected){
        Assert.assertTrue(false, expected);
    }

}
