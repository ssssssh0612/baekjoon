package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말_1043 {
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        int partyCount = Integer.parseInt(st.nextToken());
        arr = new int[person + 1];

        for(int i = 1; i <= person; i++){
            arr[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());
        if(knowCount == 0){
            System.out.println(partyCount);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < knowCount; i++){
            int number = Integer.parseInt(st.nextToken());
            set.add(number);
        }

        List<int[]> partyList = new ArrayList<>();
        for(int i = 0 ; i < partyCount; i++){
            st = new StringTokenizer(br.readLine());
            int human = Integer.parseInt(st.nextToken());
            int[] party = new int[human];
            for(int j = 0; j < human; j++){
                party[j] = Integer.parseInt(st.nextToken());
            }
            partyList.add(party);
        }
        int index = 0;
        boolean[] visited = new boolean[partyCount];
        for(int i = 0 ; i < partyCount; i++){
            int[] party = partyList.get(i);
            int length = partyList.get(i).length;
            boolean flag1 = false;
            for(int j = 0 ; j < length; j++){
                int partyHuman = party[j];
                if(set.contains(partyHuman)){
                    flag1 = true;
                    break;
                }
            }

            if(flag1 && !visited[i]){
                for(int j = 0 ; j < length; j++){
//                    System.out.print(party[j]+" ");
                    set.add(party[j]);
                }
//                System.out.println();
                visited[i] = true;
                i = -1;
            }
        }


        int count = 0;
        for(int i = 0 ; i < partyCount; i++){
            int[] party = partyList.get(i);
            boolean flag = true;
            for(int j = 0 ; j < party.length; j++){
                int human = party[j];
                if(set.contains(arr[human])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void union(int a, int b){
        arr[a] = b;
    }
    public static int find(int number){
        if(arr[number] == number){
            return number;
        }
        return arr[number] = find(arr[number]);
    }
}



//6 5
//1 6
//2 4 5
//2 1 2
//2 2 3
//2 3 4
//2 5 6