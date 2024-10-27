package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 새로운_게임_2_17837 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int color;
        List<Horse> list;

        public Node(int color) {
            this.color = color;
            this.list = new ArrayList<>();
        }
    }

    public static class Horse {
        int number;
        int dir;
        int y;
        int x;

        public Horse(int y, int x, int dir, int number) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.number = number;
        }
    }

    static ArrayList<Node>[][] graph;
    static Horse[] horseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받기
        input(br);
        for (int i = 0; i < 1000; i++) {
            movingHorse();
            if(checking()){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(-1);
    }
    public static boolean checking(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j].get(0).list.size()+" ");
                if(graph[i][j].get(0).list.size() >= 4){
                    return true;
                }
            }
            System.out.println();
        }
        System.out.println();
        return false;
    }

    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int horseCount = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n][n];
        horseList = new Horse[horseCount];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int color = Integer.parseInt(st.nextToken());
                graph[i][j] = new ArrayList<>();
                graph[i][j].add(new Node(color));
            }
        }
        for (int i = 0; i < horseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            graph[y][x].get(0).list.add(new Horse(y, x, dir - 1, i));
            horseList[i] = new Horse(y, x, dir - 1, i);
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    // 말 움직이기
    public static void movingHorse() {
        for (int i = 0; i < horseList.length; i++) {
            checking();
            // 현재 말의 위치를 갖고오기
            int nowY = horseList[i].y;
            int nowX = horseList[i].x;
            int nowDir = horseList[i].dir;
            Node node = graph[nowY][nowX].get(0);
            // 현재 이동하려는 말의 동선 확인하기(빨간색인지 흰색인지 파란색인지)
            int nextY = nowY + dy[horseList[i].dir];
            int nextX = nowX + dx[horseList[i].dir];
            int switchDir = switchDir(nowDir);
            if(!checking(nextY, nextX)){
                System.out.println("범위안돼서들어옴");
                movingBlue(node, i,switchDir);
                return;
            }
            int color = graph[nextY][nextX].get(0).color;
            // 현재 노드 넘겨주기
            switch (color) {
                // 흰색
                case 0:
                    movingWhite(node, i, nextY, nextX);
                    break;
                // 빨강
                case 1:
                    movingRed(node, i, nextY, nextX);
                    break;
                // 파랑
                case 2:
                    movingBlue(node,i,switchDir);
                    break;
            }
        }
    }

    public static void movingWhite(Node node, int number, int nextY, int nextX) {
        List<Horse> nodeHorseList = node.list;
        //흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
        //A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
        //예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
        List<Horse> movingList = new ArrayList<>();
        for (int i = 0; i < nodeHorseList.size(); i++) {
            movingList.add(nodeHorseList.get(i));
            if (nodeHorseList.get(i).number == number) {
                break;
            }
        }
        // 이동시키기위해 해당 말들 모두 삭제
        Iterator<Horse> horseIterator = nodeHorseList.iterator();
        while (horseIterator.hasNext()) {
            Horse horse = horseIterator.next();
            horseIterator.remove();
            if (horse.number == number) {
                break;
            }
        }
        // 현재 이렇게 받은 movingList를 옮겨야함
        for (int i = 0; i < movingList.size(); i++) {
            Horse horse = movingList.get(i);
            horse.y = nextY;
            horse.x = nextX;
            horseList[number] = horse;
        }
        Node newNode = graph[nextY][nextX].get(0);
        List<Horse> newNodeHorseList = newNode.list;
        for (int i = movingList.size()-1; i >= 0; i--) {
            newNodeHorseList.add(0,movingList.get(i));
        }

        for (int i = 0; i < newNodeHorseList.size(); i++) {
            System.out.print("horseList = "+newNodeHorseList.get(i).number+" ");
        }
        System.out.println();
    }

    public static void movingRed(Node node, int number, int nextY, int nextX) {
        //빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
        //A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
        //A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
        List<Horse> nodeHorseList = node.list;

        List<Horse> movingList = new ArrayList<>();
        for (int i = 0; i < nodeHorseList.size(); i++) {
            movingList.add(nodeHorseList.get(i));
            if (nodeHorseList.get(i).number == number) {
                break;
            }
        }
        // 이동시키기위해 해당 말들 모두 삭제
        Iterator<Horse> horseIterator = nodeHorseList.iterator();
        while (horseIterator.hasNext()) {
            Horse horse = horseIterator.next();
            horseIterator.remove();
            if (horse.number == number) {
                break;
            }
        }
        // 현재 이렇게 받은 movingList를 옮겨야함
        for (int i = 0; i < movingList.size(); i++) {
            Horse horse = movingList.get(i);
            horse.y = nextY;
            horse.x = nextX;
            horseList[horse.number] = horse;
        }
        Node newNode = graph[nextY][nextX].get(0);
        List<Horse> newNodeHorseList = newNode.list;
        for (int i = movingList.size() - 1; i >= 0; i--) {
            newNodeHorseList.add(0,movingList.get(i));
        }
    }

    public static void movingBlue(Node node, int number, int switchDir) {
        List<Horse> nodeHorseList = node.list;
        System.out.println("number = "+number);
        System.out.println("movingBlue" + node.list.size());
        List<Horse> movingList = new ArrayList<>();
        for (int i = 0; i < nodeHorseList.size(); i++) {
            Horse addHorse = nodeHorseList.get(i);
            System.out.print("addHorse = "+addHorse.number+" ");
            movingList.add(addHorse);
            if (addHorse.number == number) {
                addHorse.dir = switchDir;
                break;
            }
        }
        System.out.println();
        horseList[number].dir = switchDir;

        int nowY = horseList[number].y;
        int nowX = horseList[number].x;
        int nextY = nowY + dy[switchDir];
        int nextX = nowX + dx[switchDir];
        System.out.println("nextY = "+ nextY + " nextX = "+ nextX);
        if(!checking(nextY,nextX) || graph[nextY][nextX].get(0).color == 3){
            return;
        }
        if(graph[nextY][nextX].get(0).color == 0){
            System.out.println("흰색벽이라들어옴");
            movingWhite(node,number,nextY,nextX);
        }else{
            movingRed(node,number,nextY,nextX);
        }
    }
    public static int switchDir(int dir){
        int newDir = 0;
        switch (dir){
            // 우 좌 상 하
            case 0:
                newDir = 1;
                break;
            case 1:
                newDir = 0;
                break;
            case 2:
                newDir = 3;
                break;
            case 3:
                newDir = 2;
                break;
        }
        return newDir;
    }
}
