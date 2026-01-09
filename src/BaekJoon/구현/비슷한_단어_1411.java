package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 비슷한_단어_1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = list.get(i);
            int size = str.length();

            List<Integer> add = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                char ch = str.charAt(j);
                add.add(j);
                for (int k = j + 1; k < size; k++) {
                    if(ch == str.charAt(k)){
                        add.add(k);
                    }
                }
            }
            graph.add(add);

        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> graph1 = graph.get(i);
                List<Integer> graph2 = graph.get(j);
                if(graph1.size() == graph2.size()){
                    for (int k = 0; k < graph1.size(); k++) {
                        if(!graph1.get(k).equals(graph2.get(k))){
                            break;
                        }
                        if(k == graph1.size() - 1){
                            result ++;
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
}
