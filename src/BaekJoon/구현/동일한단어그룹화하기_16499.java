package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 동일한단어그룹화하기_16499 {
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            if(!step(arr)){
                list.add(arr);
            }
        }
        System.out.println(list.size());
    }
    public static boolean step(int[] arr){
        for (int i = 0; i < list.size(); i++) {
            int[] compare = list.get(i);
            for (int j = 0; j < 26; j++) {
                if(compare[j] != arr[j]){
                    break;
                }

                if(j == 25){
                    return true;
                }
            }
        }
        return false;
    }
}
