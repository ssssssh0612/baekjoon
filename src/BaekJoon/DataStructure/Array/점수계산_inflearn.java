package BaekJoon.DataStructure.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 점수계산_inflearn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count = 1;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if( list.get(i) == 1){
                result += count;
                count++;
            }else{
                count = 1;
            }
        }
        System.out.println(result);
    }
}
