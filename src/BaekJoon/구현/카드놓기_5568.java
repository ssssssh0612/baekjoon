package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 카드놓기_5568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Set<String> set = new HashSet<>();
        if(m == 2){

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i != j){
                        StringBuilder sb = new StringBuilder();
                        sb.append(arr[i]).append(arr[j]);
                        set.add(sb.toString());
                    }
                }
            }

        }else if(m == 3){

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if(i != j && j != k && i != k){
                            StringBuilder sb = new StringBuilder();
                            sb.append(arr[i]).append(arr[j]).append(arr[k]);
                            set.add(sb.toString());
                        }
                    }
                }
            }

        }else{
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < n; k++) {

                        for (int l = 0; l < n; l++) {
                            if(i != j && i != k && i != l && j != k && j != l && k != l){
                                StringBuilder sb = new StringBuilder();
                                sb.append(arr[i]).append(arr[j]).append(arr[k]).append(arr[l]);
                                set.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        System.out.println(set.size());


    }
}
