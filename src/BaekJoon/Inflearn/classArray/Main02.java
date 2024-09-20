package BaekJoon.Inflearn.classArray;

import java.util.*;

public class Main02 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int number;
    static int[][] graph;
    static boolean[][] visited = new boolean[n][n];
    static List<List<int[]>> blockGroupList = new ArrayList<>();
    static int result = 0;
    static boolean trouble;

    public static void main(String[] args) {
        trouble = false;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        number = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > 0 && !visited[i][j]) {
                        findBlockGroup(i, j);
                    }
                }
            }
            if (!blockGroupList.isEmpty()) {
                List<int[]> list = sortBlockGroup();
                result = result + list.size() * list.size();
//                System.out.println("List Size = "+list.size());
                for (int i = 0; i < list.size(); i++) {
                    graph[list.get(i)[0]][list.get(i)[1]] = -100;
                }
            } else {
                flag = false;
                break;
            }
//            System.out.println("중력전");
//            checkingGraph();
            gravity();
//            System.out.println("중력");
//            checkingGraph();
            rotate();
//            System.out.println("회전");
//            checkingGraph();
            gravity();
//            System.out.println("중력");
//            checkingGraph();
            blockGroupList.clear();
            visitedGroupReset();
            trouble = false;
        }
        System.out.println(result);
    }


    // 블록 찾기
    public static void findBlockGroup(int y, int x) {
        // 블록그룹을 저장할것
        List<int[]> blockGroup = new ArrayList<>();
        blockGroup.add(new int[]{y, x});
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int blockNum = graph[y][x];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (nowY >= 0 && nowX >= 0 && nowY < graph.length && nowX < graph[0].length) {
                    if (!visited[nowY][nowX] && (blockNum == graph[nowY][nowX] || graph[nowY][nowX] == 0) ) {
                        // 여기 || 포함된 부분 괄호로 안묶으니 계속 빙빙도는데 왜 이러는지 모르겠다
                        blockGroup.add(new int[]{nowY, nowX});
                        queue.offer(new int[]{nowY, nowX});
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }
        if (blockGroup.size() > 1) {
            blockGroupList.add(blockGroup);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 0) {
                    visited[i][j] = false;
                }
            }

        }

    }

    public static void visitedGroupReset() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void checkingGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate() {
        int[][] copyGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
        int numberX = graph[0].length - 1;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = copyGraph[j][numberX];
            }
            numberX = numberX - 1;
        }
    }

    public static List<int[]> sortBlockGroup() {
        // 길이 순서대로 정렬
        blockGroupList.sort(Comparator.comparingInt((List<int[]> l) -> l.size()).reversed());
        // 그 후 어떻게 할것이냐 ?
        List<List<int[]>> sortedBlockGroupList = new ArrayList<>();

        if (blockGroupList.size() > 1 && blockGroupList.get(0).size() == blockGroupList.get(1).size()) {
            for (int i = 0; i < blockGroupList.size(); i++) {
                if (blockGroupList.get(0).size() == blockGroupList.get(i).size()) {
                    sortedBlockGroupList.add(blockGroupList.get(i));
                }
            }
        } else {
            return blockGroupList.get(0);
        }
        // 무지개 블록의 갯수가 몇개인지
        List<int[]> lastSortedBlockGroup = new ArrayList<>();
        for (int i = 0; i < sortedBlockGroupList.size(); i++) {
            int count = 0;
            // 행이 가장 큰것
            int maxBlockX = 0;
            // 열이 가장 큰것
            int maxBlockY = 0;
            int index = i;
            List<int[]> ruleBlock = new ArrayList<>();
            for (int j = 0; j < sortedBlockGroupList.get(i).size(); j++) {
                // 기준 블록 만들기 로직
                if (graph[sortedBlockGroupList.get(i).get(j)[0]][sortedBlockGroupList.get(i).get(j)[1]] == 0) {
                    count++;
                }
                if(graph[sortedBlockGroupList.get(i).get(j)[0]][sortedBlockGroupList.get(i).get(j)[1]] > 0) {
                    ruleBlock.add(sortedBlockGroupList.get(i).get(j));
                }

            }
            ruleBlock.sort(new Comparator<int[]>() {
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
            maxBlockY = ruleBlock.get(0)[0];
            maxBlockX = ruleBlock.get(0)[1];
            lastSortedBlockGroup.add(new int[]{count, maxBlockY, maxBlockX, index});

        }
        Collections.sort(lastSortedBlockGroup, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 첫 번째 인덱스를 기준으로 내림차순 정렬
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }
                // 첫 번째 인덱스가 같으면 두 번째 인덱스를 기준으로 내림차순 정렬
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]);
                }
                // 첫 번째와 두 번째 인덱스가 같으면 세 번째 인덱스를 기준으로 내림차순 정렬
                return Integer.compare(b[2], a[2]);
            }
        });
        trouble = true;
        return sortedBlockGroupList.get(lastSortedBlockGroup.get(0)[3]);
    }

    public static void gravity() {
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph.length; j++) {
                list.add(graph[j][i]);
            }
            for (int j = 0; j < list.size(); j++) {
                gravityPreset(list);
            }

            for (int j = 0; j < list.size(); j++) {
                graph[j][i] = list.get(j);
            }
        }
    }

    public static void gravityPreset(List<Integer> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j) >= 0 && list.get(j + 1) == -100) {
                Collections.swap(list, j, j + 1);
            }
        }
    }

    public static void checkingVisited() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] ? "Y" : "X");
            }
            System.out.println();
        }
        System.out.println();
    }
}
