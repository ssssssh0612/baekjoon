package BaekJoon.CodeTree.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 싸움당 {
    static class Player{
        int talent;
        int number;
        int dir;
        int gun;
        public boolean hasGun(){
            return this.gun > 0;
        }
        public Player(int talent, int number, int dir){
            this.talent = talent;
            this.number = number;
            this.dir = dir;
        }
    }
    static class Node{
        Player player;
        PriorityQueue<Integer> gunpq;
        public Node(){
            this.gunpq = new PriorityQueue<>(Collections.reverseOrder());
        }

        public boolean isGun(){
            return !gunpq.isEmpty();
        }
        public boolean isPlayer(){
            return this.player != null;
        }
    }
    static Node[][] graph;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int k;
    static int[] playerScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        for(int i = 0 ; i < k ; i++){
            movingPlayer();
        }
        for(int i = 0 ; i < playerScore.length ; i++){
            System.out.print(playerScore[i] + " ");
        }
    }
    public static void movingPlayer(){
        for(int i = 0 ; i < playerScore.length; i++){
            moving(i);
        }
    }

    public static void moving(int number){
        checkingGraph();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph.length; j++){
                Node node = graph[i][j];
                Player player = graph[i][j].player;
                // 현재 플레이어가 존재하고, 내가 찾는 번호와 같다면
                if(node.isPlayer() && node.player.number == number){
                    // 플레이어 방향대로 움직이기
                    int[] pos = movingPlayer1(player, i, j);
                    int nextY = pos[0];
                    int nextX = pos[1];
                    Node nextNode = graph[nextY][nextX];
                    // 현재 플레이어가 존재하는가 ?
                    if(nextNode.isPlayer()){
                        // 플에이어 존재하면 싸우기
                        Player newPlayer = nextNode.player;
                        Player[] playerArr = fight(player, newPlayer);
                        Player winPlayer = playerArr[0];
                        Player losePlayer = playerArr[1];

                        // 움직이기 전에 이전 위치에 있던 Node의 Player 초기화
                        graph[i][j].player = null;
                        graph[nextY][nextX].player = null;
                        losePlayerMoving(losePlayer, nextY, nextX);
                        winPlayerMoving(winPlayer, nextY, nextX);
                    }else{
                        // 플레이어 존재하지 않으면 총 줍기
                        // 다음 위치에 총이 존재하는지 존재하지 않는지 확인
                        // 존재한다면 총 줍기
                        catchGun(player, nextNode);
                        // 자리 안옮김
                        graph[i][j].player = null;
                        graph[nextY][nextX].player = player;
                    }
                    return;
                }
            }
        }
    }
    public static void checkingGraph(){
        System.out.println();
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                Node node = graph[i][j];
                if(node.isPlayer()){
                    System.out.print(node.player.number + 1 + " ");
                }else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }

    public static void winPlayerMoving(Player player, int y, int x){
        graph[y][x].player = player;
        Node node = graph[y][x];
        catchGun(player, node);
    }

    public static void losePlayerMoving(Player player, int y, int x){
        // 그전에 player 의 총이 있는지 확인하고 내려놓기
        // 진 애는 총 내려놓기
//        System.out.println("시작!");
//        System.out.println(" playerNumber = " + (player.number + 1) + " dir = " + player.dir);

        if(player.hasGun()){
            graph[y][x].gunpq.add(player.gun);
            player.gun = 0;
        }
        int dir = player.dir;
        int nextY = y;
        int nextX = x;
        for(int i = 0; i < 4; i++){
            nextY = nextY + dy[dir];
            nextX = nextX + dx[dir];
            if(checking(nextY, nextX) && !graph[nextY][nextX].isPlayer()){
                // 진 플레이어는 위치로 움직임
                graph[nextY][nextX].player = player;
                catchGun(player, graph[nextY][nextX]);
                break;
            }
            nextY = nextY - dy[dir];
            nextX = nextX - dx[dir];
            dir = convertDir(dir);
        }
        player.dir = dir;
//        System.out.println(" playerNumber = " + (player.number + 1) + " dir = " + player.dir);
    }
    public static int convertDir(int dir){
        int newDir = dir + 1;
        if(newDir == 4){
            return 0;
        }
        return newDir;
    }
    public static Player[] fight(Player p1, Player p2){
        int p1Talent = playerTalent(p1);
        int p2Talent = playerTalent(p2);
        System.out.println((p1.number + 1) + " " + (p2.number + 1));
        if(p1Talent > p2Talent){
            playerScore[p1.number] += p1Talent - p2Talent;
            System.out.println(p1Talent - p2Talent);
            return new Player[]{p1, p2};
        }else if(p1Talent < p2Talent){
            playerScore[p2.number] += p2Talent - p1Talent;
            System.out.println(p2Talent - p1Talent);
            return new Player[]{p2, p1};
        }else{
            // 둘이 같다면 능력치로 비교
            if(p1.talent > p2.talent){
                return new Player[]{p1, p2};
            }else{
                return new Player[]{p2, p1};
            }
        }
    }
    public static int playerTalent(Player player){
        int talent = player.talent;
        if(player.hasGun()){
            talent += player.gun;
        }
        return talent;
    }

    public static void catchGun(Player player, Node node){
        // 현재 내가 총을 갖고 있는지 안갖고있는지 확인
        if(node.isGun()){
            if (player.hasGun()) {
                // 갖고있다면
                int newGun = node.gunpq.peek();
                int myGun = player.gun;
                if (myGun < newGun) {
                    player.gun = node.gunpq.poll();
                    node.gunpq.add(myGun);
                }
            } else {
                player.gun = node.gunpq.poll();
            }
        }
    }
    // 현재 입력받은 방향대로 움직이기
    public static int[] movingPlayer1(Player player, int y, int x){
        // 입력받은 방향으로 움직이는데 해당 방향에 총이 있거나 player가 있는지 체크
        int dir = player.dir;
        int nextY = y + dy[dir];
        int nextX = x + dx[dir];
        // 해당 방향이 범위에 안들어오면 방향 반대로 바꾸기
        if(!checking(nextY, nextX)){
            // 다시 원점으로 돌리고
            nextY = y - dy[dir];
            nextX = x - dx[dir];
            // 방향 반대로 바꾸고
            dir = oppositeDir(dir);
            // 한칸 더해주기
            nextY = y + dy[dir];
            nextX = x + dx[dir];
            player.dir = dir;
        }
        return new int[]{nextY, nextX};
    }


    public static void input(BufferedReader br)throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        playerScore = new int[m];
        k = Integer.parseInt(st.nextToken());

        graph = new Node[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                graph[i][j] = new Node();
            }
        }

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j ++){
                int gunPower = Integer.parseInt(st.nextToken());
                if(gunPower > 0){
                    graph[i][j].gunpq.add(gunPower);
                }
            }
        }

        for(int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            int talent = Integer.parseInt(st.nextToken());
            Player player = new Player(talent, i, dir);
            graph[y][x].player = player;
        }
    }


    public static int oppositeDir(int dir){
        if(dir == 0){
            return 2;
        }else if(dir == 1){
            return 3;
        }else if(dir == 2){
            return 0;
        }else{
            return 1;
        }
    }

    public static boolean checking(int y, int x){
        return y >= 0 && x >= 0 && y < graph.length && x < graph.length;
    }

}