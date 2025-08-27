package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 후보_추천하기_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        // int[] person = new int[3];
        // 0 = 학생번호
        // 1 = 추천 수
        // 2 = 오래된 날짜
        StringTokenizer st = new StringTokenizer(br.readLine());

        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o1[1] - o2[1];
                if(result != 0){
                    return result;
                }
                return o2[2] - o1[2];
            }
        };

        for (int i = 0; i < count; i++) {
            // 현재 리스트에 있는 목록들 1씩 추가하기
            for (int[] person : list) {
                person[2]++;
            }

            int personNumber = Integer.parseInt(st.nextToken());

            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                if(personNumber == list.get(j)[0]){
                    list.get(j)[1]++;
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }

            if(list.size() < num){
                int[] person = new int[3];
                person[0] = personNumber;
                person[1] = 1;
                list.add(person);
                continue;
            }

            // 현재 리스트도 꽉 차고 num 도 없는경우 정렬해서 list 중 하나를 빼야하는 상황
            Collections.sort(list, comparator);
            list.remove(0);
            int[] person = new int[3];
            person[0] = personNumber;
            person[1] = 1;
            list.add(person);

        }
        Comparator<int[]> comparator1 = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int result = o1[0] - o2[0];
                return result;
            }
        };
        Collections.sort(list, comparator1);
        for(int[] person : list){
            System.out.print(person[0] + " ");
        }
    }
}
