package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 크로스컨트리_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            input(br);
        }
    }

    public static void input(BufferedReader br) throws IOException {
        int length = Integer.parseInt(br.readLine());
        // 점수를 메기기 위해서 맨 처음 자격이 있는 팀인지 판단하기
        int[] arr = new int[length];
        List<List<Integer>> teamList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
            if( i == 0){
                max = arr[i];
            }else{
                max = Math.max(max,arr[i]);
            }
        }

        // 팀 자격 판단 배열
        int[] team = new int[max + 1];
        // 입력을 받은 후 최대값을 구하기 최대 팀의 갯수 구하기
        for(int i = 0 ; i < max + 1; i ++){
            teamList.add(new ArrayList<>());
        }
        // 해당 팀의 자격이 있는지 없는지 판단하기
        for(int i = 0 ; i < length; i++){
            team[arr[i]]++;
        }
        // 6인 팀은 자격이 있는 팀
        // 해당 arr 배열을 방문하면서 6인 팀은 점수를 teamList 에 메겨주기
        int score = 1;
        for( int i = 0 ; i < length; i ++){
            int teamNumber = arr[i];
            if( team[teamNumber] == 6 ){ // 팀 자격이 있는 애인지 확인하고 팀 자격이 있다면, 점수를 주기
                teamList.get(teamNumber).add(score);
                score++;
            }
        }

        List<int[]> result  = new ArrayList<>();
        for( int i = 0 ; i < teamList.size(); i ++){
            int teamSize = teamList.get(i).size();
            if( teamSize == 6 ){
                int sum = 0;
                int fivePlayer = teamList.get(i).get(4);
                for(int j = 0 ; j < 4 ; j ++){
                    sum += teamList.get(i).get(j);
                }
                result.add(new int[]{sum,fivePlayer,i+1});
            }
        }

        Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1 , int[] o2){
                int result = o1[0] - o2[0];
                if(result != 0){
                    return result;
                }
                result = o1[1] - o2[1];
                return result;
            }
        };
        Collections.sort(result, comparator);

        System.out.println(result.get(0)[2]);
    }
}
