package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
    static int result = 0;
    static int[] list;
    static boolean[] visited;
    static int[] arr;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[length];
        arr = new int[length];
        for(int i = 0 ; i < length; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[length + 1];
        backTracking(0);
    }
    public static void backTracking(int depth){
        if(depth == list.length){
            if(checking()){
                for(int i = 0 ; i < list.length; i++){
                    if(arr[i] != 0){
                        System.out.print(arr[i]+" ");
                    }
                }
                check = true;
            }
            return;
        }
        for(int i = 1; i <= list.length; i++){
            if(!visited[i] && !check){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean checking(){
        // 받아온 arr 로 새로운 arr 을 만들어서 list 와 비교햐기
        // 뽑힌 숫자로 한명씩 검사하기
        int[] newArr = new int[list.length];
        for(int i = 0 ; i < list.length; i++){
            int resultNum = list[i];
            int number = i + 1;
            for(int j = 0 ; j < list.length; j++){
                if( number == arr[j] ){
                    int count = 0;
                    for( int k = 0 ; k < j; k ++ ){
                        if( number < arr[k]){
                            count++;
                        }
                    }
                    if( count != resultNum){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
