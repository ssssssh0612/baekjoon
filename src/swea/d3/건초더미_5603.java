package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 건초더미_5603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int length = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j = 0; j < length; j++) {
                int number = Integer.parseInt(br.readLine());
                list.add(number);
                sum += number;
            }
            Collections.sort(list);
            int check = sum / length;
            int result = 0;
            for (int j = list.size() - 1; j >= 0 ; j--) {
                if(list.get(j) > check){
                    result = result + list.get(j) - check;
                }else{
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
