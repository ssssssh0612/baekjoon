package BaekJoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 걸그룹마스터준석이_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, PriorityQueue<String>> map1 = new HashMap<>();
        Map<String, Set<String>> map2 = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < length; i++){

        }
        for(int i = 0 ; i < length; i++){
            String teamName = br.readLine();
            map1.put(teamName, new PriorityQueue<>());
            map2.put(teamName, new HashSet<>());
            int teamCount = Integer.parseInt(br.readLine());
            for(int j = 0 ; j < teamCount; j++){
                String name = br.readLine();
                map1.get(teamName).add(name);
                map2.get(teamName).add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count; i++){
            String name = br.readLine();
            int ps = Integer.parseInt(br.readLine());
            // 퀴즈의 종류가 0일 경우 해당 팀에 속한 멤버의 이름을 사전순으로 한 줄에 한 명씩 출력한다.
            // 퀴즈의 종류가 1일 경우 해당 멤버가 속한 팀의 이름을 출력한다.
            if(ps==1){
                for(String teamName : map2.keySet()){
                    Set<String> set = map2.get(teamName);
                    if(set.contains(name)){
                        sb.append(teamName).append("\n");
                        break;
                    }
                }
            }else{
                for(String teamName : map1.keySet()){
                    if(teamName.equals(name)){
                        PriorityQueue<String> pq = map1.get(teamName);
                        while(!pq.isEmpty()){
                            sb.append(pq.poll()).append("\n");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(sb);

    }
}
