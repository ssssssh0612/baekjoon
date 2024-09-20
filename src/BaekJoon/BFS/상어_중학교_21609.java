package BaekJoon.BFS;

import java.util.*;

public class 상어_중학교_21609 {
    static int n;
    static int colorCount;
    static int[][] graph;
    static List<List<int[]>> blockGroupList = new ArrayList<List<int[]>>();
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 그래프의 길이
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];
        // 색상의 갯수
        colorCount = sc.nextInt();
        // 그래프를 입력받음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        boolean flag = true;
        int result = 0;
        int count = 0;
        while (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if (blockGroupList.isEmpty()) {
                flag = false;
                break;
            }
            List<int[]> list = sortBlockGroup();
            result = result + ((list.size() - 1) * (list.size() - 1));

//            System.out.println("List Size = " + (list.size() - 1));
//            System.out.println(++count);
            for (int i = 0; i < list.size() - 1; i++) {
                graph[list.get(i)[0]][list.get(i)[1]] = -2;
            }
//            System.out.println("삭제");
//            lookGraph();
            gravity();
//            System.out.println("중력");
//            lookGraph();
            rotate();
//            System.out.println("회전");
//            lookGraph();
            gravity();
//            System.out.println("중력");
//            lookGraph();
            blockGroupList.clear();
            resetVisited();
        }
        System.out.println(result);
    }

    public static void resetVisited() {
//        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
//        System.out.println();
    }
    public static void lookGraph(){
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" "+graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 크기가 가장 큰 블록 그룹을 찾는다.
    // 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹,
    // 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.
    // 일단 블록 그룹을 찾아야 함
    // 이거 구현을 리스트 말고 다른방법은 없을까 ?
    public static void bfs(int y, int x) {
        // bfs 를 통해 일단 블록 그룹을 모두 받아온다
        // 기준 블록에 대해서 리스트의 마지막 블록을 넣어준다
        visited[y][x] = true;
        // 색이 한가지 색으로 같아야 하므로,
        int normalColor = graph[y][x];
        Queue<int[]> queue = new LinkedList<int[]>();
        List<int[]> blockGroup = new ArrayList<>();
        queue.add(new int[]{y, x});
        blockGroup.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = now[0] + dy[i];
                int nowX = now[1] + dx[i];
                if (graphChecking(nowY, nowX) && !visited[nowY][nowX]) {
                    if (graph[nowY][nowX] == 0 || graph[nowY][nowX] == normalColor) {
                        blockGroup.add(new int[]{nowY, nowX});
                        queue.add(new int[]{nowY, nowX});
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }

        if (blockGroup.size() <= 1) {
            return;
        }

        // 무지개블록 갯수 찾기
        int rainbowBlockCount = 0;
        // 기준 블록 찾기
        List<int[]> ruleBlockGroup = new ArrayList<>();
//        System.out.println("block group size = " + blockGroup.size());
        for (int i = 0; i < blockGroup.size(); i++) {
            int nowY = blockGroup.get(i)[0];
            int nowX = blockGroup.get(i)[1];
            if (graph[nowY][nowX] == 0) {
                // 무지개 블록은 다른 블록에도 포함 될 수 있으므로 visited를 false 로 바꿔야함
                visited[nowY][nowX] = false;
                rainbowBlockCount++;
            } else {
                ruleBlockGroup.add(new int[]{nowY, nowX});
            }
        }

        int ruleBlockY = 0;
        int ruleBlockX = 0;
        if (ruleBlockGroup.size() == 1) {
            ruleBlockY = ruleBlockGroup.get(0)[0];
            ruleBlockX = ruleBlockGroup.get(0)[1];
        } else {
            ruleBlockGroup.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        // 0번째 Y를 기준으로 오름차순 정렬
                        return Integer.compare(a[0], b[0]);
                    } else {
                        // 0번째 Y가 같다면 1번째 X를 기준으로 오름차순 정렬
                        return Integer.compare(a[1], b[1]);
                    }
                }
            });

            ruleBlockY = ruleBlockGroup.get(0)[0];
            ruleBlockX = ruleBlockGroup.get(0)[1];

//            System.out.println("ruleBlockY = "+ruleBlockY);
//            System.out.println("ruleBlockX = "+ruleBlockX);
        }
        // 마지막 행에 무지개블록의 갯수와 기준블록의 갯수를 넣어주기
        blockGroup.add(new int[]{rainbowBlockCount, ruleBlockY, ruleBlockX});

        // 사이즈가 1보다 길어야 저장함
        blockGroupList.add(blockGroup);

//        for (int i = 0; i < blockGroup.size(); i++) {
//            System.out.print(" y = "+ blockGroup.get(i)[0] + " , x = "+ blockGroup.get(i)[1]);
//            System.out.println();
//            if( i == blockGroup.size() - 1){
//                System.out.println("graph[ruleBlockY][ruleBlockX] = " + graph[ruleBlockY][ruleBlockX] );
//            }else{
//                System.out.print(graph[blockGroup.get(i)[0]][blockGroup.get(i)[1]]+" ");
//            }
//        }
//        System.out.println();
    }

    public static List<int[]> sortBlockGroup() {
        // blockGroupList를 정렬해서 blockGroup내보내기
        if (blockGroupList.size() == 1) {
            return blockGroupList.get(0);
        }
        blockGroupList.sort(new Comparator<List<int[]>>() {
            @Override
            public int compare(List<int[]> a, List<int[]> b) {
                return Integer.compare(b.size(), a.size()); // 크기가 큰 것이 앞에 오도록 정렬
            }
        });
        // 첫번째 리스트 사이즈랑 두번째리스트 사이즈랑 다르다면 return
        if (blockGroupList.get(0).size() != blockGroupList.get(1).size()) {
            return blockGroupList.get(0);
        }
        // 길이가 같은애들끼리 무지개 갯수로 비교하기
        int listLength = blockGroupList.get(0).size();
        List<List<int[]>> rainbowGroup = new ArrayList<>();
        for (int i = 0; i < blockGroupList.size(); i++) {
            if (listLength == blockGroupList.get(i).size()) {
                rainbowGroup.add(blockGroupList.get(i));
            }
        }
        // 무지개갯수로 거르기
//        for (int i = 0; i < rainbowGroup.size(); i++) {
//            for (int j = 0; j < rainbowGroup.get(i).size(); j++) {
//                if(rainbowGroup.get(i).size() -1 != j){
//                    System.out.print("y = "+rainbowGroup.get(i).get(j)[0] +", x = "+rainbowGroup.get(i).get(j)[1]+" ");
//                }else{
//                    System.out.print("rainbowCount = "+rainbowGroup.get(i).get(j)[0] +" y = "+rainbowGroup.get(i).get(j)[1] +", x = "+rainbowGroup.get(i).get(j)[2]+" ");
//                }
//            }
//            System.out.println();
//        }


        rainbowGroup.sort(new Comparator<List<int[]>>() {
            @Override
            public int compare(List<int[]> a, List<int[]> b) {
                // a와 b의 마지막 요소의 0번째 값(무지개블록개수) 비교
                int[] lastA = a.get(a.size() - 1);
                int[] lastB = b.get(b.size() - 1);
                return Integer.compare(lastB[0], lastA[0]);
            }
        });
        // 만약 무지개 갯수도 똑같다면 기준 블록으로 거르기
        if (rainbowGroup.get(0).get(rainbowGroup.get(0).size()-1)[0] != rainbowGroup.get(1).get(rainbowGroup.get(1).size()-1)[0]) {
            return rainbowGroup.get(0);
        }


        List<List<int[]>> ruleGroup = new ArrayList<>();
        int rainbowLength = rainbowGroup.get(0).get(rainbowGroup.get(0).size()-1)[0];
        for (int i = 0; i < rainbowGroup.size(); i++) {
            if (rainbowLength == rainbowGroup.get(i).get(rainbowGroup.get(i).size()-1)[0]) {
                ruleGroup.add(rainbowGroup.get(i));
            }
        }
        ruleGroup.sort(new Comparator<List<int[]>>() {
            @Override
            public int compare(List<int[]> a, List<int[]> b) {
                int[] lastA = a.get(a.size() - 1);
                int[] lastB = b.get(b.size() - 1);

                // 마지막 요소의 1번째 값을 내림차순으로 비교
                int compare = Integer.compare(lastB[1], lastA[1]);
                if (compare == 0) {
                    // 1번째 값이 같다면 마지막 요소의 0번째 값을 내림차순으로 비교
                    compare = Integer.compare(lastB[2], lastA[2]);
                }
                return compare;
            }
        });
        return ruleGroup.get(0);
    }

    public static boolean graphChecking(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
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

//        for(int i = n-2; 0 <= i; i--){
//            for(int j = 0; j < n; j++){
//                if(graph[i][j] == -2 || graph[i][j] == -1) continue;
//                int tmp = graph[i][j], ni = i;
//                while(ni+1 < n && graph[ni+1][j] == -2)
//                    ni++;
//                if(graph[ni][j] == -2) {
//                    graph[ni][j] = tmp;
//                    graph[i][j] = -2;
//                }
//            }
//        }
    }

    public static void gravityPreset(List<Integer> list) {
        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j) >= 0 && list.get(j + 1) == -2) {
                Collections.swap(list, j, j + 1);
            }
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


}
