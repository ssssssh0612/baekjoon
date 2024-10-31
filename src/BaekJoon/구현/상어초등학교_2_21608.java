package BaekJoon.구현;

import java.util.*;
import java.io.*;

public class 상어초등학교_2_21608 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] graph;
    static List<int[]> wishList = new ArrayList<>();
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for(int i = 0; i < wishList.size(); i++){
            step1(i);
            graphSetting();
        }
        lastChecking();
        System.out.println(result);
    }
    public static void lastChecking(){
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0; j < graph.length; j ++){
                int number = graph[i][j];
                int count = 0;
                for(int k = 0 ; k < wishList.size(); k ++){
                    int check = wishList.get(k)[0];
                    if(number == check){
                        for(int z = 0 ; z < 4; z ++){
                            int nextY = i + dy[z];
                            int nextX = j + dx[z];
                            if(checkingRange(nextY,nextX)){
                                int checkNumber = graph[nextY][nextX];
                                for(int d = 1 ; d < 5 ; d++){
                                    int wishNumber = wishList.get(k)[d];
                                    if(checkNumber == wishNumber){
                                        count++;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                if(count == 1){
                    result += 1;
                }else if(count == 2){
                    result += 10;
                }else if( count == 3){
                    result += 100;
                }else if( count == 4){
                    result += 1000;
                }
            }
        }
    }
    public static void checking(){
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++ ){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0 ; i < n*n ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            wishList.add(new int[]{Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
//        if( n % 2 == 0){
//            graph[(n / 2) - 1][(n / 2) - 1] = wishList.get(0)[0];
//            visited[(n / 2) - 1][(n / 2) - 1] = true;
//        }else{
//            graph[(n / 2)][(n / 2)] = wishList.get(0)[0];
//            visited[n/2][n/2] = true;
//        }
    }
    // 그래프를 초기화하는 내용
    public static void graphSetting(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(!visited[i][j] && graph[i][j] > 0){
                    graph[i][j] = 0;
                }
            }
        }
    }
    public static boolean checking(int[] wishArr, int wishNumber){
        for(int i = 1; i < wishArr.length; i++ ){
            if(wishNumber == wishArr[i]){
                return true;
            }
        }
        return false;
    }
    public static boolean checkingRange(int y , int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    public static void step1(int index){
        int[] wishArr = wishList.get(index);

        int number = wishArr[0]; // 나머지 1, 2, 3, 4가 graph 안에 있는지 확인
        //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        //비어있지 않은 칸들 가중치 구해주기
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(visited[i][j] && checking(wishArr,graph[i][j])){
                    // 동 서 남 북 돌면서 가중치 더해주기
                    for(int k = 0; k < 4; k++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if(checkingRange(nextY, nextX) && !visited[nextY][nextX]){
                            graph[nextY][nextX]++;
                        }
                    }
                }
            }
        }
        //최대값을 찾자 근데 최대값이 2개이상이라면 step2로 넘어감
        int max = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                // 방문하지 않은 상태이고(숫자가 들어가면 방문처리)
                if(!visited[i][j] && graph[i][j] > max){
                    max = graph[i][j];
                }
            }
        }
        List<int[]> maxList = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(!visited[i][j] && graph[i][j] == max){
                    // index 2 의 값은 비어있는 칸
                    maxList.add(new int[]{i,j,0});
                }
            }
        }
        if( maxList.size() > 1){
            step2(maxList, number);
        }else{
            //숫자 삽입
            graph[maxList.get(0)[0]][maxList.get(0)[1]] = number;
            visited[maxList.get(0)[0]][maxList.get(0)[1]] = true;
        }
    }
    public static void step2(List<int[]> maxList, int number){
        //1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        for(int i = 0; i < maxList.size(); i++){
            int y = maxList.get(i)[0];
            int x = maxList.get(i)[1];
            for(int j = 0; j < 4; j++){
                int nextY = y + dy[j];
                int nextX = x + dx[j];
                if(checkingRange(nextY,nextX) && !visited[nextY][nextX]){
                    maxList.get(i)[2]++;
                }
            }
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o2[2] - o1[2];
                if(result != 0){
                    return result;
                }
                result = o1[1] - o2[1];
                if(result != 0){
                    return result;
                }
                return o1[0] - o2[0];
            }
        };
        Collections.sort(maxList,comparator);
        graph[maxList.get(0)[0]][maxList.get(0)[1]] = number;
        visited[maxList.get(0)[0]][maxList.get(0)[1]] = true;
    }
}
