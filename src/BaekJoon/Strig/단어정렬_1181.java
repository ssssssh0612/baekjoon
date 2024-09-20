package BaekJoon.Strig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Set<Node> list = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String a = br.readLine();
            Node node = new Node(a);
            list.add(node);
        }
        List<Node> result = new ArrayList<>();
        for (Node node : list) {
            result.add(node);
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            String str = result.get(i).getStr();
            if( i > 0 && !result.get(i-1).getStr().equals(str)) {
                System.out.println(str);
            }
            if (i == 0) {
                System.out.println(str);
            }
        }



    }

    public static class Node implements Comparable<Node>{
        String str;
        int length;
        int number;
        public Node(String str){
            for (int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);
                this.number += (int)a;
            }
            this.str = str;
            this.length = str.length();
        }
        public String getStr(){
            return this.str;
        }

        // Comparable 구현
        @Override
        public int compareTo(Node other) {
            // 1. 먼저 length 기준으로 정렬
            int lengthComparison = Integer.compare(this.length, other.length);

            // 2. length가 같으면 string을 사전순(알파벳 순)으로 정렬
            if (lengthComparison == 0) {
                return this.str.compareTo(other.str);  // 사전순(알파벳 순) 비교
            }

            // 3. length가 다르면 length 기준으로 정렬
            return lengthComparison;
        }
    }
}
