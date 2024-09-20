package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 뒤집은_소수 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < a; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            list.add(Integer.parseInt(sb.reverse().toString()));
            if(i == 0){
                max = Integer.parseInt(sb.toString());
            }else{
                max = Math.max(max, Integer.parseInt(sb.toString()));
            }
        }
        int[] arr = new int[max+1];
        List<Integer> resultList = new ArrayList<>();

        for (int i = 2; i <= max ; i++) {
            if(arr[i] == 0){
                checking(arr,i);
                resultList.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if(resultList.contains(list.get(i))){
                System.out.print(list.get(i)+" ");
            }
        }
    }
    public static void checking(int[] arr, int number){
        for (int i = number; i <= arr.length - 1 ; i = i + number ) {
            if(checking1(arr,i)){
                arr[i]++;
            }
        }
    }
    public static boolean checking1(int[] arr, int number){
        return arr.length > number && number >= 0;
    }
}
