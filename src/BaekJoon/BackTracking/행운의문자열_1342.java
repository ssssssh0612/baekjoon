package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행운의문자열_1342 {
    static int[] arr;
    static int[] number = new int[26];
    static String str;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';
            number[num]++;
        }
        backTracking(0);
        System.out.println(result);
    }
    public static void backTracking(int depth){
        if(depth == str.length()){
            if(check(depth )){
                result++;
            }
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(number[i] > 0){
                if(check(depth)){
                    number[i]--;
                    arr[depth] = i;
                    backTracking(depth + 1);
                    number[i]++;
                }
            }
        }
    }
    //
    // 0 1 2 -> 3
    // a b a
    public static boolean check(int depth){
        if(depth == -1 || depth == 0){
            return true;
        }
        for (int i = 0; i < depth - 1; i++) {
            if(i == 0){
                if(arr[i] == arr[i + 1]){
                    return false;
                }
                continue;
            }
            if(arr[i] == arr[i + 1] || arr[i] == arr[i - 1]){
                return false;
            }
        }
        return true;
    }
}
