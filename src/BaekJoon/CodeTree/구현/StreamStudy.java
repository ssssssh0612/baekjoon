package BaekJoon.CodeTree.구현;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> streamInteger = list.stream();
        streamInteger.forEach(i -> System.out.print(i + " "));


    }
}
