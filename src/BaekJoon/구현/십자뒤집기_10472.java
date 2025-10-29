package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 십자뒤집기_10472 {
    static class Node{
        String str;
        int num;

        public String getStr() {
            return str;
        }

        public int getNum() {
            return num;
        }

        public Node(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }
    static StringBuilder result = new StringBuilder();
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(new int[]{0,1,3});
        list.add(new int[]{0,1,2,4});
        list.add(new int[]{1,2,5});
        list.add(new int[]{0,3,4,6});
        list.add(new int[]{1,3,4,5,7});
        list.add(new int[]{2,4,5,8});
        list.add(new int[]{3,6,7});
        list.add(new int[]{4,6,7,8});
        list.add(new int[]{5,7,8});
        for (int i = 0; i < num; i++) {
            step(br);
        }
        System.out.println(result);
    }

    public static void step(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(br.readLine());
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(".........", 0));
        // 0 1 2
        // 3 4 5
        // 6 7 8

        // 0번 변경시
        // 0 1 3
        // 1번 변경시
        // 0 1 2 4
        // 2번 변경시
        // 1 2 5
        // 3번 변경시
        // 0 3 4 6
        // 4번 변경시
        // 1 3 4 5 7
        // 5번 변경시
        // 2 4 5 8
        // 6번 변경시
        // 3 6 7
        // 7번 변경시
        // 4 6 7 8
        // 8번 변경시
        // 5 7 8
        Set<String> visited = new HashSet<>();
        visited.add(".........");
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.str.contentEquals(sb)){
                result.append(now.num).append("\n");
                return;
            }
            for (int i = 0; i < 9; i++) {
                StringBuilder add = new StringBuilder(now.str);
                for (int j = 0; j < list.get(i).length; j++) {
                    int index = list.get(i)[j];
                    if(add.charAt(index) == '*'){
                        add.setCharAt(index,'.');
                    }else{
                        add.setCharAt(index,'*');
                    }
                }
                if(!visited.contains(add.toString())){
                    visited.add(add.toString());
                    queue.add(new Node(add.toString(), now.num + 1));
                }
            }
        }

    }
}
