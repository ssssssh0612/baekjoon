package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소문난_칠공주_1941 {
    static List<int[]> somList = new ArrayList<>();
    static List<int[]> yeonList = new ArrayList<>();
    static int[][] graph;

    static List<List<int[]>> yeonLists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        if(somList.size() == 4){
            // 4 해봐야함
            // 4로 백트래킹 후 3 으로 백트래킹 그리고 해당 좌표들에대해서 dfs해보았을때 7이면 count

        }else if(somList.size() == 5){
            // 4,5 해봐야함

        }else if(somList.size() >= 6){
            // 4,5,6 다 해봐야함

        }
    }
    // 4로 백트래킹 하고나서
    public static void somBackTracking(int depth, int length, boolean[] visited, int number){
        if(depth == number){

            return;
        }
        for(int i = 0 ; i < somList.size(); i++){
            if(!visited[i]){

            }
        }
    }
    public static void yeonBackTracking(int depth, int length, boolean[] visited, int number){
        if(depth == number){

            return;
        }
        for(int i = 0 ; i < somList.size(); i++){
            if(!visited[i]){

            }
        }
    }

    //이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
    //강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
    //화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
    //그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
    public static void input(BufferedReader br) throws IOException{
        for(int i = 0 ; i < 5; i++){
            String a = br.readLine();
            for(int j = 0 ; j < 5; j++){
                char ch = a.charAt(j);
                // Y == 0
                if(ch == 'Y'){
                    graph[i][j] = 0;
                    yeonList.add(new int[]{i,j});
                }else{ // S == 1
                    graph[i][j] = 1;
                    somList.add(new int[]{i,j});
                }
            }
        }
    }

}
