package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CollectionTests {

//Массив
    @Test
    void arrayTests() {
        /*var array = new String[]{"a", "b", "c"};*/
        var array = new String[3];
        Assertions.assertEquals(3, array.length);
        array[0] = "a";
        /*Assertions.assertEquals("a", array[0]);*/

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);
    }


//Список
    @Test
    void listTests() {
        //var listt = List.of("a", "b", "c");
        var listt = new ArrayList<>(List.of("a", "b", "c"));
        //listt.add("a");
        //listt.add("b");
        //listt.add("c");
        Assertions.assertEquals(3, listt.size());
        Assertions.assertEquals("a", listt.get(0));

        listt.set(0, "d");
        Assertions.assertEquals("d", listt.get(0));
    }

    @Test
    void setTests(){
        var set = new HashSet<>(List.of("a", "b", "c", "a"));
        Assertions.assertEquals(3, set.size());

        set.add("d");
        Assertions.assertEquals(4, set.size());
    }

    @Test
    void testMap () {
        var digits = new HashMap<Character, String>();
        digits.put('1', "one");
        digits.put('2', "two");
        digits.put('3', "three");
    }
}


