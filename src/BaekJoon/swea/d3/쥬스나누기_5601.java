package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쥬스나누기_5601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < number; j++) {
                sb.append(1+ "/" +number+" ");
            }
            System.out.println("#"+(i+1)+" "+sb);
        }
    }
}
