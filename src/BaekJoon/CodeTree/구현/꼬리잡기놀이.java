package BaekJoon.CodeTree.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 꼬리잡기놀이 {
    public static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static class Team {
        boolean isHeadStartZero;
        List<Position> memberPositions;
        Set<String> memberPositionGroups;
        public Team() {
            isHeadStartZero = true;
            memberPositions = new ArrayList<>();
            memberPositionGroups = new HashSet<>();
        }
    }
    static int[] deltaRow = {-1,1,0,0};
    static int[] deltaCol = {0,0,-1,1};
    static int[] rotateRow = {1,0,-1,0};
    static int[] rotateCol = {0,1,0,-1};
    static int roundDir = 0;
    static int[] roundStartPos = {0,0};
    static int gridSize;
    static int teamCount;
    static int roundCount;
    static int[][] grid;
    static final int HEAD = 1;
    static final int BODY = 2;
    static final int TAIL = 3;
    static final int ROAD = 4;
    static List<Team> teams = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputReader(bufferedReader);
        findHead();
        progressRound();
        System.out.println(result);
    }

    public static void inputReader(BufferedReader inputReader) throws IOException {
        StringTokenizer inputs = new StringTokenizer(inputReader.readLine());
        gridSize = Integer.parseInt(inputs.nextToken());
        grid = new int[gridSize][gridSize];
        teamCount = Integer.parseInt(inputs.nextToken());
        roundCount = Integer.parseInt(inputs.nextToken());
        for (int row = 0; row < gridSize; row++) {
            inputs = new StringTokenizer(inputReader.readLine());
            for (int col = 0; col < gridSize; col++) {
                grid[row][col] = Integer.parseInt(inputs.nextToken());
            }
        }
    }

    public static void findHead(){
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int gridNumber = grid[row][col];
                if(isHead(gridNumber)){
                    makeTeam(row,col);
                }
            }
        }
    }

    public static boolean isHead(int gridNumber){
        return HEAD == gridNumber;
    }

    public static void makeTeam(int headRow, int headCol){
        Team newTeam = new Team();
        newTeam.memberPositions.add(new Position(headRow, headCol));
        newTeam.memberPositionGroups.add(headRow + " " + headCol);
        grid[headRow][headCol] = ROAD;
        int nowRow = headRow;
        int nowCol = headCol;
        while(true){
            boolean loopFlag = false;
            for(int i = 0 ; i < 4; i ++){
                int nextRow = nowRow + deltaRow[i];
                int nextCol = nowCol + deltaCol[i];
                // 2를 먼저 찾음
                if(isWithinGrid(nextRow, nextCol) && isBody(grid[nextRow][nextCol]) ){
                    nowRow = nextRow;
                    nowCol = nextCol;
                    newTeam.memberPositions.add(new Position(nowRow, nowCol));
                    newTeam.memberPositionGroups.add(nowRow + " " + nowCol);
                    grid[nowRow][nowCol] = ROAD;
                    loopFlag = true;
                }
            }
            // 2를 찾다가 2가 없으면 그때 3을 찾아 종료
            if(!loopFlag){
                for(int i = 0 ; i < 4; i ++){
                    int nextRow = nowRow + deltaRow[i];
                    int nextCol = nowCol + deltaCol[i];
                    // 2를 먼저 찾음
                    if(isWithinGrid(nextRow, nextCol) && isTail(grid[nextRow][nextCol])){
                        nowRow = nextRow;
                        nowCol = nextCol;
                        newTeam.memberPositions.add(new Position(nowRow, nowCol));
                        newTeam.memberPositionGroups.add(nowRow + " " + nowCol);
                        grid[nowRow][nowCol] = ROAD;
                    }
                }
                break;
            }
        }
        teams.add(newTeam);
    }

    public static boolean isWithinGrid(int row, int col){
        return row >= 0 && col >= 0 && row < gridSize && col < gridSize;
    }

    public static boolean isBody(int gridNumber){
        return gridNumber == BODY;
    }
    public static boolean isTail(int gridNumber){
        return gridNumber == TAIL;
    }
    public static void nowGraph(){
        int[][] graph = new int[gridSize][gridSize];
        for(Team team : teams){
            if(team.isHeadStartZero){
                for(int i = 0 ; i < team.memberPositions.size(); i++){
                    Position position = team.memberPositions.get(i);
                    if(i == 0){
                        graph[position.row][position.col] = 1;
                        continue;
                    }
                    if(i == team.memberPositions.size() - 1){
                        graph[position.row][position.col] = 3;
                        continue;
                    }
                    graph[position.row][position.col] = 2;
                }
            }else{
                for(int i = team.memberPositions.size() - 1; i >= 0; i--){
                    Position position = team.memberPositions.get(i);
                    if(i == 0){
                        graph[position.row][position.col] = 3;
                        continue;
                    }
                    if(i == team.memberPositions.size() - 1){
                        graph[position.row][position.col] = 1;
                        continue;
                    }
                    graph[position.row][position.col] = 2;
                }
            }
        }
        System.out.println();
        for(int i = 0 ; i < gridSize; i++){
            for(int j = 0 ; j < gridSize; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void progressRound(){
        int nowRound = 1;
        while(nowRound <= roundCount){
            movingTeam();
            nextRound();
            nowRound++;
        }
    }
    // 이 부분에서 팀을 움직여야하고 내부적으로 for문을 돌아야 하는데
    // 어떻게 해야할지 모르겠음
    public static void movingTeam(){
        for(Team team : teams){
            move(team);
        }
    }
    public static void move(Team team){
        if(team.isHeadStartZero){
            // 0번째 인덱스에 추가 그전에 마지막 인덱스 삭제
            Position position = team.memberPositions.get(team.memberPositions.size() - 1);
            team.memberPositionGroups.remove(position.row + " " + position.col);
            team.memberPositions.remove(team.memberPositions.size() - 1);

            // 0번째 인덱스에서 숫자 4인애 찾기
            Position nowHead = team.memberPositions.get(0);
            for(int i = 0 ; i < 4; i++){
                int nextRow = nowHead.row + deltaRow[i];
                int nextCol = nowHead.col + deltaCol[i];
                if(isWithinGrid(nextRow, nextCol) && grid[nextRow][nextCol] == ROAD &&
                        !team.memberPositionGroups.contains(nextRow + " " + nextCol)){
                    team.memberPositionGroups.add(nextRow + " " + nextCol);
                    team.memberPositions.add(0,new Position(nextRow, nextCol));
                    break;
                }
            }
        }else{
            Position position = team.memberPositions.get(0);
            team.memberPositionGroups.remove(position.row + " " + position.col);
            team.memberPositions.remove(0);
            // 0번째 인덱스에서 숫자 4인애 찾기
            Position nowHead = team.memberPositions.get(team.memberPositions.size() - 1);
            for(int i = 0 ; i < 4; i++){
                int nextRow = nowHead.row + deltaRow[i];
                int nextCol = nowHead.col + deltaCol[i];
                if(isWithinGrid(nextRow, nextCol) && grid[nextRow][nextCol] == ROAD &&
                        !team.memberPositionGroups.contains(nextRow + " " + nextCol)){
                    team.memberPositionGroups.add(nextRow + " " + nextCol);
                    team.memberPositions.add(new Position(nextRow, nextCol));
                    break;
                }
            }
        }
    }
    // 메서드 이름을 뭐라고하지 ? 다음 라운드 진행을..
    public static void nextRound() {
        // 현재 startPos가 범위를 벗어나면 현재 위치에서 방향만 바꿔주기
        int ballDir = roundDir + 1;
        if(ballDir == 4){
            ballDir = 0;
        }
        // 현재 위치에서 ballDir 방향으로
        int startRow = roundStartPos[0];
        int startCol = roundStartPos[1];
        for(int i = 0 ; i < gridSize; i++){
            // 볼 던지기
            if(grid[startRow][startCol] == ROAD && throwBall(startRow, startCol)){
                break;
            }
            // 다음거 더해주기
            startRow = startRow + rotateRow[ballDir];
            startCol = startCol + rotateCol[ballDir];
        }

        int nextRoundRow = roundStartPos[0] + rotateRow[roundDir];
        int nextRoundCol = roundStartPos[1] + rotateCol[roundDir];
        if(isWithinGrid(nextRoundRow, nextRoundCol)){
            roundStartPos[0] = nextRoundRow;
            roundStartPos[1] = nextRoundCol;
        }else{
            // 범위 안에 안들어간다면
            roundDir++;
            if(roundDir == 4){
                roundDir = 0;
            }
        }
    }

    public static boolean throwBall(int row, int col){
        // 이름 수정하기
        String str = row + " " + col;
        // 팀별로 돌면서 set에 포함되는지 확인하고 set에 포함된다면 ?
        for(Team team : teams){
            if(team.memberPositionGroups.contains(str)){
                int index = 0;
                for(Position position : team.memberPositions){
                    if(position.row == row && position.col == col){
                        addScore(team, index);
                        team.isHeadStartZero = !team.isHeadStartZero;
                        return true;
                    }
                    index++;
                }
            }
        }
        return false;
    }

    public static void addScore(Team team, int index){
        // 점수를 추가해주기
        if(team.isHeadStartZero){
            result += (index + 1) * (index + 1);
        }else{
            result += (Math.abs(index - team.memberPositions.size())) * (Math.abs(index - team.memberPositions.size()));
        }
        // 1 2 2 2 3
    }
}

