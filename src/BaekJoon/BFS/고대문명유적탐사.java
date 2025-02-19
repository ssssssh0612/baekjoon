package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 고대문명유적탐사 {
    static int resultCount = 0;
    static int glassCount;
    static int[][] graph = new int[5][5];
    static int[] glass;
    static int glassIndex = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<int[]> zeroList = new ArrayList<>();
    static int testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for (int i = 0; i < testCase; i++) {
            rotate();
            if (resultCount == 0) {
                break;
            } else {
                System.out.print(resultCount + " ");
                resultCount = 0;
            }
        }
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        glassCount = Integer.parseInt(st.nextToken());
        glass = new int[glassCount];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < glassCount; i++) {
            glass[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void rotate() {
        //
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o2[3] - o1[3];
                if (result != 0) {
                    return result;
                }

                result = o1[2] - o2[2];
                if (result != 0) {
                    return result;
                }

                result = o1[1] - o2[1];
                if (result != 0) {
                    return result;
                }

                result = o1[0] - o2[0];
                return result;
            }
        };
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    list.add(new int[]{i, j, k, rotateResult(i, j, k, false)});
                }
            }
        }

        Collections.sort(list, comparator);
        // 가장 큰놈 찾아옴
        int[] arr = list.get(0);
        // 조각 개수 더해주기
        // 그래프 변환해야함
        rotateResult(arr[0], arr[1], arr[2], true);

        while (true) {
            // 그래프 변환 후 bfs를 돌면서 비워진 자리를 List에 넣어야함
            boolean[][] visited = new boolean[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    // 만약 내가 방문하고자 하는곳이 false 면 bfs
                    if (!visited[i][j]) {
                        addToBFS(visited, i, j);
                    }
                }
            }

            if (zeroList.isEmpty()) {
                break;
            }

            for (int i = 0; i < zeroList.size(); i++) {
                int[] newArr = zeroList.get(i);
                graph[newArr[0]][newArr[1]] = 0;
            }

            Comparator<int[]> zeroComparator = new Comparator<>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int result = o1[1] - o2[1];
                    if (result != 0) {
                        return result;
                    }
                    result = o2[0] - o1[0];
                    return result;
                }
            };
            Collections.sort(zeroList, zeroComparator);

            for (int i = 0; i < zeroList.size(); i++) {
                int[] newArr = zeroList.get(i);
                graph[newArr[0]][newArr[1]] = glass[glassIndex];
                glassIndex++;
            }
            resultCount += zeroList.size();
            zeroList.clear();
        }


    }

    public static void addToBFS(boolean[][] visited, int y, int x) {
        int count = 1;
        int number = graph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[]{y, x});
        list.add(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) &&
                        !visited[nextY][nextX] &&
                        graph[nextY][nextX] == number) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                    list.add(new int[]{nextY, nextX});
                    count++;
                }
            }
        }
        if (count >= 3) {
            zeroList.addAll(list);
        }
    }

    public static int rotateResult(int y, int x, int rotate, boolean convertGraph) {
        int[][] newGraph = copyGraph();

        for (int i = 0; i < rotate; i++) {
            rotateGraph(newGraph, y, x);
        }

        boolean[][] visited = new boolean[5][5];

        if (convertGraph) {
            graph = newGraph;
        }
        return checkBFS(visited, newGraph);
    }

    public static void rotateGraph(int[][] newGraph, int y, int x) {
        int startY = y - 1;
        int startX = x - 1;

        int[][] copy33 = new int[5][5];
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                copy33[i][j] = newGraph[i][j];
            }
        }
//        checkingGraph(copy33);
        int indexX = startX + 3 - 1;
        for (int i = startY; i < startY + 3; i++) {
            int indexY = startY;
            for (int j = startX; j < startX + 3; j++) {
//                System.out.println(i + " " + j + " -> " + indexY + " " + indexX);
                newGraph[indexY][indexX] = copy33[i][j];
                indexY++;
            }
            indexX--;
        }
//        checkingGraph(newGraph);
    }

    public static int checkBFS(boolean[][] visited, int[][] newGraph) {
        int count = 0;

//        checkingGraph(newGraph);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 만약 내가 방문하고자 하는곳이 false 면 bfs
                if (!visited[i][j]) {
                    count += bfs(visited, newGraph, i, j);
                }
            }
        }
        return count;
    }

    public static int bfs(boolean[][] visited, int[][] newGraph, int y, int x) {
        int count = 1;
        int number = newGraph[y][x];
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + dy[i];
                int nextX = now[1] + dx[i];
                if (checking(nextY, nextX) &&
                        !visited[nextY][nextX] &&
                        newGraph[nextY][nextX] == number) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                    count++;
                }
            }
        }
        if (count >= 3) {
            return count;
        } else {
            return 0;
        }
    }

    public static int[][] copyGraph() {
        int[][] newGraph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < 5 && x < 5;
    }

    public static void checkingGraph(int[][] newGraph) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(newGraph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
