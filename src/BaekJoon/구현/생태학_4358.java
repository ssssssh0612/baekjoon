package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 생태학_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        int index = 0;
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            index++;
            map.put(s,map.getOrDefault(s,0.0) + 1.0);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String str : list) {
            double num = map.get(str)*100;
            System.out.println(str + " " + String.format("%.4f", num / (double)index));
        }
    }

}
