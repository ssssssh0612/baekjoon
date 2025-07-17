package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(arr[i], maxNum);
            sum += arr[i];
        }
        int max = Integer.parseInt(br.readLine());

        if(sum <= max){
            System.out.println(maxNum);
            return;
        }

        int resultNum = lowerBound(max, arr);
        int sum1 = sum(arr, resultNum - 1);
        int sum2 = sum(arr, resultNum);
        // 둘다 num 보다 작거나 같음

        if(sum2 == max){
            System.out.println(resultNum);
            return;
        }

        System.out.println(resultNum - 1);



    }

    public static int lowerBound(int num, int[] arr){
        int left = 1;
        int right = num;
        while(left < right){
            int mid = (left + right) / 2;
            int sum = sum(arr, mid);
//            System.out.println(left + " " + mid + " " + right + " " + sum);
            // 같은 숫자가 없으면 처음으로 큰 숫자가 나옴
            if(sum >= num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
//        System.out.println(left);
        return left;
    }
    public static int sum(int[] arr, int mid){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > mid){
                sum += mid;
            }else{
                sum += arr[i];
            }
        }
        return sum;
    }
}


