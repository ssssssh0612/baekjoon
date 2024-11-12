package swea.역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄기세포_배양_5653 {
    // 처음 사고과정
    // 무한 배양 판에서 어떻게 해야하는가 ? -> 증가하는 만큼 최대 증가률을 증가시켜줌
    // 근데 어떻게 완전탐색하는지에 대해 시간복잡도 고려를 못해서 문제 답을 봐버림

    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            input(br);
        }
    }
    public static void input(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new int[800][800];
        int y = Integer.parseInt(st.nextToken()) + 400;
        int x = Integer.parseInt(st.nextToken()) + 400;
        for(int i = 400; i < y; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 400; j < x; j ++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void checking(){

    }
}
