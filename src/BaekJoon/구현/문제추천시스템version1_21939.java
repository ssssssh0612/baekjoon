package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제추천시스템version1_21939 {
    static class Problem implements Comparable<Problem> {
        int problemNumber;
        int level;
        public Problem(int problemNumber , int level){
            this.problemNumber = problemNumber;
            this.level = level;
        }
        public int compareTo(Problem p1){
            int result = p1.level - this.level;
            if(result != 0){
                return result;
            }else{
                return p1.problemNumber - this.problemNumber;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Problem> tree = new TreeSet<>();
        Map<Integer,Integer> tree1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problemNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            tree.add(new Problem(problemNumber, level));
            tree1.put(problemNumber, level);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("recommend")){
                int num = Integer.parseInt(st.nextToken());
                if(tree.isEmpty()){
                    continue;
                }
                if(num == 1){
                    Problem now = tree.first();
                    sb.append(now.problemNumber);
                }else{
                    Problem now = tree.last();
                    sb.append(now.problemNumber);
                }
                sb.append("\n");
            }else if(order.equals("add")){
                int problemNumber = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                tree.add(new Problem(problemNumber, level));
                tree1.put(problemNumber, level);
            }else{
                int num = Integer.parseInt(st.nextToken());
                int level = tree1.get(num);
                tree.remove(new Problem(num, level));
                tree1.remove(num);
            }
        }
        System.out.println(sb);
    }
}

