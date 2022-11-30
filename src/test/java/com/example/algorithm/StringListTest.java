package com.example.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringListTest {
    ArrayList stringList1;
    String[] array;
    int size = 7;

    @BeforeEach
    public void setUp() {
        stringList1 = new ArrayList();
        array = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", null, null};
        stringList1.setArray(array);
        stringList1.setSize(size);
    }

    @Test
    public void getSize() {
        int sizeExpected = stringList1.size();
        Assertions.assertEquals(size, sizeExpected);
    }

    @Test
    public void set() {
        stringList1.set(1, "qqq");
        String[] expected = {"aaa", "qqq", "ccc", "ddd", "eee", "fff", "ggg", null, null};
        assertThat(stringList1.getArray()).isEqualTo(expected);
    }

    @Test
    public void addWithoutIndex() {
        stringList1.add("abc");
        String[] expected = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "abc", null};
        assertThat(stringList1.getArray()).isEqualTo(expected);
    }

    @Test
    public void addWithIndex() {
        stringList1.add(1, "qwerty");
        String[] expected = {"aaa", "qwerty", "bbb", "ccc", "ddd", "eee", "fff", "ggg", null};
        assertThat(stringList1.getArray()).isEqualTo(expected);
    }

    @Test
    public void removeNotIndex() {
        stringList1.remove("aaa");
        String[] expected = {"bbb", "ccc", "ddd", "eee", "fff", "ggg", null, null, null};
        assertThat(stringList1.getArray()).isEqualTo(expected);
    }

    @Test
    public void removeWithIndex() {
        stringList1.remove(1);
        String[] expected = {"aaa", "ccc", "ddd", "eee", "fff", "ggg", null, null, null};
        assertThat(stringList1.getArray()).isEqualTo(expected);
    }

    @Test
    public void containsElement() {
        boolean a = stringList1.contains("aaa");
        Assertions.assertTrue(a);
    }

    @Test
    public void indexOf() {
        int index = stringList1.indexOf("ddd");
        assertThat(index).isEqualTo(3);
    }

    @Test
    public void lastIndexOf() {
        int index = stringList1.indexOf("ddd");
        assertThat(index).isEqualTo(3);
    }

    @Test
    public void isEmpty() {
        boolean b = stringList1.isEmpty();
        Assertions.assertFalse(b);
    }

}