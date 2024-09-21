package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 공통원소구하기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }
        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> bList = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(aList);
        Collections.sort(bList);
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        while( start < aList.size() && end < bList.size() ){
            if(aList.get(start) == bList.get(end)){
                result.add(aList.get(start));
                start++;
                end++;
            }else if(aList.get(start) > bList.get(end)){
                end++;
            }else if(aList.get(start) < bList.get(end)){
                start++;
            }
        }
        for(Integer integer : result){
            System.out.print(integer+" ");
        }
    }
}
