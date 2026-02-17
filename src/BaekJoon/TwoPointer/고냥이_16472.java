package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 고냥이_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[26];
        // n이 될때까지
        int start = 0;
        int end = 0;
        int length = 1;
        int count = 1;
        int result = length;
        arr[str.charAt(0) - 97]++;
        while(end < str.length()){
            if(count > n){
                // start를 줄이기
                while(count != n){
                    // 현재 start를 늘리기
                    if(arr[str.charAt(start) - 97] == 1){
                        arr[str.charAt(start) - 97]--;
                        count--;
                        length--;
                        start++;
                    }else{
                        arr[str.charAt(start) - 97]--;
                        length--;
                        start++;
                    }
                }
                result = Math.max(result, length);
            }else {
                // end를 늘리기 n이랑 같아질때까지
                boolean flag = true;
                while(count != n + 1){
                    end++;
                    if(end < str.length()){
                        if(arr[str.charAt(end) - 97] > 0){
                            arr[str.charAt(end) - 97]++;
                            length++;
                        }else{
                            arr[str.charAt(end) - 97]++;
                            length++;
                            count++;
                        }
                    }else{
                        flag = false;
                        break;
                    }
                }
                // 현재 n이랑 같다는 의미이므로 length 최신화
                if(flag){
                    result = Math.max(result, length - 1);
                }else{
                    result = Math.max(result, length);
                }
            }
        }
        System.out.println(result);
    }
}
