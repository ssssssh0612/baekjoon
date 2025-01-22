package BaekJoon.BaekJoonDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class dp1_2_3더하기_4 {
    public static void main(String[] args) throws IOException {

        List<String> sentences = List.of("Hello", "Java");
        List<String[]> wordArrays = sentences.stream()
                .map(sentence -> sentence.split("")) // 문자열을 배열로 변환
                .collect(Collectors.toList());
        System.out.println(wordArrays);
        for(String[] str : wordArrays){
            for(int i = 0 ; i < str.length; i++){
                System.out.print(str[i] + " ");
            }
            System.out.println();
        }
// 결과: [[Hello, World], [Java, Streams]]

    }
}
