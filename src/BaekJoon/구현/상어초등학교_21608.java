package BaekJoon.구현;

import java.util.*;

public class 상어초등학교_21608 {
    static int[][] graph;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            list.add(new ArrayList<>());
        }
        // 친구 우선순위를 입력받음
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 5; j++) {
                list.get(i).add(sc.nextInt());
            }
        }
        // 제일 첫번째 칸을 그래프에 넣기

        for (int i = 0; i < n * n; i++) {
            checking(i);
        }

        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다
        // 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다
        // 2를 만족하는 칸도 여러개인 경우 행의 번호가 가장 작은 칸으로,
        // 그러한 칸도 여러개이면 열의 번호가 가장 작은 칸으로 자리를 정한다
        for (int i = 0; i < n*n; i++) {
            int likeCount = 0;
            int number = list.get(i).get(0);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(graph[j][k] == number){
                        for (int l = 0; l < 4; l++) {
                            int nowY = j + dy[l];
                            int nowX = k + dx[l];
                            if(nowY >= 0 && nowX >= 0 && nowY < n && nowX < n){
                                for (int m = 1; m < 5; m++) {
                                    if(graph[nowY][nowX] == list.get(i).get(m)){
                                        likeCount++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (likeCount == 0) {
                result = result + 0;
            } else if (likeCount == 1) {
                result = result + 1;
            } else if (likeCount == 2) {
                result = result + 10;
            } else if (likeCount == 3) {
                result = result + 100;
            } else if (likeCount == 4) {
                result = result + 1000;
            }
        }
        System.out.println(result);







    }

    public static void checking(int index) {
        // 빈칸에 카운트가 얼마나 높은지
        List<int[]> countGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    // 조건 1번에 대한 카운트
                    int count = 0;
                    // 조건 2번에 대한 카운트
                    int count1 = 0;
                    // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다
                    for (int k = 0; k < 4; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];
                        if (nowY >= 0 && nowX >= 0 && n > nowY && n > nowX) {
                            for (int l = 1; l < 5; l++) {
                                if( graph[nowY][nowX] == list.get(index).get(l)){
                                    count++;
                                }else if(graph[nowY][nowX] == 0){
                                    count1++;
                                }
                            }
                        }
                    }
                    countGraph.add(new int[]{i,j,count,count1});
                }
            }
        }
        // 정렬 조건 정의
        // 정렬 조건 정의
        countGraph.sort((a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(b[2], a[2]); // 두 번째 인덱스를 큰 순서대로 정렬
            } else if (a[3] != b[3]) {
                return Integer.compare(b[3], a[3]); // 세 번째 인덱스를 큰 순서대로 정렬
            } else if (a[1] != b[1]) {
                return Integer.compare(a[0], b[0]); // 첫 번째 인덱스를 작은 순서대로 정렬
            } else {
                return 0; // 0번째 인덱스를 작은 순서대로 정렬
            }
        });

        graph[countGraph.get(0)[0]][countGraph.get(0)[1]] = list.get(index).get(0);

    }


    public static void firstNum(int number) {
        // number 는 graph[i][j] 에 넣을 숫자
        // 짝수일경우
//        if (n % 2 == 0) {
//            int pos = n / 2 - 1;
//            graph[pos][pos] = number;
//        } else {
//            // 홀수일경우
//            int pos = n / 2;
//            graph[pos][pos] = number;
//        }
        if( n == 3 || n == 4){
            graph[1][1] = number;
        }else{
            graph[2][2] = number;
        }
    }

    public static void graphChecking() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
