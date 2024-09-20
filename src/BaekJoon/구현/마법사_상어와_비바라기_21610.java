package BaekJoon.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 마법사_상어와_비바라기_21610 {
    static int n;
    static int[][] graph;
    // 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 이다.
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static List<int[]> moveList = new ArrayList<int[]>();
    static List<int[]> cloudList = new ArrayList<int[]>();
    static List<int[]> oldCloudList = new ArrayList<>();

    static boolean[][] visited;
    static int[] dx1 = {-1, 1, -1, 1};
    static int[] dy1 = {-1, -1, 1, 1};

    public static void main(String[] args) {
        //모든 구름이 di 방향으로 si칸 이동한다.
        //각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
        //구름이 모두 사라진다.
        //2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
        //이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
        //예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
        //바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int testCase = sc.nextInt();
        graph = new int[n + 100][n + 100];
        visited = new boolean[n + 100][n + 100];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < testCase; i++) {
            moveList.add(new int[]{sc.nextInt() - 1, sc.nextInt()});
        }

        // 이동만큼 반복
        for (int i = 0; i < moveList.size(); i++) {
            // 구름의 위치는 i=0 일때는 고정
            // 구름 만들기
            makeCloud(i);
            // di 방향으로 si 칸 움직인다
            moveCloud(i);
            // 물의양 1 증가
            rainCloud();
            // 물복사 버그
            copyWater();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] >= 2 && !visited[i][j]) {
                    cloudList.add(new int[]{i, j});
                    graph[i][j] = graph[i][j] - 2;
                }
            }
        }


        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 0) {
                    result = result + graph[i][j];
                }
            }
        }
        System.out.println(result);
    }

    public static void rainCloud() {
        for (int i = 0; i < cloudList.size(); i++) {
            // 각 구름에서 비가 내려 물의 양 1증가
            graph[cloudList.get(i)[0]][cloudList.get(i)[1]] = graph[cloudList.get(i)[0]][cloudList.get(i)[1]] + 1;
        }
    }

    public static void copyWater() {
        for (int i = 0; i < cloudList.size(); i++) {
            // 물복사버그 마법 시전
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int nowY = cloudList.get(i)[0] + dy1[j];
                int nowX = cloudList.get(i)[1] + dx1[j];
                if (nowY >= 0 && nowY < n && nowX >= 0 && nowX < n &&
                        graph[nowY][nowX] > 0) {
                    count++;
                }
            }
            // 값 더하기
            graph[cloudList.get(i)[0]][cloudList.get(i)[1]] = graph[cloudList.get(i)[0]][cloudList.get(i)[1]] + count;
        }

    }

    public static void makeCloud(int number) {
        if (number == 0) {
            // (N, 1), (N, 2), (N-1, 1), (N-1, 2)
            cloudList.add(new int[]{n - 1, 0});
            cloudList.add(new int[]{n - 1, 1});
            cloudList.add(new int[]{n - 2, 0});
            cloudList.add(new int[]{n - 2, 1});
        } else {
            // 나중에 삭제하기위해 리스트의 사이즈 기억하기
            int listSize = cloudList.size();
            // 현재 false 이면서 2이상인 물을 갖고있는 칸 체크하기
            // 체크한 후 cloudList에 넣고, 2빼기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] >= 2 && !visited[i][j]) {
                        cloudList.add(new int[]{i, j});
                        graph[i][j] = graph[i][j] - 2;
                    }
                }
            }
            // 전에 갖고있던 리스트의 사이즈만큼 구름의위치를 false 로 바꿔주기
            for (int i = 0; i < listSize; i++) {
                visited[cloudList.get(i)[0]][cloudList.get(i)[1]] = false;
            }
            // 삭제해주기
            for (int i = 0; i < listSize; i++) {
                cloudList.remove(0);
            }
        }
    }

    public static void moveCloud(int number) {
        // 모든 구름이 di 방향으로 si 칸 이동
        for (int i = 0; i < cloudList.size(); i++) {
            for (int j = 0; j < moveList.get(number)[1]; j++) {
                cloudList.get(i)[0] = cloudList.get(i)[0] + dy[moveList.get(number)[0]];
                cloudList.get(i)[1] = cloudList.get(i)[1] + dx[moveList.get(number)[0]];
                if(cloudList.get(i)[0] < 0 ) {
                    cloudList.get(i)[0] = cloudList.get(i)[0] + n;
                }else if(cloudList.get(i)[0] >= n ) {
                    cloudList.get(i)[0] = cloudList.get(i)[0] - n;
                }

                if(cloudList.get(i)[1] < 0 ) {
                    cloudList.get(i)[1] = cloudList.get(i)[1] + n;
                }else if(cloudList.get(i)[1] >= n ) {
                    cloudList.get(i)[1] = cloudList.get(i)[1] - n;
                }
            }

//            cloudList.get(i)[0] = cloudList.get(i)[0] + moveList.get(number)[1] * dy[moveList.get(number)[0]];
//            cloudList.get(i)[1] = cloudList.get(i)[1] + moveList.get(number)[1] * dx[moveList.get(number)[0]];

            // 그냥 한칸씩 움직이는거로 바꿔보자!

//            cloudList.get(i)[0] = numberCheck(cloudList.get(i)[0]);
//            cloudList.get(i)[1] = numberCheck(cloudList.get(i)[1]);

            visited[cloudList.get(i)[0]][cloudList.get(i)[1]] = true;
        }
    }

    public static int numberCheck(int number) {
        if (number < n && number >= 0) {
            return number;
        } else if (number >= n) {
            number = number % n;
            return number;
        } else if (number >= -n && number <= -1) {
            number = number + n;
            return number;
        } else if (number < -n) {
            if (number % n == 0) {
                number = 0;
                return number;
            } else {
                number = number % 5 + n;
                return number;
            }
        }
        return number;
    }
}


