package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대길이연속부분수열_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int oneLength = 0;
        int result = 0;
        while(end < length && start < length){
            if(count == zeroCount){
                if(arr[end] == 0){
                    if(arr[start] == 0){
                        zeroCount--;
                        start++;
                    }else if(arr[start] == 1){
                        oneLength--;
                        start++;
                    }
                }else if(arr[end] == 1){
                    end++;
                    oneLength++;
                    result = Math.max(result, oneLength);
                }
            }else if(count < zeroCount){
                if(arr[end] == 0){
                    zeroCount++;
                    oneLength++;
                    end++;
                    result = Math.max(result, oneLength);
                }else if(arr[end] == 1){
                    oneLength++;
                    end++;
                    result = Math.max(result, oneLength);
                }
            }
        }
        System.out.println(result);
    }
}
