package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            int[] arr= new int[101];
            int caseNumber = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 1000; j ++){
                int number = Integer.parseInt(st.nextToken());
                arr[number]++;
            }
            int maxNum = Integer.MIN_VALUE;
            int maxIndex = Integer.MIN_VALUE;
//            System.out.println(arr[4] + " " + arr[76]);
            for(int j = 0; j < 100; j ++){
                if(maxNum <= arr[j]){
                    maxNum = arr[j];
                    maxIndex = j;
                }
            }
            System.out.println("#"+caseNumber+" "+maxIndex);
        }
    }
}
