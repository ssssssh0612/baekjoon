package CodeTree.구현;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 나무박멸 {
    static int[][] graph;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    //
    static int[] sprayDX = {1, -1, -1, 1};
    static int[] sprayDY = {-1, -1, 1, 1};

    static int killMax = 0;
    static int[] killMaxPos = new int[2];

    static int[][] killGraph;
    static int[][] copyGraph;

    static int killCount;

    public static void main(String[] args) {

        // 1단계 나무 성장
        // 나무가 성장할때 주변의 나무의 갯수만큼 성장함
        // 2단계 나무 번식
        // 나무가 있는 칸 기준으로 상 하 좌 우 나무가 없다면
        // 나무가 있는 칸에서 총 번식 가능한 갯수만큼 나누어 번식된다
        // 나머지는 생략
        // 번식의 과정은 동시에 큐에 넣어서 구현하기
        // 제초제를 뿌렸을 때 나무 가장 많이 박멸되는 칸에 제추제를 뿌림
        // 벽이 있으면 막히고 제초제가 뿌려진 경우 c+1년만큼 남아있음
        // 제초제가 뿌려진곳에 다시 뿌려지면 다시 c년동안 제초제 유지 c+1년째 제초제 사라짐
        // 위의 과정이 1년에 걸쳐 진행
        // 총 m 년동안 박멸한 나무의 수 구하기

        Scanner sc = new Scanner(System.in);
        // 격자의 크기 n
        // 박멸이 진행되는 년 수 m
        // 제초제의 확산 범위 k
        // 제초제가 남아있는 년 수 c
        int graphSize = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        graph = new int[graphSize][graphSize];
        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
//            System.out.println("년수 시작");
//            debugForTree(graph);
//            System.out.println();
//            System.out.println("트리성장");
            upgradeTree(graph);
//            debugForTree(graph);
//            System.out.println("트리번식");
            treeSex(graph);
//            debugForTree(graph);
//            System.out.println("트리죽이기");
            killTree(graph, k);
//            debugForTree(graph);
//            System.out.println("살충제위치 "+killMaxPos[0] + " " + killMaxPos[1]);
//             제초제 뿌리는작업
//            System.out.println("제초제뿌리기");
            killTreeAS(graph, c + 1, k);
//            debugForTree(graph);
//            System.out.println("살충제적용");
            treeSurvive(graph);
//            debugForTree(graph);
//            System.out.println("트리보기");
        }
        System.out.println(killCount);
    }

    // 나무 성장
    public static void upgradeTree(int[][] graph) {
        boolean[][] visited = new boolean[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && !visited[i][j]) { // 나무가 있다면,
                    visited[i][j] = true;
                    int treeCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nowY = i + dy[k];
                        int nowX = j + dx[k];
                        if (nowY >= 0 && nowX >= 0 &&
                                nowY < graph.length && nowX < graph.length
                                && graph[nowY][nowX] > 0) {
                            treeCount++;
                        }
                    }
                    graph[i][j] = graph[i][j] + treeCount;
                }
            }
        }
    }

    // 나무 번식
    public static void treeSex(int[][] graph) {
        copyGraph = new int[graph.length][graph.length];
        // 해당 나무에 방문했는지 체크
        boolean[][] visited = new boolean[graph.length][graph.length];
        // copyGraph에 나무 복제
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                // 나무가 있고 방문하지 않았다면
                if (copyGraph[i][j] > 0 && !visited[i][j]) {
                    int zeroCount = 0; // 나무가 없는곳에 번식하니 나무가 없는 0인곳 찾기
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        if (i + dy[k] >= 0 && j + dx[k] >= 0 && i + dy[k] < graph.length && j + dx[k] < graph.length &&
                                copyGraph[i + dy[k]][j + dx[k]] == 0) {
                            zeroCount++;
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (i + dy[k] >= 0 && j + dx[k] >= 0 && i + dy[k] < graph.length && j + dx[k] < graph.length &&
                                copyGraph[i + dy[k]][j + dx[k]] == 0) {
                            graph[i + dy[k]][j + dx[k]] = graph[i + dy[k]][j + dx[k]] + (graph[i][j] / zeroCount);
                        }
                    }
                }
            }
        }
    }

    public static void killTree(int[][] graph, int killTreeSpray) { // 제초제의 양
        killGraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                int count = 0;
                if (graph[i][j] > 0) { // 나무가 있는곳의 제초제를 뿌리면 얼마나 나오는지
                    count = graph[i][j];
                    for (int k = 0; k < 4; k++) {
                        for (int l = 1; l <= killTreeSpray; l++) {
                            if (i + l * sprayDY[k] >= 0 && j + l * sprayDX[k] >= 0 &&
                                    i + l * sprayDY[k] < graph.length && j + l * sprayDX[k] < graph.length &&
                                    graph[i + l * sprayDY[k]][j + l * sprayDX[k]] > 0) {
                                // 벽이 없고 나무가 있는 경우
                                count = count + graph[i + l * sprayDY[k]][j + l * sprayDX[k]];
                            } else if (i + l * sprayDY[k] >= 0 && j + l * sprayDX[k] >= 0 &&
                                    i + l * sprayDY[k] < graph.length && j + l * sprayDX[k] < graph.length &&
                                    graph[i + l * sprayDY[k]][j + l * sprayDX[k]] == 0) {
                                // 나무가 없는 경우
                                break;
                            } else if (
                                    i + l * sprayDY[k] >= 0 && j + l * sprayDX[k] >= 0 &&
                                            i + l * sprayDY[k] < graph.length && j + l * sprayDX[k] < graph.length &&
                                            graph[i + l * sprayDY[k]][j + l * sprayDX[k]] == -1) {
                                // 벽이 있는 경우
                                break;
                            } else if(i + l * sprayDY[k] >= 0 && j + l * sprayDX[k] >= 0 &&
                                    i + l * sprayDY[k] < graph.length && j + l * sprayDX[k] < graph.length &&
                                    graph[i + l * sprayDY[k]][j + l * sprayDX[k]] <= -100){
                                break;
                            }
                        }
                    }
                } else if (graph[i][j] == 0) {
                    killGraph[i][j] = count;
                }
                killGraph[i][j] = count;
                killMax = Math.max(killMax, count);
            }
        }
//        System.out.println("어디를 제일많이 죽이나 ?");
//        for (int i = 0; i < killGraph.length; i++) {
//            for (int j = 0; j < killGraph.length; j++) {
//                System.out.print(killGraph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        int sameCount = 0;
        for (int i = 0; i < killGraph.length; i++) {
            for (int j = 0; j < killGraph.length; j++) {
                if (killMax == killGraph[i][j]) {
                    sameCount++;
                    killMaxPos[0] = i;
                    killMaxPos[1] = j;
                }
            }
        }
        if (sameCount > 1) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < killGraph.length; i++) {
                for (int j = 0; j < killGraph.length; j++) {
                    if (killMax == killGraph[i][j]) {
                        list.add(new int[]{i, j});
                    }
                }
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(a[1], b[1]);
                    }
                }
            });
            killMaxPos[0] = list.get(0)[0];
            killMaxPos[1] = list.get(0)[1];
        }

        if (graph[killMaxPos[0]][killMaxPos[1]] != 0) {
            killCount = killCount + killMax;
        }
        killMax = 0;
    }

    public static void killTreeAS(int[][] graph, int spread, int killTreeSpray) {
        // spread 는 남아있는 년 수
        // 어떻게 구현해야하는가 ?

        if (graph[killMaxPos[0]][killMaxPos[1]] == 0) {
            graph[killMaxPos[0]][killMaxPos[1]] = -spread * 100;
            return;
        }

        graph[killMaxPos[0]][killMaxPos[1]] = -spread * 100;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= killTreeSpray; j++) {
                if (killMaxPos[0] + j * sprayDY[i] >= 0 && killMaxPos[1] + j * sprayDX[i] >= 0 &&
                        killMaxPos[0] + j * sprayDY[i] < graph.length && killMaxPos[1] + j * sprayDX[i] < graph.length &&
                        graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] > 0) {
                    // 나무가 있는 경우
                    graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] = -spread * 100;

                } else if (killMaxPos[0] + j * sprayDY[i] >= 0 && killMaxPos[1] + j * sprayDX[i] >= 0 &&
                        killMaxPos[0] + j * sprayDY[i] < graph.length && killMaxPos[1] + j * sprayDX[i] < graph.length &&
                        graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] <= -100) {
                    // 이미 살충제가 뿌려져있는 경우
                    // 이 해 년도부터 새로 뿌리기
                    graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] = -spread * 100;
                    break;
                } else if (killMaxPos[0] + j * sprayDY[i] >= 0 && killMaxPos[1] + j * sprayDX[i] >= 0 &&
                        killMaxPos[0] + j * sprayDY[i] < graph.length && killMaxPos[1] + j * sprayDX[i] < graph.length &&
                        graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] == 0) {
                    // 나무가 없는데 살충제를 뿌린 경우
                    // 이 칸 까지만 뿌려서 뿌려주고 끝
                    graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] = -spread * 100;
                    break;

                } else if (killMaxPos[0] + j * sprayDY[i] >= 0 && killMaxPos[1] + j * sprayDX[i] >= 0 &&
                        killMaxPos[0] + j * sprayDY[i] < graph.length && killMaxPos[1] + j * sprayDX[i] < graph.length &&
                        graph[killMaxPos[0] + j * sprayDY[i]][killMaxPos[1] + j * sprayDX[i]] == -1) {
                    // 벽이 있는 경우
                    break;
                }
            }
        }
    }

    public static void treeSurvive(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] <= -100) {
                    graph[i][j] = graph[i][j] + 100;
                }
            }
        }
    }

    public static void debugForTree(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//
//11 446 20 3
//0 0 0 -1 57 0 -1 0 0 0 0
//0 18 0 -1 -1 0 0 0 0 0 45
//64 0 10 0 0 -1 74 0 0 33 0
//0 61 0 0 -1 0 0 0 0 0 -1
//0 66 0 0 0 0 0 0 16 0 0
//7 0 0 0 6 0 0 -1 27 72 0
//0 0 0 0 0 54 0 42 -1 -1 0
//0 0 -1 0 0 0 0 1 0 0 98
//-1 98 68 0 0 75 1 93 0 0 0
//0 0 0 0 77 0 0 -1 0 0 0
//0 -1 0 -1 0 0 0 0 45 0 0