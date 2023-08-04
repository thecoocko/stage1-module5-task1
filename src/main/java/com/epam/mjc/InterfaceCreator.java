package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s : list) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };

        }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> even = new ArrayList<>();
            for(Integer i : list){
                if(i%2==0){
                    even.add(i);
                }
            }
            list.addAll(even);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->{
            List<String> result = new ArrayList<>();
            for(String value : values){
                if(Character.isUpperCase(value.charAt(0))
                        && value.charAt(value.length()-1)==".".charAt(0)
                        && value.split(" ").length > 3){
                    result.add(value);
                }
            }
            return result;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String,Integer> resultMap = new HashMap<>();
       return x->{
           for(String item : x){
               resultMap.put(item,item.length());
           }
           return resultMap;
       };
    }
/**Implement the program which return BiFunction<List<Integer>, List<Integer>, List<Integer>>.
 * Function should return new List which store values from first and second lists.*/
    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> concated = new ArrayList<>();
            concated.addAll(list1);
            concated.addAll(list2);
            return concated;
        };
    }
}
