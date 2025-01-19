package BaekJoon.CodeTree.modernjava;

import BaekJoon.CodeTree.modernjava.appleFilter.AppleFilter;

import java.util.List;

public class ServiceApple {

//    각각의 사과 무게를 추력하도록 지시할 수 있다.
//    각각의 사과가 무거운지, 가벼운지 출력하도록 지시할 수 있다.
    public static void prettyPrintApple(List<Apple> inventory, AppleFilter appleFilter){
        for( Apple apple : inventory ){
            String output = appleFilter.printApple(apple);
            System.out.println(output);
        }
    }
}
