package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int see = Integer.parseInt(st.nextToken());
        int hear = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < see; i ++){
            String name = br.readLine();
            set.add(name);
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i = 0 ; i < hear; i++){
            String name = br.readLine();
            if(set.contains(name)){
                pq.add(name);
            }
        }
        System.out.println(pq.size());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
