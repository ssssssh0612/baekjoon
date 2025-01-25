package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 빌런호석_22251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<boolean[]> list = new ArrayList<>();
        list.add(new boolean[]{true, true, true, false, true, true, true});
        list.add(new boolean[]{false, false, true, false, false, true, false});
        list.add(new boolean[]{true, false, true, true, true, false, true});
        list.add(new boolean[]{true, false, true, true, false, true, true});
        list.add(new boolean[]{false, true, true, true, false, true, false});
        list.add(new boolean[]{true, true, false, true, false, true, true});
        list.add(new boolean[]{true, true, false, true, true, true, true});
        list.add(new boolean[]{true, false, true, false, false, true, false});
        list.add(new boolean[]{true, true, true, true, true, true, true});
        list.add(new boolean[]{true, true, true, true, false, true, true});

        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    arr[i][j] = calc(list, i, j);
                }
            }
        }
        // k == 자릿수
        // x == 비교숫자
        int result = 0;
        StringBuilder number2  = new StringBuilder(String.valueOf(x));
        while(number2.length() != k) {
            number2.insert(0,0);
        }
        for(int i = 1 ; i <= n; i++ ){
            if(i== x){
                continue;
            }
            StringBuilder number1 = new StringBuilder(String.valueOf(i));
            while(number1.length() != k) {
                number1.insert(0,0);
            }
            int number = step(number1.toString(), number2.toString(), arr);

            if(number <= p){
                result++;
            }
        }
        System.out.println(result);



    }
    public static int step(String str1 , String str2, int[][]arr){
        int count = 0;
//        System.out.println(str1 + " " + str2);
        for(int i = 0 ; i < str1.length(); i++){
            int number1 = str1.charAt(i) - '0';
            int number2 = str2.charAt(i) - '0';
//            System.out.println(number1 +" "+number2);
            count += arr[number2][number1];
        }
//        System.out.println("count = "+count);
        return count;
    }

    public static int calc(List<boolean[]> list, int number1, int number2) {
        int count = 0;
        for(int i = 0 ; i < 7; i++){
            if(list.get(number1)[i] != list.get(number2)[i]){
                count++;
            }
        }
        return count;
    }
}
