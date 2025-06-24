package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨박꼭질4_13913 {
    static class Node{
        StringBuilder sb;
        int nowNum;
        int count;
        public Node(int nowNum, StringBuilder sb, int count){
            this.sb = sb;
            this.sb.append(nowNum).append(" ");
            this.nowNum = nowNum;
            this.count = count;
        }
    }
    static int startNum;
    static int endNum;
    static boolean[] visited = new boolean[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        endNum = Integer.parseInt(st.nextToken());
        if(startNum < endNum){
        // 현재 시작에서 종료되는 숫자가 크다면
            bfs();
        }else if(startNum == endNum){
            System.out.println(0);
            System.out.println(endNum);
        }else{
        // 현재 시작숫자에서 종료되는 숫자가 작다면
            // bfs 할 필요가 없음
            step();
        }


    }
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        StringBuilder sb1 = new StringBuilder();
        queue.add(new Node(startNum, sb1, 0));
        visited[startNum] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int now = node.nowNum;
            if(endNum == now){
                System.out.println(node.count);
                System.out.println(node.sb);
                return;
            }
            if(checking(now + 1) && !visited[now + 1]){
                queue.add(new Node(now + 1, new StringBuilder(node.sb), node.count + 1));
                visited[now + 1] = true;
            }
            if(checking(now - 1) && !visited[now - 1]){
                queue.add(new Node(now - 1, new StringBuilder(node.sb), node.count + 1));
                visited[now - 1] = true;
            }
            if(checking(now * 2) && !visited[now * 2]){
                queue.add(new Node(now * 2, new StringBuilder(node.sb), node.count + 1));
                visited[now * 2] = true;
            }

        }
    }

    public static void step(){
        System.out.println(startNum - endNum);
        StringBuilder sb = new StringBuilder();
        for (int i = startNum; i >= endNum ; i--) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean checking(int num){
        return num >= 0 && num < 100001;
    }

}
