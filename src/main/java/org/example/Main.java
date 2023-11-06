package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        String x = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting(x));
    }

    public static String meeting(String s) {
        String temp = s.toUpperCase();
        String[] pairs = temp.split(";");
        HashMap<String, String> map = new HashMap<>();
        for (String s1 : pairs) {
            String[] keyValue = s1.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        String toString = sortByValue(sortByKey(map)).entrySet().stream()
                .map(e-> "(" + e.getValue()+", "+e.getKey() + ")")
                .collect(Collectors.joining(""));
        return toString;
    }
    public static HashMap<String, String>
    sortByValue(HashMap<String, String> hm)
    {
        List<Map.Entry<String, String> > list
                = new LinkedList<Map.Entry<String, String>>(
                hm.entrySet());
        Collections.sort(
                list,
                new Comparator<Map.Entry<String, String> >() {
                    public int compare(
                            Map.Entry<String, String> object1,
                            Map.Entry<String, String> object2)
                    {
                        return (object1.getValue())
                                .compareTo(object2.getValue());
                    }
                });
        HashMap<String, String> result
                = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> me : list) {
            result.put(me.getKey(), me.getValue());
        }
        return result;
    }
    public static HashMap<String, String>
    sortByKey(HashMap<String, String> hm)
    {
        List<Map.Entry<String, String> > list
                = new LinkedList<Map.Entry<String, String>>(
                hm.entrySet());
        Collections.sort(
                list,
                new Comparator<Map.Entry<String, String> >() {
                    public int compare(
                            Map.Entry<String, String> object1,
                            Map.Entry<String, String> object2)
                    {
                        return (object1.getKey())
                                .compareTo(object2.getKey());
                    }
                });
        HashMap<String, String> result
                = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> me : list) {
            result.put(me.getKey(), me.getValue());
        }
        return result;
    }
}
