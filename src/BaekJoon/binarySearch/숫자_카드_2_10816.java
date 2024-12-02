package BaekJoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자_카드_2_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
    }

    public static void input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int resultLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultLength; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean check = binarySearch(arr,target);
            if (check) {
                int start = lowerBound(arr,target);
                int end = upperBound(arr,target);
                sb.append(end-start).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int number = arr[mid];
            if (number == target) {
                return true;
            }
            if (number > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static int upperBound(int[] arr , int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            int number = arr[mid];
            if(target < number){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static int lowerBound(int[]arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            int number = arr[mid];
            if(target <= number){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
