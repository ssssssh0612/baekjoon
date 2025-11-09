package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 동전게임_9079 {
    static Set<String> visited;
    static class Node{
        StringBuilder sb;
        int count;
        public Node(StringBuilder sb, int count){
            this.sb = sb;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "02.1234567891011121311";
        String str2 = "02.1234567891011121311";
        double num = Double.parseDouble(str) + Double.parseDouble(str2);
        System.out.println(num);
        BigDecimal x = new BigDecimal("2.140000");
        String s = x.stripTrailingZeros().toPlainString(); // "2"
        System.out.println(s);
//        int num = Integer.parseInt(br.readLine());
//        for (int i = 0; i < num; i++) {
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < 3; j++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for (int k = 0; k < 3; k++) {
//                    String str = st.nextToken();
//                    sb.append(str);
//                }
//            }
//            bfs(sb);
//        }
    }
//    public static void bfs(StringBuilder sb){
//        visited = new HashSet<>();
//        visited.add(sb.toString());
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(sb,0));
//        while(!queue.isEmpty()){
//            Node now = queue.poll();
//            if(check(now.sb)){
//                System.out.println(now.count);
//                return;
//            }
//            for (int i = 0; i < 8; i++) {
//                String str = step(i, now.sb);
//                if(!visited.contains(str)){
//                    queue.add(new Node(new StringBuilder().append(str), now.count + 1));
//                    visited.add(str);
//                }
//            }
//        }
//        System.out.println(-1);
//    }
//    public static boolean check(StringBuilder sb){
//        char ch = sb.toString().charAt(0);
//        for (int i = 1; i < 9; i++) {
//            if(ch != sb.toString().charAt(i)){
//                return false;
//            }
//        }
//        return true;
//    }
//    // 012
//    // 345
//    // 678
//    public static String step(int step, StringBuilder newSb){
//        // 0 4 8
//        // 2 4 6
//        StringBuilder sb = new StringBuilder().append(newSb.toString());
//        if(step==0){
//            for (int i = 0; i < 3; i++) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//        if(step==1){
//            for (int i = 3; i < 6; i++) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//        if(step==2){
//            for (int i = 6; i < 9; i++) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//        if(step==3){
//            for (int i = 0; i <= 6; i+=3) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//        if(step==4){
//            for (int i = 1; i <= 7; i+=3) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//        if(step==5){
//            for (int i = 2; i <= 8; i+=3) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//
//        if(step==6){
//            for (int i = 0; i <=8; i+=4) {
//                if(sb.toString().charAt(i)=='H'){
//                    sb.replace(i,i+1,"T");
//                }else{
//                    sb.replace(i,i+1,"H");
//                }
//            }
//            return sb.toString();
//        }
//
//        for (int i = 2; i <= 6; i+=2) {
//            if(sb.toString().charAt(i)=='H'){
//                sb.replace(i,i+1,"T");
//            }else{
//                sb.replace(i,i+1,"H");
//            }
//        }
//        return sb.toString();
//    }
}
