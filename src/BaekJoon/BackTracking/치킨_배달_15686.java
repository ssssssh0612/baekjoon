package BaekJoon.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 치킨_배달_15686 {
    static int n;
    static int m;
    static int[][] graph;
    static List<int[]> chickenList = new ArrayList<>();
    static List<int[]> maxChickenList = new ArrayList<>();
    static List<int[]> houseList = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    static int result = 0;
    static int[] arr;
//  도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다.
//  집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 폐업시키지않을 치킨집을 최대 m개 골랐을때 도시의 치킨거리의 최솟값
        m = sc.nextInt();
        graph = new int[n][n];
        arr = new int[m*2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1){ // 그냥집
                    houseList.add(new int[]{i, j});
                }else if(graph[i][j] == 2){ // 치킨집
                    chickenList.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chickenList.size()];
        backTracking(0,0);
        System.out.println(result);
    }

    public static void backTracking(int depth, int index){
        if( depth == m*2 ){
            // 현재 arr에 저장되어있는 치킨집들을 갖고 검사하기
            count++;
            int value = 0;
            for (int i = 0; i < houseList.size(); i++) {
                int houseY = houseList.get(i)[0];
                int houseX = houseList.get(i)[1];
                int shortestDistance = 0;
                for (int j = 0; j < arr.length; j += 2) {
                    if( j == 0 ){
                        shortestDistance = dis(houseY , houseX , arr[j] , arr[j+1]);
                    }else{
                        shortestDistance = Math.min(shortestDistance, dis(houseY , houseX , arr[j] , arr[j+1]));
                    }
                }
                value += shortestDistance;
            }
            if(count == 1){
                result = value;
            }else{
                result = Math.min(result,value);
            }
            return;
        }
        for (int i = 0; i < chickenList.size(); i++) {
            if(!visited[i] && index <= i){
                // 인덱스의 유무에따라 시간초과 나는지 확인해보자
                visited[i] = true;
                // arr에 저장하는건 해당 치킨집의 치킨거리
                arr[depth] = chickenList.get(i)[0];
                arr[depth+1] = chickenList.get(i)[1];
                backTracking(depth + 2 , i );
                visited[i] = false;
            }
        }
    }

    public static int dis(int y, int x, int y1, int x1){
        return Math.abs(y - y1) + Math.abs(x - x1);
    }

}
