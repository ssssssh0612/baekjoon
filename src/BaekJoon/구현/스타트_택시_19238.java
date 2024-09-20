package BaekJoon.구현;

import java.util.*;

public class 스타트_택시_19238 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    // 최단경로 찾는 그래프
    static int[][] shortGraph;

    static int[][] graph;
    // 연료
    static int fuel;
    static int serviceCount;
    static int[] drivePos = new int[2];
    static int[] servicePos = new int[4];
    static List<int[]> servicePosList = new ArrayList<int[]>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        serviceCount = sc.nextInt();
        fuel = sc.nextInt();
        graph = new int[n][n];
        shortGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
                shortGraph[i][j] = graph[i][j];
            }
        }
        drivePos[0] = sc.nextInt() -1 ;
        drivePos[1] = sc.nextInt() -1 ;

        for (int i = 0; i < serviceCount; i++) {
            servicePosList.add(new int[]{sc.nextInt()-1,sc.nextInt()-1,sc.nextInt()-1,sc.nextInt()-1,});
            // 0,1이 출발지점
        }


        boolean flag = true;
        while ( flag ){
            if(bfsStart(drivePos[0],drivePos[1]) == -1){
                flag = false;
                break;
            }

            if(bfsEnd(drivePos[0],drivePos[1]) == -1){
                flag = false;
                break;
            }

            if( servicePosList.isEmpty() ){
                break;
            }
        }

        if(flag){
            System.out.println(fuel);
        }else{
            System.out.println(-1);
        }





    }
    // 최단거리로 항상 이동해야함
    // 어떠한 승객을 태울지에대해 맨 처음 선택해야함
    public static int bfsStart( int y , int x ){ // 현재 택시의 위치를 입력받음
        // 만약 손님과 택시아 같은 위치에 있는 경우는 최단거리를 찾을 필요 없으니
        // return 0 은 택시가 손님 위치에 도달 할 수있음
        // return -1 은 택시가 손님 위치에 도달 할 수 없어서 종료함
        for (int i = 0; i < servicePosList.size(); i++) {
            if(servicePosList.get(i)[0] == y && servicePosList.get(i)[1] == x){
                // 일단 return 으로 끝내자
                // return 0 일경우 승객과 택시의 위치가 동일함
                drivePos[0] = servicePosList.get(i)[0];
                drivePos[1] = servicePosList.get(i)[1];
                servicePos = servicePosList.get(i);
                servicePosList.remove(i);
                return 0 ;
            }
        }

        boolean[][] visited = new boolean[n][n];
        int[][] countGraph = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if( nowX >= 0 && nowY >= 0 && nowX < n && nowY < n &&
                    shortGraph[nowY][nowX] == 0 && !visited[nowY][nowX]){
                    countGraph[nowY][nowX] = countGraph[now[0]][now[1]] + 1;
                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY,nowX});
                }
            }
        }
        // 현재 카운트 그래프에 카운트가 찍혀있고 손님 리스트를 돌면서 최소 카운트를 기억함
        int shortCount = 0;
        for (int i = 0; i < servicePosList.size(); i++) {
            if(i == 0){
                shortCount = countGraph[servicePosList.get(i)[0]][servicePosList.get(i)[1]];
            }else{
                shortCount = Math.min(shortCount , countGraph[servicePosList.get(i)[0]][servicePosList.get(i)[1]]);
            }
        }
        // 승객이 벽에 막혀있는경우 , 혹은 내가 승객에게 닿지 못하는경우
        if(shortCount == 0){
            // return -1 일 경우 승객에게 도달 할 수 없어 -1 을 return 하므로 강제 종료됨
            return -1 ;
        }else{
            // 연료가 충분한가 ?
            if(shortCount > fuel){
                // return -1 일 경우 승객에게 도달 할 수 없어 -1 을 return 하므로 강제 종료됨
                // 연료가 부족하여 다가갈 수 없으니
                return -1;
            }
        }

        // 돌면서 한번에 할 수 있는 방법 없을까 ? 일단 진행해보자
        // 갯수가 2개 이상일수도 있다 그래서 필터링을 걸쳐야한다
        List<int[]> filterService = new ArrayList<>();
        for (int i = 0; i < servicePosList.size(); i++) {
            if(countGraph[servicePosList.get(i)[0]][servicePosList.get(i)[1]] == shortCount){
                filterService.add(servicePosList.get(i));
            }
        }
        // 이 사이즈가 0 이되는 경우의 수가 있을까 ? 없다고 가정하고 문제를 풀어보자
        // 손님을 필터링해야함
        if(filterService.size() == 1){
            servicePos = filterService.get(0);
        }else{
            Collections.sort(filterService, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // 첫 번째 인덱스를 기준으로 오름차순 정렬
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    // 첫 번째 인덱스가 같으면 두 번째 인덱스를 기준으로 오름차순 정렬
                    return Integer.compare(a[1], b[1]);
                }
            });
            servicePos = filterService.get(0);
        }
        for (int i = 0; i < servicePosList.size(); i++) {
            if(Arrays.equals(servicePos, servicePosList.get(i))){
                servicePosList.remove(i);
            }
        }
        // 손님의 위치에 도달할 수 있다고 판단하여 손님의 위치를 저장하였고,
        // 현재 나의 위치에서 손님의 위치로 이동
        drivePos[0] = servicePos[0];
        drivePos[1] = servicePos[1];
        // 연료를 뺌
        fuel = fuel - shortCount;
        return 0;
    }
    // 목적지까지 이동
    public static int bfsEnd( int y , int x ){
        // 현재 내 위치에서 목적지까지 이동 할 수 있냐 없냐 판단하기
        boolean[][] visited = new boolean[n][n];
        int[][] countGraph = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if( nowX >= 0 && nowY >= 0 && nowX < n && nowY < n &&
                        shortGraph[nowY][nowX] == 0 && !visited[nowY][nowX]){
                    countGraph[nowY][nowX] = countGraph[now[0]][now[1]] + 1;
                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY,nowX});
                }
            }
        }
        if(countGraph[servicePos[2]][servicePos[3]] != 0) {
            // 서비스 포스에 도달 할 수 있다면
            if( countGraph[servicePos[2]][servicePos[3]] <= fuel){
                // 최단거리의 위치가 연료보다 작거나 같다면
                fuel = fuel - countGraph[servicePos[2]][servicePos[3]];
                fuel = fuel + (2*countGraph[servicePos[2]][servicePos[3]]);
                drivePos[0] = servicePos[2];
                drivePos[1] = servicePos[3];
                return 0;
            }else{
                // 최단거리의 위차가 연료보다 크면 도달할 수 없으므로 -1
                return -1;
            }
        }else{
            // 서비스 포스에 도달 할 수 없다면
            // return -1 로 표시해서 끝내기
            return -1;
        }
    }
}
