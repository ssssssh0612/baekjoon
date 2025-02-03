package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Room{
    List<Shark> sharkList;
    Smell smell;
    public Room(Shark shark){
        sharkList = new ArrayList<>();
        // 상어 추가하고
        sharkList.add(shark);
        // 냄새뿌리기
        this.smell = new Smell(shark.number, 어른_상어_19237.smellCount);
    }
    public Room(){
        sharkList = new ArrayList<>();
    }
}

class Shark{
    int number;
    int dir;
    int[][] dirArr;
    public Shark(int number, int dir, int[][] dirArr) {
        this.number = number;
        this.dir = dir;
        this.dirArr = dirArr;
    }
}
class Smell{
    int sharkNumber;
    int smell;
    public Smell(int sharkNumber, int smell){
        this.sharkNumber = sharkNumber;
        this.smell = smell;
    }
}
public class 어른_상어_19237 {
    static boolean[] visited;
    static int smellCount;
    static List<int[]> sharkPos = new ArrayList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static Room[][] room;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int sharkCount = Integer.parseInt(st.nextToken());
        smellCount = Integer.parseInt(st.nextToken());
        result = sharkCount;
        room = new Room[length][length];
        sharkPos = new ArrayList<>();
        visited = new boolean[sharkCount + 1];
        for(int i = 0 ; i < length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < length; j++){
                int number = Integer.parseInt(st.nextToken());
                room[i][j] = new Room();
                if(number != 0){
                    sharkPos.add(new int[]{number,i,j});
                }
            }
        }
        Comparator<int[]> comparatorShark = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        };
        Collections.sort(sharkPos, comparatorShark);


        // 상어 위치 저장
        int[] sharkDir = new int[sharkCount];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < sharkDir.length; i++){
            sharkDir[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i = 0 ; i < sharkDir.length; i++){
            int[][] dir = new int[4][4];
            for(int j = 0 ; j < 4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 4; k++){
                    dir[j][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
            // 상어 우선순위 경로 저장했고
            // 방향 저장했고,
            // 상어 위치 저장했고
            // 생성과 동시에 냄새뿌리기
            int[] sharkPosArr = sharkPos.get(i);
            Room newRoom = new Room(new Shark(i + 1, sharkDir[i], dir));
            room[sharkPosArr[1]][sharkPosArr[2]] = newRoom;
        }
        int timeCount = 0;
        while(timeCount <= 1000){
            timeCount++;
            moveShark();
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room.length; j++) {
                    Room newRoom = room[i][j];
                    if(newRoom.smell != null && newRoom.sharkList.isEmpty()){
                        newRoom.smell.smell--;
                        if(newRoom.smell.smell == 0){
                            newRoom.smell = null;
                        }
                    }
                }
            }
            if(result == 1){
                break;
            }
        }
        if(timeCount == 1001){
            System.out.println(-1);
        }else{
            System.out.println(timeCount);
        }
    }
    public static void moveShark(){
            // 현재 위치 상어를 가고자 하는 위치로 옮기기

        Arrays.fill(visited, false);

        for(int i = 0 ; i < room.length; i++){
            for(int j = 0 ; j < room.length; j++){
                Room newRoom = room[i][j];
                // 상어가 존재하면 옮기기
                if(!newRoom.sharkList.isEmpty() && !visited[newRoom.sharkList.get(0).number]) {
                    Shark shark = room[i][j].sharkList.get(0);
                    visited[shark.number] = true;
                    // 내가 가려는 방향에 냄새가 없다면 옮기고
                    int count = 0;
                    // 내 상하좌우에 상어가 움직일 수 있는 방향이 있는가?
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (checking(nextY, nextX) && room[nextY][nextX].smell == null) {
                            // 냄새 없는 방 존재유무
                            count++;
                        }
                    }
                    if (count == 0) {
                        // 다 냄새가 난다면 그중에 냄새 안나는 방으로 옮기되, 현재 내 방향의 우선순위에 맞게 옮기기
                        int[] sharkDir = shark.dirArr[shark.dir];
                        for (int k = 0; k < 4; k++) {
                            int dir = sharkDir[k];
                            int nextY = i + dy[dir];
                            int nextX = j + dx[dir];
                            if (checking(nextY, nextX) && room[nextY][nextX].smell.sharkNumber == shark.number) {
                                shark.dir = dir;
                                // 상어 추가
                                room[nextY][nextX].sharkList.add(shark);
                                // 현재 위치 상어 삭제
                                room[i][j].sharkList.remove(0);
                                break;
                            }
                        }

                    } else {
                        // 현재 방향 우선순위를 돌면서 냄새가 안나는 방향으로 방을 옮기기
                        int[][] sharkDirArr = shark.dirArr;
                        int[] sharkDir = sharkDirArr[shark.dir];
                        for (int k = 0; k < 4; k++) {
                            int dir = sharkDir[k];
                            int nextY = i + dy[dir];
                            int nextX = j + dx[dir];
                            if (checking(nextY, nextX) && room[nextY][nextX].smell == null) {
                                // 상어 추가
                                shark.dir = dir;
                                room[nextY][nextX].sharkList.add(shark);
                                // 현재 위치 상어 삭제
                                room[i][j].sharkList.remove(0);
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 상어가 2마리 이상 있는지 없는지 확인하기 2마리 이상 있다면 삭제
        // 상어 삭제하기 번호순에 따라서
        Comparator<Shark> comparator = new Comparator<>(){
            @Override
            public int compare(Shark s1, Shark s2){
                return s1.number - s2.number;
            }
        };
        // 상어 죽이고
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                Room newRoom = room[i][j];
                if(newRoom.sharkList.size() > 1){
                    Collections.sort(newRoom.sharkList, comparator);
                    for(int k = newRoom.sharkList.size() - 1 ; k >= 1; k--){
                        newRoom.sharkList.remove(k);
                        result--;
                    }
                }
            }
        }
        // 살아남은 상어들 냄새뿌리기
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room.length; j++) {
                Room newRoom = room[i][j];
                if(!newRoom.sharkList.isEmpty()){
                    Shark shark = room[i][j].sharkList.get(0);
                    // 냄새 뿌리기
                    newRoom.smell = new Smell(shark.number, smellCount);
                }
            }
        }
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < room.length && x < room.length;
    }
    // 상어들을 한칸씩 움직이기 위치가 겹치면 죽기
}
