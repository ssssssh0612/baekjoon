package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 마법사_상어와_블리자드 {
    static int[][] graph;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[] dy1 = {0, 1, 0, -1};
    static int[] dx1 = {-1, 0, 1, 0};

    static int number1 = 0;
    static int number2 = 0;
    static int number3 = 0;
    static int[] sharkPos = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = input(br);
        sharkPos[0] = (graph.length - 1) / 2;
        sharkPos[1] = (graph.length - 1) / 2;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int destroy = Integer.parseInt(st.nextToken());
            destroy(dir, destroy);
            snail();
//            checking();
            snailBoom();
        }
        System.out.println(finalResult());
    }

    public static int finalResult() {
        int count = 0;
        count += number1;
        count += number2 * 2;
        count += number3 * 3;
        return count;
    }

    public static void destroy(int dir, int destroy) {
        int nextY = sharkPos[0];
        int nextX = sharkPos[1];

        for (int i = 0; i < destroy; i++) {
            nextY = nextY + dy[dir];
            nextX = nextX + dx[dir];
            graph[nextY][nextX] = 0;
        }
    }

    public static void snail() {
        // 숫자를 리스트에 담기
        List<Integer> list = new ArrayList<>();
        // 달팽이로 순회하면서 리스트에 담고
        snailChecking(list);
        // 다시 달팽이로 순회하면서 리스트에 있는 숫자 담기
        int[][] newGraph = new int[graph.length][graph.length];
        snailInput(list, newGraph);
        graph = newGraph;
    }

    public static void snailInput(List<Integer> list, int[][] newGraph) {
        int listIndex = 0;
        int index = 1;
        int dir = 3;
        int nowY = sharkPos[0];
        int nowX = sharkPos[1];
        while (listIndex < list.size()) {
            if (index == graph.length - 1) {
                for (int i = 0; i < 3; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        if (listIndex == list.size()) {
                            break;
                        }
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        newGraph[nowY][nowX] = list.get(listIndex);
                        listIndex++;
                    }
                }
                index++;
            } else {
                for (int i = 0; i < 2; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        if (listIndex == list.size()) {
                            break;
                        }
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        newGraph[nowY][nowX] = list.get(listIndex);
                        listIndex++;
                    }
                }
                index++;
            }
        }
    }

    public static void snailChecking(List<Integer> list) {
        int index = 1;
        int dir = 3;
        int nowY = sharkPos[0];
        int nowX = sharkPos[1];
        while (index < graph.length) {
            if (index == graph.length - 1) {
                for (int i = 0; i < 3; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (graph[nowY][nowX] != 0) {
                            list.add(graph[nowY][nowX]);
                        }
                    }
                }
                index++;
            } else {
                for (int i = 0; i < 2; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (graph[nowY][nowX] != 0) {
                            list.add(graph[nowY][nowX]);
                        }
                    }
                }
                index++;
            }
        }
    }

    public static void checking() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return m;
    }

    public static void snailBoom() {
        int index = 1;
        int dir = 3;
        int nowY = sharkPos[0];
        int nowX = sharkPos[1];
        List<Integer> list = new ArrayList<>();
        while (index < graph.length) {
            if (index == graph.length - 1) {
                for (int i = 0; i < 3; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (graph[nowY][nowX] != 0) {
                            list.add(graph[nowY][nowX]);
                        }
                    }
                }
                index++;
            } else {
                for (int i = 0; i < 2; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (graph[nowY][nowX] != 0) {
                            list.add(graph[nowY][nowX]);
                        }
                    }
                }
                index++;
            }
        }
        // 리스트에 연속되는 숫자를 찾아서 지우기
        List<Integer> newList = checkingResult(list);
        List<Integer> resultList = newResult(newList);
        int[][] newGraph = new int[graph.length][graph.length];
        snailCheckingLast(resultList, newGraph);
        graph = newGraph;
    }

    public static List<Integer> newResult(List<Integer> list) {
        if(list.size() == 0 ){
            return list;
        }
        List<Integer> newList = new ArrayList<>();
        int index = 0;
        int plus = 1;
        while (index < list.size()) {
            boolean flag = false;
            int num = list.get(index);
            for (int j = 1; j <= 2; j++) {
                if (index + j < list.size() && num == list.get(index + j)) {
                    flag = true;
                    plus++;
                } else {
                    break;
                }
            }
            newList.add(plus);
            newList.add(num);
            if (flag) {
                index = index + (plus);
                plus = 1;
            } else {
                index++;
            }
        }
        return newList;
    }

    public static List<Integer> checkingResult(List<Integer> list) {
        if(list.size() == 0){
            return list;
        }
        boolean flag = false;
        int index = 0;
        while(index < list.size()){
            int nowNum = list.get(index);
            int newIndex = index + 1;
            int count = 0 ;
            while(newIndex < list.size()){
                int newNum = list.get(newIndex);
                if(nowNum == newNum){
                    newIndex++;
                    count++;
                }else{
                    break;
                }
            }
            if(count >= 3){
                // 3과 같거나 크면 4개 연속된 숫자
                flag = true;
                for(int i = index; i < newIndex; i++){
                    list.set(i, 0);
                }
                if (nowNum == 1) {
                    number1 += count + 1;
                } else if (nowNum == 2) {
                    number2 += count + 1;
                } else {
                    number3 += count + 1;
                }
            }
            index = newIndex;
        }
//        for (int i = 1; i < list.size(); i++) {
//            int nowNum = list.get(i);
//            if (num != nowNum) {
//                if (plus >= 3) {
//                    flag = true;
//                    for (int j = (i - (1 + plus)); j < i; j++) {
//                        list.set(j, 0);
//                    }
//                    if (num == 1) {
//                        number1 += plus + 1;
//                    } else if (num == 2) {
//                        number2 += plus + 1;
//                    } else {
//                        number3 += plus + 1;
//                    }
//                }
//                num = nowNum;
//                plus = 0;
//            } else {
//                plus++;
//            }
//        }
        // 삭제한게 있어야 정리
        List<Integer> newList = new ArrayList<>();
        if (flag) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != 0) {
                    newList.add(list.get(i));
                }
            }
            // 다시 확인
            return checkingResult(newList);
        } else {
            return list;
        }
    }

    public static void snailCheckingLast(List<Integer> list, int[][] newGraph) {
        if(list.size() == 0){
            return;
        }
        int index = 1;
        int dir = 3;
        int nowY = sharkPos[0];
        int nowX = sharkPos[1];
        int listIndex = 0;
        while (index < graph.length) {
            if (index == graph.length - 1) {
                for (int i = 0; i < 3; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (listIndex == list.size()) {
                            break;
                        }
                        newGraph[nowY][nowX] = list.get(listIndex);
                        listIndex++;
                    }
                }
                index++;
            } else {
                for (int i = 0; i < 2; i++) {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    for (int j = 0; j < index; j++) {
                        nowY = nowY + dy1[dir];
                        nowX = nowX + dx1[dir];
                        if (listIndex == list.size()) {
                            break;
                        }
                        newGraph[nowY][nowX] = list.get(listIndex);
                        listIndex++;
                    }
                }
                index++;
            }
        }
    }
}


