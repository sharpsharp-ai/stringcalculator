package de.sharpsharp.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator sc = new StringCalculator();

    @Test
    public void test1() {
        assertEquals(0, sc.add(""));
    }

    @Test
    public void test2() {
        assertEquals(1, sc.add("1"));
        assertEquals(3, sc.add("1,2"));
        assertEquals(6, sc.add("1,2,3"));
        assertEquals(10, sc.add("1,2,3,4"));
        assertEquals(15, sc.add("1,2,3,4,5"));
        assertEquals(21, sc.add("1,2,3,4,5,6"));
    }

    @Test
    public void test3() {
        assertEquals(6, sc.add("1\n2,3"));
    }

    @Test
    public void test4() {
        assertEquals(3, sc.add("//;\n1;2"));
    }

    @Test
    public void test5() {
        try {
            sc.add("1,-2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: -2", e.getMessage());
        }
    }

    @Test
    public void test6() {
        try {
            sc.add("-1,-2,3");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: -1,-2", e.getMessage());
        }
    }

    @Test
    public void test7() {
        assertEquals(2, sc.add("2,1001"));
        assertEquals(1002, sc.add("2,1000"));
    }

    @Test
    public void test8() {
        assertEquals(6, sc.add("//[***]\n1***2***3"));
    }

    @Test
    public void test9() {
        assertEquals(6, sc.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void test10() {
        assertEquals(6, sc.add("//[**][%%]\n1**2%%3"));
    }

    @Test
    public void test11() {
        sc.add("1,2");
    }

    @Test
    public void testCounter() {
        sc.add("1");
        sc.add("2");
        assertEquals(2, sc.c);
    }
}
