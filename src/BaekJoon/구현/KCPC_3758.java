package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class KCPC_3758 {
    public static class Team implements Comparable<Team> {
        // 문제 개수
        int[] arr;
        // 팀 번호
        int teamNumber;
        // 최종 점수
        int result;
        // 제출 횟수
        int count;
        // 마지막 제출
        int lastR;


        //최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다.
        //최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.
        @Override
        public int compareTo(Team team){
            if(this.result == team.result){
                if( this.count == team.count ){
                    return this.lastR - team.lastR;
                }else{
                    return this.count - team.count;
                }
            }
            return team.result - this.result;
        }

        public Team(int arrCount, int teamNumber){
            arr = new int[arrCount];
            this.teamNumber = teamNumber;
            result = 0;
            count = 0;
            lastR = 0;
        }

        public void result(){
            for(int i = 0; i < arr.length; i ++){
                result += arr[i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase; i ++){
            input(br);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m
        int a = Integer.parseInt(st.nextToken());
        // 문제의 개수
        int b = Integer.parseInt(st.nextToken());
        // 당신 팀의 아이디
        int c = Integer.parseInt(st.nextToken());
        // 로그 엔트리 개수
        int d = Integer.parseInt(st.nextToken());

        List<Team> teamList = new ArrayList<>();
        for(int i = 0; i < a; i++){
            teamList.add(new Team(b, i + 1));
        }

        // 팀 ID, 문제 번호, 획득한 점수
        for(int i = 0 ; i < d; i++){
            st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            int problemNumber = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            Team team = teamList.get(teamId - 1);
            int oldScore = team.arr[problemNumber - 1];
            if(oldScore < score){
                team.arr[problemNumber - 1] = score;
                team.count++;
                team.lastR = i;
                continue;
            }
            team.count++;
            team.lastR = i;
        }

        for(int i = 0; i < teamList.size(); i++){
            Team team = teamList.get(i);
            team.result();
        }

        Collections.sort(teamList);

        for(int i = 0; i < teamList.size(); i++){
            Team team = teamList.get(i);
            if(team.teamNumber == c){
                System.out.println(i + 1);
                return;
            }
        }
    }
}
