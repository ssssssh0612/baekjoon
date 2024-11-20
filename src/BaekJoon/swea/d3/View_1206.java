package BaekJoon.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class View_1206 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int length = Integer.parseInt(bf.readLine());
            int[] arr = new int[length];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j < length - 2; j++) {
                int number = arr[j];
//                System.out.println(number);
                List<Integer> list = new ArrayList<>();
                list.add(arr[j-2]);
                list.add(arr[j-1]);
                list.add(arr[j+1]);
                list.add(arr[j+2]);
                if(number > arr[j - 2] && number > arr[j - 1] &&
                number > arr[j + 1] && number > arr[j + 2]){
                    Collections.sort(list);
                    result += number - list.get(3);
                }
            }
            System.out.println("#"+i+1+" "+result);
            result = 0;
        }
    }
}
