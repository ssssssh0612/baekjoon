package BaekJoon.Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복확인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[10000000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++){
            int number = Integer.parseInt(st.nextToken());
            if(!visited[number]){
                visited[number] = true;
            }else{
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");
    }
}
