package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class KCPC_3758 {
    public static class Team {
        int[] arr;
        // 횟수
        int count;
        // 시간
        int time;
        int teamNumber;
        int sum;
        public Team(int arrSize, int teamNumber){
            this.arr = new int[arrSize];
            this.count = 0;
            this.time = 0;
            this.teamNumber = teamNumber;
            this.sum = 0;
        }
        public void result(){
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input(br);
        }
    }
    public static void input(BufferedReader br) throws IOException {
        // 풀이를 제출한 팀의 ID, 문제 번호, 점수가 서버의 로그에 제출되는 시간 순서대로 저장된다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 팀의 개수
        int a = Integer.parseInt(st.nextToken());
        // 문제의 개수
        int b = Integer.parseInt(st.nextToken());
        // 내 팀 id
        int c = Integer.parseInt(st.nextToken());
        // 로그 개수
        int d = Integer.parseInt(st.nextToken());

        List<Team> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add(new Team(b, i + 1));
        }

        // ID, 문제 번호, 점수
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            int problemId = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            Team team = list.get(teamId - 1);
            int oldScore = team.arr[problemId - 1];
            if(score > oldScore){
                team.arr[problemId - 1] = score;
            }
            team.count++;
            team.time = i;
        }

        for (int i = 0; i < a; i++) {
            Team team = list.get(i);
            team.result();
        }

        //최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다.
        //최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.
        // 정렬
        list.sort(new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                // 최종 점수 내림차순
                if (t1.sum != t2.sum) {
                    return Integer.compare(t2.sum, t1.sum);
                }
                // 제출 횟수 오름차순
                if (t1.count != t2.count) {
                    return Integer.compare(t1.count, t2.count);
                }
                // 마지막 제출 시간 오름차순
                return Integer.compare(t1.time, t2.time);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            Team team = list.get(i);
            if(team.teamNumber == c){
                System.out.println(i + 1);
                break;
            }
        }
    }
}
