package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 다각형그리기_2641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] add = new int[length];
            int index = 0;
            for (int j = i ; j < i + length; j++) {
                if(j >= length){
                    add[index] = arr[j - length];
                }else{
                    add[index] = arr[j];
                }
                index++;
            }
            list.add(add);
        }
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = change(arr[i]);
        }

        int index1 = 0;
        for (int i = length - 1; i >= 0; i--) {
            arr2[index1] = arr[i];
            index1++;
        }

        for (int i = 0; i < length; i++) {
            int[] add = new int[length];
            int index = 0;
            for (int j = i ; j < i + length; j++) {
                if(j >= length){
                    add[index] = arr2[j - length];
                }else{
                    add[index] = arr2[j];
                }
                index++;
            }
            list.add(add);
        }

        int count = Integer.parseInt(br.readLine());
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int[] check = new int[length];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                check[j] = Integer.parseInt(st.nextToken());
            }

            if(step(check,list)){
                result.add(check);
            }

        }

        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            int[] newArr = result.get(i);
            for (int j = 0; j < newArr.length; j++) {
                sb.append(newArr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean step(int[] check, List<int[]> list){
        for (int i = 0; i < list.size(); i++) {
            int[] isTrue = list.get(i);
            boolean flag = true;
            for (int j = 0; j < check.length; j++) {
                if(isTrue[j] != check[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
    public static int change(int num){
        if(num == 1){
            return 3;
        }else if(num == 2){
            return 4;
        }else if(num == 3){
            return 1;
        }else{
            return 2;
        }
    }
}
