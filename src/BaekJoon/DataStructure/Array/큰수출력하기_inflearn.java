package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 큰수출력하기_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            if( i == 0 ){
                System.out.print(list.get(0)+" ");
            }else if( list.get(i-1) < list.get(i) ){
                System.out.print(list.get(i)+" ");
            }
        }
    }
}
