package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이차원배열과연산_17140 {
    static int[][] graph;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        int lastNum = Integer.parseInt(st.nextToken());
        graph = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (time <= 100) {
            int num = -1;
            if (checking(y, x)) {
                num = graph[y][x];
            }
            if (num == lastNum) {
                System.out.println(time);
                return;
            }
            int yLength = graph.length;
            int xLength = graph[0].length;
            if (yLength >= xLength) {
                R();
            } else {
                C();
            }
            time++;
        }

        System.out.println(-1);


    }

    public static void R() {
        List<int[]> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < graph.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < graph[0].length; j++) {
                int num = graph[i][j];
                if (num != 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            List<int[]> check = new ArrayList<>();
            for (Integer num : map.keySet()) {
                int count = map.get(num);
                check.add(new int[]{num, count});
            }
            Comparator<int[]> comparator = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int result = o1[1] - o2[1];
                    if (result != 0) {
                        return result;
                    }
                    return o1[0] - o2[0];
                }
            };
            check.sort(comparator);
            int size = 0;
            if (map.size() * 2 > 100) {
                size = 100;
            } else {
                size = map.size() * 2;
            }
            int[] addList = new int[size];

            if (maxLength < addList.length) {
                maxLength = addList.length;
            }

            // for문 돌면서 추가하기
            int index = 0;
            for (int[] arr : check) {
                if (index == 100) {
                    break;
                }
                addList[index] = arr[0];
                index++;
                addList[index] = arr[1];
                index++;
            }
            list.add(addList);
        }
        int[][] newGraph = new int[graph.length][maxLength];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                newGraph[i][j] = list.get(i)[j];
            }
        }
        graph = newGraph;
    }

    public static void C() {
        List<int[]> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < graph[0].length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < graph.length; j++) {
                int num = graph[j][i];
                if (num != 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            List<int[]> check = new ArrayList<>();
            for (Integer num : map.keySet()) {
                int count = map.get(num);
                check.add(new int[]{num, count});
            }
            Comparator<int[]> comparator = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int result = o1[1] - o2[1];
                    if (result != 0) {
                        return result;
                    }
                    return o1[0] - o2[0];
                }
            };
            check.sort(comparator);

            int size = 0;
            if (map.size() * 2 > 100) {
                size = 100;
            }else{
                size = map.size() * 2;
            }

            int[] addList = new int[size];

            if (maxLength < addList.length) {
                maxLength = addList.length;
            }

            // for문 돌면서 추가하기
            int index = 0;
            for (int[] arr : check) {
                if (index == 100) {
                    break;
                }
                addList[index] = arr[0];
                index++;
                addList[index] = arr[1];
                index++;
            }
            list.add(addList);
        }

        int[][] newGraph = new int[maxLength][graph[0].length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                newGraph[j][i] = list.get(i)[j];
            }
        }
        graph = newGraph;
    }

    public static boolean checking(int y, int x) {
        return y >= 0 && x >= 0 && y < graph.length && x < graph[0].length;
    }

}
