package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266 {
    static int[] dx = {1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < count ; i ++){
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
        }
        int resultLength = 1;
        while(true){
            boolean[] visited = new boolean[length + 1];
            for(int i = 0 ; i < arr.length; i ++){
                visited[arr[i]] = true;
                int nowX = arr[i];
                for(int j = 0; j < 2; j ++){
                    for( int z = 1; z <= resultLength; z++){
                        int nextX = nowX + dx[j]*z;
                        if(checkingLength(nextX,visited)){
                            visited[nextX] = true;
                        }
                    }
                }
            }
            if(checking(visited)){
                break;
            }
            resultLength++;
        }
        System.out.println(resultLength);

    }
    // 범위안에 들어가는지 체크하는 함수
    public static boolean checkingLength(int index, boolean[] visited){
        return visited.length > index && index >= 0 ;
    }
    public static boolean checking(boolean[] visited){
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
