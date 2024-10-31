package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시피하기_18428 {
    static int[][] graph;
    static List<int[]> zeroList = new ArrayList<>();
    static boolean[] visited;
    static int[] arr = new int [6];
    static List<int[]> teacherList = new ArrayList<>();
    static boolean result = false;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i = 0; i < n ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n ; j ++){
                String a = st.nextToken();
                char ch = a.charAt(0);
                if(ch == 'T'){
                    graph[i][j] = 2;
                    teacherList.add(new int[]{i,j});
                }else if(ch =='S'){
                    graph[i][j] = 1;
                }else{
                    zeroList.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[zeroList.size()];
//        checking();
        backTracking(0,0);
        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
    // 선생님이 한칸한칸 시작하면서 학생과 마주치는지 안마주치는지 체크
    public static boolean teacherSee(){
        // 학생 만나니 ?
        for(int i = 0; i < teacherList.size(); i ++){
            int y = teacherList.get(i)[0];
            int x = teacherList.get(i)[1];
            for(int j = 0; j < 4; j ++){
                int nextY = y + dy[j];
                int nextX = x + dx[j];
                int count = 1;
                while(true){
                    nextY = y + dy[j] * count;
                    nextX = x + dx[j] * count;
                    count++;
                    if(checking(nextY,nextX) && graph[nextY][nextX] == 1){ // 학생 만나면 그냥 끝내버리기
                        return false;
                    }else if(checking(nextY,nextX) && graph[nextY][nextX] == -1){ // 범위가 안되거나, 장애물만나면 넘김
                        break;
                    }else if(!checking(nextY,nextX)){
                        break;
                    }
                }
            }
        }
        return true;
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    // 0중에 3개 뽑기
    public static void backTracking(int depth, int index){
        if(depth == 6){
            // 백트래킹을 통해서 3개를 고르고, 해당 3개중에 장애물을 설치하였을때, teacherSee로 검증
            for(int i = 0 ; i < arr.length; i += 2){
                int y = arr[i];
                int x = arr[i+1];
                graph[y][x] = -1;
            }

            if(teacherSee()){ // 학생을 안만나면 True
                result = true;
                return;
            }

            for(int i = 0 ; i < arr.length; i += 2){
                int y = arr[i];
                int x = arr[i+1];
                graph[y][x] = 0;
            }
            return;
        }
        for(int i = 0; i < zeroList.size(); i ++){
            if(!visited[i] && i >= index){
                arr[depth] = zeroList.get(i)[0];
                arr[depth+1] = zeroList.get(i)[1];
                visited[i] = true;
                backTracking(depth+2, i);
                visited[i] = false;
            }
        }
    }
    public static  void checking(){
        for(int i = 0; i < graph.length; i ++){
            for(int j = 0; j < graph.length; j ++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
