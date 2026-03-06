package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크로스워드_1706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                graph[i][j] = ch;
            }
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                char ch = graph[i][j];
                if(ch == '#'){
                    if(sb.length() > 1){
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }else{
                    sb.append(ch);
                }
            }
            if(sb.length() > 1){
                list.add(sb.toString());
            }
        }

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                char ch = graph[j][i];
                if(ch == '#'){
                    if(sb.length() > 1){
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }else{
                    sb.append(ch);
                }
            }
            if(sb.length() > 1){
                list.add(sb.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));



    }
}
