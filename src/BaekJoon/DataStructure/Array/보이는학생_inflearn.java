package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 보이는학생_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if( i == 0 ){
                max = list.get(0);
                result++;
            }else if( max < list.get(i) ){
                result++;
                max = list.get(i);
            }
        }
        System.out.println(result);
    }
}
