package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 접미사배열_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        List<String> list = new ArrayList<>();
        list.add(sb.toString());
        while(true){
            sb.delete(0, 1);
            if (sb.toString().equals("")) break;
            list.add(sb.toString());
        }
        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        for(String str1 : list){
            result.append(str1).append("\n");
        }
        System.out.print(result);

    }
}
