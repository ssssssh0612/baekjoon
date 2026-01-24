package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DNA_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int[] arr = new int[26];

            for (int j = 0; j < n; j++) {
                int num = list.get(j).charAt(i) - 'A';
                arr[num]++;
            }

            int max = Integer.MIN_VALUE;
            int index = 0;

            for (int j = 0; j < 26; j++) {
                if(max < arr[j]){
                    max = arr[j];
                    index = j;
                }
            }

            sb.append((char)(index + 'A'));

        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < size; j++) {
                char ch1 = list.get(i).charAt(j);
                char ch2 = sb.charAt(j);
                if(ch1 != ch2){
                    count++;
                }
            }
        }

        System.out.println(sb);
        System.out.println(count);
    }
}
