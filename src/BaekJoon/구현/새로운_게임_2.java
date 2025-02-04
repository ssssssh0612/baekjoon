package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Node {
    List<Horse> horseList;
    // 0, 1, 2
    // 흰, 빨, 파
    int color;
    public Node(int color){
        this.horseList = new ArrayList<>();
        this.color = color;
    }
}
class Horse{
    int number;
    int dir;

    public Horse(int horseNumber, int dir){
        this.number = horseNumber;
        this.dir = dir;
    }
}
public class 새로운_게임_2 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Node[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int horseCount = Integer.parseInt(st.nextToken());

        graph = new Node[length][length];
        for(int i = 0 ; i < length ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < length; j++){
                graph[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0 ; i < horseCount ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            graph[y][x].horseList.add(new Horse(i + 1, dir));
        }
        int count = 0;

        while(count <= 1000){
            count++;
            boolean flag = true;
            for(int i = 1 ; i <= horseCount; i ++){
                // 말 찾기 null이 나올 수 없음
                int[] horsePos = findHorse(i);
                int y = horsePos[0];
                int x = horsePos[1];
                // 말이 리스트 어디위치에 있는지
                int index = horsePos[2];
                // 말의 방향
                int dir = horsePos[3];
//                System.out.println(" y = " + y + " x = " + x + " number = "+ i);
                int nextY = y + dy[dir];
                int nextX = x + dx[dir];

                // 현재 다음 위치가 어딘지 체크

                //흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
                //A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
                //예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
                if(checking(nextY, nextX) && graph[nextY][nextX].color == 0){
                    white(graph[y][x].horseList, graph[nextY][nextX].horseList, index);
//                    빨간색
                }else if(checking(nextY, nextX) && graph[nextY][nextX].color == 1){
                    red(graph[y][x].horseList, graph[nextY][nextX].horseList, index);
                }else{
                    // 파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다.
                    // 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
                    Horse horse = graph[y][x].horseList.get(index);
                    horse.dir = changeDir(dir);
                    dir = horse.dir;
                    nextY = y + dy[dir];
                    nextX = x + dx[dir];
                    if(checking(nextY, nextX) && graph[nextY][nextX].color == 0){
                        white(graph[y][x].horseList, graph[nextY][nextX].horseList, index);
                    }else if(checking(nextY, nextX) && graph[nextY][nextX].color == 1){
                        red(graph[y][x].horseList, graph[nextY][nextX].horseList, index);
                    }
                }

                // 지금 한번 이동함
                if(!checkSize()){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }

        }
        if(count == 1001){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }
    }
    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }
    public static int[] findHorse(int horseNumber){
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(!graph[i][j].horseList.isEmpty()){
                    for(int k = 0; k < graph[i][j].horseList.size(); k++){
                        Horse horse = graph[i][j].horseList.get(k);
                        if(horse.number == horseNumber){
                            return new int[]{i,j,k,horse.dir};
                        }
                    }
                }
            }
        }
        return new int[]{0,0,0};
    }

    public static void white(List<Horse> horseList, List<Horse> newHorseList, int index){
        for(int i = index; i < horseList.size(); i++){
            Horse horse = horseList.get(i);
            newHorseList.add(horse);
        }

        for(int i = horseList.size() - 1; i >= index; i--){
            horseList.remove(i);
        }
    }
    public static void red(List<Horse> horseList, List<Horse> newHorseList, int index){
        for(int i = horseList.size() - 1; i >= index; i--){
            Horse horse = horseList.get(i);
            newHorseList.add(horse);
        }

        for(int i = horseList.size() - 1; i >= index; i--){
            horseList.remove(i);
        }
    }
    // 파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다.
    // 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
    public static boolean checkSize(){
        for(int i = 0 ; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                if(graph[i][j].horseList.size() >= 4){
                    return false;
                }
            }
        }
        return true;
    }
    public static int changeDir(int dir){
        if( dir == 0 ){
            return 1;
        }else if( dir == 1){
            return 0;
        }else if( dir == 2){
            return 3;
        }else{
            return 2;
        }
    }
}
