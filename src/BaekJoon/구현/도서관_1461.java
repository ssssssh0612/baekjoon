package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 도서관_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            if(arr[i] > 0){
                list1.add(arr[i]);
            }else{
                list2.add(-arr[i]);
            }
        }
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i) + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.print(list2.get(i) + " ");
//        }
//        System.out.println();
        int result = 0;
        // list1, list2 둘중 하나의 사이즈가 0인경우
        if(list1.isEmpty() || list2.isEmpty()){
            // 둘중 하나라도 비었다면
            if(list1.isEmpty()){
                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list2.get(0));
                        list2.remove(0);
                        continue;
                    }

                    if(list2.isEmpty()){
                        break;
                    }else{
                        list2.remove(0);
                    }
                }
                while(!list2.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list2.get(0))*2;
                            list2.remove(0);
                            continue;
                        }
                        if(list2.isEmpty()){
                            break;
                        }else{
                            list2.remove(0);
                        }
                    }
                }
            }else{
                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list1.get(list1.size() - 1));
                        list1.remove(list1.size() - 1);
                        continue;
                    }

                    if(!list1.isEmpty()){
                        list1.remove(list1.size() - 1);
                    }else{
                        break;
                    }
                }
                while(!list1.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list1.get(list1.size() - 1))*2;
                            list1.remove(list1.size() - 1);
                            continue;
                        }

                        if(list1.isEmpty()){
                            break;
                        }else{
                            list1.remove(list1.size() - 1);
                        }
                    }
                }
            }
        }else{
            // 얘는 둘다 빌때까지 ..
            // 둘중 누가 더 큰지 파악하고 먼저할거 생각하기
            if(list1.get(list1.size() - 1) > list2.get(0)){
                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list1.get(list1.size() - 1));
                        list1.remove(list1.size() - 1);
                        continue;
                    }

                    if(!list1.isEmpty()){
                        list1.remove(list1.size() - 1);
                    }else{
                        break;
                    }
                }
                while(!list1.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list1.get(list1.size() - 1))*2;
                            list1.remove(list1.size() - 1);
                            continue;
                        }

                        if(list1.isEmpty()){
                            break;
                        }else{
                            list1.remove(list1.size() - 1);
                        }
                    }
                }

                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list2.get(0)) * 2;
                        list2.remove(0);
                        continue;
                    }

                    if(list2.isEmpty()){
                        break;
                    }else{
                        list2.remove(0);
                    }
                }
                while(!list2.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list2.get(0)) * 2;
                            list2.remove(0);
                            continue;
                        }
                        if(list2.isEmpty()){
                            break;
                        }else{
                            list2.remove(0);
                        }
                    }
                }


            }else{
                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list2.get(0));
                        list2.remove(0);
                        continue;
                    }

                    if(list2.isEmpty()){
                        break;
                    }else{
                        list2.remove(0);
                    }
                }
                while(!list2.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list2.get(0)) * 2;
                            list2.remove(0);
                            continue;
                        }
                        if(list2.isEmpty()){
                            break;
                        }else{
                            list2.remove(0);
                        }
                    }
                }

                for (int i = 0; i < count; i++) {
                    if(i == 0){
                        result += Math.abs(list1.get(list1.size() - 1)) * 2;
                        list1.remove(list1.size() - 1);
                        continue;
                    }

                    if(!list1.isEmpty()){
                        list1.remove(list1.size() - 1);
                    }else{
                        break;
                    }
                }
                while(!list1.isEmpty()){
                    for (int i = 0; i < count; i++) {
                        if(i == 0){
                            result += Math.abs(list1.get(list1.size() - 1))*2;
                            list1.remove(list1.size() - 1);
                            continue;
                        }

                        if(list1.isEmpty()){
                            break;
                        }else{
                            list1.remove(list1.size() - 1);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
