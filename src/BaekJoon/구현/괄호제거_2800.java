package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 괄호제거_2800 {
    static int[] arr;
    static boolean[] visited;
    static Set<String> result = new HashSet<>();
    static List<int[]> list = new ArrayList<>();
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 괄호의 개수 세기
        str = br.readLine();
        int count = 0;
        List<Integer> newList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                count++;
                stack.add(i);
            }else if(str.charAt(i) == ')'){
                int num = stack.pop();
                list.add(new int[]{num, i});
            }
        }
//
//        int index = newList.size() - 1;
//        for (int i = 0; i < newList.size() / 2; i++) {
//            list.add(new int[]{newList.get(i), newList.get(index)});
//            index--;
//        }
//
//        List<int[]> list2 = new ArrayList<>();
//        int size = list.size();
//        for (int i = size - 1; i >= 0; i--) {
//            list2.add(list.get(i));
//        }
//
//        list = list2;
        for (int i = 1; i <= count; i++) {
            visited = new boolean[count];
            arr = new int[i];
            backTracking(0, i, 0);
        }
        StringBuilder last = new StringBuilder();
        List<String> realResult = new ArrayList<>(result);
        Collections.sort(realResult);
        for (int i = 0; i < result.size(); i++) {
            last.append(realResult.get(i)).append("\n");
        }
        System.out.print(last);
    }
    public static void backTracking(int depth, int maxDepth, int number){
        if(maxDepth == depth){
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < arr.length; i++) {
                int[] remove = list.get(arr[i]);
                sb.setCharAt(remove[0], ' ');
                sb.setCharAt(remove[1], ' ');
            }
            result.add(sb.toString().replaceAll("\\s+", ""));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && number <= i){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, maxDepth, i);
                visited[i] = false;
            }
        }
    }
}

