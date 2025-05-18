package BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 톱니바퀴_14891 {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                char ch = str.charAt(j);
                if (ch == '0') {
                    list.get(i).add(0);
                } else {
                    list.get(i).add(1);
                }
            }
        }

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int rotateNum = Integer.parseInt(st.nextToken());
            boolean rotate = true;

            if (rotateNum == -1) {
                rotate = false;
            }

            // 처음 상태를 저장
            boolean[] rotateArr = new boolean[3];
            boolean[] visited = new boolean[4];
            if (list.get(0).get(2) != list.get(1).get(6)) {
                rotateArr[0] = true;
            }

            if (list.get(1).get(2) != list.get(2).get(6)) {
                rotateArr[1] = true;
            }

            if (list.get(2).get(2) != list.get(3).get(6)) {
                rotateArr[2] = true;
            }

            // 도는 기준을 정해주고
            rotate(visited,rotateArr,index,rotate);

        }

        int result = 0;
        for(int i  = 0 ; i < 4;  i++){
            int check = list.get(i).get(0);
            if(check == 1){
                if( i == 0 ){
                    result += 1;
                }else if( i == 1){
                    result += 2;
                }else if(i == 2){
                    result += 4;
                }else{
                    result += 8;
                }
            }
        }
        System.out.println(result);
    }

    // 시계방향
    public static void rotate(List<Integer> list, boolean rotate) {
        if (rotate) {
            int num = list.get(list.size() - 1);
            list.add(0, num);
            list.remove(list.size() - 1);
        } else {
            int num = list.get(0);
            list.add(num);
            list.remove(0);
        }
    }

    public static void rotate(boolean[] visited, boolean[] rotateArr, int index, boolean rotate) {
//        System.out.println(index);
        if (index == 0) {
            visited[0] = true;
            rotate(list.get(0), rotate);

            if(rotateArr[0] && !visited[1]){
                rotate(visited, rotateArr, 1, !rotate);
            }

        } else if (index == 1) {

            visited[1] = true;
            rotate(list.get(1), rotate);


            if(rotateArr[0] && !visited[0]){
                rotate(visited, rotateArr, 0, !rotate);
            }

            if(rotateArr[1] && !visited[2]){
                rotate(visited, rotateArr, 2, !rotate);
            }


        } else if (index == 2) {

            visited[2] = true;
            rotate(list.get(2), rotate);

            if(rotateArr[1] && !visited[1]){
                rotate(visited, rotateArr, 1, !rotate);
            }

            if(rotateArr[2] && !visited[3]){
                rotate(visited, rotateArr, 3, !rotate);
            }

        } else {

            visited[3] = true;
            rotate(list.get(3), rotate);


            if(rotateArr[2] && !visited[2]){
                rotate(visited, rotateArr, 2, !rotate);
            }

        }


    }
}
