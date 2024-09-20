package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두배열합치기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] brr = new int[b];
        for (int i = 0; i < b; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
        int aPointer = 0;
        int bPointer = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (aPointer < a || bPointer < b) {
            if(aPointer == a) {
                list.add(brr[bPointer]);
                bPointer++;
                continue;
            }else if(bPointer == b) {
                list.add(arr[aPointer]);
                aPointer++;
                continue;
            }
            if(arr[aPointer] > brr[bPointer]) {
                list.add(brr[bPointer]);
                bPointer++;
            }else if(arr[aPointer] < brr[bPointer]) {
                list.add(arr[aPointer]);
                aPointer++;
            }else{
                // 같다면
                list.add(arr[aPointer]);
                aPointer++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
