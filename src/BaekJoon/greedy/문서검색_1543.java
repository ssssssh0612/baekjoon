package BaekJoon.greedy;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색_1543 {
    static int RESULT = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] result = br.readLine().toCharArray();
        boolean[] visited = new boolean[str.length];
        step(visited, str, result);

    }
    public static void step(boolean[] visited , char[] str, char[] result ){
        for (int i = 0; i < str.length; i++) {
            if(str[i] == result[0] && !visited[i]){
                // 처음이 같으면
                int resultIndex = 0;
                int count = 0;
                for (int j = i; j < i + result.length; j++) {
                    if(j < str.length && str[j] == result[resultIndex]){
                        count++;
                        resultIndex++;
                    }else{
                        break;
                    }
                }
                if(count == result.length){
                    for (int j = i; j < i + result.length; j++) {
                        visited[j] = true;
                    }
                    RESULT++;
                }
            }
        }
        System.out.println(RESULT);
    }
}
