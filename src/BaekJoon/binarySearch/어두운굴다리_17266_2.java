package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266_2 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) + 1;
        int lightCount = Integer.parseInt(br.readLine());
        int[] arr = new int[lightCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lightCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1;
        int right = 100_000;

        while(left < right){
            int mid = (left + right) / 2;
            boolean flag = check(mid,arr);
            if(flag){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);


    }

    public static boolean check(int mid, int[] arr){
        if(arr.length == 1){
            int num = arr[0];
            return num + mid >= n - 1 && num - mid <= 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                int check1 = arr[0] - mid;
                int check2 = arr[0] + mid;
                int middle = arr[0] + arr[1];
                if(middle % 2 == 1){
                    middle++;
                }
                int middleValue = middle / 2;

                if(check1 > 0 || check2 < middleValue){
                    return false;
                }
            }else if(i == arr.length - 1){
                int check1 = arr[i] + mid;
                if(check1 < n - 1){
                    return false;
                }
            }else{
                int check1 = arr[i] + mid;
                int middle = arr[i] + arr[i + 1];
                if(middle % 2 == 1){
                    middle++;
                }
                int middleValue = middle / 2;
                if(check1 < middleValue){
                    return false;
                }
            }
        }
        return true;
    }
}
