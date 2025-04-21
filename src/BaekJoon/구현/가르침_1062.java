package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가르침_1062 {
    static int[] arr;
    static int[] num;
    static int pick;
    static boolean[] alphabet;
    static boolean[] visited;
    static String[] strArr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        // 무조건 anta tica 로 끝나야함
        int count = Integer.parseInt(st.nextToken());

        // count가 5개 미만이다 ? 무조건 0
        if(count < 5){
            System.out.println(0);
            return;
        }

        // 5개 이상인 애들이 올라옴 근데 a n t i c 무조건 포함
        alphabet = new boolean[26];
        alphabet[0] = true;
        alphabet[2] = true;
        alphabet[8] = true;
        alphabet[13] = true;
        alphabet[19] = true;
        strArr = new String[length];
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < length ; i++) {
            strArr[i] = br.readLine();
            for(int j = 4; j < strArr[i].length() - 4; j++){
                if(checking(strArr[i].charAt(j) - 'a')){
                    set.add(strArr[i].charAt(j) - 'a');
                }
            }
        }
        num = new int[set.size()];
        visited = new boolean[set.size()];
        int index = 0 ;
        for(Integer num1 : set){
            num[index] = num1;
            index++;
        }

        pick = count - 5;
        arr = new int[pick];
        // 고른갯수중 나머지
        // pick이 0이면 anta tica 로 셀 수 있는 단어들 찾기

        if(pick >= set.size()){
            System.out.println(length);
            return;
        }
        if(pick == 0){
            int resultCount = 0 ;
            for(int i = 0 ; i < strArr.length; i++){
                String str = strArr[i];
                boolean flag = false;
                for(int j = 0 ; j < str.length(); j++){
                    int num = str.charAt(j) - 'a';
                    if(!alphabet[num]){
                        flag = true;
                    }
                }
                if(!flag){
                    resultCount++;
                }
            }
            result = Math.max(result, resultCount);
            System.out.println(result);
        }else{
            backTracking(0,0);
            System.out.println(result);
        }
    }
    public static void backTracking(int depth, int number){
        if(pick == depth){
            for (int j : arr) {
                alphabet[j] = true;
            }
            int count = 0;
            // 여기서 for 문을 돌면서 String 개수 체크하기
            for(int i = 0 ; i < strArr.length; i++){
                String str = strArr[i];
                boolean flag = false;
                for(int j = 0 ; j < str.length(); j++){
                    int num = str.charAt(j) - 'a';
                    if(!alphabet[num]){
                        flag = true;
                    }
                }
                if(!flag){
                    count++;
                }
            }
            result = Math.max(result, count);
            for (int j : arr) {
                alphabet[j] = false;
            }
            return;
        }
        for(int i = 0 ; i < num.length; i ++){
            if(!visited[i] && number <= i){
                arr[depth] = num[i];
                visited[i] = true;
                backTracking(depth+1, i);
                visited[i] = false;
            }
        }
    }
    public static boolean checking(int num){
        if(num == 0){
            return false;
        }else if(num == 2){
            return false;
        }else if(num == 8){
            return false;
        }else if(num == 13){
            return false;
        }else return num != 19;
    }
}
