package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀걸이_1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                break;
            }
            String[] str = new String[num];
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                str[i] = br.readLine();
            }

            for (int i = 0; i < (num * 2) - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int student = Integer.parseInt(st.nextToken()) - 1;
                String string = st.nextToken();
                arr[student]++;
            }

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] <= 1){
                    System.out.println(index + " " + str[i]);
                    index++;
                }
            }
        }
    }
}
