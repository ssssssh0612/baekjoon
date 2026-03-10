package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크로스워드퍼즐쳐다보기_3005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] graph = new char[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                char ch = str.charAt(j);
                graph[i][j] = ch;
            }
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x; j++) {
                char ch = graph[i][j];

                if(ch == '#'){
                    if(sb.length() > 1){
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }

                sb.append(ch);
            }

            if(sb.length() > 1){
                list.add(sb.toString());
            }
        }


        for (int i = 0; i < x; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < y; j++) {
                char ch = graph[j][i];

                if(ch == '#'){
                    if(sb.length() > 1){
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                    continue;
                }

                sb.append(ch);
            }

            if(sb.length() > 1){
                list.add(sb.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));

    }
}
