package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 줄세우기_11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            list1.add(str);
            list2.add(str);
        }
        // 증가하는순
        Collections.sort(list2);
        boolean flag = true;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i).equals(list2.get(i))){
                continue;
            }else{
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("INCREASING");
            return;
        }
        int index = list1.size() - 1;
        boolean flag2= true;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i).equals(list2.get(index))){
                index--;
                continue;
            }else{
                flag2 = false;
                break;
            }
        }
        if(flag2){
            System.out.println("DECREASING");
        }else{
            System.out.println("NEITHER");
        }

    }
}
